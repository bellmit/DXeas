package com.kingdee.eas.farm.feedfactory.app;

import org.apache.log4j.Logger;
import javax.ejb.*;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.SQLException;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataCollection;
import com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataFactory;
import com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataInfo;
import com.kingdee.eas.farm.feedfactory.beans.DistanceAndTimesInfo;
import com.kingdee.eas.farm.feedfactory.beans.FF_CONSTANTS;
import com.kingdee.eas.farm.feedfactory.beans.FodderPlanDetail;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;
import java.util.Map;

public class TruckPlanFacadeControllerBean extends AbstractTruckPlanFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.feedfactory.app.TruckPlanFacadeControllerBean");

    /**
     * 获得要料计划明细信息
     */
	@Override
	protected List _getFodderPlandetails(Context ctx, Date planDate)
			throws BOSException {
		if(planDate == null ) return null;
		
		
		StringBuilder sql = new StringBuilder("/*dialect*/ select ");
		// 商品鸡日报要料统计
		sql.append(" '1CC' farmType, ");
		sql.append(" ts.fid farmID, ");
		sql.append(" ts.fnumber farmNumber, ");
		sql.append(" ts.fname_l2 farmName, ");

		sql.append(" tw.fid towerID, ");
		sql.append(" tw.fnumber towerNumber, ");
		sql.append(" tw.fname_l2 towerName, ");

		sql.append(" tm.fid materialID, ");
		sql.append(" tm.fnumber materialNumber, ");
		sql.append(" tm.fmodel materialModel, ");
		sql.append(" tm.fname_l2 materialName, ");
		sql.append(" te.cffodderqty fodderqty, ");
		sql.append(" te.CFFODDERDESC fodderDesc, ");
		
		sql.append(" te.cftowerinventory inventory ");


		sql.append("  from  ");
		sql.append(" CT_FM_CommecialCDFPE te  ");
		sql.append(" inner join CT_FM_CommecialChilkenDaily t on te.fparentid = t.fid ");
		sql.append(" inner join t_org_storage  ts on t.cfstoorgid = ts.fid ");
		sql.append(" inner join t_db_warehouse tw on te.cffoddertowerid = tw.fid ");
		sql.append(" inner join t_bd_material tm on te.cffoddermaterialid = tm.fid ");
		sql.append(" where to_char(te.cffodderdate,'yyyy-mm-dd') = '");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sql.append(sdf.format(planDate));
		sql.append("' and t.cfbasestatus='4' ");
		// 商品要料计划统计
		sql.append(" union all ");
//		sql.append("  select  '1CC' farmType, ");
		sql.append("  select	case  ");
		sql.append("        when ts.fname_l2 like '%育成%' then '2YC' ");
        sql.append("        when ts.fname_l2 like '%产蛋%' then '3CD' ");
        sql.append("          else '1CC' end farmType, ");
		sql.append(" ts.fid farmID, ");
		sql.append(" ts.fnumber farmNumber, ");
		sql.append(" ts.fname_l2 farmName, ");

		sql.append(" tw.fid towerID, ");
		sql.append(" tw.fnumber towerNumber, ");
		sql.append(" tw.fname_l2 towerName, ");

		sql.append(" tm.fid materialID, ");
		sql.append(" tm.fnumber materialNumber, ");
		sql.append(" tm.fmodel materialModel, ");
		sql.append(" tm.fname_l2 materialName, ");
		sql.append(" te.cffodderqty fodderqty, ");
		sql.append(" te.CFFODDERDESC fodderDesc, ");
		sql.append(" te.cftowerinventory inventory ");


		sql.append("  from  ");
		sql.append(" CT_FM_CommecialCAFFPE te  ");
		sql.append(" inner join CT_FM_CommecialCAF t on te.fparentid = t.fid ");
		sql.append(" inner join t_org_storage  ts on t.cfstoorgid = ts.fid ");
		sql.append(" inner join t_db_warehouse tw on te.cffoddertowerid = tw.fid ");
		sql.append(" inner join t_bd_material tm on te.cffoddermaterialid = tm.fid ");
		sql.append(" where to_char(te.cffodderdate,'yyyy-mm-dd') = '");
		
		sql.append(sdf.format(planDate));
		sql.append("'  and t.cfbasestatus='4' ");
		
		// 育成鸡日报要料统计
		sql.append(" union all ");
		sql.append("  select  '2YC' farmType, ");
		sql.append(" ts.fid farmID, ");
		sql.append(" ts.fnumber farmNumber, ");
		sql.append(" ts.fname_l2 farmName, ");

		sql.append(" tw.fid towerID, ");
		sql.append(" tw.fnumber towerNumber, ");
		sql.append(" tw.fname_l2 towerName, ");

		sql.append(" tm.fid materialID, ");
		sql.append(" tm.fnumber materialNumber, ");
		sql.append(" tm.fmodel materialModel, ");
		sql.append(" tm.fname_l2 materialName, ");
		sql.append(" te.cffodderqty fodderqty, ");
		sql.append(" te.CFFODDERDESC fodderDesc, ");
		sql.append(" te.cftowerinventory inventory ");


		sql.append("  from  ");
		sql.append(" CT_FM_BroodDailyFodderEntrys te  ");
		sql.append(" inner join CT_FM_BroodDaily t on te.fparentid = t.fid ");
		sql.append(" inner join t_org_storage  ts on t.cfstoorgid = ts.fid ");
		sql.append(" inner join t_db_warehouse tw on te.cffoddertowerid = tw.fid ");
		sql.append(" inner join t_bd_material tm on te.cffoddermaterialid = tm.fid ");
		sql.append(" where to_char(te.cffodderdate,'yyyy-mm-dd') = '");
		
		sql.append(sdf.format(planDate));
		sql.append("'  and t.cfbasestatus='4' ");
		// 产蛋鸡日报要料统计
		sql.append(" union all ");
		sql.append("  select  '3CD' farmType, ");
		sql.append(" ts.fid farmID, ");
		sql.append(" ts.fnumber farmNumber, ");
		sql.append(" ts.fname_l2 farmName, ");

		sql.append(" tw.fid towerID, ");
		sql.append(" tw.fnumber towerNumber, ");
		sql.append(" tw.fname_l2 towerName, ");

		sql.append(" tm.fid materialID, ");
		sql.append(" tm.fnumber materialNumber, ");
		sql.append(" tm.fmodel materialModel, ");
		sql.append(" tm.fname_l2 materialName, ");
		sql.append(" te.cffodderqty fodderqty, ");
		sql.append(" te.CFFODDERDESC fodderDesc, ");
		sql.append(" te.cftowerinventory inventory ");


		sql.append("  from  ");
		sql.append(" CT_FM_LayEggDailyFodderEntrys te  ");
		sql.append(" inner join CT_FM_LayEggDaily t on te.fparentid = t.fid ");
		sql.append(" inner join t_org_storage  ts on t.cfstoorgid = ts.fid ");
		sql.append(" inner join t_db_warehouse tw on te.cffoddertowerid = tw.fid ");
		sql.append(" inner join t_bd_material tm on te.cffoddermaterialid = tm.fid ");
		sql.append(" where to_char(te.cffodderdate,'yyyy-mm-dd') = '");
		
		sql.append(sdf.format(planDate));
		sql.append("'  and t.cfbasestatus='4' order by farmType desc,inventory,fodderDesc desc,farmNumber,towerNumber");
		
		// 结果集
		LinkedList<FodderPlanDetail> details = new LinkedList<FodderPlanDetail>();
		try{
			IRowSet rs  = DbUtil.executeQuery(ctx, sql.toString());
			
			while(rs.next()){
				
				String farmType = rs.getString("farmType");
				String farmID = rs.getString("farmID");
				String farmNumber = rs.getString("farmNumber");
				String farmName = rs.getString("farmName");
				String towerID = rs.getString("towerID");
				String towerNumber = rs.getString("towerNumber");
				String towerName = rs.getString("towerName");
				String materialID = rs.getString("materialID");
				String materialModel = rs.getString("materialModel");
				String materialNumber = rs.getString("materialNumber");
				String materialName = rs.getString("materialName");
				BigDecimal fodderqty = rs.getBigDecimal("fodderqty");
				String fodderDesc = rs.getString("fodderDesc");
				BigDecimal inventory = rs.getBigDecimal("inventory");
				
				FodderPlanDetail newDetail = new FodderPlanDetail();
				newDetail.setFarmType(farmType);
				newDetail.setFarmID(farmID);
				newDetail.setFarmNumber(farmNumber);
				newDetail.setFarmName(farmName);
				
				newDetail.setTowerID(towerID);
				newDetail.setTowerNumber(towerNumber);
				newDetail.setTowerName(towerName);
				
				newDetail.setMaterialID(materialID);
				newDetail.setMaterialModel(materialModel);
				newDetail.setMaterialNumber(materialNumber);
				newDetail.setMaterialName(materialName);
				
				newDetail.setFarmDesc(fodderDesc);
				newDetail.setQty(fodderqty);
				newDetail.setInventory(inventory);
				
				details.add(newDetail);
			}
			
		}catch (SQLException e) {
			throw new BOSException(e);
		}
		return details;
	}

	/**
	 * 获取饲料厂 基本设置
	 */
	@Override
	protected FeedFactoryBaseDataInfo _getFeedFactoryBaseData(Context ctx)
			throws BOSException {
		
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();
		fi.getFilterItems().add(new FilterItemInfo("baseStatus",com.kingdee.eas.scm.common.BillBaseStatusEnum.AUDITED,CompareType.EQUALS));
		fi.getFilterItems().add(new FilterItemInfo("feedFactory.id",ContextUtil.getCurrentStorageUnit(ctx).getId().toString(),CompareType.EQUALS));
		
		
		evi.setFilter(fi);
		FeedFactoryBaseDataCollection coll = FeedFactoryBaseDataFactory.getLocalInstance(ctx).getFeedFactoryBaseDataCollection(evi);
		
		if(coll.size()>0){
			return coll.get(0);
		}else{
			return null;
		}
		
	}

	/**
	 * 获取当前 路程时间设置
	 */
	@Override
	protected Map<String,DistanceAndTimesInfo> _getDistanseSetinfo(Context ctx) throws BOSException {
		
		Map<String,DistanceAndTimesInfo> result = new HashMap<String, DistanceAndTimesInfo>();
		
		String sql1 = "select sto.fid cffarmid,sto.fname_l2 farmName,te.cfdistance,te.cfaffress,te.cfloadtimes,te.cfunloadtimes " +
				"from CT_FM_JournalTFTFE te inner join CT_FM_JournalTimes t on te.fparentid = t.fid" +
				" inner join CT_FM_BreedStoorgSet tfms on te.cffarmid = tfms.fid " +
				" inner join t_org_storage sto on tfms.CFStoOrgID = sto.fid where t.cfbasestatus = '4'";
		
		
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sql1);
			while(rs.next()){
				String cffarmid = rs.getString("cffarmid");
				String farmName = rs.getString("farmName");
				String cfaffress = rs.getString("cfaffress");
				BigDecimal distance = rs.getBigDecimal("cfdistance");
				int loadTimes = rs.getInt("cfloadtimes");
				int cfunloadtimes = rs.getInt("cfunloadtimes");
				
				// 设置重车 时间
				DistanceAndTimesInfo loadDistanceInfo = new DistanceAndTimesInfo();
				String key1 = FF_CONSTANTS.FF_KEY+cffarmid;
				loadDistanceInfo.setBeginPlace(FF_CONSTANTS.FF_KEY);
				loadDistanceInfo.setEndPlace(farmName);
				loadDistanceInfo.setDistance(distance);
				loadDistanceInfo.setLoadFooder(true);
				loadDistanceInfo.setMinutes(loadTimes);
				result.put(key1, loadDistanceInfo);
				// 设置轻车 时间
				DistanceAndTimesInfo unloadDistanceInfo = new DistanceAndTimesInfo();
				String key2 = cffarmid + FF_CONSTANTS.FF_KEY;
				unloadDistanceInfo.setBeginPlace(farmName);
				unloadDistanceInfo.setEndPlace(FF_CONSTANTS.FF_KEY);
				unloadDistanceInfo.setDistance(distance);
				unloadDistanceInfo.setLoadFooder(false);
				unloadDistanceInfo.setMinutes(cfunloadtimes);
				result.put(key2, unloadDistanceInfo);
				
			}
		}catch(SQLException sqle){
			throw new BOSException("获取饲料场到养殖场路程时间设置时后台报错",sqle);
		}
		
		
		// 获得 养殖场间车程
		String sql2 = "select beginsto.fid startFarmID,beginsto.fname_l2 startFarmName,endsto.fid endFarmID,endsto.fname_l2 endFarmName,te.CFTimes,te.CFDistance" +
				" from CT_FM_JFarmToFarmE  te inner join CT_FM_JournalTimes t on te.fparentid = t.fid " +
				" inner join CT_FM_BreedStoorgSet beginbs on te.CFSTARTFARMID = beginbs.fid" +
				" inner join t_org_storage beginsto on beginbs.CFStoOrgID = beginsto.fid " +
				" inner join CT_FM_BreedStoorgSet endbs on te.CFEndFarmID = endbs.fid " +
				" inner join t_org_storage endsto on endbs.CFStoOrgID = endsto.fid" +
				" where t.cfbasestatus = '4'" ;
		
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sql2);
			while(rs.next()){
				String cfstartfarmid = rs.getString("startFarmID");
				String startFarmName = rs.getString("startFarmName");
//				String cfstartaffress = rs.getString("CFStartFarmAddress");
				String cfendfarmid = rs.getString("endFarmID");
				String endFarmName = rs.getString("endFarmName");
//				String cfendfarmaddress = rs.getString("CFEndFarmAddress");
				BigDecimal distance = rs.getBigDecimal("CFDistance");
				int times = rs.getInt("CFTimes");
				
				// 设置 去程 时间
				DistanceAndTimesInfo loadDistanceInfo = new DistanceAndTimesInfo();
				String key1 = cfstartfarmid+cfendfarmid;
				loadDistanceInfo.setBeginPlace(startFarmName);
				loadDistanceInfo.setEndPlace(endFarmName);
				loadDistanceInfo.setDistance(distance);
				loadDistanceInfo.setLoadFooder(true);
				loadDistanceInfo.setMinutes(times);
				result.put(key1, loadDistanceInfo);
				// 设置返程时间
				loadDistanceInfo = new DistanceAndTimesInfo();
				String key2 = cfendfarmid+cfstartfarmid;
				loadDistanceInfo.setBeginPlace(endFarmName);
				loadDistanceInfo.setEndPlace(startFarmName);
				loadDistanceInfo.setDistance(distance);
				loadDistanceInfo.setLoadFooder(true);
				loadDistanceInfo.setMinutes(times);
				result.put(key2, loadDistanceInfo);
				
			}
		}catch(SQLException sqle){
			throw new BOSException("获取养殖场间路程时间设置时后台报错",sqle);
		}
		return result;
		
	}
    
    
}