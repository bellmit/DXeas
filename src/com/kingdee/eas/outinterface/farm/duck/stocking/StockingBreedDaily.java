package com.kingdee.eas.outinterface.farm.duck.stocking;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.FarmStageEnum;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.BatchLastBean;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyAssEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyImmuneEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;

/**
 * 养殖日报
 * @author alex_dai
 *
 */
public class StockingBreedDaily extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		return "2859A756";
	}

	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{"*","farmer.name","farm.name","farmersTree.name"
				,"stockingBatch.number"
				,"entrys.*"
				,"AssEntrys.*"
				,"EggEntry.*"
				,"SendEggEntry.*"
				,"ImmuneEntrys.*"
				,"ImmuneEntrys.vaccineMaterial.number"
				,"ImmuneEntrys.vaccineMaterial.name"
				,"ImmuneEntrys.vaccineMaterial.model"
				,"Envi.*"
				,"TransEntry.*"
		};
	}
	
	/**
	 * 获取单据后处理
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		StockingBreedDailyInfo info=(StockingBreedDailyInfo) model;
		return info;
	}

	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","baseStatus","farmer.name","bizDate"
				,"stockingBatch.number","nowBreedStage","week","weekDay"
		};
	}
	
	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		return "order by number desc";
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
			queryStr.append(" and farmer.id='").append(jo.getString("farmer.id")).append("'");
		}
		//角色
		String rolesStr=StockingInterfaceUtils.getRoleFilterStr(jo, "farmer");
		if(rolesStr.length()>0) {
//			queryStr.append(" AND (").append(rolesStr).append(")");
		}
		
		return queryStr.toString();
	}
	
	
	@Override
	public CoreBaseInfo dealBeforeSave(Context ctx, CoreBaseInfo model) throws BOSException, EASBizException {
		StockingBreedDailyInfo info = (StockingBreedDailyInfo) model;
		if(info.getBizDate()==null) {
			info.setBizDate(new Date());
		}
		String companyId="";
		String bizDateStr=new SimpleDateFormat("yyyy-MM-dd").format(info.getBizDate());
		com.kingdee.eas.farm.stocking.basedata.FarmInfo farmInfo=null;
		BatchContractInfo contractInfo=null;
		StockingBatchInfo batchInfo=null;
		if(info.getStockingBatch()!=null) {
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("farm.*");
			slor.add("batchContract.*");
			slor.add("batchContract.settlementPolicy.*");
			batchInfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(info.getStockingBatch().getId()),slor);
			info.setFarmer(batchInfo.getFarmer());
			farmInfo=batchInfo.getFarm();
			info.setFarm(batchInfo.getFarm());
			contractInfo = batchInfo.getBatchContract();
			if(info.getCompany()==null) {
				info.setCompany(batchInfo.getCompany());
				companyId=info.getCompany().getString("id");
			}
			if(batchInfo.getMatureDate()!=null) {
				info.setNowBreedStage(FarmStageEnum.eggs);
			}else if(batchInfo.getBreedData()!=null) {
				info.setNowBreedStage(FarmStageEnum.breed);
			}else {
				info.setNowBreedStage(FarmStageEnum.brood);
			}
			if(batchInfo.getInDate()!=null) {
				//周龄 *周*
				int[] result = StockingComm.getBreedWeekAndDay(info.getBizDate(), batchInfo.getInDate());
				int week=result[0];
				int weekDay=result[1];
				info.setWeek(week);
				info.setWeekDay(weekDay);
			}
			
		}
		IMaterial ims = MaterialFactory.getLocalInstance(ctx);
		//饲喂分录
		for(int index=0;index<info.getEntrys().size();index++) {
			StockingBreedDailyEntryInfo entryInfo = info.getEntrys().get(index);
			if(entryInfo.getMaterial()!=null) {
				MaterialInfo mInfo=ims.getMaterialInfo(new ObjectUuidPK(entryInfo.getMaterial().getString("id")));
				entryInfo.setMaterialModel(mInfo.getModel());
				entryInfo.setMaterialName(mInfo.getName());
				if(entryInfo.getUnit()==null) {
					entryInfo.setUnit(mInfo.getBaseUnit());
				}
				if(entryInfo.getUnitQty()==null) {
					entryInfo.setUnitQty(mInfo.getBigDecimal("unitQty"));
				}
			}
		}
		//产蛋分录
		for(int index=0;index<info.getEggEntry().size();index++) {
			 StockingBreedDailyEggEntryInfo entryInfo = info.getEggEntry().get(index);
			 if(entryInfo.getMaterial()!=null) {
				MaterialInfo mInfo=ims.getMaterialInfo(new ObjectUuidPK(entryInfo.getMaterial().getString("id")));
				entryInfo.setMaterialName(mInfo.getName());
				entryInfo.setModel(mInfo.getModel());
				entryInfo.setUnit(mInfo.getBaseUnit());
			 }
		}
		//免疫分录
		for(int index=0;index<info.getImmuneEntrys().size();index++) {
			  StockingBreedDailyImmuneEntryInfo entryInfo = info.getImmuneEntrys().get(index);
			 if(entryInfo.getVaccineMaterial()!=null) {
				MaterialInfo mInfo=ims.getMaterialInfo(new ObjectUuidPK(entryInfo.getVaccineMaterial().getString("id")));
				entryInfo.setVaccineUnit(mInfo.getBaseUnit().getName());
			 }
		}
		//死淘分录
		for(int index=0;index<info.getAssEntrys().size();index++) {
		  StockingBreedDailyAssEntryInfo entryInfo = info.getAssEntrys().get(index);
		  //存栏
			//bean是初始存栏量
			BatchLastBean bean;
			try {
				bean = StockingComm.getEntryHouseBatchBean(ctx,null,companyId,info.getBizDate(),batchInfo.getString("id"), null);
			} catch (Exception e) {
				throw new BOSException(e);
			}
			if(bean==null) {
				continue;
			}
			BigDecimal deathQty=UIRuleUtil.getBigDecimal(entryInfo.getDeathQty());
			BigDecimal femaleDeathQty=UIRuleUtil.getBigDecimal(entryInfo.getFemaleDeathQty());
			BigDecimal cullQty=UIRuleUtil.getBigDecimal(entryInfo.getCullQty());
			BigDecimal femaleCullQty=UIRuleUtil.getBigDecimal(entryInfo.getFemaleCullQty());

			BigDecimal adjustQty=UIRuleUtil.getBigDecimal(entryInfo.getAdjustQty());
			BigDecimal femaleAdjustQty=UIRuleUtil.getBigDecimal(entryInfo.getAdjustFemaleQty());
			
			BigDecimal markedQty=UIRuleUtil.getBigDecimal(entryInfo.getMarkedQty());
			BigDecimal femaleMarkedQty=UIRuleUtil.getBigDecimal(entryInfo.getFemaleMarketed());

			BigDecimal lastQty=bean.getLaskStock().subtract(deathQty).subtract(cullQty).add(adjustQty);
			BigDecimal femaleLastQty=bean.getFemaleLaskStock().subtract(femaleDeathQty).subtract(femaleCullQty).add(femaleAdjustQty);
			
			entryInfo.setFemaleBreedkingStock(lastQty);
			entryInfo.setBreekingStock(femaleLastQty.intValue());
		}
		return info;
	}
	
	@Override
	public void dealAfterSave(Context ctx, CoreBaseInfo model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super.dealAfterSave(ctx, model);
		StockingBreedDailyInfo info = (StockingBreedDailyInfo) model;
		StockingBreedDailyFactory.getLocalInstance(ctx).submit(info);
		/*if(info.getId()!=null) {
			//单据状态改为提交
			info.setBaseStatus(BillBaseStatusEnum.SUBMITED);
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("billStatus");
			StockingBreedDailyFactory.getLocalInstance(ctx).updatePartial(info, slor);
		}*/
	}

}
