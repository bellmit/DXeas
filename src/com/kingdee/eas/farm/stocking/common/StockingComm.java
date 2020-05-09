package com.kingdee.eas.farm.stocking.common;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.ISQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.IBOTMapping;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.workflow.ProcessInstInfo;
import com.kingdee.bos.workflow.service.EnactmentServiceProxy;
import com.kingdee.bos.workflow.service.ormrpc.EnactmentServiceFactory;
import com.kingdee.bos.workflow.service.ormrpc.IEnactmentService;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.IMaterialInventory;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryCollection;
import com.kingdee.eas.basedata.master.material.MaterialInventoryFactory;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.hatch.IHatchBaseData;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingFactory;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedStandardEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedStandardEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmStageEnum;
import com.kingdee.eas.farm.stocking.basedata.IBaseSysSetting;
import com.kingdee.eas.farm.stocking.basedata.IBreedStandardEntry;
import com.kingdee.eas.farm.stocking.basedata.IFarm;
import com.kingdee.eas.farm.stocking.basedata.IStatementsPolicy;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StatementsPolicyFactory;
import com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchCollection;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * 放养公用类
 * @author dai_andong
 *
 */
public class StockingComm {

	public  static final int PRRICE_IN_TYPE=1;//支出价格
	public  static final int PRRICE_OUT_TYPE=2;//回收价格
	public static final String IsExistMutiStockingBatch="_existMuti";

