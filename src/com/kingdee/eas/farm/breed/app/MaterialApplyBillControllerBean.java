package com.kingdee.eas.farm.breed.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.BreedBatchEntryCollection;
import com.kingdee.eas.farm.breed.BreedBatchEntryFactory;
import com.kingdee.eas.farm.breed.BreedBatchEntryInfo;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.BreedFacadeFactory;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import com.kingdee.eas.farm.breed.DrugType;
import com.kingdee.eas.farm.breed.HenhouseFactory;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.MaterialApplyBillEntryCollection;
import com.kingdee.eas.farm.breed.MaterialApplyBillEntryHenhouseEntryCollection;
import com.kingdee.eas.farm.breed.MaterialApplyBillEntryHenhouseEntryInfo;
import com.kingdee.eas.farm.breed.MaterialApplyBillEntryInfo;
import com.kingdee.eas.farm.breed.MaterialApplyBillFactory;
import com.kingdee.eas.farm.breed.MaterialApplyBillInfo;
import com.kingdee.eas.farm.breed.ResidueSetInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.DateCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.util.NumericExceptionSubItem;

public class MaterialApplyBillControllerBean extends AbstractMaterialApplyBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.app.MaterialApplyBillControllerBean");
    
    
    

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// 状态设置为保存
		MaterialApplyBillInfo info =  (MaterialApplyBillInfo)model;
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&&
				info.getBaseStatus() != null){
			throw new EASBizException(new NumericExceptionSubItem("001","只能保存暂存或者新增状态的单据"));
			
		}
		// 校验 药残日期
		try {
			checkSafeDays(ctx,info);
		} catch (ParseException e) {
			
			e.printStackTrace();
			throw new BOSException(e);
		}
		info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, model);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		MaterialApplyBillInfo info =  MaterialApplyBillFactory.getLocalInstance(ctx).getMaterialApplyBillInfo(pk);
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())){
			throw new EASBizException(new NumericExceptionSubItem("001","只能删除暂存或者新增状态的单据"));
			
		}
		super._delete(ctx, pk);
	}
	
	/**
	 * 提交
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		MaterialApplyBillInfo billInfo = (MaterialApplyBillInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()) || 
    						billInfo.getBaseStatus() == null)){
    		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
    		
    		// 校验 药残日期
    		try {
				checkSafeDays(ctx,billInfo);
			} catch (ParseException e) {
				e.printStackTrace();
				throw new BOSException(e);
			}
    		return super._submit(ctx, model);
    	}else{
    		throw new EASBizException(new NumericExceptionSubItem("001","只能提交新增或保存状态的单据"));
			
    	}
	}
	
	/**
	 * 校验
	 * @throws BOSException 
	 * @throws EASBizException 
	 * @throws ParseException 
	 */
	private void checkSafeDays(Context ctx,MaterialApplyBillInfo billInfo) throws BOSException, EASBizException, ParseException{
		// 标准饲喂周期
//	    int standardAllFeedDays;
	    // 最短饲喂周期
	    int limitedFeedDays;   
	    MaterialApplyBillEntryCollection entryColl =  billInfo.getEntrys();
	    // 鸡舍类别，商品鸡 不能 用种鸡专用
	    // 种鸡不能用商品及专用
	    // 空栏期只能用消毒类药品
	    HenhouseType currHenhousetype = null;
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    // 空栏期校验 智能选择 消毒类药品，并且不校验 残留时间
	    StorageOrgUnitInfo stoOrgInfo = billInfo.getStoOrg();
	    stoOrgInfo = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectUuidPK(stoOrgInfo.getId()));
	    String longNumber  = stoOrgInfo.getLongNumber();
	    if(longNumber == null){
	    	currHenhousetype = null;
	    }else if(longNumber.indexOf("1!3!304!") >= 0){
	    	currHenhousetype = HenhouseType.CC;
	    }else if(longNumber.indexOf("1!3!302!3021") >= 0){
	    	currHenhousetype = HenhouseType.Brood;
	    }else if(longNumber.indexOf("1!3!302!3022") >= 0){
	    	currHenhousetype = HenhouseType.LayEgg;
	    }
	    // 获得批次入栏日龄
	    Map<String,Date> batchIncoopDates = getBatchIncoopDate(ctx,billInfo.getBreedBatch());
	    if(batchIncoopDates.size() <= 0){
	    	throw new BOSException("批次入栏信息不全，请产看批次基本信息");
	    }
	    if(billInfo.isIsEmpty()) {
	    	for(int i = 0; i < entryColl.size(); i++){
	    		MaterialApplyBillEntryInfo entryInfo = entryColl.get(i);
				MaterialInfo entryMaterial = entryInfo.getMaterial();
				
				ResidueSetInfo residueSetInfo = BreedFacadeFactory.getLocalInstance(ctx).getMaterialResidueSet(entryMaterial.getId().toString());
				if(residueSetInfo.getDrugType() == null){
					throw new BOSException("请联系管理员在物料残留时间中维护药品类别");
				}
				if(!DrugType.DISINFECTDRUG_VALUE.equals(residueSetInfo.getDrugType().getValue())){
					throw new BOSException("空栏期只能使用消毒类药品");
				}
				
	    	}
	    }else if(HenhouseType.LAYEGG_VALUE.equals(currHenhousetype.getValue()) || 
	    		HenhouseType.BROOD_VALUE.equals(currHenhousetype.getValue()) ){
	    	for(int i = 0; i < entryColl.size(); i++){
	    		MaterialApplyBillEntryInfo entryInfo = entryColl.get(i);
				MaterialInfo entryMaterial = entryInfo.getMaterial();
				
				ResidueSetInfo residueSetInfo = BreedFacadeFactory.getLocalInstance(ctx).getMaterialResidueSet(entryMaterial.getId().toString());
				if(residueSetInfo != null){
					if( residueSetInfo.getDrugType() == null){
						throw new BOSException("请联系管理员在物料残留时间中维护药品类别与残留天数");
					}
					if(DrugType.CCONLY_VALUE.equals(residueSetInfo.getDrugType().getValue())){
						throw new BOSException("不能使用商品鸡专用类药品");
					}
				}
				
	    	}
	    }else if(HenhouseType.CC_VALUE.equals(currHenhousetype.getValue())){
			// 商品鸡 
			BreedModelInfo currModel = BreedFacadeFactory.getLocalInstance(ctx).getBreedModelByHouseType(HenhouseType.CC_VALUE);
	        if(currModel == null){
	        	throw new BOSException("没有找到合适的养殖规范，请联系管理员");
	        	
	        }else{
//	        	standardAllFeedDays = currModel.getBreedDays();
	        	limitedFeedDays = currModel.getLimitBreedDays();
//	        	standardAllFeedDays = limitedFeedDays;
	        	// 如果标准饲喂周期 小于等于0 则提示
	        	if(limitedFeedDays <= 0){
	        		throw new BOSException("请联系管理员维护养殖规范中维护的最短饲喂周期");
	            	
	        	}
	        }
	       
	        // 逐个分录校验
			for(int i = 0; i < entryColl.size(); i++){
				MaterialApplyBillEntryInfo entryInfo = entryColl.get(i);
				MaterialInfo entryMaterial = entryInfo.getMaterial();
				ResidueSetInfo residueSetInfo = BreedFacadeFactory.getLocalInstance(ctx).getMaterialResidueSet(entryMaterial.getId().toString());
				if(residueSetInfo.getDrugType() == null){
					throw new BOSException("请联系管理员在物料残留时间中维护药品类别");
				}
				if(DrugType.HENONLY_VALUE.equals(residueSetInfo.getDrugType().getValue())){
					throw new BOSException("不能使用种鸡专用类药品");
				}
				MaterialApplyBillEntryHenhouseEntryCollection henhouseEntry = entryInfo.getHenhouseEntry();
				int useDays = entryInfo.getUseDays();
				if(useDays <=0){
					throw new BOSException("使用天数必须大于0");
					
				}
				Date beginUseDate = entryInfo.getUseDate();
				if(beginUseDate == null){
					throw new BOSException("必须填写开始使用日期");
					
				}else{
					String currDateStr = sdf.format(new Date());
					
					if(beginUseDate.before(sdf.parse(currDateStr))){
						throw new BOSException("开始使用日期必须大于当前日期");
					}
				}
				// 如果没有鸡舍分录则提示
				if(henhouseEntry == null || henhouseEntry.size() <= 0){
					throw new BOSException("申请的所有药品必须维护对应的使用鸡舍明细，请检查分录数据");
				}
				
				 MaterialInfo currMaterial = entryInfo.getMaterial();
		    	 int residueDays = 0;
		    	 // 药残时间
		    	 if(currMaterial != null){
		    		 residueDays = BreedFacadeFactory.getLocalInstance(ctx).getMaterialResidueDays(currMaterial.getId().toString());
		    	 }
				for(int j = 0; j < henhouseEntry.size(); j++){
					MaterialApplyBillEntryHenhouseEntryInfo henhouseEntryInfo = henhouseEntry.get(j);
					HenhouseInfo henhouseInfo = henhouseEntryInfo.getHenhouse();
					if(henhouseInfo == null){
						throw new BOSException("鸡舍明细中【使用鸡舍】字段不能为空");
					}else{
						// 逐个鸡舍重新计算安全宰杀日期
						Date incoopDate = batchIncoopDates.get(henhouseInfo.getId().toString());
						// 入栏日期校验
						if(incoopDate == null){
							throw new BOSException("未取到鸡舍入栏日期信息，请核对使用鸡舍是否为当前申请批次对应鸡舍");
							
						}else{
							 
							 int beginDays = DateCommon.dateDiff(incoopDate, beginUseDate);
					    	 
					    	 int endDays = beginDays + useDays;
					    	 // 药残日龄
					    	 int safeDays = endDays + residueDays;
					    	 Calendar cal = Calendar.getInstance();
					    	 cal.setTime(incoopDate);
					    	 cal.add(Calendar.DATE, safeDays);
					    	 Date safeDate = cal.getTime();
					    	 
					    	 henhouseEntryInfo.setSafeDays(safeDays);
					    	 henhouseEntryInfo.setSafeDate(safeDate);
					    	 henhouseEntryInfo.setBeginDays(beginDays);
					    	 henhouseEntryInfo.setEndDays(endDays);
					    	 
						}
					}
					int safeDays = henhouseEntryInfo.getSafeDays();
					if(safeDays > limitedFeedDays){
						throw new BOSException("存在安全宰杀日龄大于最短饲喂周期"+limitedFeedDays+"的鸡舍，不能保存数据");
					}
				}
			}
	    }else{
	    	throw new BOSException("当前所在组织不能申请");
	    }
	}
	
	/**
     * 审核
     */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		MaterialApplyBillInfo billInfo = (MaterialApplyBillInfo)model;
		
		
			if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
				if(WorkFlowUtil.checkBillInWorkflow(ctx,billInfo.getId().toString())){
					throw new FarmException("当前单据尚在工作流执行过程中，请从 工作流中进行审批");
				}
				
				boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
				if(exist){
					throw new FarmException("已经存在下游单据，不能审核");
				}
				
				// 更新单据状态
				AppCommon.updateModelStatus(ctx, "CT_FM_MaterialApplyBill", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
				
			}else{
				throw new FarmException("只能审核提交状态的单据");
			}
		
		
	}

	/**
	 * 反审核
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException {
		
		MaterialApplyBillInfo billInfo = (MaterialApplyBillInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("已经存在下游单据，不能反审核");
			}
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_MaterialApplyBill", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
			
		}else{
			throw new FarmException("只能反审核审核状态的单据");
		}
		
	}
	
	
	/**
     * 养殖批次 变化
     * @param e
     * @throws BOSException 
     * @throws EASBizException 
     */
    public Map<String,Date> getBatchIncoopDate(Context ctx,BreedBatchInfo batchInfo) throws EASBizException, BOSException {
    	Map<String,Date> batchEncoopDates = new HashMap<String, Date>();
		BreedBatchEntryCollection entryColl = null;
		
		
		if(batchInfo != null){
			entryColl = batchInfo.getEntrys();
		}
		
		if(batchInfo != null){
			if(HenhouseType.CC_VALUE.equals(batchInfo.getHouseType().getValue())){
				// 批次中的分录逐个设置
				for(int i = 0; entryColl != null && i < entryColl.size(); i++){
					BreedBatchEntryInfo entryInfo = entryColl.get(i);
					
					entryInfo = BreedBatchEntryFactory.getLocalInstance(ctx).getBreedBatchEntryInfo(new ObjectUuidPK(entryInfo.getId()));
					HenhouseInfo henhouseInfo = entryInfo.getHenHouse();
					henhouseInfo = HenhouseFactory.getLocalInstance(ctx).getHenhouseInfo(new ObjectUuidPK(henhouseInfo.getId()));
					// 保存日龄
					Date encoopDate = entryInfo.getIncoopDate();
					
					if(encoopDate == null) //encoopDate = batchInfo.getBizDate();
					{
						MsgBox.showInfo("对应批次的分录中的入栏日期为空，请先维护好批次信息后再录入申请");
						SysUtil.abort();
					}
					batchEncoopDates.put(henhouseInfo.getId().toString(), encoopDate);
					
				}
			}else{
				Date bizDate = batchInfo.getBizDate();
				if(bizDate == null) //encoopDate = batchInfo.getBizDate();
				{
					MsgBox.showInfo("对应批次的入栏日期为空，请先维护好批次信息后再录入申请");
					SysUtil.abort();
				}
				
				for(int i = 0; entryColl != null && i < entryColl.size(); i++){
					BreedBatchEntryInfo entryInfo = entryColl.get(i);
					
					entryInfo = BreedBatchEntryFactory.getLocalInstance(ctx).getBreedBatchEntryInfo(new ObjectUuidPK(entryInfo.getId()));
					HenhouseInfo henhouseInfo = entryInfo.getHenHouse();
					
					batchEncoopDates.put(henhouseInfo.getId().toString(), bizDate);
					
				}
			}
		}
		
		return batchEncoopDates;
	}
    
}