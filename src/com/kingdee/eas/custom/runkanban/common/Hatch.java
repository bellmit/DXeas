package com.kingdee.eas.custom.runkanban.common;

import net.sf.json.JSONObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class Hatch {

	public static String FFHAD(Context ctx, String paramStr) {
		JSONObject resultObj=new JSONObject();
		 resultObj.put("HFHS", HFHS(ctx,paramStr)); //孵化场上孵量汇总HatchFactoryHatchingSummary
		 resultObj.put("HSS", HSS(ctx,paramStr));//出雏情况汇总HatchingSituationSummary
		return resultObj.toString();
	}
	//出雏情况汇总
	private static Object HSS(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" /*dialect*/");
		sql.append(" select ");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"',1,10)  then");
		sql.append(" th.cfeggqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayEggQty,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"',1,7)  then");
		sql.append(" th.cfeggqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthEggQty,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"',1,10)  then");
		sql.append(" t.cfhealthqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayHealthQty,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"',1,7)  then");
		sql.append(" t.cfhealthqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthHealthQty,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy') = substr('"+fbizdate+"',1,4)  then");
		sql.append(" t.cfhealthqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearHealthQty ,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"',1,10)  then");
		sql.append(" t.cfdeathqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayDeathQty,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"',1,7)  then");
		sql.append(" t.cfdeathqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthDeathQty,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy') = substr('"+fbizdate+"',1,4)  then");
		sql.append(" t.cfdeathqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearDeathQty ,  ");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"',1,10)  then");
		sql.append(" t.cfunhatchedeggqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayUnhatchedQty,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"',1,7)  then");
		sql.append(" t.cfunhatchedeggqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthUnhatchedQty,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy') = substr('"+fbizdate+"',1,4)  then");
		sql.append(" t.cfunhatchedeggqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearUnhatchedQty ,   ");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"',1,10)  then");
		sql.append(" t.cflossqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayLossQty,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"',1,7)  then");
		sql.append(" t.cflossqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthLossQty,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy') = substr('"+fbizdate+"',1,4)  then");
		sql.append(" t.cflossqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearLossQty ,   ");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"',1,10)  then");
		sql.append(" t.cfotherlossqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayOtherLossQty,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"',1,7)  then");
		sql.append(" t.cfotherlossqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthOtherLossQty,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy') = substr('"+fbizdate+"',1,4)  then");
		sql.append(" t.cfotherlossqty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearOtherLossQty                                                      ");
		sql.append(" from CT_FM_HatchBabyBill t ");
		sql.append(" inner join ct_fm_tranferboxbill tt on t.cftransferboxbilli = tt.fid");
		sql.append(" inner join ct_fm_hatchbill th on tt.cfhatchbillid = th.fid");
		sql.append(" where t.cfbasestatus in (2,4)");
		sql.append(" and (t.fbizdate < to_date('"+fbizdate+"','yyyy-mm-dd') +1)");

		
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				resultObj.put("dayHealthQty",rs.getString("dayHealthQty"));
				resultObj.put("dayDeathQty",rs.getString("dayDeathQty"));
				resultObj.put("dayEggQty",rs.getString("dayEggQty"));
				resultObj.put("monthEggQty",rs.getString("monthEggQty"));
				resultObj.put("monthHealthQty",rs.getString("monthHealthQty"));
				resultObj.put("monthDeathQty",rs.getString("monthDeathQty"));
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	//孵化场上孵量汇总
	private static Object HFHS(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" /*dialect*/");
		sql.append(" select ");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm-dd') = substr('"+fbizdate+"',1,10)  then");
		sql.append(" t.CFEggQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayEggQty,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy-mm') = substr('"+fbizdate+"',1,7)  then");
		sql.append(" t.CFEggQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthEggQty,");
		sql.append(" sum(case when to_char(t.fbizdate, 'yyyy') = substr('"+fbizdate+"',1,4)  then");
		sql.append(" t.CFEggQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearEggQty");
		sql.append(" from ");
		sql.append(" CT_FM_HatchBill t");
		sql.append(" where t.cfbasestatus in (2,4)");
		sql.append(" and (t.fbizdate < to_date('"+fbizdate+"','yyyy-mm-dd') +1)");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				resultObj.put("dayEggQty",rs.getString("dayEggQty"));
				resultObj.put("monthEggQty",rs.getString("monthEggQty"));
				resultObj.put("yearEggQty",rs.getString("yearEggQty"));
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}

}
