package com.kingdee.eas.custom.mobileRPT.functions;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.mobileRPT.IDownload;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class PersonOrgRule implements IDownload {

	@Override
	public JSONArray downloadData(Context ctx, JSONObject queryJSON)
			throws Exception {
		// TODO Auto-generated method stub
		String userNumber;
		String bosType;
		if(queryJSON.containsKey("userNumber") && StringUtils.isNotBlank(queryJSON.getString("userNumber"))){
			userNumber = queryJSON.getString("userNumber");
			
		}else{
			throw new BOSException("”√ªß±‡¬Î£∫userNumber");
		}
		JSONArray ja = new JSONArray();
		StringBuffer sql = new StringBuffer();
		sql.append("select t3.FName_l2 OrgName,t3.FID OrgID,t3.FNumber OrgNumber from T_PM_OrgRange t1 ");
		sql.append("inner join T_PM_User t2 on t2.FID = t1.FUserID  ");
		sql.append("inner join T_ORG_BaseUnit t3 on t3.FID = t1.FOrgID ");
		sql.append("where t2.FNumber like '%");
		sql.append(userNumber).append("%' ");
		sql.append("and t1.FType = 10 ");
		//System.out.println(sql);
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		JSONObject jo = new JSONObject();
		while(rs.next()){
			jo = new JSONObject();
			jo.put("OrgName", StringUtils.isNotBlank(rs.getString("OrgName")) ? rs.getString("OrgName") : "");
			jo.put("OrgID", StringUtils.isNotBlank(rs.getString("OrgID")) ? rs.getString("OrgID") : "");
			jo.put("OrgNumber", StringUtils.isNotBlank(rs.getString("OrgNumber")) ? rs.getString("OrgNumber") : "");
			ja.add(jo);
		}
		return ja;
	}

}
