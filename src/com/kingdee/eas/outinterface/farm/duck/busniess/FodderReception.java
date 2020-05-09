package com.kingdee.eas.outinterface.farm.duck.busniess;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.castor.util.Base64Decoder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.IMaterialInventory;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryCollection;
import com.kingdee.eas.basedata.master.material.MaterialInventoryFactory;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.BunkerEnum;
import com.kingdee.eas.farm.carnivorous.basedata.IBatch;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionEntryFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionEntryInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBill;
import com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReception;
import com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReceptionEntry;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.industry.emm.pm.SqlExecuteFacadeFactory;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.outinterface.base.utils.ResultUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 饲料领用单
 * @author alex_dai
 *
 */

public class FodderReception extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "713C6B15";
	}
	
	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{"*","driver.drivername","car.name","car.driverName"
				,"farm.name","farmer.name","batchContract.number","batchContract.name"
				,"entrys.*","person.id","person.name","confirmTime"
				,"entrys.farmer.id","entrys.farmer.name"
				,"entrys.farm.id","entrys.farm.name"
				,"entrys.batch.id","entrys.batch.number","entrys.batch.name"
				,"entrys.batchContract.id","entrys.batchContract.number","entrys.batchContract.name"
				,"entrys.material.id","entrys.material.number","entrys.material.name","entrys.material.model"
				,"entrys.warehouse.name"
		};
	}

	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","billStatus","bizDate","driver.drivername","billType","farmer.name","batchContract.number","batch.name"
				,"entrys.id","entrys.materialName","entrys.model","carNo","person.id","person.name"
				,"entrys.farmer.name","entrys.farm.name","entrys.batch.number","entrys.batchContract.number"
				,"entrys.receiveQty","entrys.confirmQty","entrys.receivePrice","entrys.bagQty"
				,"entrys.confirmTime","entrys.weekAge","entrys.amount","confirmTime","warehouse.name"
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
		StringBuffer sql=new StringBuffer();
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
            		sql.append("select sum(isnull(entry.FReceiveQty,0)) FReceiveQty, sum(isnull(entry.CFAmount,0)) CFAmount from T_FM_FodderReceptionEntry entry \n")
            		   .append(" inner join T_FM_FodderReception drug on drug.fid=entry.fparentid \n")
            		   .append(" inner join CT_FM_Farmer farmer on farmer.fid= drug.CFFarmerID \n")
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
//		return "order by number desc,entrys.seq";
	}
	/**
	 * 获取单据后处理
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		FodderReceptionInfo info=(FodderReceptionInfo) model;
		//移除签名数据
//		for(int index=0;index<info.getEntrys().size();index++){
//			info.getEntrys().get(index).setSignData(null);
//		}
		info.setSignData(null);
		return info;
	}

	
	
	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException {
		JSONObject paramsJson=JSONObject.parseObject(jsonStr);
		JSONObject resutlJson = super.getData(ctx, jsonStr);
		
		//由于存在多张养户在一张领用单上得情况，所以前端传入查询List(已过滤)获取到得entryId，单据展示是只展示有权限得分录
//		if(resutlJson.getString("result").equals("0")&&paramsJson.containsKey("entryId")) {
//			List entryIdsList = JSONArray.toJavaObject(paramsJson.getJSONArray("entryId"), List.class);
//			if(entryIdsList.size()>0) {
//				if(resutlJson.getJSONObject("data")!=null){
//					JSONArray entrys = resutlJson.getJSONObject("data").getJSONArray("entrys");
//					for(int index=0;index<entrys.size();) {
//						JSONObject tmpjo = entrys.getJSONObject(index);
//						if(!entryIdsList.contains(tmpjo.getString("id"))) {
//							entrys.remove(tmpjo);
//						}else{
//							index++;
//						}
//					}
//				}
//			}
//		}
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
			if(StringUtils.equalsIgnoreCase(role,"driver")){
//				rolesStr.append(" driver.drivercardid='").append(jo.getString("idNo")).append("'");
//				rolesStr.append(" farmer.id in (")
//				.append(" select distinct tentry.FFarmerID")
//				.append(" from T_FM_PersonFarmerRange tmain")
//				.append(" inner join T_FM_PersonFarmerRangeEntry tentry on tentry.fparentid=tmain.fid")
//				.append(" inner join t_pm_user tuser on tuser.fpersonid=tmain.FPersonID")
//				.append(" where tuser.fnumber='").append(jo.getString("userNum")).append("'")
//				.append(" and tmain.FBaseStatus=3")
//				.append(")");
				//查出饲料领用单司机对应得养户
				rolesStr.append(" id in(select tmain.fid from  T_FM_FodderReception tmain\r\n" + 
						"inner join CT_PUB_Car car on car.fid=tmain.CFCarID\r\n" + 
						"inner join T_BD_Person person on person.fid=car.CFDriverID\r\n" + 
						"inner join t_pm_user tuser on tuser.fpersonid=car.CFDriverID\r\n" + 
						"where tuser.fnumber='姜文涛' and tmain.FBillStatus=4)");
			}
			
		}
		if(rolesStr.length()>0) {
			queryStr.append(" AND (").append(rolesStr).append(") ");
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
//		try {
//			IFodderReceptionEntry is = FodderReceptionEntryFactory.getLocalInstance(ctx);
//			SelectorItemCollection slor=new SelectorItemCollection();
//			
//			for(int index=0;index<entryId.size();index++) {
//				FodderReceptionEntryInfo info = is.getFodderReceptionEntryInfo(new ObjectUuidPK(entryId.getString(index)));
//				info.setConfirmTime(new Date());
//				slor.add("confirmTime");
//				
//				if(StringUtils.isNotBlank(signData)){
//					info.setSignData(Base64Decoder.decode(signData));
//					slor.add("signData");
//				}
//				is.updatePartial(info,slor);
//			}
//		} catch (Exception e) {
//			jo=ResultUtils.getResultError(e);
//		}
		try {
			IFodderReception is = FodderReceptionFactory.getLocalInstance(ctx);
			SelectorItemCollection slor=new SelectorItemCollection();			
			FodderReceptionInfo info = is.getFodderReceptionInfo(new ObjectUuidPK(id));
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
		FodderReceptionInfo info = (FodderReceptionInfo) model;
		if(info.getBizDate()==null){
			info.setBizDate(new Date());
		}
		//hRSm3ywLRHyNcbu9d7qMNYO3etg=
		String companyId="";
		String bizDateStr=new SimpleDateFormat("yyyy-MM-dd").format(info.getBizDate());
		IBatch ibs = BatchFactory.getLocalInstance(ctx);
		IMaterial ims = MaterialFactory.getLocalInstance(ctx);
		String settlementPolicyID=null;
		BatchInfo batchInfo =null;
		WarehouseInfo wInfo=null;
		MaterialInventoryInfo materialInventoryInfo = null;
		HashMap map =null;
		SelectorItemCollection slor=new SelectorItemCollection();
		slor.add("*");
		slor.add("batchContract.settlementPolicy.*");
		slor.add("farm.*");
		slor.add("batchContract.actualBreedDate");
		if(info.getBatch()!=null){
			batchInfo = ibs.getBatchInfo(new ObjectUuidPK( info.getBatch().getId()),slor);
			settlementPolicyID=batchInfo.getBatchContract().getSettlementPolicy().getId().toString();//获取结算政策
			info.setFarm(batchInfo.getFarm());
			info.setFarmer(batchInfo.getFarmer());
			info.setBatchContract(batchInfo.getBatchContract());
			if(info.getCompany()==null) {
				info.setCompany(batchInfo.getCompany());
				companyId=info.getCompany().getString("id");
			}
			if(info.getStorageOrgUnit()==null) {
				info.setStorageOrgUnit(batchInfo.getFarm().getStorageOrgUnit());
			}
			info.setIndate(batchInfo.getBatchContract().getActualBreedDate());
			int dayAge=DateUtilsComm.getDiffBetweenTwoDays(DateUtilsComm.clearDateHMS((Date)info.getIndate()),DateUtilsComm.clearDateHMS((Date) info.getBizDate()));
			info.setWeekDay(dayAge);
			info.setBunker(BunkerEnum.no);
			info.setFarmerPhone(batchInfo.getFarmer().getMobileTel());
			info.setFarmAddress(batchInfo.getFarm().getAddress());
		}
		for(int index=0;index<info.getEntrys().size();index++) {
			FodderReceptionEntryInfo entryInfo = info.getEntrys().get(index);

			if(entryInfo.getMaterial()!=null){
				MaterialInfo mInfo = ims.getMaterialInfo(new ObjectUuidPK(entryInfo.getMaterial().getId()));
				entryInfo.setMaterialName(mInfo.getName());
				entryInfo.setModel(mInfo.getModel());
				entryInfo.setUnit(mInfo.getBaseUnit());
				entryInfo.setUnitQty(mInfo.getBigDecimal("unitQty"));
				
				if(entryInfo.getReceiveQty()==null) {
					entryInfo.setReceiveQty(BigDecimal.ZERO);
				}
				//设置仓库(顺祥没有维护默认仓库的地方,目前就一个库)
			    materialInventoryInfo = (MaterialInventoryInfo)getMaterialInventory(ctx, mInfo, info.getStorageOrgUnit(), null);
				if(materialInventoryInfo!=null){
					wInfo=materialInventoryInfo.getDefaultWarehouse();//获取物料库存资料默认仓库
				}			
				if(wInfo==null){
					wInfo=WarehouseFactory.getLocalInstance(ctx).getWarehouseInfo(new ObjectUuidPK("AsD/1prnQgm9FBTSHu+KILvp+K4="));//仓库： 饲料库
				}
								
				entryInfo.setWarehouse(wInfo);
				BigDecimal unitPrice=getFodderSettlePrice(ctx, settlementPolicyID, mInfo.getString("id"), bizDateStr);
				entryInfo.setConfirmQty(entryInfo.getReceiveQty());
				entryInfo.setBasePrice(unitPrice);
				entryInfo.setReceivePrice(unitPrice);
				entryInfo.setAmount(unitPrice.multiply(entryInfo.getReceiveQty()));
				//累计领用数量
				entryInfo.setTotalReceivedQty(getSumFodderWgt(ctx, batchInfo!=null?batchInfo.getString("id"):null, mInfo.getString("id"), bizDateStr).add(entryInfo.getConfirmQty()));
				//定额数量
//				map = StockingComm.getQuota(batchInfo, mInfo);
//				entryInfo.setQuotaQty((BigDecimal)map.get("quotaQty")==null ? BigDecimal.ZERO :(BigDecimal)map.get("quotaQty"));
				//控料标准(顺祥没有)
//				List<BigDecimal> singelFeedStandard=StockingComm.getFeedStandard(companyId);
//				if(singelFeedStandard.size()>0&&batchInfo!=null&&batchInfo.getFemaleQty()!=null){
//					BigDecimal feedStandard = batchInfo.getFemaleQty().multiply(singelFeedStandard.get(0));
//					entryInfo.setFeedStandard(feedStandard);
//				}
				
			}
		}
		return info;
	}
	
	/**
	 * 获取公司对应的单只控料标准
	 * @param companyID
	 * @return
	 * @throws BOSException 
	 * @throws Exception 
	 */
	public static List<BigDecimal> getFeedStandard(Context ctx,String companyID) throws BOSException {
		// TODO Auto-generated method stub
		List<BigDecimal> feedStandard=new  ArrayList<BigDecimal>();
		String sql="select * from T_FM_SingelFeedStandard where FCompanyid='"+companyID+"' and fbasestatus='3'";
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				feedStandard.add(rs.getBigDecimal("FSingelFeedQty"));
			}
		} catch (Exception e) {
			throw new BOSException(e); 
		} 
		return feedStandard;
	}
	
	/**
	 * 获取物料价格
	 * @param settlePolicyInfo
	 * @param materialId
	 * @return
	 * @throws BOSException 
	 */
	private BigDecimal getFodderSettlePrice(Context ctx,String settlementPolicyID,String materialId,String bizDateStr) throws BOSException {
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

	private BigDecimal getSumFodderWgt(Context ctx,String batchId,String materialId,String bizDateStr) throws BOSException {
		StringBuffer sql=new StringBuffer();
		sql.append(" select isnull(sum(tentry.FConfirmQty),0) FQty")
		.append(" from T_FM_FodderReception tmain")
		.append(" inner join T_FM_FodderReceptionEntry tentry on tentry.fparentid=tmain.fid")
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
		FodderReceptionInfo info = (FodderReceptionInfo) model;
		FodderReceptionFactory.getLocalInstance(ctx).submit(info);
//		if(info.getId()!=null) {
//			//单据状态改为提交
//			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
//			SelectorItemCollection slor=new SelectorItemCollection();
//			slor.add("billStatus");
//			FodderReceptionFactory.getLocalInstance(ctx).updatePartial(info, slor);
//		}
	}
	/**
	 * 获取物料库存资料  zhanzg
	 * @param ctx
	 * @param material
	 * @param storageOrgUnit
	 * @param sic
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	  protected IObjectValue getMaterialInventory(Context ctx, IObjectValue material, IObjectValue storageOrgUnit, SelectorItemCollection sic)
	    throws BOSException, EASBizException
	  {
	    IMaterialInventory iMaterialInventory = MaterialInventoryFactory.getLocalInstance(ctx);
	    EntityViewInfo view = new EntityViewInfo();
	    FilterInfo filter = new FilterInfo();
	    filter.getFilterItems().add(new FilterItemInfo("material.id", ((MaterialInfo)material).getId(), CompareType.EQUALS));
	    filter.getFilterItems().add(new FilterItemInfo("orgUnit.id", ((StorageOrgUnitInfo)storageOrgUnit).getId(), CompareType.EQUALS));
	    view.setFilter(filter);
	    if (sic == null) {
	      view.setSelector(getSimplenessSelectorItem());
	    }
	    view.setSelector(sic);
	    MaterialInventoryCollection materialInventoryCollection = iMaterialInventory.getMaterialInventoryCollection(view);
	    if (materialInventoryCollection.size() != 0) {
	      return materialInventoryCollection.get(0);
	    }
	    return null;
	  }
	  private SelectorItemCollection getSimplenessSelectorItem()
	  {
	    SelectorItemCollection sic = new SelectorItemCollection();
	    sic.add(new SelectorItemInfo("id"));
	    sic.add(new SelectorItemInfo("number"));
	    sic.add(new SelectorItemInfo("name"));
	    return sic;
	  }
	  protected String getListQueryStr2(Context ctx, JSONObject jo) throws BOSException {
			String beginDate=JUtils.getDateStr(jo, "beginDate", JUtils.SDF_DAY);
			String endDate=JUtils.getDateStr(jo, "endDate", JUtils.SDF_DAY);
			StringBuffer queryStr= new StringBuffer();
			queryStr.append(" FBizDate>={d '").append(beginDate).append("'}")
			.append(" and FBizDate<{d '").append(endDate).append("'}");
			
			//养户过滤
			if(StringUtils.isNotEmpty(jo.getString("farmer.id"))) {
				queryStr.append(" and CFFarmerID='").append(jo.getString("farmer.id")).append("'");
			}
			 //养殖场过滤
			if(StringUtils.isNotEmpty(jo.getString("farm.id"))) {
				queryStr.append(" and CFFarmID='").append(jo.getString("farm.id")).append("'");
			}
			//批次合同
			if(StringUtils.isNotEmpty(jo.getString("batchContract.id"))) {
				queryStr.append(" and CFBatchContractID='").append(jo.getString("batchContract.id")).append("'");
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
