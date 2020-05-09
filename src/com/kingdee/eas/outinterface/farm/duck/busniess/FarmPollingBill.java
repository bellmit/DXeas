package com.kingdee.eas.outinterface.farm.duck.busniess;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.castor.util.Base64Decoder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillInventoryEntryInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBill;
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
public class FarmPollingBill extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "862C8570";
	}
	

	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{"*"
				,"farms.name","farmers.name","person.name"
				,"batch.number","batch.name"
				,"InventoryEntry.*"
				,"InventoryEntry.material.number","InventoryEntry.material.name","InventoryEntry.material.model"
				,"InventoryEntry.unit.number","InventoryEntry.unit.name"
				,"batchContract.id","signOutTime","signOutAddress"
		};
	}
	
	/**
	 * 获取单据后处理
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		FarmPollingBillInfo info=(FarmPollingBillInfo) model;
		info.setSignData(null);
		return info;
	}


	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","billStatus","farmers.name","bizDate","stockingFemaleQty","dayAge"//存栏、日龄
				,"person.name","batch.name","batch.number","farms.name","confirmTime"};
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
			queryStr.append(" and farmers.id='").append(jo.getString("farmer.id")).append("'");
		}
		
		//养殖场过滤
		if(StringUtils.isNotEmpty(jo.getString("farm.id"))) {
			queryStr.append(" and farm.id='").append(jo.getString("farm.id")).append("'");
		}
		//批次合同
		if(StringUtils.isNotEmpty(jo.getString("batchContract.id"))) {
			queryStr.append(" and batchContract.id='").append(jo.getString("batchContract.id")).append("'");
		}
		//角色
		StringBuffer rolesStr=new StringBuffer();
		JSONArray rolesArray = jo.getJSONArray("roles");
		for(int index=0;index<rolesArray.size();index++) {
			String role=rolesArray.getString(index);
			if(rolesStr.length()>0) {
				rolesStr.append(" OR ");
			}
			if(StringUtils.equalsIgnoreCase(role,"farmer")){
				rolesStr.append(" farmers.identity='").append(jo.getString("idNo")).append("'");
			}
			if(StringUtils.equalsIgnoreCase(role,"manager")){
				rolesStr.append(" farmers.id in (")
				.append(" select distinct tentry.FFarmerID")
				.append(" from T_FM_PersonFarmerRange tmain")
				.append(" inner join T_FM_PersonFarmerRangeEntry tentry on tentry.fparentid=tmain.fid")
				.append(" inner join t_pm_user tuser on tuser.fpersonid=tmain.FPersonID")
				.append(" where tuser.fnumber='").append(jo.getString("userNum")).append("'")
				.append(" and tmain.FBaseStatus=2")
				.append(")");
			}
		}
		if(rolesStr.length()>0) {
			queryStr.append(" AND (").append(rolesStr).append(") ");
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
			IFarmPollingBill is = FarmPollingBillFactory.getLocalInstance(ctx);
			SelectorItemCollection slor=new SelectorItemCollection();
			
			FarmPollingBillInfo info = is.getFarmPollingBillInfo(new ObjectUuidPK(id));
			info.setConfirmTime(new Date());
			info.setConfirmMsg(confirmMsg);
			slor.add("confirmTime");
			slor.add("confirmMsg");
			
			if(StringUtils.isNotBlank(signData)){
				info.setSignData(Base64Decoder.decode(signData));
				slor.add("signData");
			}
			is.updatePartial(info,slor);
		} catch (Exception e) {
			jo=ResultUtils.getResultError(e);
		}
		return jo.toJSONString();
	}
	
	/**
	 * 签退
	 */
	public static String signOut(Context ctx,String jsonStr) {
		JSONObject jo=JSONObject.parseObject(jsonStr);
		String id=jo.getString("id");
		String signOutAddress=jo.getString("signOutAddress");
		String signOutX=jo.getString("signOutX");
		String signOutY=jo.getString("signOutY");
		Calendar cal = Calendar.getInstance();
		Date day = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		sdf.format(day);
//		sdf.parse(sdf.format(day))
		jo=ResultUtils.getResultSuccess();
		try {
			IFarmPollingBill is = FarmPollingBillFactory.getLocalInstance(ctx);
			SelectorItemCollection slor=new SelectorItemCollection();
			FarmPollingBillInfo info = is.getFarmPollingBillInfo(new ObjectUuidPK(id));
			info.setSignOutTime(new Date());
			info.setSignOutAddress(signOutAddress);
			info.setSignOutX(new BigDecimal(signOutX));
			info.setSignOutY(new BigDecimal(signOutY));
			slor.add("signOutTime");
			slor.add("signOutAddress");
			slor.add("signOutX");
			slor.add("signOutY");
			is.updatePartial(info,slor);
		} catch (Exception e) {
			jo=ResultUtils.getResultError(e);
		}
		return jo.toJSONString();
	}


	@Override
	public CoreBaseInfo dealBeforeSave(Context ctx, CoreBaseInfo model) throws BOSException, EASBizException {
		FarmPollingBillInfo info=(FarmPollingBillInfo) model;
		if(info.getBizDate()==null) {
			info.setBizDate(new Date());
		}
		if(info.getBatch()!=null) {
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("batchContract.*");
			slor.add("farm.*");
			slor.add("farmer.*");
			slor.add("company.*");
			BatchInfo batchInfo = BatchFactory.getLocalInstance(ctx).getBatchInfo(new ObjectUuidPK(info.getBatch().getString("id")),slor);
			info.setBatchContract(batchInfo.getBatchContract());
			info.setCompany(batchInfo.getCompany());
			info.setFarms(batchInfo.getFarm());
			info.setFarmers(batchInfo.getFarmer());
//			if(batchInfo.getInDate()!=null){
//				int days = DuckBusinessUtils.getDayDiff(batchInfo.getInDate(), info.getBizDate())+1;
//				info.setDayAge(days);
//			}
		}else {
			if(info.getFarms()!=null) {
				FarmInfo farmInfo=FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(info.getFarms().getId()));
				info.setFarmers(farmInfo.getFarmer());
				info.setCompany(farmInfo.getCompany());
			}
		}
		if(info.getPerson()==null&&info.getFarmers()!=null) {
			info.setPerson(DuckBusinessUtils.getManagerPersonByFarmer(ctx, info.getFarmers().getString("id")));
		}
		IMaterial ims = MaterialFactory.getLocalInstance(ctx);
		for(int index=0;index<info.getInventoryEntry().size();index++) {
			FarmPollingBillInventoryEntryInfo entryInfo = info.getInventoryEntry().get(index);
			if(entryInfo.getMaterial()!=null) {
				MaterialInfo mInfo=ims.getMaterialInfo(new ObjectUuidPK(entryInfo.getMaterial().getId()));
				entryInfo.setMaterialName(mInfo.getName());
				if(entryInfo.getUnitQty()==null){
					entryInfo.setUnitQty(mInfo.getBigDecimal("unitQty"));
				}
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
		FarmPollingBillInfo info = (FarmPollingBillInfo) model;
		FarmPollingBillFactory.getLocalInstance(ctx).submit(info);
		FarmPollingBillFactory.getLocalInstance(ctx).audit(info);
//		if(info.getId()!=null) {
//			//单据状态改为提交
//			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
//			SelectorItemCollection slor=new SelectorItemCollection();
//			slor.add("billStatus");
//			FarmPollingBillFactory.getLocalInstance(ctx).updatePartial(info, slor);
//		}
	}

}