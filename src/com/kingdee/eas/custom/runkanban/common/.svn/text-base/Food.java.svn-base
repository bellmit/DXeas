package com.kingdee.eas.custom.runkanban.common;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class Food {
	
	//食品厂-月销量统计-按物料小类（腿类翅类）
	public static String foodMonthSaleDetails(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONArray resultArray=new JSONArray();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		String parentGroupNumber=object.getString("parentGroupNumber");
		sql.append(" select ");
		sql.append(" fid,");
		sql.append(" max(bizdate) bizdate,");
		sql.append(" max(rptYear) rptYear,");
		sql.append(" max(rptMonth) rptMonth,");
		sql.append(" max(materialGroupNumber) materialGroupNumber,");
		sql.append(" max(groupLongNumber) groupLongNumber,");
		sql.append(" max(materialGroupName) materialGroupName,");
		sql.append(" sum(allQty) allQty,");
		sql.append(" sum(allTaxAmount) allTaxAmount,");
		sql.append(" sum(allAmount) allAmount");
		sql.append(" from (");
		sql.append(" select ");
		sql.append(" tg.fid,");
		sql.append(" max(t.fbizdate) bizdate,");
		sql.append(" max(year(t.fbizdate)) rptYear,");
		sql.append(" max(month(t.fbizdate)) rptMonth,");
		sql.append(" max(tg.fnumber) materialGroupNumber,");
		sql.append(" max(tg.flongnumber) groupLongNumber,");
		sql.append(" max(tg.fname_l2) materialGroupName,");
		sql.append(" sum(te.fbaseqty) allQty,");
		sql.append(" sum(te.ftaxamount) allTaxAmount,");
		sql.append(" sum(te.famount) allAmount");
		sql.append("  from t_sd_saleorder t");
		sql.append(" inner join t_sd_saleorderentry te on t.fid= te.fparentid");
		sql.append(" inner join t_bd_customer tcus on t.fordercustomerid = tcus.fid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid");
		sql.append(" inner join t_bd_materialgroup tg on tm.fmaterialgroupid = tg.fid");
		sql.append(" where t.fcompanyorgunitid = 'at4AAAAAAHDM567U'");
		sql.append(" and tg.FLongNumber NOT IN ('02!0204!020402!02040210', '"+parentGroupNumber+"%!02040110')");
		sql.append(" and tg.flongnumber like '"+parentGroupNumber+"%'");
		sql.append(" and YEAR (t.fbizdate) = YEAR({ts '"+fbizdate+"'})");
		sql.append(" and MONTH(t.fbizdate) = MONTH({ts '"+fbizdate+"'})");
		sql.append(" and t.fbasestatus in ('4','7')");
		sql.append(" group by tg.fid");
		sql.append(" union all");
		sql.append(" select ");
		sql.append(" tg.fid,");
		sql.append(" max(t.fbizdate) bizdate,");
		sql.append(" max(year(t.fbizdate)) rptYear,");
		sql.append(" max(month(t.fbizdate)) rptMonth,");
		sql.append(" max(tg.fnumber) materialGroupNumber,");
		sql.append(" max(tg.flongnumber) groupLongNumber,");
		sql.append(" max(tg.fname_l2) materialGroupName,");
		sql.append(" -1*sum(te.fbaseqty) allQty,");
		sql.append(" -1*sum(te.ftaxamount) allTaxAmount,");
		sql.append(" -1*sum(te.famount) allAmount");
		sql.append("  from T_SD_SaleReturns t");
		sql.append(" inner join T_SD_SaleReturnsEntry te on t.fid= te.fparentid");
		sql.append(" inner join t_bd_customer tcus on t.FReturnsCustomerID = tcus.fid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid");
		sql.append(" inner join t_bd_materialgroup tg on tm.fmaterialgroupid = tg.fid");
		sql.append(" where t.fcompanyorgunitid = 'at4AAAAAAHDM567U'");
		sql.append(" and tg.FLongNumber NOT IN ('02!0204!020402!02040210', '"+parentGroupNumber+"%!02040110')");
		sql.append(" and tg.flongnumber like '"+parentGroupNumber+"%'");
		sql.append(" and YEAR (t.fbizdate) = YEAR({ts '"+fbizdate+"'})");
		sql.append(" and MONTH(t.fbizdate) = MONTH({ts '"+fbizdate+"'})");
		sql.append(" and t.fbasestatus in ('4','7')");
		sql.append(" group by tg.fid) tt group by fid order by allQty desc");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				resultObj.put("fid",rs.getString("fid"));
				resultObj.put("bizdate",rs.getString("bizdate"));
				resultObj.put("rptYear",rs.getString("rptYear"));
				resultObj.put("rptMonth",rs.getString("rptMonth"));
				resultObj.put("materialGroupNumber",rs.getString("materialGroupNumber"));
				resultObj.put("groupLongNumber",rs.getString("groupLongNumber"));
				resultObj.put("materialGroupName",rs.getString("materialGroupName"));
				resultObj.put("allQty",rs.getString("allQty"));
				resultObj.put("allTaxAmount",rs.getString("allTaxAmount"));
				resultObj.put("allAmount",rs.getString("allAmount"));
				
				resultArray.add(resultObj);
			}
		} catch (Exception e) {
			resultArray.add( e.getMessage());
		}
		return resultArray.toString();
	}


	
	//食品厂-月销量统计-按物料大类（冰鲜冷冻类）
	public static String foodMonthSaleSummary(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONArray resultArray=new JSONArray();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" select ");
		sql.append(" fid,");
		sql.append(" max(bizdate) bizdate,");
		sql.append(" max(rptYear) rptYear,");
		sql.append(" max(rptMonth) rptMonth,");
		sql.append(" max(materialGroupNumber) materialGroupNumber,");
		sql.append(" max(groupLongNumber) groupLongNumber,");
		sql.append(" max(materialGroupName) materialGroupName,");
		sql.append(" sum(allQty) allQty,");
		sql.append(" sum(allTaxAmount) allTaxAmount,");
		sql.append(" sum(allAmount) allAmount");
		sql.append(" from (");
		sql.append(" select ");
		sql.append(" tgg.fid,");
		sql.append(" max(t.fbizdate) bizdate,");
		sql.append(" max(year(t.fbizdate)) rptYear,");
		sql.append(" max(month(t.fbizdate)) rptMonth,");
		sql.append(" max(tgg.fnumber) materialGroupNumber,");
		sql.append(" max(tgg.flongnumber) groupLongNumber,");
		sql.append(" max(tgg.fname_l2) materialGroupName,");
		sql.append(" sum(te.fbaseqty) allQty,");
		sql.append(" sum(te.ftaxamount) allTaxAmount,");
		sql.append(" sum(te.famount) allAmount");
		sql.append("  from t_sd_saleorder t");
		sql.append(" inner join t_sd_saleorderentry te on t.fid= te.fparentid");
		sql.append(" inner join t_bd_customer tcus on t.fordercustomerid = tcus.fid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid");
		sql.append(" inner join t_bd_materialgroup tg on tm.fmaterialgroupid = tg.fid");
		sql.append(" inner join t_bd_materialgroup tgg on tg.fparentid = tgg.fid");
		sql.append(" where t.fcompanyorgunitid = 'at4AAAAAAHDM567U'");
		sql.append(" and tgg.fnumber in ('020401','020402')");
		sql.append(" and tg.FLongNumber NOT IN ('02!0204!020402!02040210', '02!0204!020401!02040110')");
		sql.append(" and YEAR (t.fbizdate) = YEAR({ts '"+fbizdate+"'})");
		sql.append(" and MONTH(t.fbizdate) = MONTH({ts '"+fbizdate+"'})");
		sql.append(" and t.fbasestatus in ('4','7')");
		sql.append(" group by tgg.fid");
		sql.append(" union all");
		sql.append(" select ");
		sql.append(" tg.fid,");
		sql.append(" max(t.fbizdate) bizdate,");
		sql.append(" max(year(t.fbizdate)) rptYear,");
		sql.append(" max(month(t.fbizdate)) rptMonth,");
		sql.append(" max(tg.fnumber) materialGroupNumber,");
		sql.append(" max(tg.flongnumber) groupLongNumber,");
		sql.append(" max(tg.fname_l2) materialGroupName,");
		sql.append(" sum(te.fbaseqty) allQty,");
		sql.append(" sum(te.ftaxamount) allTaxAmount,");
		sql.append(" sum(te.famount) allAmount");
		sql.append("  from t_sd_saleorder t");
		sql.append(" inner join t_sd_saleorderentry te on t.fid= te.fparentid");
		sql.append(" inner join t_bd_customer tcus on t.fordercustomerid = tcus.fid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid");
		sql.append(" inner join t_bd_materialgroup tg on tm.fmaterialgroupid = tg.fid");
		sql.append(" where t.fcompanyorgunitid = 'at4AAAAAAHDM567U'");
		sql.append(" and tg.fnumber in ('020404')");
		sql.append(" and YEAR (t.fbizdate) = YEAR({ts '"+fbizdate+"'})");
		sql.append(" and MONTH(t.fbizdate) = MONTH({ts '"+fbizdate+"'})");
		sql.append(" and t.fbasestatus in ('4','7')");
		sql.append(" group by tg.fid");
		sql.append(" union all");
		sql.append(" select ");
		sql.append(" tgg.fid,");
		sql.append(" max(t.fbizdate) bizdate,");
		sql.append(" max(year(t.fbizdate)) rptYear,");
		sql.append(" max(month(t.fbizdate)) rptMonth,");
		sql.append(" max(tgg.fnumber) materialGroupNumber,");
		sql.append(" max(tgg.flongnumber) groupLongNumber,");
		sql.append(" max(tgg.fname_l2) materialGroupName,");
		sql.append(" -1*sum(te.fbaseqty) allQty,");
		sql.append(" -1*sum(te.ftaxamount) allTaxAmount,");
		sql.append(" -1*sum(te.famount) allAmount");
		sql.append("  from T_SD_SaleReturns t");
		sql.append(" inner join T_SD_SaleReturnsEntry te on t.fid= te.fparentid");
		sql.append(" inner join t_bd_customer tcus on t.FReturnsCustomerID = tcus.fid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid");
		sql.append(" inner join t_bd_materialgroup tg on tm.fmaterialgroupid = tg.fid");
		sql.append(" inner join t_bd_materialgroup tgg on tg.fparentid = tgg.fid");
		sql.append(" where t.fcompanyorgunitid = 'at4AAAAAAHDM567U'");
		sql.append(" and tg.FLongNumber NOT IN ('02!0204!020402!02040210', '02!0204!020401!02040110')");
		sql.append(" and tgg.fnumber in ('020401','020402')");
		sql.append(" and YEAR (t.fbizdate) = YEAR({ts '"+fbizdate+"'})");
		sql.append(" and MONTH(t.fbizdate) = MONTH({ts '"+fbizdate+"'})");
		sql.append(" and t.fbasestatus in ('4','7')");
		sql.append(" group by tgg.fid");
		sql.append(" union all");
		sql.append(" select ");
		sql.append(" tg.fid,");
		sql.append(" max(t.fbizdate) bizdate,");
		sql.append(" max(year(t.fbizdate)) rptYear,");
		sql.append(" max(month(t.fbizdate)) rptMonth,");
		sql.append(" max(tg.fnumber) materialGroupNumber,");
		sql.append(" max(tg.flongnumber) groupLongNumber,");
		sql.append(" max(tg.fname_l2) materialGroupName,");
		sql.append(" -1*sum(te.fbaseqty) allQty,");
		sql.append(" -1*sum(te.ftaxamount) allTaxAmount,");
		sql.append(" -1*sum(te.famount) allAmount");
		sql.append("  from T_SD_SaleReturns t");
		sql.append(" inner join T_SD_SaleReturnsEntry te on t.fid= te.fparentid");
		sql.append(" inner join t_bd_customer tcus on t.FReturnsCustomerID = tcus.fid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid");
		sql.append(" inner join t_bd_materialgroup tg on tm.fmaterialgroupid = tg.fid");
		sql.append(" where t.fcompanyorgunitid = 'at4AAAAAAHDM567U'");
		sql.append(" and tg.fnumber in ('020404')");
		sql.append(" and YEAR (t.fbizdate) = YEAR({ts '"+fbizdate+"'})");
		sql.append(" and MONTH(t.fbizdate) = MONTH({ts '"+fbizdate+"'})");
		sql.append(" and t.fbasestatus in ('4','7')");
		sql.append(" group by tg.fid) tt group by fid ");

		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				resultObj.put("fid",rs.getString("fid"));
				resultObj.put("bizdate",rs.getString("bizdate"));
				resultObj.put("rptYear",rs.getString("rptYear"));
				resultObj.put("rptMonth",rs.getString("rptMonth"));
				resultObj.put("materialGroupNumber",rs.getString("materialGroupNumber"));
				resultObj.put("groupLongNumber",rs.getString("groupLongNumber"));
				resultObj.put("materialGroupName",rs.getString("materialGroupName"));
				resultObj.put("allQty",rs.getString("allQty"));
				resultObj.put("allTaxAmount",rs.getString("allTaxAmount"));
				resultObj.put("allAmount",rs.getString("allAmount"));
				
				resultArray.add(resultObj);
			}
		} catch (Exception e) {
			resultArray.add( e.getMessage());
		}
		return resultArray.toString();
	}

	//食品厂库存冷冻冰鲜汇总
	public static String foodInventorySummary(Context ctx, String paramStr){
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONArray resultArray=new JSONArray();
		JSONObject object=JSONObject.fromObject(paramStr);

		sql.append(" select max(tc.fid) companyID,");
		sql.append(" max(tc.fname_l2) companyName,");
		sql.append(" max(tgg.flongnumber) parentGroupLongNumber,");
		sql.append(" max(tgg.fname_l2) parentGroupName,");
		sql.append(" max(tu.fname_l2) unitName,");
		sql.append(" sum(t.fbaseqty) nowQty");
		sql.append(" from T_IM_Inventory  t");
		sql.append(" inner join t_bd_material tm on t.fmaterialid = tm.fid");
		sql.append(" inner join t_bd_measureunit tu on t.fbaseunitid = tu.fid");
		sql.append(" inner join t_org_company tc on t.fcompanyorgunitid = tc.fid ");
		sql.append(" inner join t_bd_materialgroup tg on tm.fmaterialgroupid = tg.fid");
		sql.append(" inner join t_bd_materialgroup tgg on tg.fparentid = tgg.fid");
		sql.append(" where tc.fid='at4AAAAAAHDM567U'");
		sql.append(" and tgg.flongnumber in('02!0204!020401','02!0204!020402')");
		sql.append(" and tg.FLongNumber NOT IN ('02!0204!020402!02040210', '02!0204!020401!02040110')");
		sql.append(" group by tgg.flongnumber");
		sql.append(" union all");
		sql.append(" select max(tc.fid) companyID,");
		sql.append(" max(tc.fname_l2) companyName,");
		sql.append(" max(tg.flongnumber) parentGroupLongNumber,");
		sql.append(" max(tg.fname_l2) parentGroupName,");
		sql.append(" max(tu.fname_l2) unitName,");
		sql.append(" sum(t.fbaseqty) nowQty");
		sql.append(" from T_IM_Inventory  t");
		sql.append(" inner join t_bd_material tm on t.fmaterialid = tm.fid");
		sql.append(" inner join t_bd_measureunit tu on t.fbaseunitid = tu.fid");
		sql.append(" inner join t_org_company tc on t.fcompanyorgunitid = tc.fid ");
		sql.append(" inner join t_bd_materialgroup tg on tm.fmaterialgroupid = tg.fid");
		sql.append(" where tc.fid='at4AAAAAAHDM567U'");
		sql.append(" and tg.flongnumber in('02!0204!020404')");
		sql.append(" and tg.FLongNumber NOT IN ('02!0204!020402!02040210', '02!0204!020401!02040110')");
		sql.append(" group by tg.flongnumber");
		sql.append(" order by nowQty desc");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				resultObj.put("companyID",rs.getString("companyID"));
				resultObj.put("companyName",rs.getString("companyName"));
				resultObj.put("parentGroupLongNumber",rs.getString("parentGroupLongNumber"));
				resultObj.put("parentGroupName",rs.getString("parentGroupName"));
				resultObj.put("unitName",rs.getString("unitName"));
				resultObj.put("nowQty",rs.getString("nowQty"));
				
				resultArray.add(resultObj);
			}
		} catch (Exception e) {
			resultArray.add( e.getMessage());
		}
		return resultArray.toString();
	}
	
	//食品厂库存明细分类合计
	public static String foodInventoryDetails(Context ctx, String paramStr){

		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONArray resultArray=new JSONArray();
		JSONObject object=JSONObject.fromObject(paramStr);
		String parentGroupNumber=object.getString("parentGroupNumber");//
		sql.append(" select max(tc.fid) companyID,");
		sql.append(" max(tc.fname_l2) companyName,");
		sql.append(" max(tg.flongnumber) groupNumber,");
		sql.append(" max(tg.fname_l2) groupName,");
		sql.append(" max(tgg.flongnumber) parentGroupNumber,");
		sql.append(" max(tgg.fname_l2) parentGroupName,");
		sql.append(" max(tm.fnumber) materialNumber,");
		sql.append(" max(tm.fname_l2) materialName,");
		sql.append(" max(tu.fname_l2) unitName,");
		sql.append(" sum(t.fbaseqty) nowQty");
		sql.append(" from T_IM_Inventory  t");
		sql.append(" inner join t_bd_material tm on t.fmaterialid = tm.fid");
		sql.append(" inner join t_bd_measureunit tu on t.fbaseunitid = tu.fid");
		sql.append(" inner join t_org_company tc on t.fcompanyorgunitid = tc.fid ");
		sql.append(" inner join t_bd_materialgroup tg on tm.fmaterialgroupid = tg.fid");
		sql.append(" inner join t_bd_materialgroup tgg on tg.fparentid = tgg.fid");
		sql.append(" where tc.fid='at4AAAAAAHDM567U'");
		sql.append(" and tg.flongnumber like('"+parentGroupNumber+"%')");
		sql.append(" group by tg.flongnumber");
		sql.append(" order by nowQty desc");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				resultObj.put("companyID",rs.getString("companyID"));
				resultObj.put("companyName",rs.getString("companyName"));
				resultObj.put("groupNumber",rs.getString("groupNumber"));
				resultObj.put("groupName",rs.getString("groupName"));
				resultObj.put("parentGroupNumber",rs.getString("parentGroupNumber"));
				resultObj.put("parentGroupName",rs.getString("parentGroupName"));
				resultObj.put("materialNumber",rs.getString("materialNumber"));
				resultObj.put("materialName",rs.getString("materialName"));
				resultObj.put("unitName",rs.getString("unitName"));
				resultObj.put("nowQty",rs.getString("nowQty"));
				
				resultArray.add(resultObj);
			}
		} catch (Exception e) {
			resultArray.add( e.getMessage());
		}
		return resultArray.toString();
	
	}
	
	//食品厂board全部数据
	public static String FFAD(Context ctx, String paramStr) {
		JSONObject resultObj=new JSONObject();
		resultObj.put("FFCRIS", FFCRIS(ctx,paramStr)); //食品厂毛鸡接收信息统计（年月日）FoodFactoryChickenReceiveInfoStatistics
		resultObj.put("FFCWW", FFCWW(ctx,paramStr));//食品厂毛鸡过磅重量统计FoodFactoryChickenWeighingWeight
		resultObj.put("FFSS", FFSS(ctx,paramStr));//食品厂销量统计（日、月、年）FoodFactorySalesStatistics
		resultObj.put("FFDJITI", FFDJITI(ctx,paramStr));//食品厂日报及时库存 FoodFactoryDailyJustInTimeInventory
		resultObj.put("FFDSS", FFDSS(ctx,paramStr));//食品厂日销量统计——总销量、总销售额FoodFactoryDaySalesStatistics
		resultObj.put("FFMSSS", FFMSSS(ctx,paramStr));//食品公司月销量统计_合计FoodFactoryMOnthSalesStatisticsSum
		return resultObj.toString();
	}

	//食品公司月销量统计_合计
	private static Object FFMSSS(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" select max(tt.rptYear) rptYear,");
		sql.append(" tt.rptMonth rptMonth,");
		sql.append(" sum(tt.allQty) allQty,");
		sql.append(" sum(tt.allTaxAmount) allTaxAmount,");
		sql.append(" sum(tt.allAmount) allAmount");
		sql.append(" from (");
		sql.append(" select ");
		sql.append(" max(year(t.fbizdate)) rptYear,");
		sql.append(" month(t.fbizdate) rptMonth,");
		sql.append(" sum(te.fbaseqty) allQty,");
		sql.append(" sum(te.ftaxamount) allTaxAmount,");
		sql.append(" sum(te.famount) allAmount");
		sql.append("  from t_sd_saleorder t");
		sql.append(" inner join t_sd_saleorderentry te on t.fid= te.fparentid");
		sql.append(" inner join t_bd_customer tcus on t.fordercustomerid = tcus.fid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid");
		sql.append(" inner join t_bd_materialgroup tg on tm.fmaterialgroupid = tg.fid");
		sql.append(" where t.fcompanyorgunitid = 'at4AAAAAAHDM567U'");
		sql.append(" and tg.FLongNumber NOT IN ('02!0204!020402!02040210', '02!0204!020401!02040110')");
		sql.append(" and YEAR (t.fbizdate) = YEAR({ts '"+fbizdate+"'})");
		sql.append(" and month(t.fbizdate) = month({ts '"+fbizdate+"'})");
		sql.append(" and t.fbizdate < {d '"+fbizdate+"'} +1");
		sql.append(" and t.fbasestatus in ('4','7')");
		sql.append(" group by MONTH(t.fbizdate)");
		sql.append(" union all");
		sql.append(" select ");
		sql.append(" max(year(t.fbizdate)) rptYear,");
		sql.append(" month(t.fbizdate) rptMonth,");
		sql.append(" -1*sum(te.fbaseqty) allQty,");
		sql.append(" -1*sum(te.ftaxamount) allTaxAmount,");
		sql.append(" -1*sum(te.famount) allAmount");
		sql.append("  from T_SD_SaleReturns t");
		sql.append(" inner join T_SD_SaleReturnsEntry te on t.fid= te.fparentid");
		sql.append(" inner join t_bd_customer tcus on t.FReturnsCustomerID = tcus.fid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid");
		sql.append(" inner join t_bd_materialgroup tg on tm.fmaterialgroupid = tg.fid");
		sql.append(" where t.fcompanyorgunitid = 'at4AAAAAAHDM567U'");
		sql.append(" and tg.FLongNumber NOT IN ('02!0204!020402!02040210', '02!0204!020401!02040110')");
		sql.append(" and YEAR (t.fbizdate) = YEAR({ts '"+fbizdate+"'})");
		sql.append(" and month(t.fbizdate) = month({ts '"+fbizdate+"'})");
		sql.append(" and t.fbizdate < {d '"+fbizdate+"'} +1");
		sql.append(" and t.fbasestatus in ('4','7')");
		sql.append(" group by MONTH(t.fbizdate)) tt group by tt.rptMonth");

		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){

				resultObj.put("rptYear",rs.getString("rptYear"));
				resultObj.put("rptMonth",rs.getString("rptMonth"));
				resultObj.put("allQty",rs.getString("allQty"));
				resultObj.put("allTaxAmount",rs.getString("allTaxAmount"));
				resultObj.put("allAmount",rs.getString("allAmount"));
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	//食品厂日销量统计——总销量、总销售额
	private static Object FFDSS(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" /*dialect*/");
		sql.append(" select tt.fbizdate,");
		sql.append(" sum(tt.allQty) allQty,");
		sql.append(" sum(tt.allTaxAmount) allTaxAmount,");
		sql.append(" sum(tt.allAmount) allAmount");
		sql.append(" from (");
		sql.append(" select ");
		sql.append(" t.fbizdate,");
		sql.append(" sum(te.fbaseqty) allQty,");
		sql.append(" sum(te.ftaxamount) allTaxAmount,");
		sql.append(" sum(te.famount) allAmount");
		sql.append(" from t_sd_saleorder t");
		sql.append(" inner join t_sd_saleorderentry te on t.fid= te.fparentid");
		sql.append(" inner join t_bd_customer tcus on t.fordercustomerid = tcus.fid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid");
		sql.append(" inner join t_bd_materialgroup tg on tm.fmaterialgroupid = tg.fid");
		sql.append(" where t.fcompanyorgunitid = 'at4AAAAAAHDM567U'");
		sql.append(" and tg.FLongNumber NOT IN ('02!0204!020402!02040210', '02!0204!020401!02040110')");
		sql.append(" and t.fbizdate = {ts '"+fbizdate+"'}");
		sql.append(" and t.fbasestatus in ('4','7')");
		sql.append(" group by t.fbizdate");
		sql.append(" union ");
		sql.append(" select ");
		sql.append(" t.fbizdate,");
		sql.append(" -sum(te.fbaseqty) allQty,");
		sql.append(" -sum(te.ftaxamount) allTaxAmount,");
		sql.append(" -sum(te.famount) allAmount");
		sql.append(" from T_SD_SaleReturns t");
		sql.append(" inner join T_SD_SaleReturnsEntry te on t.fid= te.fparentid");
		sql.append(" inner join t_bd_customer tcus on t.FReturnsCustomerID = tcus.fid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid");
		sql.append(" inner join t_bd_materialgroup tg on tm.fmaterialgroupid = tg.fid");
		sql.append(" where t.fcompanyorgunitid = 'at4AAAAAAHDM567U'");
		sql.append(" and tg.FLongNumber NOT IN ('02!0204!020402!02040210', '02!0204!020401!02040110')");
		sql.append(" and t.fbizdate = {ts '"+fbizdate+"'}");
		sql.append(" and t.fbasestatus in ('4','7')");
		sql.append(" group by t.fbizdate) tt group by tt.fbizdate");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){

				resultObj.put("fbizdate",rs.getString("fbizdate"));
				resultObj.put("allQty",rs.getString("allQty"));
				resultObj.put("allTaxAmount",rs.getString("allTaxAmount"));
				resultObj.put("allAmount",rs.getString("allAmount"));
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	//食品厂日报及时库存
	private static Object FFDJITI(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" SELECT");
		sql.append(" sum(FBaseQty) Fqty");
		sql.append(" FROM");
		sql.append(" t_im_inventory tinv");
		sql.append(" inner join T_DB_WAREHOUSE twh on twh.fid=tinv.FWarehouseID");
		sql.append(" inner join t_bd_material tm on tm.fid=tinv.FMaterialID");
		sql.append(" inner join t_bd_materialGroup tmg on tmg.fid=tm.fmaterialgroupid");
		sql.append(" where tmg.FLongNumber like '02!0204%'");
		sql.append(" and tmg.FLongNumber not in('02!0204!020402!02040210','02!0204!020401!02040110')");
		sql.append(" and FStorageOrgUnitID='at4AAAAAAHDM567U'");
		sql.append(" and twh.fnumber not in ('413')");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				resultObj.put("Fqty",rs.getString("Fqty"));
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	//食品厂销量统计（日、月、年）
	private static Object FFSS(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" /*dialect*/");
		sql.append(" select ");
		sql.append(" sum(case");
		sql.append(" when to_char(tb.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"',1,10)");
		sql.append(" then  tentry.FBaseQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000 daySum,");
		sql.append(" sum(case");
		sql.append(" when to_char(tb.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"',1,7)");
		sql.append(" then  tentry.FBaseQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000 monthSum,");
		sql.append(" sum(case");
		sql.append(" when to_char(tb.fbizdate, 'yyyy') = substr('"+fbizdate+"',1,4)");
		sql.append(" then  tentry.FBaseQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000 yearSum");
		sql.append(" from T_IM_ManufactureRecBill tb");
		sql.append(" inner join T_IM_ManufactureRecBillEntry tentry on tentry.fparentid=tb.fid");
		sql.append(" where tb.FStorageOrgUnitID='at4AAAAAAHDM567U'");
		sql.append(" and tb.FBaseStatus in (2,4,7)");
		sql.append(" and (to_char(tb.fbizdate, 'yyyy') = substr('"+fbizdate+"',1,4) )");
		sql.append(" and (tb.fbizdate <(to_date('"+fbizdate+"','yyyy-mm-dd')+1) )");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){

				resultObj.put("daySum",rs.getString("daySum"));
				resultObj.put("monthSum",rs.getString("monthSum"));
				resultObj.put("yearSum",rs.getString("yearSum"));
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	//食品厂毛鸡过磅重量统计
	private static Object FFCWW(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" /*dialect*/");
		sql.append(" select sum(case");
		sql.append(" when to_char(tb.fbizdate, 'yyyy-mm-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) then");
		sql.append(" nvl(tentry.CFSuttle, 0)");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000 daySuttle,");
		sql.append(" sum(case");
		sql.append(" when to_char(tb.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"', 1, 7) then");
		sql.append(" nvl(tentry.CFSuttle, 0)");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000 monthSuttle,");
		sql.append(" sum(case");
		sql.append(" when to_char(tb.fbizdate, 'yyyy') = substr('"+fbizdate+"', 1, 4) then");
		sql.append(" nvl(tentry.CFSuttle, 0)");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000 yearSuttle");
		sql.append(" from CT_WHB_InStorageBill tb");
		sql.append(" inner join CT_WHB_InStorageBillEntry tentry");
		sql.append(" on tentry.FParentID = tb.FID");
		sql.append(" where CFStorageOrgUnitID = 'at4AAAAAAHDM567U'");
		sql.append(" and (to_char(tb.fbizdate, 'yyyy') = substr('"+fbizdate+"', 1, 4) )");
		sql.append(" and (tb.fbizdate < (to_date('"+fbizdate+"', 'yyyy-mm-dd') + 1) )");
		sql.append(" and tb.CFBillStatus in ('4', '5', '6')");
		sql.append(" and (tb.CFSupplierID is null or tb.CFSupplierID = '')");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){

				resultObj.put("daySuttle",rs.getString("daySuttle"));
				resultObj.put("monthSuttle",rs.getString("monthSuttle"));
				resultObj.put("yearSuttle",rs.getString("yearSuttle"));
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	//食品厂毛鸡接收信息统计（年月日）
	private static Object FFCRIS(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" /*dialect*/");
		sql.append(" select");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"', 1, 10) then");
		sql.append(" tcd.CFDryingChickenQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayDryingChickenQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"', 1, 7) then");
		sql.append(" tcd.CFDryingChickenQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthDryingChickenQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy') = substr('"+fbizdate+"', 1, 4) then");
		sql.append(" tcd.CFDryingChickenQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearDryingChickenQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"', 1, 10) then");
		sql.append(" tcd.CFDryingChickenWeight");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayDryingChickenWeight,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"', 1, 7) then");
		sql.append(" tcd.CFDryingChickenWeight");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthDryingChickenWeight,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy') = substr('"+fbizdate+"', 1, 4) then");
		sql.append(" tcd.CFDryingChickenWeight");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearDryingChickenWeight,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"', 1, 10) then");
		sql.append(" tcd.CFPhysicalDeathQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayPhysicalDeathQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"', 1, 7) then");
		sql.append(" tcd.CFPhysicalDeathQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthPhysicalDeathQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy') = substr('"+fbizdate+"', 1, 4) then");
		sql.append(" tcd.CFPhysicalDeathQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearPhysicalDeathQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"', 1, 10) then");
		sql.append(" tcd.CFPhysicalDeathWeight");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayPhysicalDeathWeight,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"', 1, 7) then");
		sql.append(" tcd.CFPhysicalDeathWeight");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthPhysicalDeathWeight,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy') = substr('"+fbizdate+"', 1, 4) then");
		sql.append(" tcd.CFPhysicalDeathWeight");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearPhysicalDeathWeight,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"', 1, 10) then");
		sql.append(" tcd.CFUnCarcassQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayUnCarcassQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"', 1, 7) then");
		sql.append(" tcd.CFUnCarcassQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthUnCarcassQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy') = substr('"+fbizdate+"', 1, 4) then");
		sql.append(" tcd.CFUnCarcassQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearUnCarcassQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"', 1, 10) then");
		sql.append(" tcd.CFUnCarcassWeight");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayUnCarcassWeight,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"', 1, 7) then");
		sql.append(" tcd.CFUnCarcassWeight");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthUnCarcassWeight,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy') = substr('"+fbizdate+"', 1, 4) then");
		sql.append(" tcd.CFUnCarcassWeight");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearUnCarcassWeight,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"', 1, 10) then");
		sql.append(" tcd.CFCarcassQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayCarcassQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"', 1, 7) then");
		sql.append(" tcd.CFCarcassQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthCarcassQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy') = substr('"+fbizdate+"', 1, 4) then");
		sql.append(" tcd.CFCarcassQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearCarcassQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"', 1, 10) then");
		sql.append(" tcd.CFCarcassWeight");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayCarcassWeight,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"', 1, 7) then");
		sql.append(" tcd.CFCarcassWeight");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthCarcassWeight,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy') = substr('"+fbizdate+"', 1, 4) then");
		sql.append(" tcd.CFCarcassWeight");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearCarcassWeight,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"', 1, 10) then");
		sql.append(" tcd.CFMainPWeight");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayMainPWeight,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"', 1, 7) then");
		sql.append(" tcd.CFMainPWeight");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthMainPWeight,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy') = substr('"+fbizdate+"', 1, 4) then");
		sql.append(" tcd.CFMainPWeight");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearMainPWeight,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"', 1, 10) then");
		sql.append(" tcd.CFByPWeight");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayByPWeight,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"', 1, 7) then");
		sql.append(" tcd.CFByPWeight");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthByPWeight,");
		sql.append(" sum(case");
		sql.append(" when to_char(tcd.fbizdate, 'yyyy') = substr('"+fbizdate+"', 1, 4) then");
		sql.append(" tcd.CFByPWeight");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearByPWeight");
		sql.append(" from CT_FM_ChickenDaily tcd");
		sql.append(" where CFCompanyOrgUnitID = 'at4AAAAAAHDM567U'");
		sql.append(" and (to_char(tcd.fbizdate, 'yyyy') = substr('"+fbizdate+"', 1, 4) )");
		sql.append(" and (tcd.fbizdate < (to_date('"+fbizdate+"', 'yyyy-mm-dd') + 1))");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){

				resultObj.put("dayPhysicalDeathQty",rs.getString("dayPhysicalDeathQty"));
				resultObj.put("dayUnCarcassQty",rs.getString("dayUnCarcassQty"));
				resultObj.put("dayCarcassQty",rs.getString("dayCarcassQty"));
				resultObj.put("monthuncarcassqty",rs.getString("monthuncarcassqty"));
				resultObj.put("monthPhysicalDeathQty",rs.getString("monthPhysicalDeathQty"));
				resultObj.put("monthCarcassQty",rs.getString("monthCarcassQty"));
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}

	/**
	 * 食品厂月销售累计---暂未使用2016年9月25日09:51:30 传印
	 * @param ctx
	 * @param paramStr
	 * @return
	 * @throws BOSException
	 */
	public static String foodSaleSummary(Context ctx,String paramStr){
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONArray resultArray=new JSONArray();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" select max(tt.rptYear) rptYear,");
		sql.append(" tt.rptMonth rptMonth,");
		sql.append(" tt.mGroupName mGroupName,");
		sql.append(" sum(tt.allQty) allQty,");
		sql.append(" sum(tt.allTaxAmount) allTaxAmount,");
		sql.append(" sum(tt.allAmount) allAmount");
		sql.append(" from (");
		sql.append(" select ");
		sql.append(" max(year(t.fbizdate)) rptYear,");
		sql.append(" month(t.fbizdate) rptMonth,");
		sql.append(" mg.FName_l2 mGroupName,");
		sql.append(" sum(te.fbaseqty) allQty,");
		sql.append(" sum(te.ftaxamount) allTaxAmount,");
		sql.append(" sum(te.famount) allAmount");
		sql.append("  from t_sd_saleorder t");
		sql.append(" inner join t_sd_saleorderentry te on t.fid= te.fparentid");
		sql.append(" inner join t_bd_customer tcus on t.fordercustomerid = tcus.fid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid");
		sql.append(" inner join t_bd_materialgroup tg on tm.fmaterialgroupid = tg.fid");
		sql.append(" inner join t_bd_materialgroup mg on mg.FLongNumber=substring(tg.FLongNumber,0,14)");//物料分组大类，冰鲜冷冻和未处理
		sql.append(" where t.fcompanyorgunitid = 'at4AAAAAAHDM567U'");
		sql.append(" and tg.FLongNumber NOT IN ('02!0204!020402!02040210', '02!0204!020401!02040110')");
		sql.append(" and YEAR (t.fbizdate) = YEAR({ts '"+fbizdate+"'})");
		sql.append(" and month(t.fbizdate) = month({ts '"+fbizdate+"'})");
		sql.append(" and t.fbizdate < {d '"+fbizdate+"'} +1");
		sql.append(" and t.fbasestatus in ('4','7')");
		sql.append(" group by MONTH(t.fbizdate),mg.FName_l2");
		sql.append(" union all");
		sql.append(" select ");
		sql.append(" max(year(t.fbizdate)) rptYear,");
		sql.append(" month(t.fbizdate) rptMonth,");
		sql.append(" mg.FName_l2 mGroupName,");
		sql.append(" -1*sum(te.fbaseqty) allQty,");
		sql.append(" -1*sum(te.ftaxamount) allTaxAmount,");
		sql.append(" -1*sum(te.famount) allAmount");
		sql.append("  from T_SD_SaleReturns t");
		sql.append(" inner join T_SD_SaleReturnsEntry te on t.fid= te.fparentid");
		sql.append(" inner join t_bd_customer tcus on t.FReturnsCustomerID = tcus.fid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid");
		sql.append(" inner join t_bd_materialgroup tg on tm.fmaterialgroupid = tg.fid");
		sql.append(" inner join t_bd_materialgroup mg on mg.FLongNumber=substring(tg.FLongNumber,0,14)");
		sql.append(" where t.fcompanyorgunitid = 'at4AAAAAAHDM567U'");
		sql.append(" and tg.FLongNumber NOT IN ('02!0204!020402!02040210', '02!0204!020401!02040110')");
		sql.append(" and YEAR (t.fbizdate) = YEAR({ts '"+fbizdate+"'})");
		sql.append(" and month(t.fbizdate) = month({ts '"+fbizdate+"'})");
		sql.append(" and t.fbizdate < {d '"+fbizdate+"'} +1");
		sql.append(" and t.fbasestatus in ('4','7')");
		sql.append(" group by MONTH(t.fbizdate),mg.FName_l2) tt group by tt.rptMonth, tt.mGroupName");


		IRowSet rs;
		try {
			rs = DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				resultObj.put("materalGroupName",rs.getString("mGroupName"));
				resultObj.put("qty",rs.getString("allQty"));
				resultObj.put("rptYear",rs.getString("rptYear"));
				resultObj.put("rptMonth",rs.getString("rptMonth"));
				resultArray.add(resultObj);
			}
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			resultArray.add( e.getMessage());
		}

		return resultArray.toString();
	}
	
	/**
	 * 食品厂月销售累计---暂未使用2016年9月25日09:51:30 传印
	 * @param ctx
	 * @param paramStr
	 * @return
	 * @throws BOSException
	 */
	public static String foodSaleDetails(Context ctx,String paramStr){
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONArray resultArray=new JSONArray();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" select max(tt.rptYear) rptYear,");
		sql.append(" tt.rptMonth rptMonth,");
		sql.append(" tt.mGroupName mGroupName,");
		sql.append(" sum(tt.allQty) allQty,");
		sql.append(" sum(tt.allTaxAmount) allTaxAmount,");
		sql.append(" sum(tt.allAmount) allAmount");
		sql.append(" from (");
		sql.append(" select ");
		sql.append(" max(year(t.fbizdate)) rptYear,");
		sql.append(" month(t.fbizdate) rptMonth,");
		sql.append(" case when mgd.FName_l2 is null then mg.FName_l2 else mgd.FName_l2 end mGroupName,");
		sql.append(" sum(te.fbaseqty) allQty,");
		sql.append(" sum(te.ftaxamount) allTaxAmount,");
		sql.append(" sum(te.famount) allAmount");
		sql.append("  from t_sd_saleorder t");
		sql.append(" inner join t_sd_saleorderentry te on t.fid= te.fparentid");
		sql.append(" inner join t_bd_customer tcus on t.fordercustomerid = tcus.fid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid");
		sql.append(" inner join t_bd_materialgroup tg on tm.fmaterialgroupid = tg.fid");
		sql.append(" inner join t_bd_materialgroup mg on mg.FLongNumber=substring(tg.FLongNumber,0,14)");//物料分组大类，冰鲜冷冻和未处理
		sql.append(" left join t_bd_materialgroup  mgd on mgd.FLongNumber=substring(tg.FLongNumber,0,23)");//物料分组大类，冰鲜冷冻和未处理
		sql.append(" where t.fcompanyorgunitid = 'at4AAAAAAHDM567U'");
		sql.append(" and tg.FLongNumber NOT IN ('02!0204!020402!02040210', '02!0204!020401!02040110')");
		sql.append(" and YEAR (t.fbizdate) = YEAR({ts '"+fbizdate+"'})");
		sql.append(" and month(t.fbizdate) = month({ts '"+fbizdate+"'})");
		sql.append(" and t.fbizdate < {d '"+fbizdate+"'} +1");
		sql.append(" and t.fbasestatus in ('4','7')");
		sql.append(" group by MONTH(t.fbizdate),case when mgd.FName_l2 is null then mg.FName_l2 else mgd.FName_l2 end");
		sql.append(" union all");
		sql.append(" select ");
		sql.append(" max(year(t.fbizdate)) rptYear,");
		sql.append(" month(t.fbizdate) rptMonth,");
		sql.append(" case when mgd.FName_l2 is null then mg.FName_l2 else mgd.FName_l2 end mGroupName,");
		sql.append(" -1*sum(te.fbaseqty) allQty,");
		sql.append(" -1*sum(te.ftaxamount) allTaxAmount,");
		sql.append(" -1*sum(te.famount) allAmount");
		sql.append("  from T_SD_SaleReturns t");
		sql.append(" inner join T_SD_SaleReturnsEntry te on t.fid= te.fparentid");
		sql.append(" inner join t_bd_customer tcus on t.FReturnsCustomerID = tcus.fid");
		sql.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid");
		sql.append(" inner join t_bd_materialgroup tg on tm.fmaterialgroupid = tg.fid");
		sql.append(" inner join t_bd_materialgroup mg on mg.FLongNumber=substring(tg.FLongNumber,0,14)");
		sql.append(" left join t_bd_materialgroup  mgd on mgd.FLongNumber=substring(tg.FLongNumber,0,23)");
		sql.append(" where t.fcompanyorgunitid = 'at4AAAAAAHDM567U'");
		sql.append(" and tg.FLongNumber NOT IN ('02!0204!020402!02040210', '02!0204!020401!02040110')");
		sql.append(" and YEAR (t.fbizdate) = YEAR({ts '"+fbizdate+"'})");
		sql.append(" and month(t.fbizdate) = month({ts '"+fbizdate+"'})");
		sql.append(" and t.fbizdate < {d '"+fbizdate+"'} +1");
		sql.append(" and t.fbasestatus in ('4','7')");
		sql.append(" group by MONTH(t.fbizdate),case when mgd.FName_l2 is null then mg.FName_l2 else mgd.FName_l2 end) tt group by tt.rptMonth, tt.mGroupName");


		IRowSet rs;
		try {
			rs = DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				resultObj.put("materalGroupName",rs.getString("mGroupName"));
				resultObj.put("qty",rs.getString("allQty"));
				resultObj.put("rptYear",rs.getString("rptYear"));
				resultObj.put("rptMonth",rs.getString("rptMonth"));
				resultArray.add(resultObj);
			}
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			resultArray.add( e.getMessage());
		}

		return resultArray.toString();
	}

	


}
