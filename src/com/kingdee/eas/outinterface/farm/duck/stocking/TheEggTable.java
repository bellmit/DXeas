package com.kingdee.eas.outinterface.farm.duck.stocking;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.castor.util.Base64Decoder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.hatch.EggSourceType;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.ITheEggTableEntry;
import com.kingdee.eas.farm.stocking.processbizill.TheEggTableEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.TheEggTableEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.TheEggTableFactory;
import com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.outinterface.base.utils.ResultUtils;
import com.kingdee.eas.util.app.ContextUtil;

/**
 * 交蛋表
 * @author alex_dai
 *
 */
public class TheEggTable extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		return "92FD45D5";
	}

	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{"*"
				,"entrys.material.number","entrys.material.name"
				,"entrys.material.model"	
				,"entrys.unit.number","entrys.unit.name"
				,"entrys.stockingBatch.number"
				,"entrys.farmersTree.name"
				,"entrys.farmer.name","entrys.*"
				,"entrys.farm.name"
				
		};
	}
	
	/**
	 * 获取单据后处理
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		TheEggTableInfo info=(TheEggTableInfo) model;
		//移除签名数据
//		info.setSignData(null);
		return info;
	}



	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","billStatus","bizDate"
				,"material.name"
				,"farmer.name"
				,"farm.name"
				,"house.name"
				,"stockingBatch.number"
				,"entrys.sendAllQty"
				,"entrys.id"
		};
	}
	
	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		return "order by number desc,entrys.seq";
	}

	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		String beginDate=JUtils.getDateStr(jo, "beginDate", JUtils.SDF_DAY);
		String endDate=JUtils.getDateStr(jo, "endDate", JUtils.SDF_DAY);
		StringBuffer queryStr= new StringBuffer();
		queryStr.append(" bizDate>={d '").append(beginDate).append("'}")
		.append(" and bizDate<{d '").append(endDate).append("'}");
		
		//养户过滤
		if(StringUtils.isNotEmpty(jo.getString("farmer.id"))) {
			queryStr.append(" and entrys.farmer.id='").append(jo.getString("entrys.farmer.id")).append("'");
		}
		//角色
		String rolesStr=StockingInterfaceUtils.getRoleFilterStr(jo, "entrys.farmer");
		if(rolesStr.length()>0) {
//			queryStr.append(" AND (").append(rolesStr).append(")");
		}
		
		return queryStr.toString();
	}
	

	@Override
	public CoreBaseInfo dealBeforeSave(Context ctx, CoreBaseInfo model) throws BOSException, EASBizException {
		TheEggTableInfo info = (TheEggTableInfo) model;
		if(info.getBizDate()==null) {
			info.setBizDate(new Date());
		}
//		String companyId="";
//		String bizDateStr=new SimpleDateFormat("yyyy-MM-dd").format(info.getBizDate());
		
		IStockingBatch ibs = StockingBatchFactory.getLocalInstance(ctx);
		SelectorItemCollection slor=new SelectorItemCollection();
		slor.add("*");
		slor.add("farmer.*");
		slor.add("farm.*");
		for(int index=0;index<info.getEntrys().size();index++){
			TheEggTableEntryInfo entryInfo = info.getEntrys().get(index);
			if(entryInfo.getStockingBatch()==null) {
				continue;
			}
			StockingBatchInfo batchInfo = ibs.getStockingBatchInfo(new ObjectUuidPK(entryInfo.getStockingBatch().getString("id")),slor);
			entryInfo.setFarm(batchInfo.getFarm());
//			entryInfo.setFarmer(batchInfo.getFarmer());
//			entryInfo.setFarmersTree(batchInfo.getFarmer().getTreeid());
			entryInfo.setCostItem(batchInfo.getCostItem());
			entryInfo.setConfirmAllQty(entryInfo.getSendAllQty());
			entryInfo.setConfirmBasketQty(entryInfo.getSendBasketQty());
			if(batchInfo.getInDate()!=null) {
				//周龄 *周*
				int[] result = StockingComm.getBreedWeekAndDay(info.getBizDate(), batchInfo.getInDate());
				int week=result[0];
				int weekDay=result[1];
				entryInfo.setWeekAge(week+"周"+weekDay);
				//日龄
				entryInfo.setDayAge(StockingComm.getDayAgeByWeekAge(ctx, batchInfo, week, weekDay));
			}
			
			if(batchInfo.getFormalDate()!=null){
				entryInfo.setIsFormal(true);
			}else {
				entryInfo.setIsFormal(false);
			}
			if(entryInfo.getSendDate()==null) {
				entryInfo.setSendDate(new Date());
			}
//			if(entryInfo.getSendPerson()==null) {
//				entryInfo.setSendPerson(ContextUtil.getCurrentUserInfo(ctx).getName());
//			}
			if(info.getCompany()==null){
				info.setCompany(batchInfo.getCompany());
			}
			if(info.getStorageOrgUnit()==null) {
//				info.setStorageOrgUnit(batchInfo.getStorageOrgUnit());
			}
			if(StockingFarmTypeEnum.stocking.equals(batchInfo.getFarm().getFarmType())) {
				info.setEggSource(EggSourceType.SubContract);
			}else {
				info.setEggSource(EggSourceType.InternalFarm);
			}
		}
		return info;
	}
	
	
	/**
	 * 确认单据--分录
	 */
	public static String confirm(Context ctx,String jsonStr) {
		JSONObject jo=JSONObject.parseObject(jsonStr);
		String id=jo.getString("id");
		JSONArray entryId=jo.getJSONArray("entryIds");
		String signData=jo.getString("signData");
		jo=ResultUtils.getResultSuccess();
		try {
			ITheEggTableEntry is = TheEggTableEntryFactory.getLocalInstance(ctx);
			SelectorItemCollection slor=new SelectorItemCollection();
			
			for(int index=0;index<entryId.size();index++) {
				TheEggTableEntryInfo info = is.getTheEggTableEntryInfo(new ObjectUuidPK(entryId.getString(index)));
				info.setConfirmTime(new Date());
				info.setHasConfirm(true);
				slor.add("confirmTime");
				slor.add("hasConfirm");
				
				if(StringUtils.isNotBlank(signData)){
//					info.setSignData(Base64Decoder.decode(signData));
					slor.add("signData");
				}
				is.updatePartial(info,slor);
			}
		} catch (Exception e) {
			jo=ResultUtils.getResultError(e);
		}
		return jo.toJSONString();
	}




	@Override
	public void dealAfterSave(Context ctx, CoreBaseInfo model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super.dealAfterSave(ctx, model);
		TheEggTableInfo info = (TheEggTableInfo) model;
		TheEggTableFactory.getLocalInstance(ctx).submit(info);
		/*if(info.getId()!=null) {
			//单据状态改为提交
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("billStatus");
			TheEggTableFactory.getLocalInstance(ctx).updatePartial(info, slor);
		}*/
	}

}
