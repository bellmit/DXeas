package com.kingdee.eas.custom.mobileRPT.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.mobileRPT.IDownload;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class DownloadMaterialDayRpt implements IDownload {
	//原料日报表
	@Override
	public JSONArray downloadData(Context ctx, JSONObject queryJSON)
	throws Exception {
// TODO Auto-generated method stub
		String date;
		String companyID;
		if(queryJSON.containsKey("date") && StringUtils.isNotBlank(queryJSON.getString("date"))){
			date = queryJSON.getString("date");
		}else{
			throw new BOSException("日期不允许为空！");
		}
		if(queryJSON.containsKey("companyID") && StringUtils.isNotBlank(queryJSON.getString("companyID"))){
			companyID = queryJSON.getString("companyID");
		}else{
			throw new BOSException("公司不允许为空！");
		}
		StringBuffer sql = new StringBuffer();
//		sql.append(" ");
		sql.append("select companyName,count(CFBatchContractID) AS contractQty, ");
		sql.append("sum(inqty) AS inQty, ");
		sql.append("sum(qty) hsQty, ");
		sql.append("sum(totalSettleWgt) AS totalWgt, ");
		sql.append("sum(totalAmount) totalAmount, ");
		sql.append("sum(dtWgt) dtWgt ");
		sql.append("from ( ");
		sql.append("select t2.FName_l2 AS companyName, ");
		sql.append("CFBatchContractID, ");
		sql.append("t1.FInQty inQty, ");
		sql.append("sum(t1.CFQty) Qty, ");
		sql.append("sum(t1.CFTotalSettleWgt) totalSettleWgt, ");
		sql.append("sum(t1.CFQty*t1.CFPurchasePrice) totalAmount, ");
		sql.append("sum(t3.CFWgt) dtWgt ");
		sql.append("from CT_SET_SettleBill t1 ");
		sql.append("inner join T_ORG_Company t2 on t1.CFCompanyID=t2.FID ");
		sql.append("inner join CT_SET_SettleBillAssEntry t3 on t3.FParentID=t1.FID ");
		sql.append("where t1.CFBatchContractID is not null and CFWgtType=0 and to_Char(FBizDate,'yyyy-MM-dd')='").append(date).append("' ");
		sql.append("group by t2.FName_l2,CFBatchContractID,t1.FInQty ");
		
		sql.append("order by CFBatchContractid ");
		sql.append(")group by CompanyName ");
		System.out.println(sql.toString());
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		JSONArray ja = new JSONArray();
		JSONObject jo;
		while(rs.next()){
			jo = new JSONObject();
			jo.put("companyName", rs.getString("companyName"));
			jo.put("contractQty", rs.getInt("contractQty"));
			jo.put("inQty", rs.getBigDecimal("inQty"));//上苗数量
			BigDecimal hsQty = rs.getBigDecimal("hsQTy");
			jo.put("hsQty", hsQty);//回收数量
			BigDecimal totalWgt = rs.getBigDecimal("totalWgt");
			jo.put("totalWgt", totalWgt);//回收重量
			BigDecimal pjzz = totalWgt.divide(hsQty, 2, RoundingMode.HALF_UP);
			jo.put("pjzz", pjzz);//平均只重
			BigDecimal totalAmount = rs.getBigDecimal("totalAmount");
			BigDecimal pjjsj = totalAmount.divide(totalWgt, 2, RoundingMode.HALF_UP);
			jo.put("pjjsj", pjjsj);//平均结算价
			BigDecimal dtWgt = rs.getBigDecimal("dtWgt");
			BigDecimal killRate = dtWgt.divide(totalWgt, 2, RoundingMode.HALF_UP);
			jo.put("killRate", killRate);//杀胴体比率 
			ja.add(jo);
		}

		return ja;
	}

}
