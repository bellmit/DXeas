package com.kingdee.eas.outinterface.farm.duck.stocking;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

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
import com.kingdee.eas.farm.stocking.basedata.FarmStageEnum;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.BasePriceBean;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo;
import com.kingdee.eas.farm.stocking.processbizill.TransFodderBillEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.TransFodderBillFactory;
import com.kingdee.eas.farm.stocking.processbizill.TransFodderBillInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;

/**
 * 转料单
 * 调料单
 * @author alex_dai
 *
 */
public class TransFodderBill  extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		return "AF6AF160";
	}

	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{"*","farm.name"
				,"stockingBatch.number","farmer.name"
				,"driver.drivername","driver.drivercardid"
				,"person.number","person.name"
				,"entrys.*"
				,"entrys.material.number","entrys.material.name","entrys.material.model"	
				,"entrys.unit.number","entrys.unit.name"
				,"entrys.warehouse.number","entrys.warehouse.name"
				,"entrys.orderFarmer.name","entrys.orderFarm.name"
				,"entrys.orderStockingBatch.number"
				,"entrys.orderPerson.number","entrys.orderPerson.name"
				,"entrys.orderWarehouse.number","entrys.orderWarehouse.name"
			
		};
	}
	
	/**
	 * 获取单据后处理
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		TransFodderBillInfo info=(TransFodderBillInfo) model;
		//移除签名数据
//		info.setSignData(null);
		return info;
	}

	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","billStatus","bizDate"
				,"farmer.name"
				,"stockingBatch.number"
				,"entrys.orderStockingBatch.number"
				,"entrys.orderFarmer.name"
				,"entrys.materialName"
				,"entrys.confirmQty"
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
		TransFodderBillInfo info = (TransFodderBillInfo) model;
		if(info.getBizDate()==null) {
			info.setBizDate(new Date());
		}
		String companyId="";
		String bizDateStr=new SimpleDateFormat("yyyy-MM-dd").format(info.getBizDate());
		com.kingdee.eas.farm.stocking.basedata.FarmInfo farmInfo=null;
		IStockingBatch ibs = StockingBatchFactory.getLocalInstance(ctx);
		BatchContractInfo contractInfo=null;
		StockingBatchInfo batchInfo =null;
		SelectorItemCollection slor=new SelectorItemCollection();
		slor.add("*");
		slor.add("farm.*");
		slor.add("batchContract.*");
		slor.add("batchContract.settlementPolicy.*");
		if(info.getStockingBatch()!=null) {
			batchInfo = ibs.getStockingBatchInfo(new ObjectUuidPK(info.getStockingBatch().getId()),slor);
			info.setFarmer(batchInfo.getFarmer());
			farmInfo=batchInfo.getFarm();
			info.setFarm(batchInfo.getFarm());
			contractInfo = batchInfo.getBatchContract();
			if(info.getCompany()==null) {
				info.setCompany(batchInfo.getCompany());
				companyId=info.getCompany().getString("id");
			}
			if(info.getStorageOrgUnit()==null) {
				info.setStorageOrgUnit(batchInfo.getFarm().getStorageOrgUnit());
			}
			//技术员
//			if(info.getPerson()==null&&info.getFarmer()!=null) {
//				String personId = StockingComm.getPersonByFarmer(ctx,info.getFarmer().getString("id"));
//				info.setString("person", personId);
//			}
			//养殖阶段
//			if(batchInfo.getMatureDate()!=null) {
//				info.setBreedStage(FarmStageEnum.eggs);
//			}else if(batchInfo.getBreedData()!=null) {
//				info.setBreedStage(FarmStageEnum.breed);
//			}else {
//				info.setBreedStage(FarmStageEnum.brood);
//			}
			//周日龄
			if(batchInfo.getInDate()!=null) {
				//周龄 *周*
				int[] result = StockingComm.getBreedWeekAndDay(info.getBizDate(), batchInfo.getInDate());
				int week=result[0];
				int weekDay=result[1];
//				info.setWeekDays(week+"周"+weekDay);
			}
		}
		IMaterial ims = MaterialFactory.getLocalInstance(ctx);
		for(int index=0;index<info.getEntrys().size();index++) {
			TransFodderBillEntryInfo entryInfo = info.getEntrys().get(index);
			entryInfo.setConfirmQty(entryInfo.getTransQty());
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
				
				BigDecimal unitPrice=getFodderSettlePrice(ctx, contractInfo!=null?contractInfo.getString("id"):"", mInfo.getString("id"), entryInfo.getUnit().getString("id"));
				entryInfo.setConfirmQty(entryInfo.getTransQty());
				entryInfo.setBasePrice(unitPrice);
				entryInfo.setReceivePrice(unitPrice);
				entryInfo.setAmount(unitPrice.multiply(entryInfo.getTransQty()));
				
//				entryInfo.setWarehouse(StockingComm.getDefaultWarehouseByMaterial(ctx, batchInfo.getStorageOrgUnit()!=null?batchInfo.getString("id"):"",  mInfo.getString("id")));
				
			}
			//目标批次
			if(entryInfo.getOrderStockingBatch()!=null) {
				StockingBatchInfo orderBatchInfo = ibs.getStockingBatchInfo(new ObjectUuidPK(entryInfo.getOrderStockingBatch().getId()),slor);
				entryInfo.setOrderFarmer(orderBatchInfo.getFarmer());
				entryInfo.setOrderFarm(orderBatchInfo.getFarm());
//				String personId = StockingComm.getPersonByFarmer(ctx,orderBatchInfo.getFarmer().getString("id"));
//				info.setString("orderPerson", personId);
//				if(orderBatchInfo.getMatureDate()!=null) {
//					entryInfo.setOrderBreedStage(FarmStageEnum.eggs);
//				}else if(orderBatchInfo.getBreedData()!=null) {
//					entryInfo.setOrderBreedStage(FarmStageEnum.breed);
//				}else {
//					entryInfo.setOrderBreedStage(FarmStageEnum.brood);
//				}
				//周日龄
				if(orderBatchInfo.getInDate()!=null) {
					//周龄 *周*
					int[] result = StockingComm.getBreedWeekAndDay(info.getBizDate(), orderBatchInfo.getInDate());
					int week=result[0];
					int weekDay=result[1];
//					entryInfo.setOrderWeekDays(week+"周"+weekDay);
				}
				
				if(entryInfo.getMaterial()!=null) {
					BatchContractInfo orderContractInfo = orderBatchInfo.getBatchContract();
					BigDecimal unitPrice=getFodderSettlePrice(ctx, orderContractInfo!=null?orderContractInfo.getString("id"):"", 
							entryInfo.getMaterial().getString("id"), entryInfo.getUnit().getString("id"));
					entryInfo.setConfirmQty(entryInfo.getConfirmQty());
					entryInfo.setBasePrice(unitPrice);
					entryInfo.setReceivePrice(unitPrice);
					entryInfo.setAmount(unitPrice.multiply(entryInfo.getConfirmQty()));
					
//					entryInfo.setWarehouse(StockingComm.getDefaultWarehouseByMaterial(ctx, orderBatchInfo.getStorageOrgUnit()!=null?orderBatchInfo.getString("id"):"",
//							entryInfo.getMaterial().getString("id")));
					
				}
			}
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
					for(int index=0;index<entrys.size();) {
						JSONObject tmpjo = entrys.getJSONObject(index);
						if(!entryIdsList.contains(tmpjo.getString("id"))) {
							entrys.remove(tmpjo);
						}else{
							index++;
						}
					}
				}
			}
		}
		return resutlJson;
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




	@Override
	public void dealAfterSave(Context ctx, CoreBaseInfo model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super.dealAfterSave(ctx, model);
		TransFodderBillInfo info = (TransFodderBillInfo) model;
		TransFodderBillFactory.getLocalInstance(ctx).submit(info);
		/*if(info.getId()!=null) {
			//单据状态改为提交
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("billStatus");
			TransFodderBillFactory.getLocalInstance(ctx).updatePartial(info, slor);
		}*/
	}
	
}
