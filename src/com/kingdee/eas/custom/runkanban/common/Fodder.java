package com.kingdee.eas.custom.runkanban.common;

import net.sf.json.JSONObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class Fodder {

	public static String FMAD(Context ctx, String paramStr) {
		JSONObject resultObj=new JSONObject();
		 resultObj.put("FFOS", FFOS(ctx,paramStr)); //饲料厂产量统计FodderFactoryOutputStatistic
		 resultObj.put("FFPAS", FFPAS(ctx,paramStr));//饲料厂自用调拨统计 FodderFactoryPrivateAllocationStatistic
		 resultObj.put("FFCSMPS", FFCSMPS(ctx,paramStr));//饲料厂玉米豆粕采购统计FodderFactoryCornSoybeanMealPurchaseStatistic
		return resultObj.toString();
	}
	//饲料厂玉米豆粕采购统计
	private static Object FFCSMPS(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" /*dialect*/");
		sql.append(" select ");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"',1,10) and tm.fname_l2 like '%玉米（禽用）%' then");
		sql.append(" te.fbaseqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000 cornDayQtySum,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"',1,10) and tm.fname_l2 like '%玉米（禽用）%' then");
		sql.append(" te.FTaxAmount");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) cornDayTaxAmountSum,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"',1,10) and tm.fname_l2 like '%豆粕%' then");
		sql.append(" te.fbaseqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000 soybeanDayQtySum,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"',1,10) and tm.fname_l2 like '%豆粕%' then");
		sql.append(" te.FTaxAmount");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) soybeanDayTaxAmountSum,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"',1,7) and tm.fname_l2 like '%玉米（禽用）%' then");
		sql.append(" te.fbaseqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000 cornMonthQtySum,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"',1,7) and tm.fname_l2 like '%玉米（禽用）%' then");
		sql.append(" te.FTaxAmount");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) cornMonthTaxAmountSum,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"',1,7) and tm.fname_l2 like '%豆粕%' then");
		sql.append(" te.fbaseqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000 soybeanMonthQtySum,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"',1,7) and tm.fname_l2 like '%豆粕%' then");
		sql.append(" te.FTaxAmount");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) soybeanMonthTaxAmountSum,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy') = substr('"+fbizdate+"',1,4) and tm.fname_l2 like '%玉米（禽用）%' then");
		sql.append(" te.fbaseqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000 cornYearQtySum,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy') = substr('"+fbizdate+"',1,4) and tm.fname_l2 like '%玉米（禽用）%' then");
		sql.append(" te.FTaxAmount");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) cornYearTaxAmountSum,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy') = substr('"+fbizdate+"',1,4) and tm.fname_l2 like '%豆粕%' then");
		sql.append(" te.fbaseqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000 soybeanYearQtySum, ");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy') = substr('"+fbizdate+"',1,4) and tm.fname_l2 like '%豆粕%' then");
		sql.append(" te.FTaxAmount");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) soybeanYearTaxAmountSum");
		sql.append(" from ");
		sql.append(" T_IM_PurInWarehsBill t ");
		sql.append(" inner join T_IM_PurInWarehsentry te on t.fid = te.fparentid ");
		sql.append(" inner join t_bd_material tm");
		sql.append(" on te.fmaterialid = tm.fid");
		sql.append(" inner join T_SCM_TransactionType tt");
		sql.append(" on t.ftransactiontypeid = tt.fid");
		sql.append(" where  t.fstorageorgunitid = 'at4AAAAACFnM567U' and tt.fnumber ='001'");
		sql.append(" and t.FBaseStatus in (2,4,7)");
		sql.append(" and (to_char(t.fbizdate, 'yyyy') = substr('"+fbizdate+"',1,4) )");
		sql.append(" and (t.fbizdate <(to_date('"+fbizdate+"','yyyy-mm-dd')+1) )");
		sql.append(" and (tm.fname_l2 like '%玉米（禽用）%' or tm.fname_l2 like '%豆粕%' )");

		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				
				resultObj.put("cornDayQtySum",rs.getString("cornDayQtySum"));
				resultObj.put("cornMonthQtySum",rs.getString("cornMonthQtySum"));
				resultObj.put("soybeanDayQtySum",rs.getString("soybeanDayQtySum"));
				resultObj.put("soybeanMonthQtySum",rs.getString("soybeanMonthQtySum"));
				resultObj.put("cornDayTaxAmountSum",rs.getString("cornDayTaxAmountSum"));
				resultObj.put("soybeanDayTaxAmountSum",rs.getString("soybeanDayTaxAmountSum"));
				resultObj.put("cornMonthTaxAmountSum",rs.getString("cornMonthTaxAmountSum"));
				resultObj.put("soybeanMonthTaxAmountSum",rs.getString("soybeanMonthTaxAmountSum"));
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	//饲料厂自用调拨统计
	private static Object FFPAS(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" /*dialect*/");
		sql.append(" select sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"',1,10) and t.FIssueStorageOrgUnitID = 'at4AAAAACFnM567U'  then");
		sql.append(" te.fbaseqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000 -");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"',1,10) and  t.FReceiptStorageOrgUnitID = 'at4AAAAACFnM567U'  then");
		sql.append(" te.fbaseqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000");
		sql.append(" ownDaySum,     ");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-mm') =  substr('"+fbizdate+"',1,7)  and t.FIssueStorageOrgUnitID = 'at4AAAAACFnM567U'  then");
		sql.append(" te.fbaseqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000-");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-mm') =  substr('"+fbizdate+"',1,7)  and t.FReceiptStorageOrgUnitID =  'at4AAAAACFnM567U' then");
		sql.append(" te.fbaseqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000");
		sql.append(" ownMonthSum,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =  substr('"+fbizdate+"',1,4)  and t.FIssueStorageOrgUnitID = 'at4AAAAACFnM567U'  then");
		sql.append(" te.fbaseqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) /1000-");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =  substr('"+fbizdate+"',1,4) and t.FReceiptStorageOrgUnitID = 'at4AAAAACFnM567U' then");
		sql.append(" te.fbaseqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) /1000 ownYearSum   ");
		sql.append(" from T_IM_StockTransferBill t");
		sql.append(" inner join T_IM_StockTransferBillEntry te");
		sql.append(" on t.fid = te.fparentid");
		sql.append(" inner join t_bd_material tm ");
		sql.append(" on te.fmaterialid = tm.fid");
		sql.append(" inner join T_SCM_BizType tb ");
		sql.append(" on t.FBizTypeID = tb.fid");
		sql.append(" where ( t.FIssueStorageOrgUnitID = 'at4AAAAACFnM567U' ");
		sql.append(" or t.FReceiptStorageOrgUnitID =  'at4AAAAACFnM567U')");
		sql.append(" and tb.fnumber in ('320','321')");
		sql.append(" and t.FBaseStatus in (2,4,7)");
		sql.append(" and (to_char(t.fbizdate, 'yyyy') = substr('"+fbizdate+"',1,4) ) ");
		sql.append(" and (t.fbizdate <(to_date('"+fbizdate+"','yyyy-mm-dd')+1) )");
		sql.append(" and (tm.fname_l2 like '%配合饲料%' or  tm.fname_l2 like '%开口料%')");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				
				resultObj.put("ownDaySum",rs.getString("ownDaySum"));
				resultObj.put("ownMonthSum",rs.getString("ownMonthSum"));
				resultObj.put("ownYearSum",rs.getString("ownYearSum"));
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	//饲料厂产量统计
	private static Object FFOS(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" /*dialect*/");
		sql.append(" select sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"',1,10)  and tt.fnumber = '024'then");
		sql.append(" te.fbaseqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000 ownDaySum,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"',1,10)  and tt.fnumber = '411' then");
		sql.append(" te.fbaseqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000 proxyDaySum,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-mm') =  substr('"+fbizdate+"',1,7)  and tt.fnumber = '024' then");
		sql.append(" te.fbaseqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000 ownMonthSum,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-mm') =  substr('"+fbizdate+"',1,7) and tt.fnumber = '411' then");
		sql.append(" te.fbaseqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000 proxyMonthSum,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =  substr('"+fbizdate+"',1,4) and tt.fnumber = '024' then");
		sql.append(" te.fbaseqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) /1000 ownYearSum,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =  substr('"+fbizdate+"',1,4) and tt.fnumber = '411' then");
		sql.append(" te.fbaseqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)/1000 proxyYearSum");
		sql.append(" from t_im_manufacturerecbill t");
		sql.append(" inner join t_im_manufacturerecbillentry te");
		sql.append(" on t.fid = te.fparentid");
		sql.append(" inner join t_bd_material tm");
		sql.append(" on te.fmaterialid = tm.fid");
		sql.append(" inner join T_SCM_TransactionType tt");
		sql.append(" on t.ftransactiontypeid = tt.fid");
		sql.append(" where  t.fstorageorgunitid = 'at4AAAAACFnM567U' and tt.fnumber in ('024', '411')");
		sql.append(" and t.FBaseStatus in (2,4,7)");
		sql.append(" and (to_char(t.fbizdate, 'yyyy') = substr('"+fbizdate+"',1,4) )");
		sql.append(" and (t.fbizdate <(to_date('"+fbizdate+"','yyyy-mm-dd')+1))");
		sql.append(" and (tm.fname_l2 like '%配合饲料%'  or  tm.fname_l2 like '%开口料%' or tm.fname_l2 like '%益生%' )");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				
				resultObj.put("ownDaySum",rs.getString("ownDaySum"));
				resultObj.put("ownMonthSum",rs.getString("ownMonthSum"));
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}

}
