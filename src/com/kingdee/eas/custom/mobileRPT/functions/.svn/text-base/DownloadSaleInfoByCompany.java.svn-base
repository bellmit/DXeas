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

public class DownloadSaleInfoByCompany implements IDownload {
    //销售数据
	@Override
	public JSONArray downloadData(Context ctx, JSONObject queryJSON)
			throws Exception {
		// TODO Auto-generated method stub
		String companyID;
		String beginDate;
		String endDate;
		if(queryJSON.containsKey("companyID") && StringUtils.isNotBlank(queryJSON.getString("companyID"))){
			companyID = queryJSON.getString("companyID");
		}else{
			throw new BOSException("公司不允许为空！");
		}if(queryJSON.containsKey("beginDate") && StringUtils.isNotBlank(queryJSON.getString("beginDate"))){
			beginDate = queryJSON.getString("beginDate");
		}else{
			throw new BOSException("开始日期不允许为空！");
		}
		if(queryJSON.containsKey("endDate") && StringUtils.isNotBlank(queryJSON.getString("endDate"))){
			endDate = queryJSON.getString("endDate");
		}else{
			throw new BOSException("结束日期不允许为空！");
		}
		int pageNumber;//页数
		int rows;//显示行数
		if(queryJSON.containsKey("pageNumber")  && StringUtils.isNotBlank(queryJSON.getString("pageNumber"))){
			pageNumber = Integer.valueOf(queryJSON.getString("pageNumber"));
		}else{
			pageNumber = 1;
		}
		if(queryJSON.containsKey("rows")  && StringUtils.isNotBlank(queryJSON.getString("rows"))){
			rows = Integer.valueOf(queryJSON.getString("rows"));
		}else{
			rows = 10;
		}
		StringBuffer sql = new StringBuffer();
		sql.append("/*dialect*/ SELECT * from(");
		sql.append("SELECT rownum rn,companyName,materialName,model,saleQty,saleAmount,saleIncome from( ");
		sql.append("select ");
		sql.append("t3.FName_l2 AS companyName,");
		sql.append("t4.FName_l2 AS materialName,");
		sql.append("t4.FModel AS model,");
		sql.append("sum(t2.FQty) AS saleQty,");
		sql.append("sum(t2.FLocalAmount) AS saleAmount,");
		sql.append("sum(t2.FLocalNonTaxAmount) AS saleIncome ");
		sql.append("FROM ");
		sql.append("T_IM_SaleIssueBill t1 ");
		sql.append("INNER JOIN T_IM_SaleIssueEntry t2 on t1.FID=t2.FParentID ");
		sql.append("INNER JOIN T_ORG_Storage t3 on t1.FStorageOrgUnitID=t3.FID ");
		sql.append("INNER JOIN T_BD_Material t4 on t2.FMaterialID=t4.FID ");
		sql.append("WHERE t3.FID='").append(companyID).append("' ");
		sql.append("and t4.FMaterialGroupID not in('E3sAAAAArLfHn8BC','E3sAAAAAptDHn8BC') ");
		sql.append(" and TO_CHAR(t1.FBIZDATE,'yyyy-MM-dd')>='").append(beginDate).append("' ");
		sql.append("AND TO_CHAR(t1.FBIZDATE,'yyyy-MM-dd')<='").append(endDate).append("' ");
		sql.append("GROUP BY ");
		sql.append("t3.FName_l2,t4.FName_l2,t4.FModel ");
		sql.append("ORDER BY sum(t2.FQty) desc))");
		sql.append("WHERE ").append("\n");
		sql.append("RN<=").append(pageNumber*rows).append("\n");
		sql.append(" AND ").append("\n");
		sql.append("RN>=").append((pageNumber-1)*rows+1).append("\n");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		JSONArray ja = new JSONArray();
		JSONObject jo;
		while(rs.next()){
			jo = new JSONObject();
			jo.put("companyName", rs.getString("companyName"));
			jo.put("materialName", rs.getString("materialName"));//产品名称
			jo.put("model", rs.getString("model"));//规格型号
			BigDecimal saleQty = rs.getBigDecimal("saleQty");
			jo.put("saleQty", saleQty.divide(new BigDecimal("1000"), 2, RoundingMode.HALF_UP));//销售数量（吨）
			BigDecimal saleAmount = rs.getBigDecimal("saleAmount");
			jo.put("saleAmount", saleAmount);//销售金额
			jo.put("saleIncome", rs.getString("saleIncome"));//销售收入
			jo.put("average",  saleAmount.divide(saleQty, 2, RoundingMode.HALF_UP));//平均售价
			ja.add(jo);
		}
		return ja;
	}

}
