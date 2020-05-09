package com.kingdee.eas.outinterface.farm.duck.busniess;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitFactory;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillEntryInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBill;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.industry.emm.pm.SqlExecuteFacadeFactory;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.outinterface.base.utils.ResultUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 药品处方单
 * 药品领用单
 * @author alex_dai
 *
 */
public class DrugReceiveBill extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "0E74B6E6";
	}



	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{"*","farm.name","entrys.warehouse.number","entrys.warehouse.name",
				"entrys.material.number","entrys.material.name"	,"entrys.material.model"	
				,"entrys.unit.number","entrys.unit.name","entrys.warehouse.name"
				,"batch.number","farmer.name","entrys.*","person.id","person.name"

		};
	}

	/**
	 * 获取单据后处理
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		DrugReceiveBillInfo info=(DrugReceiveBillInfo) model;
		//移除签名数据
		info.setSignData(null);
		return info;
	}



	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","billStatus","farmer.name","bizDate","person.id","person.name"
				,"batch.number","entrys.seq","entrys.material.name","entrys.unit.name","entrys.confirmQty"
				,"confirmTime","entrys.amount","entrys.warehouse.name","entrys.receiveQty"
				,"costCenter.name","treeid.name","farm.mileStd","farm.gm"
		};
	}
	@Override
	public JSONObject getList(Context ctx, String jsonStr) throws BOSException,
	EASBizException, RemoteException {
		// TODO Auto-generated method stub
		JSONObject paramsJson=JSONObject.parseObject(jsonStr);
		JSONObject reusltJson = super.getList(ctx, jsonStr);
		JSONObject dataJsonDetail=null;
		JSONArray dataJson=null;
		BigDecimal qty=BigDecimal.ZERO, amount=BigDecimal.ZERO;
		if(reusltJson.getString("result").equals("0")) {
			dataJson=reusltJson.getJSONArray("data");
			if(!dataJson.isEmpty()){
				//        		for(int i=0;i<dataJson.size();i++){
				//        			qty=qty.add(dataJson.getJSONObject(i).getBigDecimal("entrys_receiveQty")==null ?BigDecimal.ZERO
				//        					:dataJson.getJSONObject(i).getBigDecimal("entrys_receiveQty"));
				//        			amount=amount.add(dataJson.getJSONObject(i).getBigDecimal("entrys_amount")==null ?BigDecimal.ZERO
				//        					:dataJson.getJSONObject(i).getBigDecimal("entrys_amount"));
				//        		}
				//不按页码返回，返回查询条件后的所有
				try {
					StringBuffer sql=new StringBuffer();
					sql.append("select sum(isnull(entry.FReceiveQty,0)) FReceiveQty, sum(isnull(entry.CFAmount,0)) CFAmount from T_FM_DrugReceiveBillEntry entry \n")
					.append(" inner join T_FM_DrugReceiveBill drug on drug.fid=entry.fparentid \n")
					.append(" inner join CT_FM_Farmer farmer on farmer.fid= drug.FFarmerID \n")
					.append(" where "+getListQueryStr2(ctx,paramsJson)+"");
					IRowSet rs= SqlExecuteFacadeFactory.getLocalInstance(ctx).executeQuery(sql.toString());
					if(rs.next()){
						qty=rs.getBigDecimal("FReceiveQty");
						amount=rs.getBigDecimal("CFAmount");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}                
				dataJsonDetail=dataJson.getJSONObject(0);
				dataJsonDetail.put("sum_amount", amount);
				dataJsonDetail.put("sum_qty", qty);
			}        	
		}


		return reusltJson;
	}
	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		String type=jo.getString("type");
		if(StringUtils.isEmpty(type)){
			type="ASC";
		}
		String bizDate=jo.getString("bizDate");
		String farmerName=jo.getString("farmer.name");
		String costCenterName=jo.getString("costCenter.name");
		String GM=jo.getString("farm.gm");
		String MILESTD=jo.getString("farm.mileStd");
		String treeName=jo.getString("treeid.name");
		String str=null;
		if(StringUtils.isNotEmpty(bizDate)){
			str=" bizDate desc " ;
		}else if(StringUtils.isNotEmpty(farmerName)){
			str=" farmer.name " +type;
		}else if(StringUtils.isNotEmpty(costCenterName)){
			str=" costCenter.name " +type;
		}else if(StringUtils.isNotEmpty(GM)){
			str=" farm.gm " +type;
		}else if(StringUtils.isNotEmpty(MILESTD)){
			str=" farm.mileStd " +type;
		}else if(StringUtils.isNotEmpty(treeName)){
			str=" TREEID.NAME " +type;
		}else{
			str=" bizDate desc " ;
		}
		return "order by "+str+", entrys.seq";
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
		jo=ResultUtils.getResultSuccess();
		try {
			IDrugReceiveBill is = DrugReceiveBillFactory.getLocalInstance(ctx);
			SelectorItemCollection slor=new SelectorItemCollection();

			DrugReceiveBillInfo info = is.getDrugReceiveBillInfo(new ObjectUuidPK(id));
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



	@Override
	public CoreBaseInfo dealBeforeSave(Context ctx, CoreBaseInfo model) throws BOSException, EASBizException {
		DrugReceiveBillInfo info = (DrugReceiveBillInfo) model;
		if(info.getBizDate()==null) {
			info.setBizDate(new Date());
		}
		String companyId="";
		String bizDateStr=new SimpleDateFormat("yyyy-MM-dd").format(info.getBizDate());
		FarmInfo farmInfo=null;
		BatchContractBillInfo contractInfo=null;
		String settlementPolicyID=null;
		if(info.getBatch()!=null) {
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("farm.*");
			slor.add("batchContract.*");
			slor.add("batchContract.settlementPolicy.*");
			BatchInfo batchInfo = BatchFactory.getLocalInstance(ctx).getBatchInfo(new ObjectUuidPK(info.getBatch().getId()),slor);
			info.setFarmer(batchInfo.getFarmer());
			farmInfo=batchInfo.getFarm();
			info.setFarm(batchInfo.getFarm());
			contractInfo = batchInfo.getBatchContract();
			contractInfo = BatchContractBillFactory.getLocalInstance(ctx).getBatchContractBillInfo(new ObjectUuidPK(contractInfo.getId()));
			settlementPolicyID=batchInfo.getBatchContract().getSettlementPolicy().getId().toString();//获取结算政策
			SettlePolicyInfo settleInfo = SettlePolicyFactory.getLocalInstance(ctx).getSettlePolicyInfo(new ObjectUuidPK(settlementPolicyID));
			info.setBatchContract(contractInfo);
			info.setInDate(batchInfo.getInDate());
			info.setInQty(batchInfo.getFemaleQty());

			info.setFarmerPhone(contractInfo.getMobileTel());
			info.setFarmAddress(contractInfo.getFarmAddress());
			info.setSettlePolicy(settleInfo);
			if(contractInfo.getBreedData() != null){
				BreedDataInfo  breedInfo = BreedDataFactory.getLocalInstance(ctx).getBreedDataInfo(new ObjectUuidPK(contractInfo.getBreedData().getId()));
				info.setBreedData(breedInfo);
			}

			if(contractInfo.getCostCenter() != null){
				CostCenterOrgUnitInfo costCenter = CostCenterOrgUnitFactory.getRemoteInstance().getCostCenterOrgUnitInfo(new ObjectUuidPK(contractInfo.getCostCenter().getId()));
				info.setCostcenter(costCenter);
			}
			if(contractInfo.getPerson() != null){
				PersonInfo  personInfo = PersonFactory.getLocalInstance(ctx).getPersonInfo(new ObjectUuidPK(contractInfo.getPerson().getId()));  
				info.setPerson(personInfo);
			}

			//开药金额
			calcDrugAmount(ctx,info);
			if(info.getCompany()==null) {
				info.setCompany(batchInfo.getCompany());
				companyId=info.getCompany().getString("id");
			}
			if(info.getStorageOrgUnit()==null) {
				info.setStorageOrgUnit(batchInfo.getFarm().getStorageOrgUnit());
			}
		}
		BigDecimal sumAmt=BigDecimal.ZERO;
		IMaterial ims = MaterialFactory.getLocalInstance(ctx);
		BigDecimal totalAmt = BigDecimal.ZERO;
		for(int index=0;index<info.getEntrys().size();index++) {
			DrugReceiveBillEntryInfo entryInfo = info.getEntrys().get(index);
			if(entryInfo.getMaterial()!=null) {
				MaterialInfo mInfo = ims.getMaterialInfo(new ObjectUuidPK( entryInfo.getMaterial().getId()));
				entryInfo.setMaterialName(mInfo.getName());
				entryInfo.setModel(mInfo.getModel());
				if(entryInfo.getUnit()==null) {
					entryInfo.setUnit(mInfo.getBaseUnit());
				}
				if(farmInfo!=null&&entryInfo.getWarehouse()==null) {
					//					entryInfo.setWarehouse(farmInfo.getDrugWarehouse());
				}
				if(entryInfo.getReceiveQty()==null) {
					entryInfo.setReceiveQty(BigDecimal.ZERO);
				}
				BigDecimal unitPrice=getDrugSettlePrice(ctx, settlementPolicyID, mInfo.getString("id"), bizDateStr);
				entryInfo.setConfirmQty(entryInfo.getReceiveQty());
				entryInfo.setBasePrice(unitPrice);
				entryInfo.setReceivePrice(unitPrice);
				BigDecimal amt=unitPrice.multiply(entryInfo.getReceiveQty());
				entryInfo.setAmount(amt);
				sumAmt=sumAmt.add(amt);
			}
		}
		info.setTotalAmt(sumAmt);
		info.setSaveAmount(sumAmt.add(UIRuleUtil.getBigDecimal(info.getHasDrugAmount())));
		return info;
	}

	private void calcDrugAmount(Context ctx, DrugReceiveBillInfo info) {
		// TODO Auto-generated method stub

		if(info.getBatchContract() != null){
			BatchContractBillInfo batchcontractInfo = (BatchContractBillInfo) info.getBatchContract();
			String s1 = "/*dialect*/ select t4.CFMaxSingleDrug maxDrug,sum(t2.CFAmount) amount from T_FM_DrugReceiveBill t1" +
			" inner join T_FM_DrugReceiveBillEntry t2 on t2.fparentid = t1.fid" +
			" inner join T_FM_BatchContractBill t3 on t3.fid=t1.FBatchContractID" +
			" inner join T_FM_SettlePolicy t4 on t4.fid = t3.FSettlementPolicyI"+
			" where t1.FBatchContractID = '"+batchcontractInfo.getId()+"' and t1.FBillStatus in (4,7)  group by t4.CFMaxSingleDrug";
			try {
				IRowSet r1 = DbUtil.executeQuery(ctx, s1.toString());
				//已开药总金额
				BigDecimal amount = BigDecimal.ZERO;
				if(r1.next()){
					amount = UIRuleUtil.getBigDecimal(r1.getBigDecimal("amount"));
				}

				//已开药单只金额
				if(UIRuleUtil.getBigDecimal(info.getInQty()).compareTo(BigDecimal.ZERO) >0){
					info.setHasOneDrug(amount.divide(UIRuleUtil.getBigDecimal(info.getInQty()),2,RoundingMode.HALF_UP));
				}else{
					info.setHasOneDrug(BigDecimal.ZERO);
				}



				String s2 = "/*dialect*/ select t4.CFMaxSingleDrug maxDrug  from  T_FM_BatchContractBill t3  inner join T_FM_SettlePolicy t4 on t4.fid = t3.FSettlementPolicyI where t3.fid = '"+batchcontractInfo.getId()+"'";
				IRowSet r2 = DbUtil.executeQuery(ctx, s2.toString());
				//最高单只药品
				BigDecimal maxDrug = BigDecimal.ZERO;
				if(r2.next()){
					maxDrug = UIRuleUtil.getBigDecimal(r2.getBigDecimal("maxDrug"));
				}

				//最高开药金额
				BigDecimal hignDrugAmount = maxDrug.multiply(UIRuleUtil.getBigDecimal(info.getInQty()));
				info.setHasDrugAmount(amount);
				info.setHignDrugAmount(hignDrugAmount);
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}




	}



	/**
	 * 获取物料价格(从结算政策获取基本价格)
	 * @param settlePolicyInfo
	 * @param materialId
	 * @return
	 * @throws BOSException 
	 */
	private BigDecimal getDrugSettlePrice(Context ctx,String settlementPolicyID,String materialId,String bizDateStr) throws BOSException {
		StringBuffer sql=new StringBuffer();
		if(settlementPolicyID!=null&&materialId!=null){
			sql.append(" select top 1 isnull(entry.FBasePrice,0) price from T_FM_SettlePolicyPriceEntry entry \n")
			.append(" inner join T_FM_SettlePolicy settle on settle.fid=entry.fparentid \n")
			.append(" where settle.fid='"+settlementPolicyID+"' \n")
			.append(" and entry.FMaterialID='"+materialId+"'")
			.append(" ");
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			try {
				if(rs.next()) {
					return rs.getBigDecimal("price");
				}
			} catch (SQLException e) {
				throw new BOSException(e);
			}
		}		
		return BigDecimal.ZERO;
	}



	@Override
	public void dealAfterSave(Context ctx, CoreBaseInfo model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super.dealAfterSave(ctx, model);
		DrugReceiveBillInfo info = (DrugReceiveBillInfo) model;
		DrugReceiveBillFactory.getLocalInstance(ctx).submit(info);
		//		if(info.getId()!=null) {
		//			//单据状态改为提交
		//			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		//			SelectorItemCollection slor=new SelectorItemCollection();
		//			slor.add("billStatus");
		//			DrugReceiveBillFactory.getLocalInstance(ctx).updatePartial(info, slor);
		//		}
	}

	protected String getListQueryStr2(Context ctx, JSONObject jo) throws BOSException {
		String beginDate=JUtils.getDateStr(jo, "beginDate", JUtils.SDF_DAY);
		String endDate=JUtils.getDateStr(jo, "endDate", JUtils.SDF_DAY);
		StringBuffer queryStr= new StringBuffer();
		queryStr.append(" FBizDate>={d '").append(beginDate).append("'}")
		.append(" and FBizDate<{d '").append(endDate).append("'}");

		//养户过滤
		if(StringUtils.isNotEmpty(jo.getString("farmer.id"))) {
			queryStr.append(" and FFarmerID='").append(jo.getString("farmer.id")).append("'");
		}
		//养殖场过滤
		if(StringUtils.isNotEmpty(jo.getString("farm.id"))) {
			queryStr.append(" and FFarmID='").append(jo.getString("farm.id")).append("'");
		}
		//批次合同
		if(StringUtils.isNotEmpty(jo.getString("batchContract.id"))) {
			queryStr.append(" and FBatchContractID='").append(jo.getString("batchContract.id")).append("'");
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
				rolesStr.append(" farmer.FIdentity='").append(jo.getString("idNo")).append("'");
			}
			if(StringUtils.equalsIgnoreCase(role,"manager")){
				rolesStr.append(" farmer.fid in (")
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
			queryStr.append(" AND (").append(rolesStr).append(")");
		}

		return queryStr.toString();
	}


}
