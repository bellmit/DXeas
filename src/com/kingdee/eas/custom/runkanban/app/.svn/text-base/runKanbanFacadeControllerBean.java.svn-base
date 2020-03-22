package com.kingdee.eas.custom.runkanban.app;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.runkanban.common.CommonExportUtils;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class runKanbanFacadeControllerBean extends AbstractrunKanbanFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.runkanban.app.runKanbanFacadeControllerBean");

	@Override
	protected String _getDataFromJsonCondition(Context ctx, String queryStr)
			throws BOSException {

		JSONObject resultJson=new JSONObject();
		resultJson.put("success", true);
		resultJson.put("message", "success");
		JSONObject jsonObj=JSONObject.fromObject(queryStr);

		try {
			if(!jsonObj.containsKey("userNum")){
				throw new Exception("用户名不能为空！");
			}
			if(!jsonObj.containsKey("queryType")){
				throw new Exception("查询类型不能为空！");
			}
			if(!jsonObj.containsKey("paramStr")){
				jsonObj.put("paramStr", "");
			}
			String userNum=jsonObj.getString("userNum");
			String queryType=jsonObj.getString("queryType");
			String paramStr=jsonObj.getString("paramStr");
			//判断该用户是否有查询该类型的权限，如果没有直接返回
			String aunumber=null;
			Boolean haveauthority=false;
			StringBuffer sql=new StringBuffer();
			sql.append(" select ae.cfauthoritynumber aunumber from t_pm_user u");
			sql.append(" inner join CT_RUN_KanbanUserAuthority a on u.fid=a.cfnameid");
			sql.append(" inner join CT_RUN_KanbanUAE ae on a.fid=ae.fparentid");
			sql.append(" where u.fnumber='").append(userNum).append("'");
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()) {
				aunumber=rs.getString("aunumber");
				if(aunumber.equalsIgnoreCase(queryType)){
					haveauthority=true;
					break;
				}
			}
			rs.close();
			
			if(haveauthority){
				String result=	CommonExportUtils.getDataFromJsonCondition(ctx, userNum,queryType, paramStr);
				resultJson.put("result", result);
			}else{
				resultJson.put("result", "没有 "+queryType+" 的权限");
			}
			
		} catch (Exception e) {
			resultJson.put("success", false);
			resultJson.put("message",e.getMessage());
		}
		return resultJson.toString();
	}
    
}