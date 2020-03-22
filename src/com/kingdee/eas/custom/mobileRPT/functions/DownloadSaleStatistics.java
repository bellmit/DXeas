package com.kingdee.eas.custom.mobileRPT.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.mobileRPT.IDownload;
import com.kingdee.eas.custom.mobileRPT.utils.UserUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class DownloadSaleStatistics implements IDownload {
	//每个公司所有物料销售数据
	@Override
	public JSONArray downloadData(Context ctx, JSONObject queryJSON) throws Exception {
		// TODO Auto-generated method stub
		String beginDate;
		String endDate;
		String companyIds = null;
		if(queryJSON.containsKey("userNumber") && StringUtils.isNotBlank(queryJSON.getString("userNumber"))){
			String userNumber = queryJSON.getString("userNumber");
			companyIds = UserUtil.getUserOrgPerm(ctx, userNumber);
			if(!StringUtils.isNotBlank(companyIds)){
				throw new EASBizException(new NumericExceptionSubItem("001","无组织权限！"));
			}
		}
		if(queryJSON.containsKey("beginDate") && StringUtils.isNotBlank(queryJSON.getString("beginDate"))){
			beginDate = queryJSON.getString("beginDate");
		}else{
			throw new BOSException("开始日期不允许为空！");
		}
		if(queryJSON.containsKey("endDate") && StringUtils.isNotBlank(queryJSON.getString("endDate"))){
			endDate = queryJSON.getString("endDate");
		}else{
			throw new BOSException("结束日期不允许为空！");
		}
		StringBuffer sql = new StringBuffer();
		sql.append("/*dialect*/ SELECT ");
		sql.append("t3.FID AS companyID,");
		sql.append("t3.FName_l2 AS companyName,");
		sql.append("sum(t2.FQty) AS saleQty,");
		sql.append("sum(t2.FLocalAmount) AS saleAmount,");
		sql.append("sum(t2.FLocalNonTaxAmount) AS saleIncome ");
		sql.append("FROM ");
		sql.append("T_IM_SaleIssueBill t1 ");
		sql.append("INNER JOIN T_IM_SaleIssueEntry t2 on t1.FID=t2.FParentID ");
		sql.append("INNER JOIN T_ORG_Storage t3 on t1.FStorageOrgUnitID=t3.FID ");
		sql.append("INNER JOIN T_BD_Material t4 on t2.FMaterialID=t4.FID ");
		sql.append("WHERE TO_CHAR(t1.FBIZDATE,'yyyy-MM-dd')>='").append(beginDate).append("' ");
		sql.append("AND TO_CHAR(t1.FBIZDATE,'yyyy-MM-dd')<='").append(endDate).append("' ");
		sql.append("and t1.FStorageOrgUnitID in (").append(companyIds).append(") ");
		sql.append("and t4.FMaterialGroupID not in('E3sAAAAArLfHn8BC','E3sAAAAAptDHn8BC') ");
		sql.append("GROUP BY ");
		sql.append("t3.FName_l2,t3.FID ");
		sql.append("ORDER BY t3.FName_l2");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		JSONArray ja = new JSONArray();
		JSONObject jo;
		while(rs.next()){
			jo = new JSONObject();
			jo.put("companyID", rs.getString("companyID"));
			jo.put("companyName", rs.getString("companyName"));
			jo.put("saleQty", rs.getBigDecimal("saleQty").divide(new BigDecimal("1000"), 2, RoundingMode.HALF_UP));//销售数量（吨）
			jo.put("saleAmount", rs.getString("saleAmount"));//销售金额
			jo.put("saleIncome", rs.getString("saleIncome"));//销售收入
			ja.add(jo);
		}
		
		return ja;
	}

}
