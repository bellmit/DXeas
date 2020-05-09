package com.kingdee.eas.outinterface.farm.duck.stocking;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.BasePriceBean;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo;
import com.kingdee.eas.farm.stocking.processbizill.FodderBillType;
import com.kingdee.eas.farm.stocking.processbizill.FodderReceiveBillEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.FodderReceiveBillEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.FodderReceiveBillFactory;
import com.kingdee.eas.farm.stocking.processbizill.FodderReceiveBillInfo;
import com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBillEntry;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.outinterface.base.utils.ResultUtils;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 饲料领用单
 * @author alex_dai
 *
 */
public class FodderReceiveBill extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "F330056F";
	}
	
	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{"*"
				,"returnCompany.number","returnCompany.name"
				,"entrys.*"
//				,"entrys.farmer.id","entrys.farmer.name"
				,"entrys.farm.id","entrys.farm.name"
				,"entrys.stockingBatch.id","entrys.stockingBatch.number","entrys.stockingBatch.name"
				,"entrys.batchContract.id","entrys.batchContract.number","entrys.batchContract.name"
				,"entrys.material.id","entrys.material.number","entrys.material.name","entrys.material.model"
		};
	}

	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","billStatus","bizDate","billType"
				,"entrys.id","entrys.materialName","entrys.model"
				,"farmer.name","farm.name","stockingBatch.number","stockingBatch.name"
				,"batchContract.number"
				,"entrys.receiveQty","entrys.confirmQty","entrys.receivePrice","entrys.bagQty"
				,"entrys.confirmTime","entrys.weekAge","entrys.amount"
		};
	}
	
	
	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		return "order by number desc,entrys.seq";
	}
	/**
	 * 获取单据后处理
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		FodderReceiveBillInfo info=(FodderReceiveBillInfo) model;
		//移除签名数据
		for(int index=0;index<info.getEntrys().size();index++){
//			info.getEntrys().get(index).setSignData(null);
		}
		return info;
	}

	
	
	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException {
		JSONObject paramsJson=JSONObject.parseObject(jsonStr);
		JSONObject resutlJson = super.getData(ctx, jsonStr);
		
		//由于存在多张养户在一张领用单上得情况，所以前端传入查询List(已过滤)获取到得entryId，单据展示是只展示有权限得分录
		if(resutlJson.getString("result").equals("0")&&paramsJson.containsKey("entryId")) {
			List entryIdsList = JSONArray.toJavaObject(paramsJson.getJSONArray("entryId"), List.class);
			if(entryIdsList.size()>0) {
				if(resutlJson.getJSONObject("data")!=null){
					JSONArray entrys = resutlJson.getJSONObject("data").getJSONArray("entrys");
					for(int index=0;index<entrys.size();index++) {
						JSONObject tmpjo = entrys.getJSONObject(index);
						if(!entryIdsList.contains(tmpjo.getString("id"))) {
							entrys.remove(tmpjo);
						}
					}
				}
			}
		}
		return resutlJson;
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
			queryStr.append(" and entrys.farmer.id='").append(jo.getString("farmer.id")).append("'");
		}
		//角色
		String rolesStr=StockingInterfaceUtils.getRoleFilterStr(jo, "entrys.farmer");
		if(rolesStr.length()>0) {
//			queryStr.append(" AND (").append(rolesStr).append(")");
		}
		
		return queryStr.toString();
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
			IFodderReceiveBillEntry is = FodderReceiveBillEntryFactory.getLocalInstance(ctx);
			SelectorItemCollection slor=new SelectorItemCollection();
			
			for(int index=0;index<entryId.size();index++) {
				FodderReceiveBillEntryInfo info = is.getFodderReceiveBillEntryInfo(new ObjectUuidPK(entryId.getString(index)));
				info.setConfirmDate(new Date());
				slor.add("confirmDate");
				
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
	public CoreBaseInfo dealBeforeSave(Context ctx, CoreBaseInfo model) throws BOSException, EASBizException {
		FodderReceiveBillInfo info = (FodderReceiveBillInfo) model;
		if(info.getBizDate()==null){
			info.setBizDate(new Date());
		}
		if(!FodderBillType.Return.equals(info.getBillType())) {
			info.setReturnCompany(null);
		}
		String companyId="";
		String bizDateStr=new SimpleDateFormat("yyyy-MM-dd").format(info.getBizDate());
		IStockingBatch ibs = StockingBatchFactory.getLocalInstance(ctx);
		IMaterial ims = MaterialFactory.getLocalInstance(ctx);
		for(int index=0;index<info.getEntrys().size();index++) {
			FodderReceiveBillEntryInfo entryInfo = info.getEntrys().get(index);
			StockingBatchInfo batchInfo =null;
			BatchContractInfo contractInfo = null;
			if(entryInfo.getStockingBatch()!=null) {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				slor.add("batchContract.settlementPolicy.*");
				slor.add("farm.*");
				batchInfo = ibs.getStockingBatchInfo(new ObjectUuidPK( entryInfo.getStockingBatch().getId()),slor);
				if(info.getStorageOrgUnit()==null) {
//					info.setStorageOrgUnit(batchInfo.getStorageOrgUnit());
				}
				entryInfo.setFarm(batchInfo.getFarm());
				if(entryInfo.getWarehouse()==null&&batchInfo.getFarm()!=null) {
					entryInfo.setWarehouse(batchInfo.getFarm().getWarehouse());//场部库
				}
				entryInfo.setFarmer(batchInfo.getFarmer());
				contractInfo=batchInfo.getBatchContract();
				entryInfo.setBatchContract(contractInfo);
				if(batchInfo.getInDate()!=null) {
					//周龄 *周*
					int[] result = StockingComm.getBreedWeekAndDay(info.getBizDate(), batchInfo.getInDate());
					int week=result[0];
					int weekDay=result[1];
					entryInfo.setWeekAge(week+"周"+weekDay);
				}
				if(info.getCompany()==null) {
					info.setCompany(batchInfo.getCompany());
					companyId=info.getCompany().getString("id");
				}
//				entryInfo.setCurrentBreedState(StockingComm.getBreedStage(ctx,batchInfo.getString("id"), info.getBizDate()));
				if(info.getStorageOrgUnit()==null) {
					info.setStorageOrgUnit(batchInfo.getFarm().getStorageOrgUnit());
				}
				//技术员
//				String personId = StockingComm.getPersonByFarmer(ctx,entryInfo.getFarmer().getString("id"));
//				entryInfo.setString("person", personId);
			}
			if(entryInfo.getMaterial()!=null){
				MaterialInfo mInfo = ims.getMaterialInfo(new ObjectUuidPK(entryInfo.getMaterial().getId()));
				entryInfo.setMaterialName(mInfo.getName());
				entryInfo.setModel(mInfo.getModel());
				entryInfo.setUnit(mInfo.getBaseUnit());
				entryInfo.setUnitQty(mInfo.getBigDecimal("unitQty"));
				
				if(entryInfo.getReceiveQty()==null) {
					entryInfo.setReceiveQty(BigDecimal.ZERO);
				}
				BigDecimal unitPrice=getFodderSettlePrice(ctx, contractInfo!=null?contractInfo.getString("id"):"", mInfo.getString("id"), entryInfo.getUnit().getString("id"));
				entryInfo.setConfirmQty(entryInfo.getReceiveQty());
				entryInfo.setBasePrice(unitPrice);
				entryInfo.setReceivePrice(unitPrice);
				entryInfo.setAmount(unitPrice.multiply(entryInfo.getReceiveQty()));
				
//				entryInfo.setWarehouse(StockingComm.getDefaultWarehouseByMaterial(ctx, batchInfo.getStorageOrgUnit()!=null?batchInfo.getString("id"):"",  mInfo.getString("id")));
				
			}
		}
		return info;
	}
	
	/**
	 * 获取物料价格
	 * @param settlePolicyInfo
	 * @param materialId
	 * @return
	 * @throws BOSException 
	 */
	private BigDecimal getFodderSettlePrice(Context ctx,String contractID,String materialId,String unitID) throws BOSException {
		ArrayList<BasePriceBean> list = StockingComm.getBasePrice(null,StockingComm.PRRICE_OUT_TYPE,contractID,materialId,unitID);
		if(list!=null&&list.size()>0) {
			return list.get(0).getBasePrice();
		}
		return BigDecimal.ZERO;
	}

	private BigDecimal getSumFodderWgt(Context ctx,String batchId,String materialId,String bizDateStr) throws BOSException {
		StringBuffer sql=new StringBuffer();
		sql.append(" select isnull(sum(tentry.FConfirmQty),0) FQty")
		.append(" from T_FM_FodderReceiveBill tmain")
		.append(" inner join T_FM_FodderReceiveBillEntry tentry on tentry.fparentid=tmain.fid")
		.append(" where tmain.FBillStatus=4")
		.append(" and tmain.FBizDate<({d '").append(bizDateStr).append("'}+1)")
		.append(" and tentry.FBatchID='").append(batchId).append("'")
		.append(" and tentry.FMaterialID='").append(materialId).append("'")
		.append(" ");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try {
			if(rs.next()) {
				return rs.getBigDecimal("FQty");
			}
		} catch (SQLException e) {
			throw new BOSException(e);
		}
		return BigDecimal.ZERO;
	}

	@Override
	public void dealAfterSave(Context ctx, CoreBaseInfo model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super.dealAfterSave(ctx, model);
		FodderReceiveBillInfo info = (FodderReceiveBillInfo) model;
		FodderReceiveBillFactory.getLocalInstance(ctx).submit(info);
		/*if(info.getId()!=null) {
			//单据状态改为提交
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("billStatus");
			FodderReceiveBillFactory.getLocalInstance(ctx).updatePartial(info, slor);
		}*/
	}
}