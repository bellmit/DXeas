package com.kingdee.eas.farm.breed.app;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.BreedBatchEntryCollection;
import com.kingdee.eas.farm.breed.BreedBatchEntryFactory;
import com.kingdee.eas.farm.breed.BreedBatchEntryInfo;
import com.kingdee.eas.farm.breed.BreedBatchFactory;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.BreedModelEntryFactory;
import com.kingdee.eas.farm.breed.BreedModelEntryInfo;
import com.kingdee.eas.farm.breed.BreedModelFactory;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import com.kingdee.eas.farm.breed.HenhouseFactory;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.IBreedBatchEntry;
import com.kingdee.eas.farm.breed.ResidueSetFactory;
import com.kingdee.eas.farm.breed.ResidueSetInfo;
import com.kingdee.eas.farm.breed.comm.BreedBatchDetailInfo;
import com.kingdee.eas.farm.breed.comm.CCBatchAgeDetailInfo;
import com.kingdee.eas.farm.breed.comm.CCBatchAgeInfo;
import com.kingdee.eas.farm.rpt.CCProductPlanRptCommonFacadeFactory;
import com.kingdee.eas.farm.rpt.app.CCProductPlanRptBean;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;

public class BreedFacadeControllerBean extends AbstractBreedFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.app.BreedFacadeControllerBean");
    /**
	 * 根据仓库id获得对应鸡舍信息
	 */
	@Override
	protected HenhouseInfo _getWarehsHenhouse(Context ctx, String warehsID)
			throws BOSException {
		String sql = "select fid from CT_FM_Henhouse where CFWarehouseID =?  ";
		String[] args = {warehsID};
		
		try{
			IRowSet rs  = DbUtil.executeQuery(ctx, sql, args);
			if(rs.next()){
				String fid = rs.getString("fid");
				
				return HenhouseFactory.getLocalInstance(ctx).getHenhouseInfo(new ObjectUuidPK(fid));
				
			}
			
			return null;
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		} catch (EASBizException e) {
//			e.printStackTrace();
			throw new BOSException(e);
		}
//		EntityViewInfo view = new EntityViewInfo();
//		FilterInfo filterInfo = new FilterInfo();
//		filterInfo.getFilterItems().add(new FilterItemInfo("warehouse.id",warehsID,CompareType.EQUALS));
//		
//		view.setFilter(filterInfo);
//		HenhouseCollection coll =  HenhouseFactory.getLocalInstance(ctx).getHenhouseCollection(view);
//		if(coll != null && coll.size() > 0){
//			return coll.get(0);
//		}else{
//			return null;
//		}
		
	}
	/**
	 * 根据批次信息获得对应的 批次当前详情
	 */
	@Override
	protected BreedBatchDetailInfo _getBreedBatchDetailInfos(Context ctx,
			String batchID, String costObjectID,Date bizDate) throws BOSException {
		BreedBatchInfo batchInfo = null;
		 
		BreedBatchDetailInfo result = null;
		if(StringUtils.isBlank(batchID)){
			if(StringUtils.isBlank(costObjectID)){
				return null;
			}else{
				batchInfo = this._getBreedBatchInfoByCostObjID(ctx, costObjectID);
			}
		}else{
			try {
				batchInfo = BreedBatchFactory.getLocalInstance(ctx).getBreedBatchInfo(new ObjectUuidPK(batchID));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new FarmException(e);
			}
		}
		// 根据批次获得对应批次详情
		if(batchInfo != null){
			result =  new BreedBatchDetailInfo(ctx,batchInfo,bizDate);
			// TODO
			return result;
		}else{
			return null;
		}
		
	}
	/**
	 * 根据成本对象ID获得对应的 养殖批次信息
	 */
	@Override
	protected BreedBatchInfo _getBreedBatchInfoByCostObjID(Context ctx,
			String costObjectID) throws BOSException {
		String sql = "select fid from CT_FM_BreedBatch where CFCostObjectID=? ";
		String[] args = {costObjectID};
		
		IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
		if(rs.size() > 0){
			throw new FarmException("指定的成本对象存在不止一个养殖批次，请联系管理员设置");
		}else{
			try{
				if(rs.next()){
					String fid = rs.getString("fid");
					return BreedBatchFactory.getLocalInstance(ctx).getBreedBatchInfo(new ObjectUuidPK(fid));
				}else{
					return null;
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
				throw new BOSException(sqle);
			} catch (EASBizException e) {
				e.printStackTrace();
				throw new BOSException(e);
			}
		}
		
		
	}
	/**
	 * 根据鸡舍类别获得 对应的养殖规范
	 */
	protected BreedModelInfo _getBreedModelByHouseType(Context ctx,
			String henHouseType) throws BOSException {
		String sql = "select fid from CT_FM_BreedModel where CFHouseType = ? and CFDeletedStatus=1 ";//CFDisableState=1
		String[] args = {henHouseType};
		IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
		
		if(rs.size() > 1){
			throw new FarmException("指定的鸡舍类别存在不止一个启用的 饲养规范，请联系管理员设置");
		}else{
			try{
				if(rs.next()){
					String fid = rs.getString("fid");
					return BreedModelFactory.getLocalInstance(ctx).getBreedModelInfo(new ObjectUuidPK(fid));
				}else{
					return null;
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
				throw new BOSException(sqle);
			} catch (EASBizException e) {
				e.printStackTrace();
				throw new BOSException(e);
			}
		}
		
	}
	/**
	 * 获得指定批次的周龄日龄信息
	 * @param arg0
	 * @param arg1
	 * @return
	 * @throws BOSException
	 * @throws  
	 */
	@Override
	protected HashMap<String, Integer> _getBatchWeekages(Context ctx, String batchID,Date bizdate)
			throws BOSException {
		HashMap<String, Integer>  ageInfos = new HashMap<String, Integer>();
		if(StringUtils.isNotBlank(batchID)){
			try{
				
				BreedBatchInfo batchInfo = BreedBatchFactory.getLocalInstance(ctx).getBreedBatchInfo(new ObjectUuidPK(batchID));
				if(batchInfo != null){
					int initWeek = batchInfo.getWeek();
					int initDay = batchInfo.getWeekDay();
					Date initDate = batchInfo.getBizDate();
					if(initDate == null){
						throw new BOSException("养殖批次的业务日期为空，无法计算");
					}
					Date nowDate = bizdate;
					if(nowDate == null) nowDate = new Date();
					
					long diff = nowDate.getTime() - initDate.getTime();
				    long days = diff / (1000 * 60 * 60 * 24);
				    // 批次日期到当前的日期差，加上批次定栏时的 周龄 算出当前的日龄
				    int daysInt = (int) days;
				    
				    daysInt = daysInt + (initWeek-1) * 7 + initDay;
				    // TODO 待验证准确性
				    int currDay = daysInt%7;
				    int currWeek = daysInt/7 +1;
				    if(daysInt != 0 && currDay == 0) {
				    	currDay = 7;
				    	currWeek = currWeek -1;
				    }
				   
				    
				    
				    ageInfos.put("currWeek", Integer.valueOf(currWeek));
				    ageInfos.put("currDay", Integer.valueOf(currDay));
				}
			}catch(EASBizException e){
				e.printStackTrace();
				throw new BOSException(e);
			}
		}else{
			
		}
		return ageInfos;
	}
	/**
	 * 获取 模型entryinfo
	 */
	@Override
	protected BreedModelEntryInfo _getBreedModelEntryInfo(Context ctx,
			String modelID, int week,int days) throws BOSException {
		
		String column = "cfweek";
		int intValue = week;
		if(week == 0){
			column = "cfdays";
			intValue = days;
		}
		String sql = "select te.fid from CT_FM_BreedModelEntrys te where te.fparentid = ? and te."+ column + "=?";
		
		Object[] args = {modelID,new Integer(intValue)};
		
		IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
		if(rs.size() > 1){
			throw new FarmException("存在多条设置统一个周龄的饲喂计划分录");
		}
		try{
			if(rs.next()){
				String fid = rs.getString("fid");
				return BreedModelEntryFactory.getLocalInstance(ctx).getBreedModelEntryInfo(new ObjectUuidPK(fid));
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new FarmException(e);
		} catch (EASBizException e) {
			e.printStackTrace();
			throw new FarmException(e);
		}
		return null;
	}
	/**
	 * 根据不同 鸡舍类别校验对应的 日报 中是否已经存在了 批次信息
	 */
	@Override
	protected boolean _isBatchGeneratedDailyInfos(Context ctx, String batchID,
			String henHouseType) throws BOSException {
		String tableName = "";
		if(HenhouseType.Brood.getValue().equals(henHouseType)){
			tableName = "CT_FM_BroodDaily"; // 育成日报
		}else if(HenhouseType.LayEgg.getValue().equals(henHouseType)){
			tableName = "CT_FM_LayEggDaily"; // 产蛋日报
		}else if(HenhouseType.CC.getValue().equals(henHouseType)){
			tableName = "CT_FM_CommecialChilkenDaily"; // 商品鸡日报
		}
		
		String sql = "select 1 from " + tableName + " where CFBreedBatchID=?";
		String[] args = {batchID};
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			throw new FarmException(e);
		}
		
	}
	/**
	 * 校验 指定批次指定日期是否已经存在保存的 日报了
	 */
	@Override
	protected boolean _checkDateDailyState(Context ctx, String breedBatchID,
			Date bizDate, String henhouseType, String dailyID)
			throws BOSException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sb = new StringBuffer();
		String table = "CT_FM_CommecialChilkenDaily";
		if(HenhouseType.CC.getValue().equals(henhouseType)){
			table = "CT_FM_CommecialChilkenDaily";
		}else if(HenhouseType.Brood.getValue().equals(henhouseType)){
			table = "CT_FM_BroodDaily";
		}else if(HenhouseType.LayEgg.getValue().equals(henhouseType)){
			table = "CT_FM_LayEggDaily";
		}
		sb = sb.append("select 1 from ");
		sb.append(table);
		sb.append(" where CFBreedBatchID ='");
		sb.append(breedBatchID);
		sb.append("' and fbizdate>={ts'");
		sb.append(sdf.format(bizDate));
		sb.append(" 00:00:00'}");
		sb.append(" and fbizdate<={ts'");
		sb.append(sdf.format(bizDate));
		sb.append(" 23:59:59'} ");
		if(org.apache.commons.lang.StringUtils.isNotBlank(dailyID)){
			sb.append(" and fid <> '");
			sb.append(dailyID);
			sb.append("'");
		}
		
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try{
			if(rs.next()){
				return true;
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
		
		return false;
	}
	/**
	 * 获得 指定批次 鸡 对应的 调整分录的数量
	 */
	protected int _getBatchEntryEditInfos(Context ctx, String batchID,
			String henhouseID, Date bizDate,String chikenType) throws BOSException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder sql = new StringBuilder("select sum(te.CFAddQty) addQty from CT_FM_BreedBatchEditEntrys te");
		sql.append(" inner join CT_FM_BreedBatch t on te.fparentid = t.fid");
		sql.append(" where t.fid=? and te.cfhenhouseid=? and te.CFChikenType=? ");
		sql.append(" and te.CFAddDate <={ts'");
		sql.append(sdf.format(bizDate));
		sql.append("'} ");
		try{
			Object[] args = {batchID,henhouseID,chikenType};
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString(),args);
			if(rs.next()){
				int addQty = rs.getInt("addQty");
				return addQty;
			}else{
				return 0;
			}
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		}
	}
	
	
	
	/**
	 * 获取指定养殖场  最近一个 成本对象（养殖批次）
	 */
	@Override
	protected CostObjectInfo _getFarmLatestCostObject(Context ctx, String farmID)
			throws BOSException {
		String sql = "select t.fid from T_BD_CostObject t inner join t_org_storage ts on trim(t.FDescription_l2) = trim(ts.fname_l2) where (t.FIsForbiden = '0' or t.FIsForbiden is null)  and ts.fid=? order by t.fbatchnumber desc ";
		Object[] args = {farmID};
		IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
		try{
			if(rs.next()){
				String fid = rs.getString("fid");
				return CostObjectFactory.getLocalInstance(ctx).getCostObjectInfo(new ObjectUuidPK(fid));
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		} catch (EASBizException e) {
			
			e.printStackTrace();
			throw new BOSException(e);
		}
		return null;
	}
	/**
	 * 更新批次 出栏状态
	 * （商品鸡）
	 */
	@Override
	protected boolean _updateBatchEntryOutState(Context ctx, String batchID,
			String houseID, boolean isAllOut, int outQty, Date outDate)
			throws BOSException {
		String sql = "update CT_FM_BatchHouseEntry set CFIsAllOut =?,CFAllOutDate=? where FParentID = ? and CFHouseID =?";
		int isMarked = (isAllOut==true?1:0);
		Object[] args = {isMarked,outDate,batchID,houseID};
		// 执行更新
		DbUtil.execute(ctx, sql,args);
		
		return true;
	}
	/**
	 * 更新指定批次所有分录出栏状态和出栏数量
	 */
	@Override
	protected void _updateBatchOutState(Context ctx, String batchID)
			throws BOSException {
	try{
		// 根据分录状态更新 批次分录 出栏状态
		BreedBatchInfo batchInfo = BreedBatchFactory.getLocalInstance(ctx).getBreedBatchInfo(new ObjectUuidPK(batchID));
		if(batchInfo != null){
			BreedBatchEntryCollection entryColl = batchInfo.getEntrys();
			IBreedBatchEntry iEntry = BreedBatchEntryFactory.getLocalInstance(ctx);
			
			for(int i = 0; i < entryColl.size(); i++){
				BreedBatchEntryInfo entryInfo = entryColl.get(i);
				
				if(entryInfo.getHenHouse() == null){
					entryInfo = iEntry.getBreedBatchEntryInfo(new ObjectUuidPK(entryInfo.getId()));
				}
				// 获取出栏数量 TODO
				String henhouseID = entryInfo.getHenHouse().getId().toString();
				
					int markedQty = 0;
					boolean isMarked = false;
					Date markedDate = null;
					StringBuilder sql = new StringBuilder("select sum(te.CFMarketQty) CFMarketQty,max(CFIsMarketed) isMarked,max(t.fbizDate) markedDate from CT_FM_CommecialCDAE te inner join CT_FM_CommecialChilkenDaily t on te.fparentid = t.fid ");
					sql.append(" where te.CFMARKETQTY> 0 and te.CFBREEDINGSTOCK =0 and t.CFBreedBatchID = ? and te.CFHenhouseID = ?");
					Object[] args = {batchID,henhouseID};
					
					IRowSet rs = DbUtil.executeQuery(ctx, sql.toString(),args);
				
					if(rs.next()){
						markedQty = rs.getInt("CFMarketQty");
						isMarked = rs.getBoolean("isMarked");
						markedDate = rs.getDate("markedDate");
						
					}
					// 更新数据
					this.updateBatchEntryOutState(ctx,
							batchID,
							entryInfo.getHenHouse().getId().toString(),
							isMarked, 
							markedQty,
							markedDate);
				}
				
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new FarmException("更新 批次出栏汇总时出错");
		} catch (EASBizException e) {
			
			e.printStackTrace();
			throw new FarmException("更新 批次出栏汇总时出错");
		}
		
	}
	
	/**
	 * 获得指定日期 指定数量的 养殖批次信息，
	 * 查询系统中
	 */
	@Override
	protected Map _getCCBatchAgeAndQty(Context ctx, Date bizDate, int breedDays, int count)
			throws BOSException {

		try{ 
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			
			StringBuilder sb=new StringBuilder();
			sb.append(" select  distinct t.fid,t.fnumber batchNumber,tc.fname_l2 batchName,ts.fid stoOrgID,ts.fnumber stoOrgNumber, ts.fname_l2 stoOrgName,te.cfincoopdate  from ct_fm_breedbatch t ");
			sb.append(" inner join t_org_storage ts on t.cfstoorgid = ts.fid ");
			sb.append(" inner join T_BD_CostObject tc on t.CFCOSTOBJECTID = tc.fid ");
			sb.append(" inner join ct_fm_breedbatchentry te on t.fid = te.fparentid ");
	
			sb.append(" where te.cfismarket <>1 and te.cfincoopdate is not null ");//未完全出栏 入栏日期不为Null
			
			sb.append(" and te.cfincoopdate>=({d '").append(sdf.format(bizDate)).append("'}-").append(breedDays).append(")");//在养周期内
			
			sb.append(" order by te.cfincoopdate asc ");
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			String nowBatchID = "";
			int batchCount = 0;
			Map<String,CCBatchAgeInfo> batchInfos = new HashMap<String, CCBatchAgeInfo>(); 
			while(rs.next()){
				String batchID = rs.getString("fid");
				if(nowBatchID.equals(batchID)){
					continue;
				}else{
					if(rs.getRow()==1) {
						nowBatchID=batchID;//add by dai
					}
					// 保存现有 批次信息 然后继续迭代直到取到满足要求的数据量
					if(StringUtils.isNotBlank(nowBatchID)){
						String stoOrgID = rs.getString("stoOrgID");
						String stoOrgNumber = rs.getString("stoOrgNumber");
						String stoOrgName = rs.getString("stoOrgName");
						
						String batchNumber = rs.getString("batchNumber");
						String batchName = rs.getString("batchName");
						
						
						CCBatchAgeInfo batchAgeInfo = new CCBatchAgeInfo();
						batchAgeInfo.setBatchID(batchID);
						batchAgeInfo.setBatchNumber(batchNumber);
						batchAgeInfo.setBatchName(batchName);
						batchAgeInfo.setStoOrgID(stoOrgID);
						batchAgeInfo.setStoOrgNumber(stoOrgNumber);
						batchAgeInfo.setStoOrgName(stoOrgName);
						
						batchAgeInfo = this.setBatchAgeDetailInfo(ctx,batchAgeInfo,breedDays,nowBatchID,bizDate);
//						if(batchAgeInfo.getDetails().size()<1){//add by dai
//							continue;
//						}
						
						String mapKey = Integer.toString(++batchCount);
						batchInfos.put(mapKey, batchAgeInfo);
					}
					
					if(batchCount < count){
						nowBatchID = batchID;
						
					}else{
						break;
					}
				}
			}
			return batchInfos;
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
		
		
	}

		
	/**
	 * 设置批次明细信息
	 * 
	 * @param ctx
	 * @param ccRptBean
	 * @param param
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	private CCBatchAgeInfo setBatchAgeDetailInfo(Context ctx,CCBatchAgeInfo ageInfo, int breedDays,String batchID,Date bizDate) throws  BOSException{
		List<CCProductPlanRptBean> batchDetailInfos = new ArrayList<CCProductPlanRptBean>();
		// 获取批次明细信息 
		if(StringUtils.isNotBlank(batchID)){
			// 获取 批次明细信息
			// 判断批次 入栏日期  和当前时间比较  批次是否在 当前时间内
			StringBuilder sb = new StringBuilder();
			sb.append("select t.fid billID,te.fid entryID,");
			sb.append(" te.cfhenhouseid,th.fnumber henhouseNumber, th.cfname henhouseName,th.CFName cfhenhouseName,te.cfincoopdate, ");
//			sb.append(" ts.fid stoOrgID,ts.fnumber stoOrgNumber, ts.fname_l2 stoOrgName,");
			sb.append(" te.cfinitqty,te.cfincoopdate,t.fbizdate billBizdate ");
			sb.append(" from CT_FM_BreedBatch t inner join CT_FM_BreedBatchEntry te on t.fid = te.fparentid ");
//			sb.append(" inner join t_org_storage ts on t.cfstoorgid = ts.fid ");
			sb.append(" inner join CT_FM_Henhouse th on te.cfhenhouseid = th.fid ");
			sb.append(" where t.fid ='");
			sb.append(batchID);
			sb.append("'  order by te.cfincoopdate ");
			
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			
//				Date currEntryInDate = new Date();
			Date currEntryOutDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String currEntryDateStr = "";
			List<String> entryHenhouseIDs = new ArrayList<String>();
			int currIncoopQty =0;
			int  currEntryDays;
			Date batchFirstIncoopDate = null;
			try{
				// 获取批次日龄明细信息
				List<CCBatchAgeDetailInfo> batchEntryDetailBean = new ArrayList<CCBatchAgeDetailInfo>();
				
				while(rs.next()){
					
					String billID = rs.getString("billID");
					String entryID = rs.getString("entryID");
					String cfhenhouseid = rs.getString("cfhenhouseid");
					String henhouseNumber = rs.getString("henhouseNumber");
					String cfhenhouseName = rs.getString("cfhenhouseName");
					
					
					
					
					int cfinitqty = rs.getInt("cfinitqty");
					// 入栏日期
					Date cfincoopdate = rs.getDate("cfincoopdate");
					// 设置 批次 首次入栏日期
					if(batchFirstIncoopDate == null){
						batchFirstIncoopDate = cfincoopdate;
					}
					if(cfincoopdate == null ){
						cfincoopdate = rs.getDate("billBizdate");
					}
					
					currEntryDateStr = sdf.format(cfincoopdate);
					entryHenhouseIDs = new ArrayList<String>();
					entryHenhouseIDs.add(cfhenhouseid);
					// 当前总入栏量等于当前行
					currIncoopQty = cfinitqty;
					// 明细
					CCBatchAgeDetailInfo newDetail = new CCBatchAgeDetailInfo();
					newDetail.setHenhouseID(cfhenhouseid);
					newDetail.setHenhouseNumber(henhouseNumber);
					newDetail.setHenhouseName(cfhenhouseName);
					
					newDetail.setIncoopDate(cfincoopdate);
					newDetail.setIncoopQty(cfinitqty);
					newDetail.setNowDate(bizDate);
					
					
					Calendar cal = Calendar.getInstance();
					
					// 如果取得的出栏日期为null，则计算理论出栏时间     入栏日期加上  38天
					if(currEntryOutDate == null){
						cal.setTime(cfincoopdate);
						cal.add(Calendar.DATE, breedDays);
						
						currEntryOutDate = cal.getTime();
					}
					
					
					// 数量迭代计算
					int qty = cfinitqty;
					// 记录当前计算日期的 时间戳
					
					Calendar currCal = Calendar.getInstance();
					Date currDate = null;
					for(int i = 1; i <= breedDays; i++){
						
						currCal.setTime(cfincoopdate);
						currCal.add(Calendar.DATE, i);
						
						// 获取当前循环到的日期
						currDate = currCal.getTime();
						
						
						
						// 获取当天的实际存栏量，从头一天日报的 存栏量获得，如果未取到则以头一天算出的 存栏量 与理论死淘比例计算获得存栏量
						qty = CCProductPlanRptCommonFacadeFactory.getLocalInstance(ctx).getCCPredateHenqty(ageInfo.getStoOrgID(),batchID,currDate,"",cfhenhouseid,qty);
						if(qty <= 0){
							continue;
						}
						
						if(sdf.format(currDate).equals(sdf.format(bizDate))){
							newDetail.setNowQty(qty);
							newDetail.setNowDate(currDate);
						}
						
					}
					
					newDetail.setOutDate(currDate);
					newDetail.setOutQty(qty);
//					if(newDetail.getNowQty()>0)//add by dai 
					batchEntryDetailBean.add(newDetail);
				
					
					// 添加到结果集中
//					ageInfo.setDetails(batchEntryDetailBean);
//					return ageInfo;
					
				}
				// 添加到结果集中
				ageInfo.setDetails(batchEntryDetailBean);
				return ageInfo;
			}catch(SQLException sqle){
				sqle.printStackTrace();
				throw new BOSException(sqle);
				
			} 
		}
		
		return ageInfo;
	}
	/**
	 * 根据 库存组织id和出栏日期 取得对应的 养殖批次信息
	 */
	@Override
	protected BreedBatchInfo _getBreedBatchByOrgAndOutDate(Context ctx,
			String stoOrgID, Date outDate) throws BOSException {
		String sql = "select cfbreedbatchid  from ct_fm_commecialchilkendaily  where cfstoorgid=? and to_char(fbizdate,'yyyy-mm-dd')=? ";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Object[] args = {stoOrgID,sdf.format(outDate)};
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sql,args);
			if(rs.next()){
				String fid = rs.getString("cfbreedbatchid");
				return BreedBatchFactory.getLocalInstance(ctx).getBreedBatchInfo(new ObjectUuidPK(fid));
			}else{
				return null;
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		} catch (EASBizException e) {
			e.printStackTrace();
			throw new BOSException(e);
		}
	}
	/**
	 * 获取批次指定 鸡舍的到某一天为止的转栏统计
	 */
	@Override
	protected int _getBatchEntryTransQty(Context ctx, String batchID,
			String henhouseID, Date bizDate) throws BOSException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder sql = new StringBuilder("select sum(te.CFTransQty) transQty from CT_FM_CommecialCDAE te");
		sql.append(" inner join CT_FM_CommecialChilkenDaily t on te.fparentid = t.fid");
		sql.append(" where t.CFBreedBatchID=? and te.cfhenhouseid=?  ");
		sql.append(" and t.fbizdate <{ts'");
		sql.append(sdf.format(bizDate));
		sql.append("'} ");
		try{
			Object[] args = {batchID,henhouseID};
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString(),args);
			if(rs.next()){
				int transQty = rs.getInt("transQty");
				return transQty;
			}else{
				return 0;
			}
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		}
		
	}
	/**
	 * 获取 物料的 残留时间
	 */
	@Override
	protected int _getMaterialResidueDays(Context ctx, String materialID)
			throws BOSException {
		String sql = "select CFResidueDays from CT_FM_ResidueSet where CFMaterialID = ?";
		Object[] args = {materialID};
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
			// 
			if(rs.size() > 1){
				throw new BOSException("物料维护了不止一个残留时间，请联系管理员调整基础设置");
			}else if(rs.size() > 0 && rs.next()){
				
					int days = rs.getInt("CFResidueDays");
					return days;
			
			}else{
				return 999;
			}
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		}
	}
	@Override
	protected ResidueSetInfo _getMaterialResidueSet(Context ctx,
			String materialID) throws BOSException {
		String sql = "select fid from CT_FM_ResidueSet where CFMaterialID = ?";
		Object[] args = {materialID};
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
			// 
			if(rs.size() > 1){
				throw new BOSException("物料维护了不止一个残留时间，请联系管理员调整基础设置");
			}else if(rs.size() > 0 && rs.next()){
				
					String fid = rs.getString("fid");
					return ResidueSetFactory.getLocalInstance(ctx).getResidueSetInfo(new ObjectUuidPK(fid));
			
			}else{
				return null;
			}
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		} catch (EASBizException e) {
			
			e.printStackTrace();
			throw new BOSException(e);
		}
	}
	@Override
	protected String _getPermission(Context ctx, IObjectValue user)
			throws BOSException {
		// TODO Auto-generated method stub
		return null;
	}

	

}