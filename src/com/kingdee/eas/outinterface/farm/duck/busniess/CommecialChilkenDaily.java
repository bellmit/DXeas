package com.kingdee.eas.outinterface.farm.duck.busniess;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyAssEntryInfo;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyEntryInfo;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyFactory;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyInfo;
import com.kingdee.eas.farm.breed.business.ICommecialChilkenDaily;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.IBatch;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDaily;
import com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyAssEntryInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyEntryInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.outinterface.base.utils.ResultUtils;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 
 * @author zhanzg
 *商品鸡日报
 */
public class CommecialChilkenDaily extends AbstractOutInterfaceImpl {

private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "8506D469";
	}

	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{"*"
				,"farmer.name","farm.name","breedBatch.name"
				,"entrys.material.id","entrys.material.number","entrys.material.model","entrys.material.name"
				,"entrys.henhouse.name","entrys.henhouse.id","entrys.days","entrys.standardFeedQty","entrys.dailyQtyAll","entrys.waterQty","entrys.averageWeight"
				 // 鸡舍、日龄、饲料、规格  标准日饲喂量（g/只）  日喂料量(kg)   饮水量  只耗料(kg)
				,"AssEntrys.henhouse.id","AssEntrys.henhouse.name","AssEntrys.days","AssEntrys.cullAndDeath","AssEntrys.transQty","AssEntrys.breedingStock","AssEntrys.marketQty"
				//  鸡舍、日龄、当日死淘、出栏量、转栏量、存栏量 
				,"FodderPlanEntrys.fodderTower.id","FodderPlanEntrys.fodderTower.name"		
				,"FodderPlanEntrys.TowerInventory","FodderPlanEntrys.fodderMaterial.id"	,"FodderPlanEntrys.fodderMaterial.model","FodderPlanEntrys.fodderMaterial.name"	
				,"FodderPlanEntrys.fodderDate","FodderPlanEntrys.fodderQty"
				//  料塔、当前剩余库存、饲料、规格、要料日期、数量（kg）
		};
	}
	
	
	
	/**
	 * 获取单据后处理
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		CommecialChilkenDailyInfo info=(CommecialChilkenDailyInfo)model;
		info.getImmuneEntrys().clear();
		return model;
	}



	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","baseStatus","bizDate","farmer.name","farm.name","batch.name","breedBatch.number","breedBatch.baseStatus"};
	}
	
	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		return "order by bizDate desc";

	}
	
	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException {
		JSONObject paramsJson=JSONObject.parseObject(jsonStr);
		JSONObject resutlJson = super.getData(ctx, jsonStr);		
		return resutlJson;
	}
	
	

	@Override
	public JSONObject uploadData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException {
		JSONObject jo=JSONObject.parseObject(jsonStr);		
		if(StringUtils.isEmpty(jo.getString("bizDate"))){
			jo.put("bizDate",sdf.format(new Date()));
		}		
		IBatch ibs = BatchFactory.getLocalInstance(ctx);
		if(jo.containsKey("id")) {
			if(checkHasExistsDaliy(ctx, jo.getString("id"), jo.getString("bizDate"))) {
				String batchNum=jo.getString("number");
				if(StringUtils.isEmpty(batchNum)){
					batchNum=ibs.getBatchInfo(new ObjectUuidPK(jo.getString("id"))).getNumber();
				}
				return ResultUtils.getResultError("批次:"+batchNum+"已存在当日日报");
			}
		}		
		return super.uploadData(ctx, jo.toJSONString());
	}
	
	/**
	 * 检查批次当日日报是否存在
	 * @param ctx
	 * @param batchId
	 * @param dateStr
	 * @throws BOSException 
	 */
	private static boolean checkHasExistsDaliy(Context ctx,String batchId,String dateStr) throws BOSException {
		if(dateStr.length()>10) {
			dateStr=dateStr.substring(0,10);
		}
		StringBuffer sql=new StringBuffer();
		sql.append(" select 1")
		.append(" from CT_FM_CommecialChilkenDaily tmain")
		.append(" where to_char(tmain.FBizDate,'yyyy-MM-dd')='").append(dateStr).append("'")
		.append(" and tmain.CFBreedBatchID='").append(batchId).append("'")
		.append(" ");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		if(rs.size()>0){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	@Override
	public CoreBaseInfo dealBeforeSave(Context ctx, CoreBaseInfo model) throws BOSException, EASBizException {
		CommecialChilkenDailyInfo info =(CommecialChilkenDailyInfo) model;
		String companyId="";
		//业务日期
		if(info.getBizDate()==null) {
			info.setBizDate(new Date());
		}
		FarmInfo farmInfo=null;
		BatchContractBillInfo contractInfo=null;
		String settlementPolicyID=null;
		if(info.getBreedBatch()!=null) {
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("farm.*");
			slor.add("batchContract.*");
			slor.add("batchContract.settlementPolicy.*");
			BatchInfo batchInfo = BatchFactory.getLocalInstance(ctx).getBatchInfo(new ObjectUuidPK(info.getBreedBatch().getId()),slor);
			info.setFarmer(batchInfo.getFarmer());
			farmInfo=batchInfo.getFarm();
			info.setFarm(batchInfo.getFarm());
			contractInfo = batchInfo.getBatchContract();
			settlementPolicyID=batchInfo.getBatchContract().getSettlementPolicy().getId().toString();//获取结算政策
			if(info.getCompany()==null) {
				info.setCompany(batchInfo.getCompany());
				companyId=info.getCompany().getString("id");
			}
		}
//		//分录数据填充
		IMaterial ims = MaterialFactory.getLocalInstance(ctx);
		for(int index=0;index<info.getEntrys().size();index++) {
			CommecialChilkenDailyEntryInfo entryInfo= info.getEntrys().get(index);
			if(entryInfo.getMaterial()!=null) {
				MaterialInfo mInfo = ims.getMaterialInfo(new ObjectUuidPK( entryInfo.getMaterial().getId()));
				entryInfo.setMaterialName(mInfo.getName());
				entryInfo.setMaterialModel(mInfo.getModel());
			}
		}
		for(int index=0;index<info.getAssEntrys().size();index++){
			CommecialChilkenDailyAssEntryInfo assentryInfo= info.getAssEntrys().get(index);	
			if(String.valueOf(assentryInfo.getCullAndDeath())==null){
				assentryInfo.setCullAndDeath(0);
			}
		}
		return info;
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
//			queryStr.append(" and entrys.farmer.id='").append(jo.getString("farmer.id")).append("'");
			queryStr.append("and farmer.id='").append(jo.getString("farmer.id")).append("'");
		}
		//养殖场过滤
		if(StringUtils.isNotEmpty(jo.getString("farm.id"))) {
			queryStr.append(" and farm.id='").append(jo.getString("farm.id")).append("'");
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
//				rolesStr.append(" entrys.farmer.identity='").append(jo.getString("idNo")).append("'");
				rolesStr.append(" farmer.identity='").append(jo.getString("idNo")).append("'");
			}
			if(StringUtils.equalsIgnoreCase(role,"manager")){
				rolesStr.append(" farmer.id in (")
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
			queryStr.append(" AND (").append(rolesStr).append(") and entrys.seq=1");
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
		jo=ResultUtils.getResultSuccess();
		try {
			ICommecialChilkenDaily is = CommecialChilkenDailyFactory.getLocalInstance(ctx);
			SelectorItemCollection slor=new SelectorItemCollection();
			
			CommecialChilkenDailyInfo info = is.getCommecialChilkenDailyInfo(new ObjectUuidPK(id));
			info.setConfirmTime(new Date());
			slor.add("confirmTime");
			
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

	
	//通过饲喂标准获取物料名称
	public JSONObject getFieldMaterielName(Context ctx,String jsonStr) throws  BOSException {
		JSONObject resultJson = ResultUtils.getResultSuccess();
		JSONArray ja=new JSONArray();
		StringBuffer sql=new StringBuffer();
		sql.append("/*dialect*/select distinct t3.fname_l2 materiel from T_FM_FeedStd t1  ")
		.append("inner join T_FM_FeedStdTotalEntry t2 on t2.fparentid=t1.fid  ")
		.append("inner join T_BD_Material t3 on t3.fid=t2.FMaterialID ")
		.append("order by t3.fname_l2");		
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try {
			while(rs.next()) {
				String filedName="";
				JSONObject tmpJo=new JSONObject();
				switch(rs.getRow()) {
					case 1:
						filedName="feedMateriel2";
						break;
					case 2:
						filedName="feedMateriel1";
						break;
					case 3:
						filedName="feedMateriel3";
						break;
					case 4:
						filedName="feedMateriel4";
						break;
					default:
						filedName="feedMateriel4";
				}
				tmpJo.put("filedName",filedName);	
				tmpJo.put("materialName", rs.getString("materiel"));
				ja.add(tmpJo);
			}
		} catch (SQLException e) {
			return ResultUtils.getResultError(e);
		}
		resultJson.put("data", ja);
		return resultJson;
	}

	
	@Override
	public void dealAfterSave(Context ctx, CoreBaseInfo model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super.dealAfterSave(ctx, model);
		CommecialChilkenDailyInfo info = (CommecialChilkenDailyInfo) model;
		CommecialChilkenDailyFactory.getLocalInstance(ctx).submit(info);
		CommecialChilkenDailyFactory.getLocalInstance(ctx).audit(info);
		if(info.getId()!=null) {
			//单据状态改为提交
//			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
//			info.setBillStatus(BillBaseStatusEnum.AUDITED);
//			SelectorItemCollection slor=new SelectorItemCollection();
//			slor.add("billStatus");
//			StockDailyNewFactory.getLocalInstance(ctx).updatePartial(info, slor);
		}
	}
}
