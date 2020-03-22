package com.kingdee.eas.wlhlcomm.app;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.param.ParamControlFactory;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupStandardInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialSalesFactory;
import com.kingdee.eas.basedata.master.material.MaterialSalesInfo;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.basedata.scm.sd.sale.BlockedStatusEnum;
import com.kingdee.eas.basedata.scm.sd.sale.CheckedStatusEnum;
import com.kingdee.eas.basedata.scm.sd.sale.IPriceProvider;
import com.kingdee.eas.basedata.scm.sd.sale.MaterialBasePriceCollection;
import com.kingdee.eas.basedata.scm.sd.sale.MaterialBasePriceFactory;
import com.kingdee.eas.basedata.scm.sd.sale.MaterialBasePriceInfo;
import com.kingdee.eas.basedata.scm.sd.sale.PriceCondition;
import com.kingdee.eas.basedata.scm.sd.sale.PriceProviderFactory;
import com.kingdee.eas.basedata.scm.sd.sale.SalePriceTO;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.scm.common.SCMBillCommonFacadeFactory;
import com.kingdee.eas.scm.im.rpt.InOutStoreGatherReportFacadeFactory;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.bean.JobInfo;
import com.kingdee.jdbc.rowset.IRowSet;

public class ToolFacadeControllerBean extends AbstractToolFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.wlhlcomm.app.ToolFacadeControllerBean");

    
	@Override
	protected void _execute(Context ctx, String sql) throws BOSException {

		DbUtil.execute(ctx, sql);
	}

	@Override
	protected IRowSet _executeQuery(Context ctx, String sql) throws BOSException {

		return DbUtil.executeQuery(ctx, sql);
	}

	@Override
	protected void _execute(Context ctx, String sql, Object[] params) throws BOSException {
		// TODO Auto-generated method stub
		DbUtil.execute(ctx, sql,params);
	}

	//add by wzz 20190923
	@Override
	protected RptParams _getInOutStoreGatherParamArray(Context ctx,
			StorageOrgUnitInfo[] stoArray, String warehouseID, Date beginDate,
			Date endDate, String matid) throws BOSException {

		RptParams para = new RptParams();

		//			StorageOrgUnitInfo orgInfo = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectUuidPK(stoorgID));
		//			para.setObject("storageOrgUnit", orgInfo);
		StorageOrgUnitInfo[]  fullOrgs = stoArray;
		para.setObject("fullStorageOrgUnit", fullOrgs);


		para.setObject("dateFrom", beginDate);
		para.setObject("dateTo", endDate);


		MaterialInfo matInfo;
		try {
			matInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(matid));
			para.setObject("materialFrom", matInfo);
			para.setObject("materialTo", matInfo);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	

		para.setObject("materialTypeFrom", null);
		para.setObject("materialTypeTo", null);

		MaterialGroupStandardInfo standardInfo = new MaterialGroupStandardInfo();
		standardInfo.setId(BOSUuid.read("dR8lnQEPEADgAAWKwKgSxZeb4R8="));
		para.setObject("materialGroupStandard", standardInfo);

		if(warehouseID != null){
			WarehouseInfo wsInfo;
			try {
				wsInfo = WarehouseFactory.getLocalInstance(ctx).getWarehouseInfo(new ObjectUuidPK(warehouseID));
				para.setObject("warehouseFrom", wsInfo);
				para.setObject("warehouseTo", wsInfo);
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			para.setObject("warehouseFrom", null);
			para.setObject("warehouseTo", null);
		}

		para.setObject("locationFrom", null);
		para.setObject("locationTo", null);

		para.setObject("asstAttrFrom", null);
		para.setObject("asstAttrTo", null);

		para.setObject("lotFrom", "");
		para.setObject("lotTo", "");



		para.setObject("projectNumFrom", "");
		para.setObject("projectNumTo", "");

		para.setObject("trackNumFrom", "");
		para.setObject("trackNumTo", "");
		para.setObject("ckBxShowProject", Boolean.FALSE);
		para.setObject("ckBxShowTrackNum", Boolean.FALSE);

		para.setObject("ckBxShowsumRow", Boolean.FALSE);

		para.setObject("ckBoxLevelGather", Boolean.FALSE);
		para.setObject("ckBoxShowGatherLine", Boolean.FALSE);
		para.setInt("coBoxGatherCondition", 0);


		para.setObject("ckBxIn",Boolean.FALSE);
		para.setObject("ckBxOut", Boolean.FALSE);
		para.setObject("ckBxCostAdjIn", Boolean.FALSE);
		para.setObject("ckBxCostAdjOut", Boolean.FALSE);
		para.setObject("ckBxLocIn", Boolean.FALSE);
		para.setObject("ckBxLocOut", Boolean.FALSE);
		para.setObject("RIType", null);

		para.setObject("ckBxShowLot", Boolean.TRUE);
		para.setObject("ckBxShowAsstAttr", Boolean.FALSE);
		para.setObject("ckBxShowWhs", Boolean.TRUE);

		//	    if (this.params.getObject("ckBxShowLocation") == null)
		//	      para.setObject("ckBxShowLocation", new Boolean(false));
		//	    else {
		para.setObject("ckBxShowLocation", Boolean.FALSE);
		//	    }

		para.setObject("ckBxByStatUnit", Boolean.FALSE);

		para.setObject("ckBxByStatUnit", Boolean.FALSE);

		para.setObject("ckBxShowQty", Boolean.TRUE);
		para.setObject("ckBxShowAmt", Boolean.TRUE);
		para.setObject("ckBxShowAssistQty", Boolean.FALSE);
		para.setObject("ckBxShowPrice", Boolean.TRUE);

		para.setInt("spinAmountPrecission", 4);
		para.setInt("spinAssQtyPrecission", 6);
		para.setInt("spinPricePrecission", 4);
		para.setInt("spinQtyPrecission", 6);

		para.setObject("ckBxOnlyShowDetail", Boolean.TRUE);
		para.setInt("coBoxZeroCondition", 0);
		para.setInt("coBoxBillStatus", 2);

		Vector perOrg = new Vector();
		para.setObject("amtPermssionOrg", perOrg);
		para.setObject("ckBxIscalculate", Boolean.TRUE);


		para.setObject("shortNameFrom", "");
		para.setObject("shortNameTo", "");
		//	    if (this.params.getObject("ckBxShowMShortName") == null)
		//	      para.setObject("ckBxShowMShortName", new Boolean(false));
		//	    else {
		para.setObject("ckBxShowMShortName", Boolean.FALSE);

		//	    }
		para.setObject("idList", null);

		HashMap<String, String> riTypCol = new HashMap<String, String>();



		RptParams rpt;
		try {
			rpt = InOutStoreGatherReportFacadeFactory.getLocalInstance(ctx).createTempTable(para);
			para.setObject("riTypeColMap", rpt.getObject("riTypeColMap"));
			para.setString("tempTable", rpt.getString("tempTable"));
			para.setString("orgTempTable", rpt.getString("orgTempTable"));
			System.out.println("临时表tempTable："+ rpt.getString("tempTable"));
			System.out.println("临时表orgTempTable："+ rpt.getString("orgTempTable"));
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		

		return para;
		//	    rpt = InOutStoreGatherReportFacadeFactory.getLocalInstance(ctx).query(para, -1, -1);
		//	    
		//	    RptRowSet rs = (RptRowSet)rpt.getObject("rowset");
		//		return rs;





	}

	@Override
	protected RptParams _getInOutStoreGatherParam(Context ctx, String stoorgID,
			String warehouseID, Date beginDate, Date endDate,String matid)
	throws BOSException {


		RptParams para = new RptParams();
		//		para.setString("tempTable", getTempTable());
		//	    para.setString("orgTempTable", getOrgTempTable());

		if(stoorgID != null){
			StorageOrgUnitInfo orgInfo;
			try {
				orgInfo = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectUuidPK(stoorgID));
				para.setObject("storageOrgUnit", orgInfo);
				StorageOrgUnitInfo[]  fullOrgs = {orgInfo};
				para.setObject("fullStorageOrgUnit", fullOrgs);
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else{
			para.setObject("storageOrgUnit", null);
			para.setObject("fullStorageOrgUnit", null);
		}


		para.setObject("dateFrom", beginDate);
		para.setObject("dateTo", endDate);


		MaterialInfo matInfo;
		try {
			matInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(matid));
			para.setObject("materialFrom", matInfo);
			para.setObject("materialTo", matInfo);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		para.setObject("materialTypeFrom", null);
		para.setObject("materialTypeTo", null);

		MaterialGroupStandardInfo standardInfo = new MaterialGroupStandardInfo();
		standardInfo.setId(BOSUuid.read("dR8lnQEPEADgAAWKwKgSxZeb4R8="));
		para.setObject("materialGroupStandard", standardInfo);

		if(warehouseID != null){
			WarehouseInfo wsInfo;
			try {
				wsInfo = WarehouseFactory.getLocalInstance(ctx).getWarehouseInfo(new ObjectUuidPK(warehouseID));
				para.setObject("warehouseFrom", wsInfo);
				para.setObject("warehouseTo", wsInfo);
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			para.setObject("warehouseFrom", null);
			para.setObject("warehouseTo", null);
		}

		para.setObject("locationFrom", null);
		para.setObject("locationTo", null);

		para.setObject("asstAttrFrom", null);
		para.setObject("asstAttrTo", null);

		para.setObject("lotFrom", "");
		para.setObject("lotTo", "");



		para.setObject("projectNumFrom", "");
		para.setObject("projectNumTo", "");

		para.setObject("trackNumFrom", "");
		para.setObject("trackNumTo", "");
		para.setObject("ckBxShowProject", Boolean.FALSE);
		para.setObject("ckBxShowTrackNum", Boolean.FALSE);

		para.setObject("ckBxShowsumRow", Boolean.FALSE);

		para.setObject("ckBoxLevelGather", Boolean.FALSE);
		para.setObject("ckBoxShowGatherLine", Boolean.FALSE);
		para.setInt("coBoxGatherCondition", 0);


		para.setObject("ckBxIn",Boolean.FALSE);
		para.setObject("ckBxOut", Boolean.FALSE);
		para.setObject("ckBxCostAdjIn", Boolean.FALSE);
		para.setObject("ckBxCostAdjOut", Boolean.FALSE);
		para.setObject("ckBxLocIn", Boolean.FALSE);
		para.setObject("ckBxLocOut", Boolean.FALSE);
		para.setObject("RIType", null);

		para.setObject("ckBxShowLot", Boolean.TRUE);
		para.setObject("ckBxShowAsstAttr", Boolean.FALSE);
		para.setObject("ckBxShowWhs", Boolean.TRUE);

		//	    if (this.params.getObject("ckBxShowLocation") == null)
		//	      para.setObject("ckBxShowLocation", new Boolean(false));
		//	    else {
		para.setObject("ckBxShowLocation", Boolean.FALSE);
		//	    }

		para.setObject("ckBxByStatUnit", Boolean.FALSE);

		para.setObject("ckBxByStatUnit", Boolean.FALSE);

		para.setObject("ckBxShowQty", Boolean.TRUE);
		para.setObject("ckBxShowAmt", Boolean.TRUE);
		para.setObject("ckBxShowAssistQty", Boolean.FALSE);
		para.setObject("ckBxShowPrice", Boolean.TRUE);

		para.setInt("spinAmountPrecission", 4);
		para.setInt("spinAssQtyPrecission", 6);
		para.setInt("spinPricePrecission", 4);
		para.setInt("spinQtyPrecission", 6);

		para.setObject("ckBxOnlyShowDetail", Boolean.TRUE);
		para.setInt("coBoxZeroCondition", 0);
		para.setInt("coBoxBillStatus", 2);

		Vector perOrg = new Vector();
		para.setObject("amtPermssionOrg", perOrg);
		para.setObject("ckBxIscalculate", Boolean.TRUE);


		para.setObject("shortNameFrom", "");
		para.setObject("shortNameTo", "");
		//	    if (this.params.getObject("ckBxShowMShortName") == null)
		//	      para.setObject("ckBxShowMShortName", new Boolean(false));
		//	    else {
		para.setObject("ckBxShowMShortName", Boolean.FALSE);

		//	    }
		para.setObject("idList", null);

		HashMap<String, String> riTypCol = new HashMap<String, String>();



		RptParams rpt;
		try {
			rpt = InOutStoreGatherReportFacadeFactory.getLocalInstance(ctx).createTempTable(para);
			para.setObject("riTypeColMap", rpt.getObject("riTypeColMap"));
			para.setString("tempTable", rpt.getString("tempTable"));
			para.setString("orgTempTable", rpt.getString("orgTempTable"));
			System.out.println("临时表tempTable："+ rpt.getString("tempTable"));
			System.out.println("临时表orgTempTable："+ rpt.getString("orgTempTable"));
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		return para;
		//	    rpt = InOutStoreGatherReportFacadeFactory.getLocalInstance(ctx).query(para, -1, -1);
		//	    
		//	    RptRowSet rs = (RptRowSet)rpt.getObject("rowset");
		//		return rs;
	}
	@Override
	protected IRowSet _executeQuery(Context ctx, String sql, Object[] params) throws BOSException {
		// TODO Auto-generated method stub
		return DbUtil.executeQuery(ctx, sql,params);
	}

	
	
	/**
	 * 获得物料的基本价格信息
	 */
	@Override
	protected MaterialBasePriceInfo _getMaterialBasePrice(Context ctx,
			String adminCUID, 
			String priceTypeID,
			String materialID,
			String unitID,
			String currencyID) throws BOSException {
		

		EntityViewInfo ev = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		
		FilterItemInfo filterItemAdminCU = new FilterItemInfo("adminCU.id", materialID, CompareType.EQUALS);
//		filter.getFilterItems().add(filterItemAdminCU);
		
		FilterItemInfo filterItemMaterialNumber = new FilterItemInfo("material.id", materialID, CompareType.EQUALS);
		filter.getFilterItems().add(filterItemMaterialNumber);
		
		// 默认人民币
		if(StringUtils.isBlank(currencyID)){
			currencyID = "dfd38d11-00fd-1000-e000-1ebdc0a8100dDEB58FDC";
		}
		FilterItemInfo filterItemCurrency = new FilterItemInfo("currency.id", currencyID, CompareType.EQUALS);
		filter.getFilterItems().add(filterItemCurrency);
		
		// 默认千克
		if(StringUtils.isBlank(unitID)){
			unitID = "gw5fUwEOEADgAAsRwKgSOFuCXFc=";
		}
		FilterItemInfo filterItemUnit = new FilterItemInfo("unit.id", unitID, CompareType.EQUALS);
		filter.getFilterItems().add(filterItemUnit);

		// 默认 基本价格政策
		if(StringUtils.isBlank(priceTypeID)){
			priceTypeID = "at4AAAACs3BqYc6N";
		}
		FilterItemInfo filterItemPriceType = new FilterItemInfo("priceType.id", priceTypeID, CompareType.EQUALS);
		filter.getFilterItems().add(filterItemPriceType);
		
		// 已审核
		FilterItemInfo filterItemCheckStatus = new FilterItemInfo("checkedStatus", CheckedStatusEnum.AUDITED, CompareType.EQUALS);
		filter.getFilterItems().add(filterItemCheckStatus);
		
		// 启用状态
		FilterItemInfo filterItemBlockStatus = new FilterItemInfo("blockedStatus", BlockedStatusEnum.UNBLOCKED, CompareType.EQUALS);
		filter.getFilterItems().add(filterItemBlockStatus);
		

		ev.setFilter(filter);
		MaterialBasePriceCollection mbpc = MaterialBasePriceFactory.getLocalInstance(ctx).getMaterialBasePriceCollection(ev);
		if (mbpc.size() < 1) {
		  return null;
		}
		return mbpc.get(0);
	}

	/**
	 * 获得满足条件的 后台事务
	 */
	@Override
	public List _getEnableJobs(Context ctx, String jobName)
			throws BOSException {
		StringBuilder sql = new StringBuilder("select td.ftitle,td.fjobdefid  ");
		sql.append(" from T_JOB_TRIGGER tg inner join T_JOB_DEF td on tg.fjobdefid = td.fjobdefid ");
		sql.append(" where tg.fisvalid = 'Y' ");
		if(StringUtils.isNotBlank(jobName)){
			sql.append(" and td.ftitle like '%");
			sql.append(StringUtils.trim(jobName));
			sql.append("%' ");
		}
		
		List<JobInfo> jobs = new LinkedList<JobInfo>();
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try{
			while(rs.next()){
				String jobid = rs.getString("fjobdefid");
				String title = rs.getString("ftitle");
				
				JobInfo newJob = new JobInfo();
				newJob.setJobID(jobid);
				newJob.setJobName(title);
				jobs.add(newJob);
			}
			
			return jobs;
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
	}

	/**
	 * 根据 job名称获得 可以匹配到的 job列表
	 * @param 
	 */
	@Override
	protected List _getJobByNames(Context ctx, String[] jobNames)
			throws BOSException {
		List<JobInfo> jobs = new LinkedList<JobInfo>();
		if(jobNames == null || jobNames.length <= 0){
			return jobs;
		}
		StringBuilder sql = new StringBuilder("select td.ftitle,td.fjobdefid  ");
		sql.append(" from T_JOB_TRIGGER tg inner join T_JOB_DEF td on tg.fjobdefid = td.fjobdefid ");
		sql.append(" where  tg.fisvalid = 'Y'  and ( 1<>1  ");
		
		for(int i = 0; i < jobNames.length; i++){
			String jobName = jobNames[i];
			if(StringUtils.isNotBlank(jobName)){
				sql.append(" or td.ftitle like '%");
				sql.append(StringUtils.trim(jobName));
				sql.append("%' ");
			}
			
		}
		sql.append(" ) ");
		
		
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try{
			while(rs.next()){
				String jobid = rs.getString("fjobdefid");
				String title = rs.getString("ftitle");
				
				JobInfo newJob = new JobInfo();
				newJob.setJobID(jobid);
				newJob.setJobName(title);
				jobs.add(newJob);
			}
			
			return jobs;
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
	}

	
}