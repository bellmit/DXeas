package com.kingdee.eas.custom.runkanban.common;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class CommicalChicken {

	//商品鸡展示全部数据
	public static String FFCCAD(Context ctx, String paramStr) {
		 JSONObject resultObj=new JSONObject();
		 resultObj.put("MUNLI", FFCCMUNLI(ctx,paramStr));//截止到今天的出栏信息
		 resultObj.put("MUNFC", FFCCMUNFC(ctx,paramStr));//截止到今天的耗料重量
		 resultObj.put("MUNIQ", FFCCMUNIQ(ctx,paramStr));//截止到今天的入栏信息
		 resultObj.put("MUNGCN", FFCCMUNGCN(ctx,paramStr));//截止到今天的毛鸡数量
		 resultObj.put("MUNGCW", FFCCMUNGCW(ctx,paramStr));//截止到今天的毛鸡重量
		 resultObj.put("DBSADAC", FFCCDBSADAC(ctx,paramStr));//当日养殖存栏总量，死淘总量
		 
		 resultObj.put("FFCCCGCN", FFCCCGCN(ctx,paramStr));//商品鸡最近一次宰杀批次-毛鸡数量
		 resultObj.put("FFCCCFC", FFCCCFC(ctx,paramStr));//商品鸡最近一次宰杀批次_批次耗料量
		 resultObj.put("FFCCCIQ", FFCCCIQ(ctx,paramStr));//商品鸡最近一次宰杀批次_批次入栏信息
		 resultObj.put("FFCCCGCW", FFCCCGCW(ctx,paramStr));//商品鸡最近一次宰杀批次_毛鸡重量
		return resultObj.toString();
	}
	
	//鸡场养殖只数统计（出栏数据明细）
	public static String farmBreedQtyStatistic(Context ctx, String paramStr){
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONArray resultArray=new JSONArray();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" /*dialect*/");
		sql.append(" select ");
		sql.append(" t.CFFarmID farmid,bu.fname_l2 farmname,");
		sql.append(" to_char(max(t.FBizdate),'yyyy-mm-dd')  bizdate,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizDate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) then");
		sql.append(" t.cfphysicaldeathqty+t.cfuncarcassqty+t.cfcarcassqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizDate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1, 7) then");
		sql.append(" t.cfphysicaldeathqty+t.cfuncarcassqty+t.cfcarcassqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizDate, 'yyyy') =");
		sql.append(" substr('"+fbizdate+"', 1, 4) then");
		sql.append(" t.cfphysicaldeathqty+t.cfuncarcassqty+t.cfcarcassqty+0");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearQty  ");
		sql.append(" from CT_FM_ChickenDaily t ");
		sql.append(" inner join T_ORG_BaseUnit bu on t.CFFarmID=bu.fid ");
		sql.append(" where  (to_char(t.fbizdate, 'yyyy') = substr('"+fbizdate+"', 1, 4))");
		sql.append(" and (t.fbizdate <(to_date('"+fbizdate+"','yyyy-mm-dd')+1) )");
		sql.append(" group by t.CFFarmID,bu.fname_l2");
		sql.append(" order by bizdate desc");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				resultObj.put("farmid",rs.getString("farmid"));
				resultObj.put("farmname",rs.getString("farmname"));
				resultObj.put("bizdate",rs.getString("bizdate"));
				resultObj.put("dayQty",rs.getString("dayQty"));
				resultObj.put("monthQty",rs.getString("monthQty"));
				resultObj.put("yearQty",rs.getString("yearQty"));
				
				resultArray.add(resultObj);
			}
		} catch (Exception e) {
			resultArray.add( e.getMessage());
		}
		return resultArray.toString();
	}
	
	//商品鸡批次汇总全部数据
	public static String BreedBatchSummaryAllData(Context ctx, String paramStr){
		JSONObject resultObj=new JSONObject();
		resultObj.put("ccDailySummaryByBatch", ccDailySummaryByBatch(ctx,paramStr));//商品鸡日报按批次汇总
		resultObj.put("foodCCDailySummaryByBatch", foodCCDailySummaryByBatch(ctx,paramStr));//食品厂商品鸡日报按批次汇总
		resultObj.put("foodCCWeighingSummaryByBatch", foodCCWeighingSummaryByBatch(ctx,paramStr));//食品厂商品鸡入库过磅批次汇总
		resultObj.put("farmBatchFeedAllocationSummary", farmBatchFeedAllocationSummary(ctx,paramStr));//养殖场批次饲料调拨汇总
		
		return resultObj.toString();
	}
	
	//养殖场批次饲料调拨汇总
	public static String farmBatchFeedAllocationSummary(Context ctx,String paramStr){
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONArray resultArray=new JSONArray();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" /*dialect*/");
		sql.append(" select t.batchID,");
		sql.append(" sum(t.qty) qty ");
		sql.append(" from (");
		sql.append(" select ");
		sql.append(" tb.fid batchID,");
		sql.append(" sum(te.fbaseqty) qty");
		sql.append(" from t_im_stocktransferbill t ");
		sql.append(" inner join t_im_stocktransferbillentry te on t.fid = te.fparentid");
		sql.append(" inner join ct_fm_breedbatch tb on t.cfcostobjectid = tb.cfcostobjectid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid");
		sql.append(" where  (tm.fmaterialgroupid='at4AAAAAbzDHn8BC' or tm.fmaterialgroupid='at4AAAAAbzDHn8BC')");
		sql.append(" and t.FISSUESTORAGEORGUNITID ='at4AAAAACFnM567U' ");
		sql.append(" group by tb.fid");
		sql.append(" union all");
		sql.append(" select ");
		sql.append(" tb.fid batchID,");
		sql.append(" sum(te.fbaseqty)* -1 qty");
		sql.append(" from t_im_stocktransferbill t ");
		sql.append(" inner join t_im_stocktransferbillentry te on t.fid = te.fparentid");
		sql.append(" inner join ct_fm_breedbatch tb on t.cfcostobjectid = tb.cfcostobjectid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid");
		sql.append(" where  (tm.fmaterialgroupid='at4AAAAAbzDHn8BC' or tm.fmaterialgroupid='at4AAAAAbzDHn8BC') ");
		sql.append(" and t.FReceiptStorageOrgUnitID ='at4AAAAACFnM567U' ");
		sql.append(" and (tb.fid='' or null is null)  ");
		sql.append(" group by tb.fid");
		sql.append(" ) t group by t.batchID");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				resultObj.put("batchID",rs.getString("batchID"));
				resultObj.put("qty",rs.getString("qty"));
				
				resultArray.add(resultObj);
			}
		} catch (Exception e) {
			resultArray.add( e.getMessage());
		}
		return resultArray.toString();
		
	}
	
	//食品厂商品鸡入库过磅批次汇总
	public static String foodCCWeighingSummaryByBatch(Context ctx,String paramStr){
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONArray resultArray=new JSONArray();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		
		sql.append(" select ");
		sql.append(" t.CFOrderStorageOrgU cforderstorageorgu,");
		sql.append(" max(t.FBizdate) bizdate,");
		sql.append(" tc.fid cfbreedbatchid,");
		sql.append(" sum(te.CFSuttle) suttle");
		sql.append(" from CT_WHB_InStorageBill t ");
		sql.append(" inner join CT_WHB_InStorageBillEntry te on t.fid = te.fparentid");
		sql.append(" inner join CT_FM_BreedBatch tc on t.CFOrderStorageOrgU = tc.cfstoorgid  and t.fbizdate < tc.fbizdate+50 and  t.fbizdate > tc.fbizdate");
		sql.append(" where t.cfbillstatus = '4' and te.cfmaterialid='at4AAAAAph1ECefw'");
		sql.append(" and t.fbizdate >= ({d '"+fbizdate.substring(0,8)+"01'}-4)");
		sql.append(" and t.fbizdate <= ({d '"+fbizdate+"'} + 50)");
		sql.append(" group by t.CFOrderStorageOrgU,tc.fid");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				resultObj.put("cforderstorageorgu",rs.getString("cforderstorageorgu"));
				resultObj.put("bizdate",rs.getString("bizdate"));
				resultObj.put("cfbreedbatchid",rs.getString("cfbreedbatchid"));
				resultObj.put("suttle",rs.getString("suttle"));

				resultArray.add(resultObj);
			}
		} catch (Exception e) {
			resultArray.add( e.getMessage());
		}
		return resultArray.toString();
	}
	
	//食品厂商品鸡日报按批次汇总
	public static String foodCCDailySummaryByBatch(Context ctx,String paramStr){
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONArray resultArray=new JSONArray();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" select ");
		sql.append(" t.CFFarmID farmid,");
		sql.append(" max(t.FBizdate) bizdate,");
		sql.append(" tc.fid cfbreedbatchid,");
		sql.append(" sum(t.CFByPWeight) ByPWeight,");
		sql.append(" sum(t.CFMainPWeight) MainPWeight,");
		sql.append(" sum(t.CFDryingChickenQty) DryingChickenQty,");
		sql.append(" sum(t.CFUnCarcassQty) UnCarcassQty,");
		sql.append(" sum(t.CFUnCarcassWeight) UnCarcassWeight,");
		sql.append(" sum(t.CFDryingChickenWeight) DryingChickenWeight,");
		sql.append(" sum(t.CFCarcassWeight) CarcassWeight,");
		sql.append(" sum(t.CFCarcassQty) CarcassQty,");
		sql.append(" sum(t.CFPhysicalDeathWeight) PhysicalDeathWeight,");
		sql.append(" sum(t.CFPhysicalDeathQty) PhysicalDeathQty");
		sql.append(" from CT_FM_ChickenDaily t ");
		sql.append(" inner join CT_FM_BreedBatch tc on t.cffarmid = tc.CFStoOrgID and t.fbizdate < tc.fbizdate+50 and t.fbizdate> tc.fbizdate");
		sql.append(" where 1=1 ");
		sql.append(" and  t.fbizdate >= ({d '"+fbizdate.substring(0,8)+"01'} - 4)");
		sql.append(" and  t.fbizdate <= ({d '"+fbizdate+"'} + 50)");
		sql.append(" and tc.cfstoorgid in ");
		sql.append(" (");
		sql.append(" select tor.forgid");
		sql.append(" from T_PM_OrgRange tor");
		sql.append(" where tor.ftype = 10");
		sql.append(" ");
		sql.append(" ");
		sql.append(" ) group by t.CFFarmID,tc.fid  ");
		
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				resultObj.put("farmid",rs.getString("farmid"));
				resultObj.put("bizdate",rs.getString("bizdate"));
				resultObj.put("cfbreedbatchid",rs.getString("cfbreedbatchid"));
				resultObj.put("ByPWeight",rs.getString("ByPWeight"));
				resultObj.put("MainPWeight",rs.getString("MainPWeight"));
				resultObj.put("DryingChickenQty",rs.getString("DryingChickenQty"));
				resultObj.put("UnCarcassQty",rs.getString("UnCarcassQty")==null?"0":rs.getString("UnCarcassQty"));
				resultObj.put("UnCarcassWeight",rs.getString("UnCarcassWeight")==null?"0":rs.getString("UnCarcassWeight"));
				resultObj.put("DryingChickenWeight",rs.getString("DryingChickenWeight"));
				resultObj.put("CarcassWeight",rs.getString("CarcassWeight"));
				resultObj.put("CarcassQty", rs.getString("CarcassQty"));
				resultObj.put("PhysicalDeathWeight", rs.getString("PhysicalDeathWeight"));
				resultObj.put("PhysicalDeathQty", rs.getString("PhysicalDeathQty"));

				resultArray.add(resultObj);
			}
		} catch (Exception e) {
			resultArray.add( e.getMessage());
		}
		return resultArray.toString();
	}
	
	//商品鸡日报按批次汇总
	public static String ccDailySummaryByBatch(Context ctx, String paramStr){
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONArray resultArray=new JSONArray();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" SELECT t.fid batchID,");
		sql.append(" max(t.fnumber) batchNumber,");
		sql.append(" max(tco.fname_l2) batchName,");
		sql.append(" ts.fid stoorgID,");
		sql.append(" max(ts.fnumber) stoOrgNumber,");
		sql.append(" max(ts.fname_l2) stoOrgName,");
		sql.append(" max(tbe.CFINCOOPDATE) maxIncoopDate,");
		sql.append(" sum(tbe.cfinitQty) initQty,");
		sql.append(" count(tbe.cfhenhouseid) henhouseCount,");
		sql.append(" sum(thh.cfarea) houseArea     ");
		sql.append(" from ct_fm_breedbatch t");
		sql.append(" INNER JOIN t_org_storage ts");
		sql.append(" ON t.cfstoOrgID = ts.fid");
		sql.append(" INNER JOIN T_BD_CostObject tco");
		sql.append(" ON t.CFCostObjectID = tco.fid");
		sql.append(" INNER JOIN ct_fm_breedbatchentry tbe");
		sql.append(" ON t.fid = tbe.fparentid");
		sql.append(" INNER JOIN ct_fm_henhouse thh");
		sql.append(" ON tbe.CFHENHOUSEID = thh.fid");
		sql.append(" WHERE t.fid IN (SELECT tc.fid");
		sql.append(" FROM CT_FM_ChickenDaily t");
		sql.append(" INNER JOIN ct_fm_breedbatch tc");
		sql.append(" ON t.cffarmid = tc.cfstoorgid");
		sql.append(" and tc.fbizdate >= t.fbizdate -50");
		sql.append(" WHERE 1 = 1");
		sql.append(" AND (t.fbizdate >= {D '"+fbizdate.substring(0,8)+"01' })");
		sql.append(" AND (t.fbizdate <= {D '"+fbizdate+"' })");
		sql.append(" GROUP BY t.CFFarmID, tc.fid)");
		sql.append(" and t.cfstoOrgID in ");
		sql.append(" (");
		sql.append(" select tor.forgid");
		sql.append(" from T_PM_OrgRange tor");
		sql.append(" where tor.ftype = 10");
		sql.append(" )  ");
		sql.append(" and t.fid in ");
		sql.append(" (");
		sql.append(" select  tc.fid cfbreedbatchid      ");
		sql.append(" from CT_WHB_InStorageBill t ");
		sql.append(" inner join CT_WHB_InStorageBillEntry te on t.fid = te.fparentid");
		sql.append(" inner join CT_FM_BreedBatch tc on t.CFOrderStorageOrgU = tc.cfstoorgid  and t.fbizdate < tc.fbizdate+50 and  t.fbizdate > tc.fbizdate");
		sql.append(" where t.cfbillstatus = '4' and te.cfmaterialid='at4AAAAAph1ECefw'");
		sql.append(" and t.fbizdate >= ({d '"+fbizdate.substring(0,8)+"01'}-4)");
		sql.append(" and t.fbizdate <= ({d '"+fbizdate+"'} + 50)");
		sql.append(" and te.CFSuttle > 0");
		sql.append(" group by t.CFOrderStorageOrgU,tc.fid");
		sql.append(" )");
		sql.append(" GROUP BY t.fid, ts.fid");
		sql.append(" ORDER BY batchNumber ASC, stoOrgNumber ASC");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				resultObj.put("batchID",rs.getString("batchID"));
				resultObj.put("batchNumber",rs.getString("batchNumber"));
				resultObj.put("batchName",rs.getString("batchName"));
				resultObj.put("stoorgID",rs.getString("stoorgID"));
				resultObj.put("stoOrgNumber",rs.getString("stoOrgNumber"));
				resultObj.put("stoOrgName",rs.getString("stoOrgName"));
				resultObj.put("maxIncoopDate",rs.getString("maxIncoopDate"));
				resultObj.put("initQty",rs.getString("initQty"));
				resultObj.put("henhouseCount",rs.getString("henhouseCount"));
				resultObj.put("houseArea",rs.getString("houseArea"));
			
				resultArray.add(resultObj);
			}
		} catch (Exception e) {
			resultArray.add( e.getMessage());
		}
		return resultArray.toString();
	
	}
	
	//商品鸡本月截止到今天的出栏数量汇总
	public static String ccCurrentMonthMarketSummary(Context ctx, String paramStr){
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONArray resultArray=new JSONArray();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" select s.fname_l2 farmname,bb.fnumber batchnumber,cclbe.CFHenhouseName henhousename,sum(cclbe.cfqty) marketqty,sum(cclbe.cfweight) markeatweight");
		sql.append(" from CT_FM_CCLeaveBill cclb");
		sql.append(" inner join CT_FM_CCLeaveBillEntry cclbe on cclb.fid=cclbe.fparentid");
		sql.append(" inner join CT_FM_BreedBatch bb on bb.fid=cclbe.CFBreedBatchID");
		sql.append(" inner join T_ORG_Storage s on cclb.CFStorageOrgUnitID=s.fid");
		sql.append(" where 1=1");
		sql.append(" and cclb.cfbillstatus=4");
		sql.append(" and cclb.fbizdate<=to_date('"+fbizdate+" 23:59:59')");
		sql.append(" and cclb.fbizdate>=to_date('"+fbizdate.substring(0, 8)+"01 00:00:00')");
		sql.append(" group by  s.fname_l2,bb.fnumber,cclbe.CFHenhouseName");
		sql.append(" order by  length(s.fname_l2),s.fname_l2,bb.fnumber,length(cclbe.cfhenhousename),cclbe.cfhenhousename");

		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				resultObj.put("farmname",rs.getString("farmname"));//养殖场名称
				resultObj.put("batchnumber",rs.getString("batchnumber"));//养殖批次编码
				resultObj.put("henhousename",rs.getString("henhousename"));//鸡舍名称
				resultObj.put("marketqty",rs.getString("marketqty"));//出栏数量
				resultObj.put("markeatweight",rs.getString("markeatweight"));//出栏重量
				resultArray.add(resultObj);
			}
		} catch (Exception e) {
			resultArray.add( e.getMessage());
		}
		return resultArray.toString();
	
	}
	
	
	//商品鸡最近一次宰杀批次_毛鸡重量
	private static String FFCCCGCW(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" select ");
		sql.append(" t.CFOrderStorageOrgU CFOrderStorageOrgU,");
		sql.append(" max(t.FBizdate) bizdate,");
		sql.append(" tc.fid cfbreedbatchid,");
		sql.append(" sum(te.CFSuttle) suttle   ");
		sql.append(" from CT_WHB_InStorageBill t ");
		sql.append(" inner join CT_WHB_InStorageBillEntry te on t.fid = te.fparentid");
		sql.append(" inner join CT_FM_BreedBatch tc on t.CFOrderStorageOrgU = tc.cfstoorgid  and t.fbizdate < tc.fbizdate+50 and  t.fbizdate > tc.fbizdate ");
		sql.append(" where t.cfbillstatus = '4' and te.cfmaterialid='at4AAAAAph1ECefw'");
		sql.append(" and tc.fid ");
		sql.append(" in (");
		sql.append(" select top 1       ");
		sql.append(" tc.fid cfbreedbatchid            ");
		sql.append(" from CT_FM_ChickenDaily t ");
		sql.append(" inner join CT_FM_BreedBatch tc on t.cffarmid = tc.CFStoOrgID and t.fbizdate < tc.fbizdate+50 and t.fbizdate> tc.fbizdate");
		sql.append(" where 1=1 ");
		sql.append(" and  t.fbizdate <= ({d '"+fbizdate+"'} )");
		sql.append(" and  t.CFIsBatchOver = 1 ");
		sql.append(" order by t.fbizdate desc");
		sql.append(" ) group by t.CFOrderStorageOrgU,tc.fid");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				String suttle=rs.getString("suttle");
				resultObj.put("suttle",suttle==null?"0":suttle);
				resultObj.put("CFOrderStorageOrgU",rs.getString("CFOrderStorageOrgU"));
				resultObj.put("bizdate",rs.getString("bizdate"));
				resultObj.put("cfbreedbatchid",rs.getString("cfbreedbatchid"));
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	//商品鸡最近一次宰杀批次_批次入栏信息
	private static String FFCCCIQ(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" SELECT t.fid batchID,");
		sql.append(" max(t.fnumber) batchNumber,");
		sql.append(" max(tco.fname_l2) batchName,");
		sql.append(" ts.fid stoorgID,");
		sql.append(" max(ts.fnumber) stoOrgNumber,");
		sql.append(" max(ts.fname_l2) stoOrgName,");
		sql.append(" max(tbe.CFINCOOPDATE) maxIncoopDate,");
		sql.append(" sum(tbe.cfinitQty) initQty,");
		sql.append(" count(tbe.cfhenhouseid) henhouseCount,");
		sql.append(" sum(thh.cfarea) houseArea     ");
		sql.append(" from ct_fm_breedbatch t");
		sql.append(" INNER JOIN t_org_storage ts");
		sql.append(" ON t.cfstoOrgID = ts.fid");
		sql.append(" INNER JOIN T_BD_CostObject tco");
		sql.append(" ON t.CFCostObjectID = tco.fid");
		sql.append(" INNER JOIN ct_fm_breedbatchentry tbe");
		sql.append(" ON t.fid = tbe.fparentid");
		sql.append(" INNER JOIN ct_fm_henhouse thh");
		sql.append(" ON tbe.CFHENHOUSEID = thh.fid");
		sql.append(" WHERE  t.fid in  (");
		sql.append(" select top 1  tc.fid cfbreedbatchid              ");
		sql.append(" from CT_FM_ChickenDaily t ");
		sql.append(" inner join CT_FM_BreedBatch tc on t.cffarmid = tc.CFStoOrgID and t.fbizdate < tc.fbizdate+50 and t.fbizdate> tc.fbizdate");
		sql.append(" where 1=1 ");
		sql.append(" and  t.fbizdate <= ({d '"+fbizdate+"'} )");
		sql.append(" and  t.CFIsBatchOver = 1 ");
		sql.append(" order by t.fbizdate desc");
		sql.append(" )");
		sql.append(" GROUP BY t.fid, ts.fid");
		sql.append(" ORDER BY batchNumber ASC, stoOrgNumber ASC");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				String initQty=rs.getString("initQty");
				String henhouseCount=rs.getString("henhouseCount");
				String houseArea=rs.getString("houseArea");
				
				resultObj.put("initQty",initQty==null?"0":initQty);
				resultObj.put("henhouseCount",henhouseCount==null?"0":henhouseCount);
				resultObj.put("houseArea",houseArea==null?"0":houseArea);
				resultObj.put("batchID",rs.getString("batchID"));
				resultObj.put("batchNumber",rs.getString("batchNumber"));
				resultObj.put("batchName",rs.getString("batchName"));
				resultObj.put("stoOrgNumber",rs.getString("stoOrgNumber"));
				resultObj.put("stoOrgName",rs.getString("stoOrgName"));
				resultObj.put("maxIncoopDate",rs.getString("maxIncoopDate"));
				resultObj.put("batchID",rs.getString("batchID"));
				
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	//商品鸡最近一次宰杀批次_批次耗料量
	private static String FFCCCFC(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" select t.batchID,");
		sql.append(" sum(t.qty) qty ");
		sql.append(" from (");
		sql.append(" select ");
		sql.append(" tb.fid batchID,");
		sql.append(" sum(te.fbaseqty) qty");
		sql.append(" from t_im_stocktransferbill t ");
		sql.append(" inner join t_im_stocktransferbillentry te on t.fid = te.fparentid");
		sql.append(" inner join ct_fm_breedbatch tb on t.cfcostobjectid = tb.cfcostobjectid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid");
		sql.append(" where  (tm.fmaterialgroupid='at4AAAAAbzDHn8BC' or tm.fmaterialgroupid='at4AAAAAbzDHn8BC')");
		sql.append(" and t.FISSUESTORAGEORGUNITID ='at4AAAAACFnM567U' ");
		sql.append(" and tb.fid in (");
		sql.append(" select top 1    tc.fid cfbreedbatchid              ");
		sql.append(" from CT_FM_ChickenDaily t ");
		sql.append(" inner join CT_FM_BreedBatch tc on t.cffarmid = tc.CFStoOrgID and t.fbizdate < tc.fbizdate+50 and t.fbizdate> tc.fbizdate");
		sql.append(" where 1=1 ");
		sql.append(" and  t.fbizdate <= ({d '"+fbizdate+"'} )");
		sql.append(" and  t.CFIsBatchOver = 1 ");
		sql.append(" order by t.fbizdate desc");
		sql.append(" )	 group by tb.fid");
		sql.append(" union all");
		sql.append(" select ");
		sql.append(" tb.fid batchID,");
		sql.append(" sum(te.fbaseqty)* -1 qty     ");
		sql.append(" from t_im_stocktransferbill t ");
		sql.append(" inner join t_im_stocktransferbillentry te on t.fid = te.fparentid");
		sql.append(" inner join ct_fm_breedbatch tb on t.cfcostobjectid = tb.cfcostobjectid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid ");
		sql.append(" where  (tm.fmaterialgroupid='at4AAAAAbzDHn8BC' or tm.fmaterialgroupid='at4AAAAAbzDHn8BC') ");
		sql.append(" and t.FReceiptStorageOrgUnitID ='at4AAAAACFnM567U' and ");
		sql.append(" tb.fid in (");
		sql.append(" select top 1  tc.fid cfbreedbatchid            ");
		sql.append(" from CT_FM_ChickenDaily t ");
		sql.append(" inner join CT_FM_BreedBatch tc on t.cffarmid = tc.CFStoOrgID and t.fbizdate < tc.fbizdate+50 and t.fbizdate> tc.fbizdate");
		sql.append(" where 1=1 ");
		sql.append(" and  t.fbizdate <= ({d '"+fbizdate+"'} )");
		sql.append(" and  t.CFIsBatchOver = 1 ");
		sql.append(" order by t.fbizdate desc");
		sql.append(" )  group by tb.fid");
		sql.append(" ) t group by t.batchID");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				String qty=rs.getString("qty");
				resultObj.put("batchID",rs.getString("batchID"));
				resultObj.put("qty",qty==null?"0":qty);
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	//商品鸡最近一次宰杀批次-毛鸡数量
	private static String FFCCCGCN(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" select top 1");
		sql.append(" t.CFFarmID cffarmid,");
		sql.append(" max(t.FBizdate) bizdate,");
		sql.append(" tc.fid cfbreedbatchid,");
		sql.append(" sum(t.CFByPWeight) ByPWeight,");
		sql.append(" sum(t.CFMainPWeight) MainPWeight,");
		sql.append(" sum(t.CFDryingChickenQty) DryingChickenQty,");
		sql.append(" sum(t.CFUnCarcassQty) UnCarcassQty,");
		sql.append(" sum(t.CFUnCarcassWeight) UnCarcassWeight,");
		sql.append(" sum(t.CFDryingChickenWeight) DryingChickenWeight,");
		sql.append(" sum(t.CFCarcassWeight) CarcassWeight,");
		sql.append(" sum(t.CFCarcassQty) CarcassQty,");
		sql.append(" sum(t.CFPhysicalDeathWeight) PhysicalDeathWeight,");
		sql.append(" sum(t.CFPhysicalDeathQty) PhysicalDeathQty   ");
		sql.append(" from CT_FM_ChickenDaily t ");
		sql.append(" inner join CT_FM_BreedBatch tc on t.cffarmid = tc.CFStoOrgID and t.fbizdate < tc.fbizdate+50 and t.fbizdate> tc.fbizdate");
		sql.append(" where 1=1 ");
		sql.append(" and  t.fbizdate <= ({d '"+fbizdate+"'} )");
		sql.append(" and tc.fid in ");
		sql.append(" (");
		sql.append(" select top 1");
		sql.append(" tc.fid cfbreedbatchid");
		sql.append(" from CT_FM_ChickenDaily t ");
		sql.append(" inner join CT_FM_BreedBatch tc on t.cffarmid = tc.CFStoOrgID and t.fbizdate < tc.fbizdate+50 and t.fbizdate> tc.fbizdate");
		sql.append(" where 1=1 ");
		sql.append(" and  t.fbizdate <= ({d '"+fbizdate+"'} )");
		sql.append(" and  t.CFIsBatchOver = 1 ");
		sql.append(" order by t.fbizdate desc");
		sql.append(" ) ");
		sql.append(" group by t.CFFarmID,tc.fid order by bizdate desc");

		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				String cffarmid=rs.getString("cffarmid");
				String bizdate=rs.getString("bizdate");
				String cfbreedbatchid=rs.getString("cfbreedbatchid");
				String ByPWeight=rs.getString("ByPWeight");
				String MainPWeight=rs.getString("MainPWeight");
				String DryingChickenQty=rs.getString("DryingChickenQty");
				String UnCarcassQty=rs.getString("UnCarcassQty");
				String UnCarcassWeight=rs.getString("UnCarcassWeight");
				String DryingChickenWeight=rs.getString("DryingChickenWeight");
				String CarcassWeight=rs.getString("CarcassWeight");
				String CarcassQty=rs.getString("CarcassQty");
				String PhysicalDeathWeight=rs.getString("PhysicalDeathWeight");
				String PhysicalDeathQty=rs.getString("PhysicalDeathQty");
				
				resultObj.put("cffarmid",cffarmid);
				resultObj.put("bizdate",bizdate);
				resultObj.put("cfbreedbatchid",cfbreedbatchid);
				resultObj.put("ByPWeight",ByPWeight==null?"0":ByPWeight);
				resultObj.put("MainPWeight",MainPWeight==null?"0":MainPWeight);
				resultObj.put("UnCarcassQty",UnCarcassQty==null?"0":UnCarcassQty);
				resultObj.put("UnCarcassWeight",UnCarcassWeight==null?"0":UnCarcassWeight);
				resultObj.put("DryingChickenQty",DryingChickenQty==null?"0":DryingChickenQty);
				resultObj.put("DryingChickenWeight",DryingChickenWeight==null?"0":DryingChickenWeight);
				resultObj.put("CarcassWeight",CarcassWeight==null?"0":CarcassWeight);
				resultObj.put("CarcassQty",CarcassQty==null?"0":CarcassQty);
				resultObj.put("PhysicalDeathWeight",PhysicalDeathWeight==null?"0":PhysicalDeathWeight);
				resultObj.put("PhysicalDeathQty",PhysicalDeathQty==null?"0":PhysicalDeathQty);
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	//养殖场——商品鸡场——当月——截止到今天_出栏信息
	private static String FFCCMUNLI(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" select sum(cclbe.cfqty) qty,sum(cclbe.cfweight) weight from CT_FM_CCLeaveBill cclb");
		sql.append(" inner join CT_FM_CCLeaveBillEntry cclbe on cclb.fid=cclbe.fparentid");
		sql.append(" where 1=1");
		sql.append(" and cclb.cfbillstatus=4");
		sql.append(" and cclb.fbizdate<to_date('"+fbizdate+" 23:59:59')");
		sql.append(" and cclb.fbizdate>=to_date('"+fbizdate.substring(0, 8)+"01 00:00:00')");
		
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				resultObj.put("qty",rs.getString("qty"));
				resultObj.put("weight",rs.getString("weight"));
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	//养殖场——商品鸡场——当月——截止到今天_耗料重量
	private static String FFCCMUNFC(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" select ");
		sql.append(" sum(t.qty) qty ");
		sql.append(" from (");
		sql.append(" select     ");
		sql.append(" sum(te.fbaseqty) qty      ");
		sql.append(" from t_im_stocktransferbill t ");
		sql.append(" inner join t_im_stocktransferbillentry te on t.fid = te.fparentid");
		sql.append(" inner join ct_fm_breedbatch tb on t.cfcostobjectid = tb.cfcostobjectid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid       ");
		sql.append(" where  (tm.fmaterialgroupid='at4AAAAAbzDHn8BC' or tm.fmaterialgroupid='at4AAAAAbzDHn8BC')");
		sql.append(" and t.FISSUESTORAGEORGUNITID ='at4AAAAACFnM567U' ");
		sql.append(" and tb.fid in (");
		sql.append(" select ");
		sql.append(" top 30");
		sql.append(" tc.fid cfbreedbatchid      ");
		sql.append(" from CT_FM_ChickenDaily t ");
		sql.append(" inner join CT_FM_BreedBatch tc on t.cffarmid = tc.CFStoOrgID and t.fbizdate < tc.fbizdate+50 and t.fbizdate> tc.fbizdate");
		sql.append(" where 1=1 ");
		sql.append(" and  t.fbizdate <= ({d '"+fbizdate+"'} )");
		sql.append(" and year( t.fbizdate ) = year( {d '"+fbizdate+"'} ) ");
		sql.append(" and month( t.fbizdate ) = month( {d '"+fbizdate+"'} ) ");
		sql.append(" and  t.CFIsBatchOver = 1 ");
		sql.append(" order by t.fbizdate desc");
		sql.append(" ) ");
		sql.append(" union all");
		sql.append(" select ");
		sql.append(" sum(te.fbaseqty)* -1 qty      ");
		sql.append(" from t_im_stocktransferbill t ");
		sql.append(" inner join t_im_stocktransferbillentry te on t.fid = te.fparentid");
		sql.append(" inner join ct_fm_breedbatch tb on t.cfcostobjectid = tb.cfcostobjectid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid      ");
		sql.append(" where  (tm.fmaterialgroupid='at4AAAAAbzDHn8BC' or tm.fmaterialgroupid='at4AAAAAbzDHn8BC') ");
		sql.append(" and t.FReceiptStorageOrgUnitID ='at4AAAAACFnM567U' and ");
		sql.append(" tb.fid in (");
		sql.append(" select");
		sql.append(" top 30");
		sql.append(" tc.fid cfbreedbatchid    ");
		sql.append(" from CT_FM_ChickenDaily t ");
		sql.append(" inner join CT_FM_BreedBatch tc on t.cffarmid = tc.CFStoOrgID and t.fbizdate < tc.fbizdate+50 and t.fbizdate> tc.fbizdate");
		sql.append(" where 1=1 ");
		sql.append(" and  t.fbizdate <= ({d '"+fbizdate+"'} )");
		sql.append(" and year( t.fbizdate ) = year( {d '"+fbizdate+"'} ) ");
		sql.append(" and month( t.fbizdate ) = month( {d '"+fbizdate+"'} ) ");
		sql.append(" and  t.CFIsBatchOver = 1 ");
		sql.append(" order by t.fbizdate desc");
		sql.append(" )");
		sql.append(" ) t");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				resultObj.put("qty",rs.getString("qty"));
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	//养殖场——商品鸡场——当月——截止到今天_入栏信息
	private static String FFCCMUNIQ(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" SELECT      ");
		sql.append(" sum(tbe.cfinitQty) initQty,");
		sql.append(" count(tbe.cfhenhouseid) henhouseCount,");
		sql.append(" sum(thh.cfarea) houseArea");
		sql.append(" from ct_fm_breedbatch t");
		sql.append(" INNER JOIN t_org_storage ts");
		sql.append(" ON t.cfstoOrgID = ts.fid");
		sql.append(" INNER JOIN T_BD_CostObject tco");
		sql.append(" ON t.CFCostObjectID = tco.fid");
		sql.append(" INNER JOIN ct_fm_breedbatchentry tbe");
		sql.append(" ON t.fid = tbe.fparentid");
		sql.append(" INNER JOIN ct_fm_henhouse thh");
		sql.append(" ON tbe.CFHENHOUSEID = thh.fid");
		sql.append(" WHERE  t.fid in ");
		sql.append(" (");
		sql.append(" select top 10       ");
		sql.append(" tc.fid cfbreedbatchid");
		sql.append(" ");
		sql.append(" from CT_FM_ChickenDaily t ");
		sql.append(" inner join CT_FM_BreedBatch tc on t.cffarmid = tc.CFStoOrgID and t.fbizdate < tc.fbizdate+50 and t.fbizdate> tc.fbizdate");
		sql.append(" where 1=1 ");
		sql.append(" and  t.fbizdate <= ({d '"+fbizdate+"'} )");
		sql.append(" and year( t.fbizdate ) = year( {d '"+fbizdate+"'} ) ");
		sql.append(" and month( t.fbizdate ) = month( {d '"+fbizdate+"'} ) ");
		sql.append(" and  t.CFIsBatchOver = 1 ");
		sql.append(" order by t.fbizdate desc");
		sql.append(" )");

		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				resultObj.put("initQty",rs.getString("initQty"));
				resultObj.put("henhouseCount",rs.getString("henhouseCount"));
				resultObj.put("houseArea",rs.getString("houseArea"));
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	//养殖场——商品鸡场——当月——截止到今天_毛鸡数量
	private static String FFCCMUNGCN(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" select      ");
		sql.append(" sum(t.CFByPWeight) ByPWeight,");
		sql.append(" sum(t.CFMainPWeight) MainPWeight,");
		sql.append(" sum(t.CFDryingChickenQty) DryingChickenQty,");
		sql.append(" sum(t.CFUnCarcassQty) UnCarcassQty,");
		sql.append(" sum(t.CFUnCarcassWeight) UnCarcassWeight,");
		sql.append(" sum(t.CFDryingChickenWeight) DryingChickenWeight,");
		sql.append(" sum(t.CFCarcassWeight) CarcassWeight,");
		sql.append(" sum(t.CFCarcassQty) CarcassQty,");
		sql.append(" sum(t.CFPhysicalDeathWeight) PhysicalDeathWeight,");
		sql.append(" sum(t.CFPhysicalDeathQty) PhysicalDeathQty     ");
		sql.append(" from CT_FM_ChickenDaily t ");
		sql.append(" inner join CT_FM_BreedBatch tc on t.cffarmid = tc.CFStoOrgID and t.fbizdate < tc.fbizdate+50 and t.fbizdate> tc.fbizdate");
		sql.append(" where 1=1 ");
		sql.append(" and  t.fbizdate <= ({d '"+fbizdate+"'} )");
		sql.append(" and tc.fid in ");
		sql.append(" (");
		sql.append(" select top 10       ");
		sql.append(" tc.fid cfbreedbatchid            ");
		sql.append(" from CT_FM_ChickenDaily t ");
		sql.append(" inner join CT_FM_BreedBatch tc on t.cffarmid = tc.CFStoOrgID and t.fbizdate < tc.fbizdate+50 and t.fbizdate> tc.fbizdate");
		sql.append(" where 1=1 ");
		sql.append(" and  t.fbizdate <= ({d '"+fbizdate+"'} )");
		sql.append(" and year( t.fbizdate ) = year( {d '"+fbizdate+"'} ) ");
		sql.append(" and month( t.fbizdate ) = month( {d '"+fbizdate+"'} ) ");
		sql.append(" and  t.CFIsBatchOver = 1 ");
		sql.append(" order by t.fbizdate desc");
		sql.append(" ) ");

		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				String ByPWeight=rs.getString("ByPWeight");
				String MainPWeight=rs.getString("MainPWeight");
				String UnCarcassQty=rs.getString("UnCarcassQty");
				String DryingChickenQty=rs.getString("DryingChickenQty");
				String UnCarcassWeight=rs.getString("UnCarcassWeight");
				String DryingChickenWeight=rs.getString("DryingChickenWeight");
				String CarcassWeight=rs.getString("CarcassWeight");
				String CarcassQty=rs.getString("CarcassQty");
				String PhysicalDeathWeight=rs.getString("PhysicalDeathWeight");
				String PhysicalDeathQty=rs.getString("PhysicalDeathQty");
				
				resultObj.put("ByPWeight",ByPWeight==null?"0":ByPWeight);
				resultObj.put("MainPWeight",MainPWeight==null?"0":MainPWeight);
				resultObj.put("DryingChickenQty",DryingChickenQty==null?"0":DryingChickenQty);
				resultObj.put("UnCarcassQty",UnCarcassQty==null?"0":UnCarcassQty);
				resultObj.put("UnCarcassWeight",UnCarcassWeight==null?"0":UnCarcassWeight);
				resultObj.put("DryingChickenWeight",DryingChickenWeight==null?"0":DryingChickenWeight);
				resultObj.put("CarcassWeight",CarcassWeight==null?"0":CarcassWeight);
				resultObj.put("CarcassQty",CarcassQty==null?"0":CarcassQty);
				resultObj.put("PhysicalDeathWeight",PhysicalDeathWeight==null?"0":PhysicalDeathWeight);
				resultObj.put("PhysicalDeathQty",PhysicalDeathQty==null?"0":PhysicalDeathQty);
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	//养殖场——商品鸡场——当月——截止到今天 毛鸡重量
	private static String FFCCMUNGCW(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" select     ");
		sql.append(" sum(te.CFSuttle) suttle              ");
		sql.append(" from CT_WHB_InStorageBill t ");
		sql.append(" inner join CT_WHB_InStorageBillEntry te on t.fid = te.fparentid");
		sql.append(" inner join CT_FM_BreedBatch tc on t.CFOrderStorageOrgU = tc.cfstoorgid  and t.fbizdate < tc.fbizdate+50 and  t.fbizdate > tc.fbizdate");
		sql.append(" where t.cfbillstatus = '4' and te.cfmaterialid='at4AAAAAph1ECefw'");
		sql.append(" and tc.fid ");
		sql.append(" in (");
		sql.append(" select top 10      ");
		sql.append(" tc.fid cfbreedbatchid            ");
		sql.append(" from CT_FM_ChickenDaily t ");
		sql.append(" inner join CT_FM_BreedBatch tc on t.cffarmid = tc.CFStoOrgID and t.fbizdate < tc.fbizdate+50 and t.fbizdate> tc.fbizdate");
		sql.append(" where 1=1 ");
		sql.append(" and  t.fbizdate <= ({d '"+fbizdate+"'} )");
		sql.append(" and year( t.fbizdate ) = year( {d '"+fbizdate+"'} ) ");
		sql.append(" and month( t.fbizdate ) = month( {d '"+fbizdate+"'} ) ");
		sql.append(" and  t.CFIsBatchOver = 1 ");
		sql.append(" order by t.fbizdate desc");
		sql.append(" )");

		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				String suttle= rs.getString("suttle");
				resultObj.put("suttle", suttle);
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	//养殖场——商品鸡场——今天——养殖存栏总量，死淘总量
	private static String FFCCDBSADAC(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" select  sum(ccdae.cfcullanddeath) cullanddeath, sum(ccdae.cfbreedingstock) breedingstock");
		sql.append(" from CT_FM_CommecialChilkenDaily ccd ");
		sql.append(" inner join CT_FM_CommecialCDAE ccdae on ccd.fid=ccdae.fparentid");
		sql.append(" where  ");
		sql.append(" ccd.fbizdate<to_date('"+fbizdate+" 23:59:59') and ccd.fbizdate >=to_date('"+fbizdate+" 00:00:00')");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				String cullanddeath= rs.getString("cullanddeath");
				String breedingstock=rs.getString("breedingstock");
				resultObj.put("cullanddeath", cullanddeath);
				resultObj.put("breedingstock", breedingstock);
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	
	//养殖场-商品鸡场-各个场存栏量明细
	public static String BreedingstockDetails(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONArray resultArray=new JSONArray();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" select distinct s.fname_l2 factoryname ,ccdae.CFDays days,sum(ccdae.CFBreedingStock) breedingstock");
		sql.append(" from CT_FM_CommecialChilkenDaily ccd");
		sql.append(" inner join CT_FM_CommecialCDAE ccdae on ccdae.fparentid=ccd.fid ");
		sql.append(" inner join T_ORG_Storage s on s.fid=ccd.CFStoOrgID ");
		sql.append(" where ccd.fbizdate>={ts'"+fbizdate+" 00:00:00'} and ccd.fbizdate<{ts'"+fbizdate+" 23:59:59'}");
		sql.append(" group by ccdae.CFDays,s.fname_l2");
		sql.append(" order by factoryname");
		
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				resultObj.put("factoryname",rs.getString("factoryname"));
				resultObj.put("days",rs.getString("days"));
				resultObj.put("breedingstock",rs.getString("breedingstock"));
				resultArray.add(resultObj);
			}
		} catch (Exception e) {
			resultArray.add( e.getMessage());
		}
		return resultArray.toString();
	}

	
}
