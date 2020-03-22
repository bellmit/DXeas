package com.kingdee.eas.custom.mobileRPT.functions;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.custom.mobileRPT.IDownload;
import com.kingdee.eas.rptclient.gr.rptclient.util.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class SaleRpt implements IDownload {

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
		sql.append("").append("\n");
		sql.append("select storageID,companyName,bizDate,storageID,sum(dayQty) DayQty,sum(zxQty) zxQty,sum(xxQty) xxQty,sum(shQty) shQty,sum(kclQty) kcQty,sum(storageQty) storageQty from ( ").append("\n");
		sql.append("select storageID,companyName,BizDate,sum(zxl) dayQty,sum(zx) zxQty,sum(xx) xxQty,sum(sh) shQty,sum(kcl) kclQty,0 storageQty from ( ").append("\n");
		sql.append("select t1.FStorageOrgUnitID storageID,t3.FName_l2 companyName,to_char(t1.FbizDate,'yyyy-MM-dd') bizDate,sum(t2.FQty) zxl, ").append("\n");
		sql.append("case when t2.FSalePersonID in ('E3sAAAAB5fWA733t','E3sAAAACmqCA733t') then sum(t2.FQty) else 0 end zx, ").append("\n");
		sql.append("case when t2.FSalePersonID not in ('E3sAAAAB5fWA733t','E3sAAAACmqCA733t') then sum(t2.FQty) else 0 end xx, ").append("\n");
		sql.append("case when t4.FName_l2 like ('%双汇%') then sum(t2.FQty) else 0 end sh, ").append("\n");
		sql.append("case when t5.FMaterialGroupID='E3sAAAAArMLHn8BC' then sum(t2.FQty) else 0 end kcl ").append("\n");
		sql.append("from T_IM_SaleIssueBill t1 ").append("\n");
		sql.append("inner join T_IM_SaleIssueEntry t2 on t1.FID=t2.FParentID ").append("\n");
		sql.append("inner join T_ORG_Storage t3 on t1.FStorageOrgUnitID=t3.FID ").append("\n");
		sql.append("inner join T_BD_Customer t4 on t1.FCustomerID=t4.FID ").append("\n");
		sql.append("inner join T_BD_Material t5 on t2.FMaterialID=t5.fid ").append("\n");
		sql.append("where to_char(t1.FbizDate,'yyyy-MM-dd')='"+bizDate+"' ").append("\n");
		if(isGroup){
			sql.append("and t3.FNumber like '").append(companyID).append("%'").append("\n");
		}
		sql.append("Group by  t3.FName_l2,t1.FbizDate,FSalePersonID,t4.FName_l2,t5.FMaterialGroupID,t1.FStorageOrgUnitID) ").append("\n");
		sql.append("group by companyName,bizDate,storageID ").append("\n");
		sql.append("union all ").append("\n");
		sql.append("select FStorageOrgUnitID storageID,t2.FName_l2 companyName,'"+bizDate+"' bizDate,").append("\n");
		sql.append("0 dayQty,0 zxQty,0 xxQty,0 shQty,0 kclQty,sum(FCurStoreQty) storageQty from T_IM_Inventory t1 ").append("\n");
		sql.append("inner join T_ORG_Storage t2 on t1.FStorageOrgUnitID=t2.FID ").append("\n");
		if(isGroup){
			sql.append("and t2.FNumber like '").append(companyID).append("%'").append("\n");
		}
		sql.append("GROUP by FStorageOrgUnitID,").append("\n");
		sql.append("t2.FName_l2,'"+bizDate+"' ").append("\n");

		sql.append(")Group by storageID,companyName,bizDate,storageID").append("\n");
//		IRowSet rs = DbUtil.executeQuery(sql.toString());
		System.out.println(sql.toString());
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
		JSONArray ja = new JSONArray();
		JSONObject jo = null;
		while(rs.next()){
			jo = new JSONObject();
			jo.put("companyName", rs.getString("companyName"));//公司名称
			jo.put("bizDate", rs.getString("bizDate"));//业务日期
			jo.put("DayQty", rs.getBigDecimal("DayQty"));//当日总销量
			jo.put("zxQty", rs.getBigDecimal("zxQty"));//坐销
			jo.put("xxQty", rs.getBigDecimal("xxQty"));//行销
			jo.put("shQty", rs.getBigDecimal("shQty"));//双汇
			jo.put("kcQty", rs.getBigDecimal("kcQty"));//快餐
			jo.put("storageQty", rs.getBigDecimal("storageQty"));//成品库存
			ja.add(jo);
		}
		return ja;
	}

}
