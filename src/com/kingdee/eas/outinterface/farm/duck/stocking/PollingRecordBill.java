package com.kingdee.eas.outinterface.farm.duck.stocking;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.castor.util.Base64Decoder;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.farmpolling.IPollingRecordBill;
import com.kingdee.eas.custom.farmpolling.PollingRecordBillFactory;
import com.kingdee.eas.custom.farmpolling.PollingRecordBillInfo;
import com.kingdee.eas.custom.farmpolling.PollingRecordBillInventoryEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.outinterface.base.utils.ResultUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;

/**
 * 巡场记录
 * @author alex_dai
 *
 */
public class PollingRecordBill extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "9CFC4C15";
	}

	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{"*"
				,"farm.name","farmer.name","person.name"
				,"stockingBatch.number","stockingBatch.name"
				,"InventoryEntry.*"
				,"InventoryEntry.material.number","InventoryEntry.material.name","InventoryEntry.material.model"
				,"InventoryEntry.unit.number","InventoryEntry.unit.name"
		};
	}
	
	/**
	 * 获取单据后处理
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		PollingRecordBillInfo info=(PollingRecordBillInfo) model;
//		info.setSignData(null);
		return info;
	}


	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","billStatus","farmer.name","bizDate",
				"person.name","stockingBatch.name","stockingBatch.number","farm.name","confirmTime"};
	}
	
	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		return "order by bizDate desc";
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
		String rolesStr=StockingInterfaceUtils.getRoleFilterStr(jo, "farm");
		if(rolesStr.length()>0) {
			queryStr.append(" AND (").append(rolesStr).append(")");
		}
		return queryStr.toString();
	}
	
	
	/**
	 * 确认单据
	 */
	public static String confirm(Context ctx,String jsonStr) {
		JSONObject jo=JSONObject.parseObject(jsonStr);
		String id=jo.getString("id");
		String signData=jo.getString("signData");
		String confirmMsg=jo.getString("confirmMsg");
		jo=ResultUtils.getResultSuccess();
		try {
			IPollingRecordBill is = PollingRecordBillFactory.getLocalInstance(ctx);
			SelectorItemCollection slor=new SelectorItemCollection();
			
			PollingRecordBillInfo info = is.getPollingRecordBillInfo(new ObjectUuidPK(id));
			info.setConfirmTime(new Date());
			info.setConfirmMsg(confirmMsg);
			slor.add("confirmTime");
			slor.add("confirmMsg");
			
			if(StringUtils.isNotBlank(signData)){
//				info.setSignData(Base64Decoder.decode(signData));
				slor.add("signData");
			}
			is.updatePartial(info,slor);
		} catch (Exception e) {
			jo=ResultUtils.getResultError(e);
		}
		return jo.toJSONString();
	}


	@Override
	public CoreBaseInfo dealBeforeSave(Context ctx, CoreBaseInfo model) throws BOSException, EASBizException {
		PollingRecordBillInfo info=(PollingRecordBillInfo) model;
		if(info.getBizDate()==null) {
			info.setBizDate(new Date());
		}
		if(info.getStockingBatch()!=null) {
			StockingBatchInfo batchInfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(info.getStockingBatch().getString("id")));
			info.setCompany(batchInfo.getCompany());
			info.setFarm(batchInfo.getFarm());
			info.setFarmer(batchInfo.getFarmer());
			if(info.getDayAge()<=0&&batchInfo.getInDate()!=null){
				if(batchInfo.getInDate()!=null) {
					//周龄 *周*
					int[] result = StockingComm.getBreedWeekAndDay(info.getBizDate(), batchInfo.getInDate());
					int week=result[0];
					int weekDay=result[1];
//					info.setWeekAge(week+"周"+weekDay);
					//日龄
					info.setDayAge(StockingComm.getDayAgeByWeekAge(ctx, batchInfo, week, weekDay));
				}
			}
		}else {
			if(info.getFarm()!=null) {
				FarmInfo farmInfo=FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(info.getFarm().getId()));
				info.setFarmer(StockingInterfaceUtils.getFarmerByFarm(ctx,farmInfo));
				info.setCompany(farmInfo.getCompany());
			}
		}
		//技术员 
		if(info.getPerson()==null&&info.getFarmer()!=null) {
//			String personId = StockingComm.getPersonByFarmer(ctx,info.getFarmer().getString("id"));
//			info.setString("person", personId);
		}
		IMaterial ims = MaterialFactory.getLocalInstance(ctx);
		for(int index=0;index<info.getInventoryEntry().size();index++) {
			PollingRecordBillInventoryEntryInfo entryInfo = info.getInventoryEntry().get(index);
			if(entryInfo.getMaterial()!=null) {
				MaterialInfo mInfo=ims.getMaterialInfo(new ObjectUuidPK(entryInfo.getMaterial().getId()));
				entryInfo.setMaterialName(mInfo.getName());
				entryInfo.setUnitQty(mInfo.getBigDecimal("unitQty"));
				entryInfo.setModel(mInfo.getModel());
				entryInfo.setUnit(mInfo.getBaseUnit());
			}
		}
		return info;
	}
	
	
	@Override
	public void dealAfterSave(Context ctx, CoreBaseInfo model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super.dealAfterSave(ctx, model);
		PollingRecordBillInfo info = (PollingRecordBillInfo) model;
		if(info.getId()!=null) {
			//单据状态改为提交
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("billStatus");
			PollingRecordBillFactory.getLocalInstance(ctx).updatePartial(info, slor);
		}
		PollingRecordBillFactory.getLocalInstance(ctx).submit(info);
	}


}
