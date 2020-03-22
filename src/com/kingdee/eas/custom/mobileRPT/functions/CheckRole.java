package com.kingdee.eas.custom.mobileRPT.functions;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.mobileRPT.IDownload;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class CheckRole implements IDownload {

	@Override
	public JSONArray downloadData(Context ctx, JSONObject queryJSON)
			throws Exception {
		// TODO Auto-generated method stub
		String userNumber;
		if(queryJSON.containsKey("userNumber") && StringUtils.isNotBlank(queryJSON.getString("userNumber"))){
			userNumber = queryJSON.getString("userNumber");
		}else{
			throw new BOSException("ÓÃ»§±àÂë£ºuserNumberÎª¿Õ£¡");
		}
		JSONArray ja = new JSONArray();
		StringBuffer sql = new StringBuffer();
		sql.append("Select distinct ");
		sql.append("t1.CFRptName ");
		sql.append("from CT_MOB_RPTRole t1 ");
		sql.append("inner join CT_MOB_RPTRoleRoleEntry t2 on t2.FParentID=t1.FID ");
		sql.append("where t2.CFRoleID in ( ");
		sql.append("select t1.FRoleID from T_PM_UserRoleOrg t1 inner join T_PM_USER t2 on t2.FID=t1.FUserID where t2.FNUMBER='");
		sql.append(userNumber).append("') ");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		JSONObject jo = new JSONObject();
		while(rs.next()){
			jo = new JSONObject();
			jo.put("rptName", StringUtils.isNotBlank(rs.getString("CFRptName")) ? rs.getString("CFRptName") : "");
			ja.add(jo);
		}
		return ja;
	}

}