	/**
	 * 获取系统内部参数
	 * @param ctx
	 * @param companyID
	 * @return
	 */
	public static BaseSysSettingInfo getSysSetting(Context ctx,String companyID) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select top 1 fid ")
			.append(" from T_FM_BaseSysSetting ")
			.append(" where FCompanyID='").append(companyID).append("'")
			.append(" order by FCreateTime desc");
			IRowSet rs=null;
			IBaseSysSetting ibase;
			if(ctx==null){
				ibase=BaseSysSettingFactory.getRemoteInstance();
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sql.toString()).executeSQL();
				ibase=BaseSysSettingFactory.getLocalInstance(ctx);
			}
			if(rs.next()) {
				return ibase.getBaseSysSettingInfo(new ObjectUuidPK(rs.getString("fid")));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取系统内部参数
	 * @param ctx
	 * @param companyID
	 * @return
	 */
	public static BaseSysSettingInfo getSysSettingByOrgId(Context ctx,String orgId) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select top 1 fid ")
			.append(" from T_FM_BaseSysSetting ")
			.append(" where FDefaultStorageOrg='").append(orgId).append("'")
			.append(" order by FCreateTime desc");
			IRowSet rs=null;
			IBaseSysSetting ibase;
			if(ctx==null){
				ibase=BaseSysSettingFactory.getRemoteInstance();
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sql.toString()).executeSQL();
				ibase=BaseSysSettingFactory.getLocalInstance(ctx);
			}
			if(rs.next()) {
				return ibase.getBaseSysSettingInfo(new ObjectUuidPK(rs.getString("fid")));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}



	/**
	 * 根据成本中心获取库存组织
	 * @param ctx
	 * @param costCenterOrgID
	 * @return
	 */
	public static String getStorageOrgIDByCostCenterID(Context ctx,String costCenterOrgID) {
		String storageOrgUnitID=null;
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select fid from  t_org_storage ");
			sql.append(" where fid='").append(costCenterOrgID).append("'");
			IRowSet rs=null;
			if(ctx!=null){
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}else{
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}
			if(rs.size()>0) {
				storageOrgUnitID=costCenterOrgID;
			}else{
				sql.setLength(0);
				sql.append(" select FparentID from t_org_costcenter");
				sql.append(" where fid='").append(costCenterOrgID).append("'");
				if(ctx!=null){
					rs=DbUtil.executeQuery(ctx, sql.toString());
				}else{
					rs.close();
					rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				}
				if(rs.next()) {
					storageOrgUnitID=getStorageOrgIDByCostCenterID(ctx,rs.getString("FParentID"));
				}
				rs.close();
			}
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return storageOrgUnitID;
	}



	/**
	 * 根据库存组织 和物料ID获取 默认仓库资料
	 * 
	 * @param ctx
	 * @param storageOrgUnitID
	 * @param materialID
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public static MaterialInventoryInfo getDefaultWarehouseDataByMaterial(Context ctx, String storageOrgUnitID, String materialID)
	throws BOSException, EASBizException {
		try{
			IMaterialInventory is = null;
			if (ctx != null)
				is = MaterialInventoryFactory.getLocalInstance(ctx);
			else
				is = MaterialInventoryFactory.getRemoteInstance();
			EntityViewInfo ev = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("orgUnit.id", storageOrgUnitID, CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("material.id", materialID, CompareType.EQUALS));
			ev.setFilter(filter);
			MaterialInventoryCollection col = is.getMaterialInventoryCollection(ev);
			if (col != null && col.size() > 0) {
				SelectorItemCollection slr = new SelectorItemCollection();
				slr.add(new SelectorItemInfo("*"));
				slr.add(new SelectorItemInfo("defaultWarehouse.*"));
				MaterialInventoryInfo info = is.getMaterialInventoryInfo(new ObjectUuidPK(col.get(0).getString("id")), slr);
				return info;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据库存组织 和物料ID获取 默认仓库
	 * 
	 * @param ctx
	 * @param storageOrgUnitID
	 * @param materialID
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public static WarehouseInfo getDefaultWarehouseByMaterial(Context ctx, String storageOrgUnitID, String materialID)
	throws BOSException, EASBizException {
		try{
			if(StringUtils.isEmpty(storageOrgUnitID)) {
				return null;
			}
			MaterialInventoryInfo tempInfo = getDefaultWarehouseDataByMaterial(ctx, storageOrgUnitID, materialID);
			return tempInfo!=null?tempInfo.getDefaultWarehouse():null;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 检查是否处于工作流
	 * @param ctx
	 * @return
	 * @throws BOSException 
	 */
	public static boolean checkIsFlow(Context ctx,String billID) throws BOSException {
		IEnactmentService wfService =null;
		if(ctx!=null)
			wfService=EnactmentServiceProxy.getEnacementService(ctx);
		else
			wfService=EnactmentServiceFactory.createRemoteEnactService();
		ProcessInstInfo[] processInstances = wfService.getProcessInstanceByHoldedObjectId(billID);//不包括已经结束的流程
		//ProcessInstInfo[] processInstances = wfService.getAllProcessInstancesByBizobjId(billID);//包括已经结束的流程
		if(null != processInstances &&  processInstances.length > 0){//存在流程
			return true;
		}
		return false;
	}
	/**
	 * 通过批次ID获取合同ID
	 * @param batchID
	 * @return
	 */
	public static String getContractIDByBatchID(Context ctx,String batchID) {
		try {
			if(StringUtils.isEmpty(batchID)) {
				return null;
			}
			IStockingBatch is = null;
			if(ctx!=null){ 
				is=StockingBatchFactory.getLocalInstance(ctx);
			}else{
				is=StockingBatchFactory.getRemoteInstance();
			}
			StockingBatchInfo batchInfo = is.getStockingBatchInfo(new ObjectUuidPK(batchID));
			if(batchInfo.getBatchContract()!=null) {
				return batchInfo.getBatchContract().getString("id");
			}

			StringBuffer sql=new StringBuffer();
			/*sql.append(" select top 1 tc.fid from T_FM_BreedSeedBill tbill")
	    	.append(" inner join T_FM_BatchContract tc on tc.fid=tbill.CFBatchContractID")
	    	.append(" where tbill.fbillstatus=4")
	    	.append(" and tbill.FStockingBatchID='").append(batchID).append("'")
	    	.append(" order by tbill.FCreateTime desc");*/
			sql.append(" select fbatchcontractid ")
			.append(" from t_fm_stockingBatch")
			.append(" where fid='").append(batchID).append("'")
			.append(" ");
			IRowSet rs=null;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sql.toString()).executeSQL();
			}
			if(rs.next()) {
				return rs.getString("fid");
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过合同ID获取批次ID
	 * @param batchID
	 * @return
	 */
	public static String getBatchIDByContractID(Context ctx,String contractID) {
		try {
			if(StringUtils.isEmpty(contractID)) {
				return null;
			}
			StringBuffer sql=new StringBuffer();
			sql.append(" select distinct fid from (")
			.append(" select fid from t_fm_stockingBatch ")
			.append(" where fbatchcontractid='").append(contractID).append("'")
			.append(" union all")
			.append(" select tbill.fstockingbatchid from T_FM_BreedSeedBill tbill")
			.append(" inner join T_FM_BatchContract tc on tc.fid=tbill.CFBatchContractID")
			.append(" where tbill.fbillstatus=4")
			.append(" and tc.fid='").append(contractID).append("'")
			.append(" )");
			IRowSet rs=null;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sql.toString()).executeSQL();
			}
			//一个合同多个批次 返回Null
			if(rs.size()>1){
				return IsExistMutiStockingBatch;
			}
			if(rs.next()) {
				return rs.getString("fid");
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取基础价格 
	 * @param ctx
	 * @param companyID
	 * @param materialID
	 * @return
	 */
	public static ArrayList<BasePriceBean> getBasePrice(Context ctx,int priceType,String contractID,String materialID,String unitID) {
		if(StringUtils.isEmpty(contractID)){
			return null;
		}
		try {
			ArrayList<BasePriceBean> result=new ArrayList<BasePriceBean>();
			StringBuffer sql=new StringBuffer();
			sql.append(" select distinct tse.fmaterialid,tse.FunitID,tse.FBasePrice")
			.append(" from T_FM_StatementsPolicy ts");
			if(priceType==PRRICE_OUT_TYPE) {
				sql.append(" inner join T_FM_StatementsPPE tse on tse.fparentid=ts.fid");
			}
			if(priceType==PRRICE_IN_TYPE) {
				sql.append(" inner join T_FM_StatementsPRE tse on tse.fparentid=ts.fid");
			}
			sql.append(" inner join T_FM_BatchContract tc on tc.FSettlementPolicyI=ts.fid")
			.append(" where tc.fid='").append(contractID).append("'");
			//    		if(StringUtils.isNotEmpty(materialID)){
			sql.append(" and tse.fmaterialid='").append(materialID).append("'");
			//    		}
			//    		if(StringUtils.isNotEmpty(unitID)){
			sql.append(" and tse.funitid='").append(unitID).append("'");
			//    		}
			IRowSet rs=null;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sql.toString()).executeSQL();
			}
			while(rs.next()) {
				BasePriceBean bean=new BasePriceBean();
				bean.setMaterialID(rs.getString("FMaterialID"));
				bean.setUnitID(rs.getString("FunitID"));
				bean.setBasePrice(rs.getBigDecimal("FBasePrice"));

				result.add(bean);
			}
			rs.close();
			return result;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}





	/**
	 * 通过财务组织和编码获取批次
	 * @param ctx
	 * @param companyID
	 * @param number
	 * @return
	 */
	public static StockingBatchInfo getStockingBatchByNumber(Context ctx,String companyID,String number) {
		try {
			if(StringUtils.isEmpty(number)) {
				return null;
			}
			IStockingBatch iss =null;
			if(ctx!=null){
				iss=StockingBatchFactory.getLocalInstance(ctx);
			}else{
				iss=StockingBatchFactory.getRemoteInstance();
			}
			StockingBatchCollection col = iss.getStockingBatchCollection("where baseStatus="+FarmBaseStatusEnum.ENABLE_VALUE+" and company.id='"+companyID+"' and number='"+number+"'");
			if(col!=null&&col.size()>0) {
				return col.get(0);
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取物料的单包重
	 * @return
	 */
	public static BigDecimal getUnitQty(Context ctx,String companyID,String materialID) {
		try {
			IMaterial ims = null;
			if(ctx!=null){
				ims=MaterialFactory.getLocalInstance(ctx);
			}else{
				ims=MaterialFactory.getRemoteInstance();
			}
			MaterialInfo mInfo = ims.getMaterialInfo(new ObjectUuidPK(materialID));
			if(mInfo.containsKey("unitQty")) {
				return mInfo.getBigDecimal("unitQty");
			}
			if(mInfo.containsKey("bagQty")) {
				return mInfo.getBigDecimal("bagQty");
			}
		}catch(Exception err) {
			err.printStackTrace();
		}

		return BigDecimal.ZERO;
	}
	/**
	 * 根据批次获取蛋品id
	 */
	public static ArrayList<String> getEggListByStockingBatchID(Context ctx,String batchID,boolean isOnlyQc) {
		try{
			IStockingBatch is =null;
			if(ctx!=null){
				is= StockingBatchFactory.getLocalInstance(ctx);
			}else{
				is=StockingBatchFactory.getRemoteInstance();
			}
			String breedDataID=is.getStockingBatchInfo(new ObjectUuidPK(batchID)).getBreedData().getString("id");
			return getEggListByBreedID(ctx,breedDataID,isOnlyQc);
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}


	/**
	 * 通过品种资料获取蛋品Id
	 * @param ctx
	 * @param breedDataID
	 * @return
	 */
	public static ArrayList<String> getEggListByBreedID(Context ctx,String breedDataID,boolean isOnlyQc) {
		try {
			ArrayList<String> list=new ArrayList<String>();
			StringBuffer sql=new StringBuffer();
			sql.append(" select t1.fmaterialid from T_FM_BreedDataEntry t1")
			.append(" inner join T_FM_BreedData t2 on t1.fparentid=t2.fid")
			.append(" where t2.fid='").append(breedDataID).append("'");
			if(isOnlyQc) {
				sql.append(" and t1.FIsQualified=1");
			}
			sql.append(" order by t1.fseq");
			IRowSet rs=null;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}
			while(rs.next()) {
				list.add(rs.getString("FMaterialID"));
			}
			return list;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	/**
	 * 得到最新的一个批次
	 * @return
	 */
	public static String getLastStockingBatch(Context ctx,String farmerID,String farmID) {
		if(StringUtils.isEmpty(farmerID)) {
			return null;
		}
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select top 1 fid from t_fm_stockingBatch")
			.append(" where FFarmerID='").append(farmerID).append("'")
			.append(" and FbaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE);
			if(StringUtils.isNotEmpty(farmID)) {
				sql.append(" and FFarmID='").append(farmID).append("'");
			}sql.append(" order by FInDate desc");

			IRowSet rs=null;
			if(ctx!=null) {
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}else {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}
			if(rs.next()) {
				return rs.getString("fid");
			}
		}catch(Exception err) {
			err.printStackTrace();
		}

		return null;
	}
	/**
	 * 根据用户获取范围内的养殖场
	 * @return
	 */
	public static ArrayList<String> getFarmersByPerson(Context ctx,String companyID) {
		ArrayList<String> list=new ArrayList<String>();
		//    	list.add("abcd1234");
		String personID=null;
		if(ctx!=null) {
			if(ContextUtil.getCurrentUserInfo(ctx).getPerson()!=null) {
				personID=ContextUtil.getCurrentUserInfo(ctx).getString("id");
			}
		}else{
			if(SysContext.getSysContext().getCurrentUserInfo().getPerson()!=null) {
				personID=SysContext.getSysContext().getCurrentUserInfo().getPerson().getString("id");
			}
		}
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select distinct t2.FFarmerID  from T_FM_PersonFarmerRelation t1  ")
			.append(" inner join  T_FM_PersonFarmerRelationEntry t2 on t2.fparentid=t1.fid")
			.append(" where 1=1");
			if(StringUtils.isNotEmpty(personID)) {
				sql.append(" and FPersonID='").append(personID).append("'");
			}
			//			 .append(" and t1.fbaseStaus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
			sql.append(" and t1.FCompanyID='").append(companyID).append("'")
			.append(" and t2.FFarmerID is not null ")
			;
			IRowSet rs = null;
			if(ctx==null){
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}
			while(rs.next()) {
				list.add(rs.getString("FFarmerID"));
			}
			rs.close();
		}catch(Exception err) {
			err.printStackTrace();
		}
		return list;
	}


	public static FarmInfo getFarmInfoByFarmerID(Context ctx,String farmerID) {
		if(StringUtils.isEmpty(farmerID)){
			return null;
		}
		try {
			String str="select top 1 FFarmID from T_FM_FarmersFarmEntry where fparentid='"+farmerID+"' order by fseq asc";
			IRowSet rs=null;
			IFarm ifs=null;
			if(ctx==null) {
				rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
				ifs = FarmFactory.getRemoteInstance();
			}else{
				rs=DbUtil.executeQuery(ctx, str);
				ifs = FarmFactory.getLocalInstance(ctx);
			}
			if(rs.next()) {
				return ifs.getFarmInfo(new ObjectUuidPK(rs.getString("FFarmID")));
			}
		}catch(Exception err){
			err.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取养殖周龄和日龄
	 * @param bizDate
	 * @return
	 * @throws EASBizException 
	 */
	public static int[] getBreedWeekAndDay(Date bizDate,Date batchDate) throws EASBizException {
		int[] result=new int[]{0,0};

		Calendar cal=Calendar.getInstance();
		cal.setTime(bizDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		bizDate=cal.getTime();

		cal.setTime(batchDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		batchDate=cal.getTime();

		if(bizDate.getTime()<batchDate.getTime()) {
			throw new EASBizException(new NumericExceptionSubItem("001","当前业务日期小于批次入栏日期"));
		}
		long timeDiff=bizDate.getTime()-batchDate.getTime();

		long diffDays=timeDiff/(1000*60*60*24);

		//yumingxu Jx  0日龄
		//		diffDays =diffDays -1;
		int week=(int) (diffDays/7)+1;
		int weekDay=(int) (diffDays%7)+1;

		/*if(week==0){
			week=1;
		}*/

		//		if(weekDay==0) {
		//			weekDay=7;
		//		}else{
		//			//			week++;
		//			//			weekDay++;
		//		}
		result[0]=week;
		result[1]=weekDay;
		return result;
	}


	/**
	 * 通过养殖品种和业务日期获取饲料标准
	 * @param breedDataID
	 * @param week
	 * @param weekDay
	 */
	public static HashMap<MaterialInfo,BigDecimal> getBreedFodderStandard(Context ctx,String companyID,String breedDataID,int week,int weekDay) {
		HashMap<MaterialInfo,BigDecimal> map=new HashMap<MaterialInfo, BigDecimal>();
		try {
			//日龄 
			int dayAge=(week-1)*7+weekDay-1;

			StringBuffer sql=new StringBuffer();
			sql.append(" select top 1 tentry.CFHenMaterialID,isnull(tentry.CFHenQtyPerday,0) CFHenQtyPerday,tentry.CFCockMaterialID,isnull(tentry.CFCockQtyPerday,0) CFCockQtyPerday")
			.append(" from T_FM_BreedStandard tmain ")
			.append(" inner join T_FM_BreedStandardEntry tentry on tentry.fparentid=tmain.fid")
			.append(" where tmain.FCompanyID='").append(companyID).append("'")
			.append(" and FBreedDataID='").append(breedDataID).append("'")
			.append(" and FBaseStatus=3")//启用状态
			.append(" and (")
			//起始周日均大于当前
			.append(" (CFWeek<=").append(week).append(" and CFDays<=").append(weekDay).append(" ")
			//结束同周，日大于当前日
			.append(" and ((FEndWeek=").append(week).append(" and FEndDays>=").append(weekDay).append(" )")
			//周大于当前周
			.append(" or FEndWeek>").append(week).append(" ))")
			//0周 进行日龄判断
			.append(" or (CFWeek=0 and CFDays<=").append(dayAge).append(" and FEndWeek=0 and FEndDays>=").append(dayAge).append(")")
			.append(" )")
			.append(" order by tentry.FSeq")
			.append(" ");
			IRowSet rs = null;
			if(ctx==null){ 
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else {
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}
			MaterialInfo mInfo;
			BigDecimal qty;
			IMaterial ims = null;
			if(ctx==null){
				ims = MaterialFactory.getRemoteInstance();
			}else{
				ims = MaterialFactory.getLocalInstance(ctx);
			}
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("baseUnit.*");

			if(rs.next()) {
				if(StringUtils.isNotEmpty(rs.getString("CFHenMaterialID"))){
					mInfo=ims.getMaterialInfo(new ObjectUuidPK(rs.getString("CFHenMaterialID")),slor);
					qty=rs.getBigDecimal("CFHenQtyPerday");
					map.put(mInfo, qty);
				}
				if(StringUtils.isNotEmpty(rs.getString("CFCockMaterialID"))){
					mInfo=ims.getMaterialInfo(new ObjectUuidPK(rs.getString("CFCockMaterialID")),slor);
					qty=rs.getBigDecimal("CFCockQtyPerday");
					map.put(mInfo, qty);
				}
			}
			rs.close();
		}catch(Exception err) {
			err.printStackTrace();
		}
		return map;
	}

	/**
	 * 通过养殖品种和业务日期获取饲料标准
	 * @param breedDataID
	 * @param week
	 * @param weekDay
	 */
	public static BreedStandardEntryInfo getBreedFodderStandardEntryInfo(Context ctx,String companyID,String breedDataID,int week,int weekDay) {
		try {
			//日龄 
			int dayAge=(week-1)*7+weekDay-1;

			StringBuffer sql=new StringBuffer();
			sql.append(" select top 1 tentry.fid")
			.append(" from T_FM_BreedStandard tmain ")
			.append(" inner join T_FM_BreedStandardEntry tentry on tentry.fparentid=tmain.fid")
			.append(" where tmain.FCompanyID='").append(companyID).append("'")
			.append(" and FBreedDataID='").append(breedDataID).append("'")
			.append(" and FBaseStatus=3")//启用状态
			//20190425 macheng add 周龄按照开始周龄 截止周龄计算
			.append(" and CFWeek <=").append(week)
			.append(" and fendweek >= ").append(week)
			.append(" order by tentry.FSeq");
			IRowSet rs = null;
			if(ctx==null){ 
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else {
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("baseUnit.*");

			if(rs.next()) {
				IBreedStandardEntry is =null;
				if(ctx==null) {
					is=BreedStandardEntryFactory.getRemoteInstance();
				}else {
					is=BreedStandardEntryFactory.getLocalInstance(ctx);
				}
				slor.clear();
				slor.add("*");
				slor.add("henMaterial.*");
				slor.add("henMaterial.baseUnit.*");
				slor.add("cockMaterial.*");
				slor.add("cockMaterial.baseUnit.*");
				return is.getBreedStandardEntryInfo(new ObjectUuidPK(rs.getString("fid")),slor);
			}
			rs.close();
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	/**
	 * 得到实例类
	 * @param bosType
	 * @return
	 */
	public static EntityObjectInfo getEntityObject(Context ctx,String bosType) {
		try {
			IMetaDataLoader loader =null;
			if(ctx!=null)
				loader=MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
			else
				loader=MetaDataLoaderFactory.getRemoteMetaDataLoader();
			EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(bosType));
			if (eo == null) {
				return null;
			}
			return eo;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 得到实例类
	 * @param bosType
	 * @return
	 */
	public static ICoreBase getBillInstance(Context ctx,String bosType) {
		try {
			IMetaDataLoader loader =null;
			if(ctx!=null)
				loader=MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
			else
				loader=MetaDataLoaderFactory.getRemoteMetaDataLoader();
			EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(bosType));
			if (eo == null) {
				return null;
			}
			Class cls = Class.forName(eo.getBusinessImplFactory());
			ICoreBase iCoreBase=null;
			Method mtd =null;
			if(ctx!=null) {
				mtd=cls.getMethod("getLocalInstance", new Class[] { com.kingdee.bos.Context.class });
				iCoreBase = (ICoreBase) mtd.invoke(cls, new Object[] { ctx });
			} else {
				mtd=cls.getMethod("getRemoteInstance");
				iCoreBase = (ICoreBase) mtd.invoke(cls);
			}
			return iCoreBase;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查看即时库存
	 * @param storageOrgUnitID
	 * @param batchNum
	 * @param materialNum
	 * @return
	 */
	public static BigDecimal getInventroy(Context ctx,String storageOrgUnitID,String materialID,String batchNum){
		try{
			StringBuffer sql=new StringBuffer();
			sql.append(" select isnull(sum(iFBaseQty),0) FbaseQty");
			sql.append(" from t_im_inventory ");
			sql.append(" where FStorageOrgUnitID='").append(storageOrgUnitID).append("'");
			sql.append(" and FMaterialID='").append(materialID).append("'");
			if(StringUtils.isNotBlank(batchNum))
				sql.append(" and FLot='").append(batchNum).append("'");
			ISQLExecutor is=null;
			if(ctx==null)
				is=SQLExecutorFactory.getRemoteInstance(sql.toString());
			else 
				is=SQLExecutorFactory.getLocalInstance(ctx, sql.toString());
			IRowSet rs=is.executeSQL();
			if(rs.next()) {
				return rs.getBigDecimal("FbaseQty");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return BigDecimal.ZERO;
	}
	/**
	 * 返回处理后的计算脚本
	 * @param formulaTxt
	 */
	public static String getCalDealedFormulaTxt(String formulaTxt) throws EASBizException {
		try {
			if(StringUtils.isEmpty(formulaTxt)) {
				return null;
			}
			String tempStr,resultStr="";
			int strLength=formulaTxt.length();
			int beginIndex=0;
			for(int index=0;index<strLength;index++) {
				if(formulaTxt.indexOf("[")<0) {
					resultStr+=formulaTxt.substring(0,formulaTxt.length());
					break;
				}
				resultStr+=formulaTxt.substring(0,formulaTxt.indexOf("["));
				tempStr=formulaTxt.substring(formulaTxt.indexOf("["), formulaTxt.indexOf("]")+1);
				beginIndex=tempStr.indexOf("\"");
				resultStr+=tempStr.substring(beginIndex,tempStr.indexOf("\"", beginIndex+1)+1);
				formulaTxt=formulaTxt.substring(formulaTxt.indexOf("]")+1,formulaTxt.length());
				strLength=formulaTxt.length();
			}
			System.out.println(resultStr);
			return resultStr;
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}
	}
	/**
	 * 通过脚本进行计算
	 * @throws BOSException 
	 */
	public static BigDecimal getCalResultByJsTxt(Context ctx,CoreBaseCollection cols,String jsTxt) throws BOSException {
		int strLength=jsTxt.length();
		String tempStr,resultStr="";
		String[] ifp;
		CoreBaseInfo info;
		EntityObjectInfo eo;
		int beginIndex;
		HashMap<String,EntityObjectInfo> map=new HashMap<String, EntityObjectInfo>();
		for(int index=0;index<strLength;index++) {
			if(jsTxt.indexOf("\"")<0) {
				resultStr+=jsTxt.substring(0,jsTxt.length());
				break;
			}
			resultStr+=jsTxt.substring(0,jsTxt.indexOf("\""));
			beginIndex=jsTxt.indexOf("\"");
			tempStr=jsTxt.substring(beginIndex, jsTxt.indexOf("\"",beginIndex+1)+1);
			tempStr=tempStr.replaceAll("\"", "");
			if(tempStr.contains(".")) {
				ifp=tempStr.split("\\.");
				for(int j=0;j<cols.size();j++) {
					info = cols.get(j);
					if(info==null) {
						continue;
					}
					if(map.containsKey(info.getBOSType().toString())){
						eo=map.get(info.getBOSType().toString());
					}else {
						eo = getEntityObject(ctx, info.getBOSType().toString());
						map.put(info.getBOSType().toString(), eo);
					}
					//单据名称相同
					if(eo.getName().equals(ifp[0])) {
						if(info.containsKey(ifp[1])) {
							resultStr+=info.get(ifp[1])!=null?info.get(ifp[1]).toString():"0";
						}
					}
				}
			}else{
				resultStr+=tempStr;
			}
			jsTxt=jsTxt.substring(jsTxt.indexOf("\"",beginIndex+1)+1,jsTxt.length());
			strLength=jsTxt.length();
		}
		//		resultStr="result"+resultStr;
		System.out.println(resultStr);
		String paramsStr="";
		//js脚本取值
		try {
			resultStr="function getValue(params)\n{  var result=0.0;\n "+resultStr+"\n return result;\n}";
			ScriptEngineManager mgr = new ScriptEngineManager();    
			ScriptEngine engine = mgr.getEngineByMimeType("application/javascript");
			engine.eval(resultStr);   
			Invocable inv = (Invocable) engine;   
			Object res = inv.invokeFunction("getValue",paramsStr); 
			return new BigDecimal(String.valueOf(res));
		}catch(Exception err) {
			throw new BOSException("公式脚本计算错误:\n"+err.getMessage());
		}
	}
	/**
	 * 获取蛋品价格
	 * @param companyID
	 * @param materialID
	 * @param bizDate
	 */
	public static BigDecimal getBasePriceByPricePolicy(Context ctx,String companyID,String materialID,Date bizDate) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select top 1 FPrice ")
			.append(" from CT_FM_EggPriceData ")
			.append(" where FCompanyID='").append(companyID).append("'")
			.append(" and FMaterialID='").append(materialID).append("'")
			//			.append(" and FUnitID='").append(unitID).append("'")
			.append(" and FBaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
			.append(" and FEffectDate>={ts'").append(new SimpleDateFormat("yyyy-MM-dd").format(bizDate)).append(" 00:00:00'}")
			.append(" and FEffectDate<({ts'").append(new SimpleDateFormat("yyyy-MM-dd").format(bizDate)).append(" 00:00:00'}+1)")
			.append(" order by FCreateTime desc");
			IRowSet rs = null;
			if(ctx==null){
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}
			if(rs.next()) {
				return rs.getBigDecimal("Fprice");
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return BigDecimal.ZERO;
	}
	/**
	 * 通过成本中心id获取养殖户id
	 * @param ctx
	 * @param companyID
	 * @param costCenterID
	 * @return
	 */
	public static String getFarmerIDByCostCenterID(Context ctx,String companyID,String costCenterID) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select fid ")
			.append(" from t_fm_farmers ")
			.append(" where fcompanyid='").append(companyID).append("'")
			.append(" and FCostCenterID='").append(costCenterID).append("'");
			IRowSet rs=null;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}
			if(rs.next()){
				return rs.getString("id");
			}
		}catch(Exception err){
			err.printStackTrace();
		}
		return null;
	}
	/**
	 * 通过单据的BOSTYPE获取配置的转换规则
	 * @param ctx
	 * @param companyID
	 * @param bosType
	 */
	public static BOTMappingCollection getBotpColsByBosType(Context ctx,String companyID,String bosType) {
		BOTMappingCollection cols=new BOTMappingCollection();
		try{
			StringBuffer sql=new StringBuffer();
			sql.append(" select tbot.fid")
			.append(" from T_FM_BotpSetting tmain")
			.append(" inner join T_FM_BotpSettingEntry tentry on tentry.fparentid=tmain.fid")
			.append(" inner join T_BOT_Mapping tbot on tbot.fname=tentry.FBotpNum")
			.append(" where tmain.FCompanyID='").append(companyID).append("'")
			.append(" and tentry.fbillbostype='").append(bosType).append("'")
			.append(" order by tentry.FSeq");
			IRowSet rs=null;
			IBOTMapping ibs =null;
			if(ctx!=null){
				rs=DbUtil.executeQuery(ctx, sql.toString());
				ibs = BOTMappingFactory.getLocalInstance(ctx);
			}else{
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				ibs = BOTMappingFactory.getRemoteInstance();
			}
			while(rs.next()) {
				cols.add(ibs.getBOTMappingInfo(new ObjectUuidPK(rs.getString("fid"))));
			}
		}catch(Exception err) {
			err.printStackTrace();
		} 
		return cols;
	}
	/**
	 * 获取自动编码
	 * @param ctx
	 * @param orgType
	 * @param editData
	 * @return
	 */
	public static String getAutoNumberByOrg(Context ctx,CoreBaseInfo editData) {
		if (editData == null) 
			return null;
		if (editData.getString("number") == null) {
			try {
				String companyID = null;
				com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = null;
				if(ctx==null) {
					iCodingRuleManager=com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
					companyID=SysContext.getSysContext().getCurrentCtrlUnit().getString("id");
				}else{
					iCodingRuleManager=com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getLocalInstance(ctx);
					companyID=ContextUtil.getCurrentCtrlUnit(ctx).getString("id");
				}
				if (iCodingRuleManager.isExist(editData, companyID)) {
					//			            if (iCodingRuleManager.isAddView(editData, companyID)) {
					return iCodingRuleManager.getNumber(editData,companyID);
					//			            }
				}
			}
			catch (Exception e) {
				com.kingdee.eas.util.SysUtil.abort();
			} 
		} 
		else {
			if (editData.getString("number") .trim().length() > 0) {
				return editData.getString("number") ;
			}
		}
		return null;
	}

	/**
	 * 通过棚舍id查找批次id
	 * @param ctx
	 * @param batchID
	 * @return
	 */
	public static HashSet<String> getBatchIDByHouseID(Context ctx,String companyID,String houseID) {
		HashSet<String> set=new HashSet<String>();
		set.add("abcd1234");
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select distinct tmain.fid ")
			.append(" from t_fm_stockingBatch tmain")
			.append(" inner join T_FM_StockingBatchHouseEntry tentry on tentry.FParentID=tmain.fid");
			if(StringUtils.isNotEmpty(companyID)) {
				sql.append(" and tmain.FCompanyID='").append(companyID).append("'");
			}
			sql.append(" and tentry.FHouseID='").append(houseID).append("'")
			.append(" and tmain.FBaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
			;
			IRowSet rs=null;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}
			while(rs.next()) {
				set.add(rs.getString("fid"));
			}


		}catch(Exception err) {
			err.printStackTrace();
		}
		return set;
	}
	/**
	 * 获取即时库存
	 * @param ctx
	 * @param storageOrgUnitID
	 * @param materialID
	 * @param unitID
	 * @param houseID
	 * @return
	 */
	public static BigDecimal getNowInventory(Context ctx,String storageOrgUnitID,String materialID,String unitID,String warehouseID) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select isnull(sum(FCurStoreQty),0) FQty")
			.append(" from T_IM_Inventory")
			.append(" where FStorageOrgUnitID='").append(storageOrgUnitID).append("'")
			.append(" and FMaterialID='").append(materialID).append("'")
			.append(" and FUnitID='").append(unitID).append("'");
			if(StringUtils.isNotEmpty(warehouseID)) {
				sql.append(" and FWarehouseID='").append(warehouseID).append("'");
			}
			IRowSet rs=null;
			if(ctx==null){
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}
			if(rs.next()) {
				return rs.getBigDecimal("FQty");
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return BigDecimal.ZERO;
	}
	/**
	 * 根据养户设置批次
	 */
	public static ArrayList<String> getBatchByFarmerFarm(Context ctx,String companyID,String farmerID,String farmID,String houseID) {
		ArrayList<String> list=new ArrayList<String>();
		try {
			StringBuffer sql=new StringBuffer();
			//棚舍为空
			if(StringUtils.isNotEmpty(houseID)) {
				sql.append(" select distinct tbatch.fid  ")
				.append(" from t_fm_stockingBatch tbatch")
				.append(" inner join T_FM_StockingBatchHouseEntry tentry on tentry.fparentid=tbatch.fid")
				.append(" where tbatch.FCompanyID='").append(companyID).append("'")
				.append(" and tbatch.fbaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
				.append(" and tbatch.FFarmerID='").append(farmerID).append("'")
				.append(" and (tbatch.FIsAllOut=0 or tbatch.FIsAllOut is null)");
				if(StringUtils.isNotEmpty(farmID)) {
					sql.append(" and tbatch.FFarmID='").append(farmID).append("'");
				}
				sql.append(" and tentry.FHouseID='").append(houseID).append("'");
			}else{
				sql.append(" select distinct tbatch.fid  ")
				.append(" from t_fm_stockingBatch tbatch")
				.append(" where tbatch.FCompanyID='").append(companyID).append("'")
				.append(" and tbatch.fbaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
				.append(" and tbatch.FFarmerID='").append(farmerID).append("'")
				.append(" and (tbatch.FIsAllOut=0 or tbatch.FIsAllOut is null)");
				if(StringUtils.isNotEmpty(farmID)) {
					sql.append(" and tbatch.FFarmID='").append(farmID).append("'");
				}
			}
			IRowSet rs =null;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}
			while(rs.next()) {
				list.add(rs.getString("fid"));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return list;
	}
	/**
	 * 根据组织id获取孵化场信息
	 * @return
	 */
	public static HatchBaseDataInfo getHatchBaseDataByOrgID(Context ctx,String storageOrgUnitID) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select fid ")
			.append(" from CT_FM_HatchBaseData ")
			.append(" where CFHatchFactoryID='").append(storageOrgUnitID).append("'")
			//				.append(" and FBillStatus=4")
			.append(" ");
			IRowSet rs=null;
			IHatchBaseData is;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				is = HatchBaseDataFactory.getRemoteInstance();
			}else{
				rs=DbUtil.executeQuery(ctx, sql.toString());
				is = HatchBaseDataFactory.getLocalInstance(ctx);
			}
			if(rs.next()) {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				slor.add("defaultEggWarehouse.*");
				return is.getHatchBaseDataInfo(new ObjectUuidPK(rs.getString("fid")),slor);
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取棚舍的周龄和日龄
	 * @param houseID
	 * @return
	 * @throws Exception 
	 */
	public static BatchLastBean getEntryHouseBatchBean(Context ctx,String dailyBillID,String companyID,Date bizDate,String batchID,String houseID) throws Exception {
		BatchLastBean bean=null;
		try {
			Date inDate=null;
			StringBuffer sql=new StringBuffer();
			//棚舍不为空
			if(StringUtils.isNotEmpty(houseID)) {
				sql.append(" select to_char(tentry.FInData,'yyyy-MM-dd') FDate,isnull(tentry.FQty,0) FQty,isnull(tentry.FFemaleQty,0) FFemaleQty")
				.append(" from T_FM_StockingBatch tmain ")
				.append(" inner join T_FM_StockingBatchHouseEntry tentry on tentry.fparentid=tmain.fid")
				.append(" where tmain.fid='").append(batchID).append("'")
				.append(" and tentry.fhouseid='").append(houseID).append("'");
			}else{
				//棚舍为空
				sql.append(" select to_char(tmain.FInDate,'yyyy-MM-dd') FDate,isnull(FBatchQty,0) FQty,isnull(FFemaleQty,0) FFemaleQty")
				.append(" from T_FM_StockingBatch tmain ")
				.append(" where tmain.fid='").append(batchID).append("'");
			}
			IRowSet rs=null;
			if(ctx==null){
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}
			if(rs.next()) {
				inDate=rs.getDate("FDate");
			}
			if(inDate!=null) {
				bean=new BatchLastBean();
				int[] weekAndDays= StockingComm.getBreedWeekAndDay(bizDate, inDate);
				bean.setBatchID(batchID);
				bean.setHouseID(houseID);
				bean.setWeek(weekAndDays[0]);
				bean.setWeekDays(weekAndDays[1]);
				bean.setInDate(inDate);
				bean.setInitQty(rs.getBigDecimal("FQty"));
				bean.setInitFemaleQty(rs.getBigDecimal("FFemaleQty"));
				bean.setLaskStock(BigDecimal.ZERO);
				bean.setFemaleLaskStock(BigDecimal.ZERO);
				setLastStock(ctx,dailyBillID,companyID,bean,bizDate);
			}
		}catch(Exception err) {
			throw new Exception(err);
		}
		return bean;
	}

	/**
	 * 设置最后存栏量
	 * @param bean
	 */
	private static void setLastStock(Context ctx,String dailyBillID,String companyID,BatchLastBean bean,Date bizDate) {
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

			StringBuffer sql=new StringBuffer();
			sql.append(" select isnull(sum(FQty),0) FQty,isnull(sum(FFemaleQty),0) FFemaleQty")
			.append(" from (")
			.append(" select isnull(te.CFDeathQty,0)+isnull(te.CFCullQty,0)-isnull(FAdjustQty,0)+isnull(FMarkedQty,0) FQty,isnull(te.FFemaleDeathQty,0)+isnull(te.FFemaleCullQty,0)-isnull(FAdjustFemaleQty,0)+isnull(FFemaleMarketed,0) FFemaleQty")
			.append(" from T_FM_StockingBreeddaily tmain ")
			.append(" inner join T_FM_StockingBDAE te on te.fparentid=tmain.fid")
			.append(" where tmain.fcompanyid='").append(companyID).append("'")
			.append(" and CFStockingBatchID='").append(bean.getBatchID()).append("'")
			.append(" and tmain.FBizDate<={d'").append(sdf.format(bizDate)).append("'}")
			.append(" and CFBaseStatus=4");
			if(StringUtils.isNotEmpty(dailyBillID)) {
				sql.append(" and tmain.FID!='").append(dailyBillID).append("'");
			}
			if(StringUtils.isNotEmpty(bean.getHouseID())) {
				sql.append(" and te.fhouseID='").append(bean.getHouseID()).append("'");
				//转栏信息
				sql.append(" union all ")
				.append(" select (-1)*isnull(FTransQty,0) FQty,(-1)*isnull(FTransFemaleQty,0) FFemaleQty")
				.append(" from T_FM_StockingBreeddaily tmain ")
				.append(" inner join T_FM_StockingBDTE te on te.fparentid=tmain.fid")
				.append(" where tmain.fcompanyid='").append(companyID).append("'")
				.append(" and CFStockingBatchID='").append(bean.getBatchID()).append("'")
				.append(" and tmain.FBizDate<={d'").append(sdf.format(bizDate)).append("'}")
				.append(" and CFBaseStatus=4")
				.append(" and te.fhouseID='").append(bean.getHouseID()).append("'");
				if(StringUtils.isNotEmpty(dailyBillID)) {
					sql.append(" and tmain.FID!='").append(dailyBillID).append("'");
				}
				sql.append(" union all ")
				.append(" select isnull(FTransQty,0) FQty,isnull(FTransFemaleQty,0) FFemaleQty")
				.append(" from T_FM_StockingBreeddaily tmain ")
				.append(" inner join T_FM_StockingBDTE te on te.fparentid=tmain.fid")
				.append(" where tmain.fcompanyid='").append(companyID).append("'")
				.append(" and tmain.FBizDate<={d'").append(sdf.format(bizDate)).append("'}")
				.append(" and CFBaseStatus=4")
				.append(" and te.FFromStockingBatch='").append(bean.getBatchID()).append("'")
				.append(" and te.ffromhouseID='").append(bean.getHouseID()).append("'");
				if(StringUtils.isNotEmpty(dailyBillID)) {
					sql.append(" and tmain.FID!='").append(dailyBillID).append("'");
				}
				;
			}
			sql.append(" ) temp");
			IRowSet rs = null;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}
			BigDecimal qty,femaleQty;
			if(rs.next()) {
				qty=rs.getBigDecimal("fqty");
				femaleQty=rs.getBigDecimal("ffemaleQty");
				bean.setLaskStock(bean.getInitQty().subtract(qty));
				bean.setFemaleLaskStock(bean.getInitFemaleQty().subtract(femaleQty));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * 根据批次ID获取棚舍信息
	 * @param batchID
	 * @return
	 */
	public static LinkedHashSet<String> getHouseSetByBatchID(Context ctx,String batchID) {
		LinkedHashSet<String> result=new LinkedHashSet<String>();
		try{
			StringBuffer sql=new StringBuffer();
			sql.append(" select tentry.FhouseID")
			.append(" from T_FM_StockingBatch tmain")
			.append(" inner join  T_FM_StockingBatchHouseEntry tentry on tentry.fparentid=tmain.fid")
			.append(" inner join CT_FM_FarmHouseEntry the on the.fid=tentry.FhouseID")
			.append(" where tmain.fid='").append( batchID).append("'")
			.append(" and tentry.FIsAllout=0")//没有完全出栏
			.append(" order by the.FSeq")
			;
			IRowSet rs=null;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}
			while(rs.next()) {
				result.add(rs.getString("FHouseID"));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return result;
	}

	/**
	 * 通过合同id获取结算政策
	 * @return
	 */
	public static StatementsPolicyInfo getSettlePolicyByContractID(Context ctx,String contractID) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select FSettlementPolicyI policyID")
			.append(" from T_FM_BatchContract")
			.append(" where fid ='").append(contractID).append("'");
			IRowSet rs=null;
			IStatementsPolicy is=null;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				is=StatementsPolicyFactory.getRemoteInstance();
			}else{
				rs=DbUtil.executeQuery(ctx, sql.toString());
				is=StatementsPolicyFactory.getLocalInstance(ctx);
			}
			if(rs.next()) {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				slor.add("PriceEntry.*");
				slor.add("RecycleEntry.*");
				slor.add("AwardsEntry.*");
				slor.add("SubsidyEntry.*");
				return is.getStatementsPolicyInfo(new ObjectUuidPK(rs.getString("policyID")),slor);
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据期间获取业务起始及结束日期
	 * @param ctx
	 * @param period
	 */
	public static Date[] getDateRangeByPeriod(Context ctx,String companyID,String periodID) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select to_Char(t2.FBeginDate,'yyyy-MM-dd') FBeginDate,to_char(t2.FEndDate,'yyyy-MM-dd') FEndDate")
			.append(" from T_FM_StockingPeriod t1")
			.append(" inner join T_FM_StockingPeriodPeriodEntry t2 on t2.fparentid=t1.fid")
			.append(" where t1.fcompanyID='").append(companyID).append("'")
			.append(" and t2.fperiodid='").append(periodID).append("'");
			IRowSet rs=null;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}
			if(rs.next()) {
				return new Date[]{rs.getDate("FBeginDate"),rs.getDate("FEndDate")};
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据批次Id获取已经完全出栏的id
	 * @return
	 */
	public static HashSet getAllOutHouseIDsByBatchID(Context ctx,String batchID,String farmID) {
		HashSet set =new HashSet();
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select tentry.FHouseID ")
			.append(" from t_fm_stockingBatch tmain")
			.append(" inner join T_FM_StockingBatchHouseEntry tentry on tentry.FParentID=tmain.fid")
			.append(" inner join CT_FM_FarmHouseEntry tfe on tfe.fid=tentry.FHouseID")
			.append(" inner join T_FM_Farm tf on tf.fid=tfe.fparentid")
			.append(" where 1=1");
			if(StringUtils.isNotEmpty(batchID)) {
				sql.append(" and tmain.fid='").append(batchID).append("'");
			}
			//					.append(" and tmain.FCompanyID='").append(curCompanyID).append("'")
			sql.append(" and tmain.FBaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE);
			//				.append(" and tentry.fisAllout=0");
			if(StringUtils.isNotBlank(farmID)) {
				sql.append(" and tf.fid='").append(farmID).append("'");
			}
			sql.append(" and tf.FBaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE);
			IRowSet rs=null;
			if(rs==null) { 
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}
			while(rs.next()) {
				set.add(rs.getString("FHouseID"));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		set.add("123");
		return set;
	}


	/**
	 * 获得指定批次指定栋舍的存栏量
	 * @param ctx
	 * @param companyID
	 * @param bizDate
	 * @return
	 */
	public static BigDecimal getCurrentBirdQty(Context ctx,String companyID,String bizDate){
		StringBuffer sb=new StringBuffer();
		String sp="\n";
		sb.append("/*dialect*/").append(sp);
		sb.append("SELECT tbe.fhouseid,tb.fid,TB.Fnumber,to_char(FInDate,'yyyy-MM-dd') FInDate,max(tbe.FQty) FBatchQty,max(tbe.FFemaleQty) FFemaleQty,sum(tde.CFDeathQty) FDeathQty,sum(tde.CFCullQty) FCullQty,sum(FFemaleDeathQty) FFemaleDeathQty,sum(FFemaleCullQty) FFemaleCullQty,sum(FadjustQty) FadjustQty,sum(FadjustFemaleQty) FadjustFemaleQty").append(sp);
		sb.append("FROM T_FM_StockingBreedDaily td").append(sp);
		sb.append("inner join t_fm_stockingBatch tb on tb.fid=td.cfstockingbatchid").append(sp);
		sb.append("inner join t_fm_farm tf on tf.fid=tb.ffarmid").append(sp);
		sb.append("inner join T_FM_StockingBDAE tde on tde.fparentid=td.fid").append(sp);
		sb.append("left join T_FM_StockingBatchHouseEntry tbe on (tbe.fparentid=tb.fid and tbe.fhouseid=tde.fhouseid)").append(sp);
		sb.append("where td.fcompanyid='").append(companyID).append("'").append(sp);
		sb.append("and td.fbizDate<=to_date('").append(bizDate).append("','yyyy-MM-dd')").append(sp);
		sb.append("and (tf.FFarmType=1 or  tf.FFarmType=2)").append(sp);
		sb.append("and tb.fid in (").append(sp);
		sb.append("select cfstockingbatchid from T_FM_StockingBreedDaily").append(sp);
		sb.append("where fcompanyid='").append(companyID).append("'").append(sp);
		sb.append("and fbizDate=to_date('").append(bizDate).append("','yyyy-MM-dd')").append(sp);
		sb.append(")").append(sp);
		sb.append("group by tb.fid,tb.fnumber,tb.FinDate,tbe.FInData,tbe.fhouseid").append(sp);
		IRowSet rs;
		try {
			if(ctx==null)
				rs=DbUtil.executeQuery(ctx, sb.toString());
			else
				rs=SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();

			if(rs.next()){
				return (rs.getBigDecimal("FBATCHQTY")==null?BigDecimal.ZERO:rs.getBigDecimal("FBATCHQTY")).subtract(
						rs.getBigDecimal("FBATCHQTY")==null?BigDecimal.ZERO:rs.getBigDecimal("FDEATHQTY")).subtract(
								rs.getBigDecimal("FBATCHQTY")==null?BigDecimal.ZERO:rs.getBigDecimal("FCULLQTY")
						);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 获取棚舍的周龄和日龄
	 * @param houseID
	 * @return
	 * @throws Exception 
	 */
	public static BatchLastBean getEntryHouseBatchBean(Context ctx,String dailyBillID,String companyID,Date bizDate,String batchID,String houseID,int isAllOut) throws Exception {
		BatchLastBean bean=null;
		try {
			Date inDate=null;
			StringBuffer sql=new StringBuffer();
			//棚舍不为空
			if(StringUtils.isNotEmpty(houseID)) {
				sql.append(" select to_char(tentry.FInData,'yyyy-MM-dd') FDate,isnull(tentry.FQty,0) FQty,isnull(tentry.FFemaleQty,0) FFemaleQty")
				.append(" from T_FM_StockingBatch tmain ")
				.append(" inner join T_FM_StockingBatchHouseEntry tentry on tentry.fparentid=tmain.fid")
				.append(" where tmain.fid='").append(batchID).append("'")
				.append(" and tentry.fhouseid='").append(houseID).append("'");
				if(isAllOut == 0){
					sql.append(" and tentry.FIsAllout=0");
				}
			}else{
				//棚舍为空
				sql.append(" select to_char(tmain.FInDate,'yyyy-MM-dd') FDate,isnull(FBatchQty,0) FQty,isnull(FFemaleQty,0) FFemaleQty")
				.append(" from T_FM_StockingBatch tmain ")
				.append(" where tmain.fid='").append(batchID).append("'");
				if(isAllOut == 0){
					sql.append(" and tentry.FIsAllout=0");
				}
			}
			IRowSet rs=null;
			if(ctx==null){
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}
			if(rs.next()) {
				inDate=rs.getDate("FDate");
			}
			if(inDate!=null) {
				bean=new BatchLastBean();
				int[] weekAndDays= StockingComm.getBreedWeekAndDay(bizDate, inDate);
				bean.setBatchID(batchID);
				bean.setHouseID(houseID);
				bean.setWeek(weekAndDays[0]);
				bean.setWeekDays(weekAndDays[1]);
				bean.setInDate(inDate);
				bean.setInitQty(rs.getBigDecimal("FQty"));
				bean.setInitFemaleQty(rs.getBigDecimal("FFemaleQty"));
				bean.setLaskStock(BigDecimal.ZERO);
				bean.setFemaleLaskStock(BigDecimal.ZERO);
				setLastStock(ctx,dailyBillID,companyID,bean,bizDate);
			}
		}catch(Exception err) {
			throw new Exception(err);
		}
		return bean;
	}

	//获取当前阶段
	public static FarmStageEnum getCurBreedStage(Context ctx,String breedDataID,String week,String weekDay) {
		FarmStageEnum farmStage=null;
		try {			
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append(" select FFarmStage from T_FM_BreedDataStageEntry ")
			//起始周日均大于当前
			.append("where (FWeek < ").append(week).append("  or (FWeek=").append(week).append(" and FDays<=").append(weekDay).append(")) ")
			//结束同周，日大于当前日
			.append(" and ((FEndWeek=").append(week).append(" and FEndDays>=").append(weekDay).append(" )")
			//周大于当前周
			.append(" or FEndWeek>").append(week).append(" )")
			.append(" and FParentID='"+breedDataID+"'");
			IRowSet rs=null;
			if(ctx!=null){
				rs = DbUtil.executeQuery(ctx, sqlBuf.toString());
			}else{
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}
			if(rs.next()){
				farmStage=FarmStageEnum.getEnum(rs.getInt("FFarmStage"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return farmStage;
	}

	public static int[] getspBreedWeekAndDay(Date bizDate,Date batchDate) throws EASBizException {


		int[] result=new int[]{0,0};

		Calendar cal=Calendar.getInstance();
		cal.setTime(bizDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		bizDate=cal.getTime();

		cal.setTime(batchDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		batchDate=cal.getTime();

		if(bizDate.getTime()<batchDate.getTime()) {
			throw new EASBizException(new NumericExceptionSubItem("001","当前业务日期小于批次入栏日期"));
		}
		long timeDiff=bizDate.getTime()-batchDate.getTime();

		long diffDays=timeDiff/(1000*60*60*24)-1;

		//yumingxu Jx  0日龄
		//		diffDays =diffDays -1;
		int week=(int) (diffDays/7)+1;
		int weekDay=(int) (diffDays%7)+1;

		/*if(week==0){
			week=1;
		}*/

		//		if(weekDay==0) {
		//			weekDay=7;
		//		}else{
		//			//			week++;
		//			//			weekDay++;
		//		}
		result[0]=week;
		result[1]=weekDay;
		return result;
	
	
	}

	public static int getDayAgeByWeekAge(Context ctx,
			StockingBatchInfo batchInfo, int week, int weekDay) throws EASBizException, BOSException {
		if(batchInfo==null) {
			return 0;
		}
		SelectorItemCollection selector=new SelectorItemCollection();
//		selector.add("dayAgeCalType");
//		if(batchInfo.getDayAgeCalType()==null) {
			if(ctx==null) {
				batchInfo=StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(batchInfo.getId()), selector);
			}else {
				batchInfo=StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(batchInfo.getId()), selector);
			}
//		}
		int age=((week-1)*7+weekDay)-1;
		if(age<0) {
			age=0;
		}
		//上苗日为1日龄
//		if(batchInfo.getDayAgeCalType().equals(DayAgeCalTypeEnum.Day1)) {
//			age+=1;
//		}
		return age;
	}

}
