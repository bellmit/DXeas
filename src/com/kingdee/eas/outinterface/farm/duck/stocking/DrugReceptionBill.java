package com.kingdee.eas.outinterface.farm.duck.stocking;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.BasePriceBean;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo;
import com.kingdee.eas.farm.stocking.processbizill.DrugReceptionBillEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.DrugReceptionBillFactory;
import com.kingdee.eas.farm.stocking.processbizill.DrugReceptionBillInfo;
import com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBill;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.outinterface.base.utils.ResultUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;

/**
 * 药品处方单
 * @author alex_dai
 *
 */
public class DrugReceptionBill  extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		return "F16676F1";
	}

	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{"*","farm.name","entrys.warehouse.number","entrys.warehouse.name",
				"entrys.material.number","entrys.material.name"	,"entrys.material.model"	
				,"entrys.unit.number","entrys.unit.name"
				,"stockingBatch.number","farmer.name","entrys.*"
			
		};
	}
	
	/**
	 * 获取单据后处理
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		DrugReceptionBillInfo info=(DrugReceptionBillInfo) model;
		//移除签名数据
//		info.setSignData(null);
		return info;
	}



	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","billStatus","farmer.name","bizDate",
				"stockingBatch.number","entrys.seq","entrys.material.name","entrys.unit.name","entrys.confirmQty"
				,"confirmTime","company.name"
		};
	}
	
	
	@Override
	public JSONObject deleteData(Context ctx, String jsonStr)
			throws BOSException, EASBizException, RemoteException {
		// TODO Auto-generated method stub
		return super.deleteData(ctx, jsonStr);
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
			queryStr.append(" and farmer.id='").append(jo.getString("farmer.id")).append("'");
		}
		//角色
		String rolesStr=StockingInterfaceUtils.getRoleFilterStr(jo, "farmer");
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
			IDrugReceptionBill is = DrugReceptionBillFactory.getLocalInstance(ctx);
			SelectorItemCollection slor=new SelectorItemCollection();
			
			DrugReceptionBillInfo info = is.getDrugReceptionBillInfo(new ObjectUuidPK(id));
			info.setConfirmTime(new Date());
			slor.add("confirmTime");
			
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
		DrugReceptionBillInfo info = (DrugReceptionBillInfo) model;
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
			info.setBatchContract(contractInfo);
			if(info.getCompany()==null) {
				info.setCompany(batchInfo.getCompany());
				companyId=info.getCompany().getString("id");
			}
//			if(info.getStorageOrgUnit()==null) {
//				info.setStorageOrgUnit(batchInfo.getStorageOrgUnit());
//			}
//			//养殖阶段
//			info.setNowBreedState(StockingComm.getBreedStage(ctx,info.getStockingBatch().getString("id"), info.getBizDate()));
		}
		BigDecimal sumAmt=BigDecimal.ZERO;
		IMaterial ims = MaterialFactory.getLocalInstance(ctx);
		for(int index=0;index<info.getEntrys().size();index++) {
			DrugReceptionBillEntryInfo entryInfo = info.getEntrys().get(index);
			if(entryInfo.getMaterial()!=null) {
				MaterialInfo mInfo = ims.getMaterialInfo(new ObjectUuidPK( entryInfo.getMaterial().getId()));
				entryInfo.setMaterialName(mInfo.getName());
				entryInfo.setModel(mInfo.getModel());
				if(entryInfo.getUnit()==null) {
					entryInfo.setUnit(mInfo.getBaseUnit());
				}
				if(farmInfo!=null&&entryInfo.getWarehouse()==null) {
					entryInfo.setWarehouse(farmInfo.getWarehouse());//场部库
				}
				if(entryInfo.getReceiveQty()==null) {
					entryInfo.setReceiveQty(BigDecimal.ZERO);
				}
				BigDecimal unitPrice=getDrugSettlePrice(ctx, contractInfo!=null?contractInfo.getString("id"):"", mInfo.getString("id"), entryInfo.getUnit().getString("id"));
				entryInfo.setConfirmQty(entryInfo.getReceiveQty());
				entryInfo.setBasePrice(unitPrice);
				entryInfo.setReceivePrice(unitPrice);
				
//				entryInfo.setWarehouse(StockingComm.getDefaultWarehouseByMaterial(ctx, batchInfo.getStorageOrgUnit()!=null?batchInfo.getString("id"):"",  mInfo.getString("id")));
				
				BigDecimal amt=unitPrice.multiply(entryInfo.getReceiveQty());
				entryInfo.setAmount(amt);
				sumAmt=sumAmt.add(amt);
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
	private BigDecimal getDrugSettlePrice(Context ctx,String contractID,String materialId,String unitID) throws BOSException {
		ArrayList<BasePriceBean> list = StockingComm.getBasePrice(null,StockingComm.PRRICE_OUT_TYPE,contractID,materialId,unitID);
		if(list!=null&&list.size()>0) {
			return list.get(0).getBasePrice();
		}
		return BigDecimal.ZERO;
	}



	@Override
	public void dealAfterSave(Context ctx, CoreBaseInfo model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super.dealAfterSave(ctx, model);
		DrugReceptionBillInfo info = (DrugReceptionBillInfo) model;
		DrugReceptionBillFactory.getLocalInstance(ctx).submit(info);
		/*if(info.getId()!=null) {
			//单据状态改为提交
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("billStatus");
			DrugReceptionBillFactory.getLocalInstance(ctx).updatePartial(info, slor);
		}*/
	}
	

}
