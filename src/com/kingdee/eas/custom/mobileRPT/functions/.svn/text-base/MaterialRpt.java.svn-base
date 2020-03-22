package com.kingdee.eas.custom.mobileRPT.functions;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.custom.mobileRPT.IDownload;
import com.kingdee.jdbc.rowset.IRowSet;

public class MaterialRpt implements IDownload {

	@Override
	public JSONArray downloadData(Context ctx, JSONObject queryJSON)
			throws Exception {
		// TODO Auto-generated method stub
		String bizDate = null;
		String companyID;
		Boolean isGroup = true;
		if(queryJSON.containsKey("date") && StringUtils.isNotBlank(queryJSON.getString("date"))){
			bizDate = queryJSON.getString("date");
		}
		if(queryJSON.containsKey("companyID") && StringUtils.isNotBlank(queryJSON.getString("companyID"))){
			if(queryJSON.getString("companyID").equals("0")){
				//companyID = queryJSON.getString("companyID");
				isGroup = false;
			}
			companyID = queryJSON.getString("companyID");
		}else{
			throw new BOSException("公司不允许为空！");
		}
		StringBuffer sql = new StringBuffer();
		sql.append("/*dialect*/ ");
		sql.append("select distinct t.companyName,t.bizDate,monthQty,dayQty,t.contractType,t.type ").append("\n");
		sql.append("from ").append("\n");
		sql.append("(select t2.FName_l2 companyName, ").append("\n");
		sql.append("'"+bizDate+"' bizDate, ").append("\n");
		sql.append("sum(t1.CFInQty) over (PARTITION BY t1.CFCompanyID,t3.FName_l2) monthQty, ").append("\n");
		sql.append("sum(case when  TO_CHAR(t1.FBizDate,'yyyy-MM-dd')='"+bizDate+"' then t1.CFInQty else 0 end) ").append("\n");
		sql.append("over (PARTITION BY t1.CFCompanyID,t3.FName_l2,t1.FBizDate,t4.FName_l2) dayQty, ").append("\n");
		sql.append("case when TO_CHAR(t1.FBizDate,'yyyy-MM-dd')='"+bizDate+"' then t3.FName_l2 else null end contractType, ").append("\n");
		sql.append("case when TO_CHAR(t1.FBizDate,'yyyy-MM-dd')='"+bizDate+"' then t4.FName_l2 else null end type ").append("\n");
//		sql.append("inner join T_SET_TaiHeSettlePolicy t4 on t1.FSettlePolicyID=t4.FID ").append("\n");
		sql.append("from CT_CON_BatchContract t1 ").append("\n");
		sql.append("inner join T_ORG_Company t2 on t1.CFCompanyID=t2.FID ").append("\n");
		sql.append("inner join T_SIG_ContractType t3 on t1.CFContractTypeID=t3.FID ").append("\n");
		sql.append("inner join T_SET_TaiHeSettlePolicy t4 on t1.FSettlePolicyID=t4.FID ").append("\n");
		sql.append("where TO_CHAR(t1.FBizDate,'yyyy-MM-dd')>TO_CHAR(trunc(to_date('"+bizDate+"','yyyy-mm-dd'),'MM'),'yyyy-MM-dd') ").append("\n");
		sql.append("and TO_CHAR(t1.FBizDate,'yyyy-MM-dd')<TO_CHAR(last_day(to_date('"+bizDate+"','yyyy-mm-dd')),'yyyy-MM-dd') ").append("\n");
		if(isGroup){
			sql.append("and t2.FNumber like '").append(companyID).append("%'").append("\n");
		}
		sql.append(") t ").append("\n");
		sql.append("where t.dayQty <> 0 order BY t.companyName ").append("\n");
		System.out.println(sql.toString());
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
		JSONArray ja = new JSONArray();
		JSONObject jo = null;
		while(rs.next()){
			jo = new JSONObject();
			jo.put("companyName", rs.getString("companyName"));//公司
			jo.put("bizDate", rs.getString("bizDate"));//业务日期
			jo.put("monthQty", rs.getBigDecimal("monthQty"));//累计上苗数量
			jo.put("dayQty", rs.getBigDecimal("dayQty"));//当日上苗数量
			jo.put("type", rs.getString("type"));//当日上苗分类
			jo.put("contractType", rs.getString("contractType"));//合同类型
			ja.add(jo);
		}
		return ja;
	}

}
