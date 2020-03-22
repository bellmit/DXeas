package com.kingdee.eas.custom.mobileRPT.functions;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.mobileRPT.IDownload;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class modelRule implements IDownload {

	@Override
	public JSONArray downloadData(Context ctx, JSONObject queryJSON)
			throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String userNumber;
		String bosType;
		if(queryJSON.containsKey("userNumber") && StringUtils.isNotBlank(queryJSON.getString("userNumber"))){
			userNumber = queryJSON.getString("userNumber");
			
		}else{
			throw new BOSException("用户编码：userNumber");
		}
		JSONArray ja = new JSONArray();
		StringBuffer sql = new StringBuffer();
		sql.append("select t1.FName_l2 RuleName ");
		sql.append("from  ");
		sql.append("T_PM_Role t1 ");
		sql.append("left join T_PM_UserRoleOrg t3 on t3.FRoleID = t1.FID ");
		sql.append("left join T_PM_User t4 on t4.FID = t3.FUserID ");
		sql.append("where t4.FNumber like '%");
		sql.append(userNumber).append("%' ");
		sql.append("and t1.FName_l2 like '%移动端查看%' ");
		System.out.println(sql);
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		JSONObject jo = new JSONObject();
		while(rs.next()){
			jo = new JSONObject();
			jo.put("RuleName", StringUtils.isNotBlank(rs.getString("RuleName")) ? rs.getString("RuleName") : "");
			ja.add(jo);
		}
		return ja;
	}

}
