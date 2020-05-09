package com.kingdee.eas.outinterface.base.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.util.CryptoTean;
import com.kingdee.bos.util.CryptoUtil;
import com.kingdee.eas.base.attachment.AttachmentFactory;
import com.kingdee.eas.base.attachment.AttachmentInfo;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.org.OrgSwitchFacadeFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.outinterface.base.app.OutAppInterfaceControllerBean;
import com.kingdee.eas.outinterface.base.utils.AttachmentUtils;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.outinterface.base.utils.LoginHelper;
import com.kingdee.eas.outinterface.base.utils.ResultUtils;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.jdbc.rowset.impl.SerialBlob;
import com.opensymphony.xwork2.ActionSupport;

//@Controller
//@RequestMapping(value = "/*")
public class BaseInterfaceController extends ActionSupport  {
	private static final Logger logger = Logger.getLogger(BaseInterfaceController.class);
	
//	private String eid;
//	private  String dbName;
//	private  String sln;
//	private  String aix ;
//	private  Locale locale;
//	private static HashMap<String,Context> sysContextMap=new HashMap<String,Context>();
//	private  Context sysContext;
//	private  int dbType;
//	private  static XTServiceConfig cfg = XTServiceConfig.getInstance();//
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired  
	private HttpSession session;
	
	@Autowired  
	private HttpServletRequest request;
	
	@Autowired
	private OutAppInterfaceControllerBean wsFacade;
	
	public BaseInterfaceController(){
	}
	
	@ResponseBody
	@RequestMapping(value = "/login.json", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")//
	public String login(@RequestBody String joStr,HttpServletResponse response) {
		JSONObject reusltJO=ResultUtils.getResultSuccess();
		
		if(StringUtils.isBlank(joStr)&&request.getParameterMap().containsKey("params")) {
			joStr=request.getParameter("params");
		}
		
		JSONObject jo=JSONObject.parseObject(joStr);

		LoginBean bean=doEasLogin(request, response, jo.getString("eid"), jo.getString("userNum"), jo.getString("userPwd"));
		if(bean.isSuccess) {
			session.setAttribute("easContext", bean.getContext());
			jo.clear();
			jo.put("userId", bean.getUserId());
			jo.put("personId", bean.getPersonId());
			jo.put("sessionId",session.getId());
			reusltJO.put("data", jo);
		}else {
			reusltJO.put("result", "98");
			reusltJO.put("message", bean.getmessage());
		}
		
		return reusltJO.toJSONString();
	}
	
	private String getUserNameByID(Context ctx,String userid) throws BOSException, SQLException{
		if(StringUtils.isBlank(userid)){
			return "";
		}
		String sql="select fname_l2 nn from t_pm_user where fid='"+userid+"'";
		IRowSet rs=null;
		if(ctx!=null) {
			rs=DbUtil.executeQuery(ctx, sql);
		}else{
			rs=SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
		}
		
		if(rs.next()){
			return rs.getString("nn");
		}
		return "";
	}
	
	/**
	 * 切换组织
	 * @throws Exception 
	 */
	public void switchOrgUnit() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		String userId=request.getHeader("userId");
		userId=(userId!=null?URLDecoder.decode(userId,"utf-8"):null);
		LoginBean bean = getUserContext(userId,null);
		Context ctx=bean.getContext();
		JSONObject jo=JSONObject.parseObject(getStringByRequest(request));
		String orgId=jo.getString("orgId");
		if(StringUtils.isEmpty(orgId)&&jo.containsKey("serviceDeptId")) {
			String serviceDeptId=jo.getString("serviceDeptId");
			IRowSet rs = DbUtil.executeQuery(ctx, "select CFStorageOrgUnitID from CT_BAS_ServiceFileSetUp where fid='"+serviceDeptId+"'");
			if(rs.next()){
				orgId=rs.getString("CFStorageOrgUnitID");
			}
		}
		JSONObject resultJO=ResultUtils.getResultSuccess();
		try {
			OrgSwitchFacadeFactory.getLocalInstance(ctx).orgSwitch(orgId);
		}catch(Exception err) {
			resultJO.put("result", "1");
			resultJO.put("message", err.getMessage());
		}
		if(!bean.isOrgContext) {
			ctx=null;
		}
		JsonUtil.buildJsonStr(resultJO.toJSONString(),ServletActionContext.getResponse());
		return ;
	}
	
	/**
     * struts用
     * @return
     */
	public String changePassword(){
		request = ServletActionContext.getRequest();
		session = request.getSession();

		JSONObject jo=JSONObject.parseObject(getStringByRequest(request));
		String userId=jo.getString("userId");
		String oldPassword=jo.getString("oldPassword");
		String newPassword=jo.getString("newPassword");
		String newPassword2=jo.getString("newPassword2");
		
		JSONObject reusltJO=ResultUtils.getResultSuccess();
		
		if(!newPassword.equals(newPassword2)){
			reusltJO.put("result", "1");
			reusltJO.put("message", "两次输入的密码不一致！");
		}
		
		try {
			Context ctx=(Context) session.getAttribute("easContext");
			IRowSet rs=DbUtil.executeQuery(ctx,"select FPassword from t_pm_user where fid=?", new Object[]{userId});
			if(rs.next()) {
				//旧密码
				String encodePwd= CryptoUtil.encrypt(userId+oldPassword.trim());
				if(!encodePwd.equals(rs.getString("FPassword"))){
					throw new Exception("原密码不正确！");
				}
				//新密码
				encodePwd= CryptoUtil.encrypt(userId+newPassword.trim());
				DbUtil.execute(ctx, "update t_pm_user set FPassword=? where fid=?",new Object[]{encodePwd,userId});
			}else {
				throw new Exception("没有该用户！");
			}
		}catch(Exception err) {
			reusltJO.put("result", "1");
			reusltJO.put("message", err.getMessage());
		}
		JsonUtil.buildJsonStr(reusltJO.toJSONString());
		return null;
	}

    /**
     * struts用
     * @return
     */
	public String login(){
		/*Enumeration itr = logger.getRoot().getAllAppenders();
		while(itr.hasMoreElements()) {
			Object it = itr.nextElement();
			if(it instanceof FileAppender) {
				System.out.println("【【【【【【【当前日志路径:"+((FileAppender)it).getFile()+"】】】】】】");
			}
		}*/
		
		request = ServletActionContext.getRequest();
		session = request.getSession();
//		System.out.println("走入struts后台login"+session.getId());
		JsonUtil.buildJsonStr(login(getStringByRequest(request),null));
		return null;
	}
	
	  /**
     * struts用
     * 根据用户id进行登陆
     * @return
     */
	public void loginByUserNum(){
		request = ServletActionContext.getRequest();
		session = request.getSession();
		String joStr=getStringByRequest(request);
		JSONObject jo=JSONObject.parseObject(joStr);
		JSONObject reusltJO=ResultUtils.getResultSuccess();
		try {
			String clientIP=request!=null?request.getRemoteAddr():null;
			Context ctx=LoginHelper.loginEASByUserNum(jo.getString("eid"), jo.getString("userNum"),clientIP);
			if(ctx!=null) {
				session.setAttribute("easContext", ctx);
				UserInfo userInfo = ContextUtil.getCurrentUserInfo(ctx);
				String personId=userInfo.getPerson()!=null?userInfo.getPerson().getString("id"):null;
				ctx.put("personId", personId);
				jo.clear();
				jo.put("userId",userInfo.getString("id"));
				jo.put("personId", personId);
				jo.put("sessionId",session.getId());
				reusltJO.put("data", jo);
			}else {
				reusltJO.put("result", "98");
				reusltJO.put("message", "EAS登陆失败");
			}
		}catch(Exception err) {
			reusltJO.put("result", "98");
			reusltJO.put("message", "登陆失败:"+err.getMessage());
		}
		
		JsonUtil.buildJsonStr( reusltJO.toJSONString());
	}
	
	 /**
     * struts用
     * @return
     */
	public String logout(){
		request = ServletActionContext.getRequest();
		session = request.getSession();
		JsonUtil.buildJsonStr(logout(getStringByRequest(request),null));
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/logout.json", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")//+
	public String logout(@RequestBody String joStr,HttpServletResponse response) {
		JSONObject reusltJO=ResultUtils.getResultSuccess();
		
		request = ServletActionContext.getRequest();
		session = request.getSession();
		Context ctx=(Context) session.getAttribute("easContext");
		
		try {
			/*ILoginModule loginModule = LoginModuleFactory.getRemoteInstance();
			loginModule.logout(session.getId());*/
			LoginHelper.logOut(ctx);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(ctx!=null) {
			ctx=null;
			session.removeAttribute("easContext");
		}
		session.invalidate();
		return reusltJO.toJSONString();
	}
	 /**
     * struts用
     * @return
     */
	public String reLogin(){
		request = ServletActionContext.getRequest();
		session = request.getSession();
		
		JSONObject jo=JSONObject.parseObject(getStringByRequest(request));
		Context ctx=(Context) session.getAttribute("easContext");
		JSONObject reusltJO=ResultUtils.getResultSuccess();
		if(ctx.getUserName().equals(jo.getString("userNum"))) {
			jo=new JSONObject();
			jo.put("userId", ctx.getCaller().toString());
			jo.put("sessionId",session.getId());
			reusltJO.put("data", jo);
		}else {
			reusltJO.put("result", "97");
			reusltJO.put("message", "登陆账户与当前登陆账户不一致！");
		}
		JsonUtil.buildJsonStr(reusltJO.toString(),ServletActionContext.getResponse());
		return null;
	}
	
	
	/**
	 * 登陆bean
	 * @author dai_a
	 *
	 */
	private class LoginBean {
		private String userName;
		private String userId;
		private String personId;
		private boolean isSuccess=true;
		private Context context;
		private String message;
		private boolean isOrgContext=true;
		
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public boolean isSuccess() {
			return isSuccess;
		}
		public void setSuccess(boolean isSuccess) {
			this.isSuccess = isSuccess;
		}
		public Context getContext() {
			return context;
		}
		public void setContext(Context context) {
			this.context = context;
		}
		public String getmessage() {
			return message;
		}
		public void setmessage(String message) {
			this.message = message;
		}
		public boolean isOrgContext() {
			return isOrgContext;
		}
		public void setOrgContext(boolean isOrgContext) {
			this.isOrgContext = isOrgContext;
		}
		public String getPersonId() {
			return personId;
		}
		public void setPersonId(String personId) {
			this.personId = personId;
		}
		
	}
	
	/**
	 * 获取用户id
	 * @param ctx
	 * @param userNum
	 * @param pwd
	 * @return
	 * @throws Exception 
	 */
	public LoginBean getUserContext(String userId,String pwd) throws Exception  {
		LoginBean bean=new LoginBean();
		//非登陆
		Context ctx=(Context) session.getAttribute("easContext");
		//用户相等
		if(userId!=null&&ctx.getCaller()!=null&&ctx.getCaller().toString().equalsIgnoreCase(userId)) {
			bean.setContext(ctx);
			bean.setUserName("");
			bean.setUserId(ctx.getCaller().toString());
			return bean;
		}else {
			//用户不相等直接new
			if(userId!=null) {
				String eid=(String) ctx.get("eid");
				String userNum=null;
				if(BOSUuid.isValid(userId, true)) {
					userNum=getUserNameByID(null, userId);
				}
				bean=doEasLogin(ServletActionContext.getRequest(),ServletActionContext.getResponse(), eid, userNum, pwd);
				//getUserContextForLogin(null,userId, pwd, false);
				bean.setOrgContext(false);
			}else {
				bean.setContext(ctx);
				bean.setUserName(ctx.getUserName());
				bean.setUserId(ctx.getCaller().toString());
				return bean;
			}
		}
		//不成功
		if(!bean.isSuccess) {
			throw new Exception(bean.getmessage());
		}
		return bean;
	}
	
	/**
	 * 登陸
	 * @param httpRequest
	 * @param response
	 * @param eid
	 * @param username
	 * @param password
	 * @return
	 * @throws IOException
	 */
	private LoginBean doEasLogin(HttpServletRequest httpRequest, ServletResponse response, String eid, String userNum, String password)
			{
		LoginBean bean=new LoginBean();
		HttpSession session = httpRequest.getSession();
		try {
			password = URLDecoder.decode(password!=null?password:"");
			password=CryptoTean.encrypt(userNum, password);
			String clientIP=request!=null?request.getRemoteAddr():null;
			Context ctx = LoginHelper.loginEASWithPassWord(eid, userNum, password,clientIP);
			if(ctx!=null) {
				ctx.put("eid", eid);
	//			session.setAttribute("easContext", ctx);
				UserInfo userInfo = ContextUtil.getCurrentUserInfo(ctx);
				bean.setUserId(userInfo.getString("id"));
				bean.setPersonId(userInfo.getPerson()!=null?userInfo.getPerson().getString("id"):"");
				bean.setContext(ctx);
			}else {
				bean.setSuccess(false);
				bean.setmessage("密码错误，登陆失败！");
			}
		} catch (Exception e) {
			logger.error("login error :: " + e.getMessage() + e);
			bean.setSuccess(false);
			bean.setmessage(e.getMessage());
			session.invalidate();
		}
		return bean;
	}
	
	@ResponseBody
	@RequestMapping(value = "/interface/getList.json", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
	public String getList(@RequestBody String jaStr,HttpServletResponse response) throws Exception {
//		if(true) {
//			return jaStr;
//		}
		String result=null;
		try {
			String userId=request.getHeader("userId");
			userId=(userId!=null?URLDecoder.decode(userId,"utf-8"):null);
			LoginBean bean = getUserContext(userId,null);
			Context ctx=bean.getContext();
			result= wsFacade._getList(ctx, jaStr);
			if(!bean.isOrgContext) {
				ctx=null;
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return result;
	}

    /**
     * struts用
     * @return
     * @throws Exception 
     */
	public String getList() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		
		if(wsFacade==null) {
			wsFacade=new OutAppInterfaceControllerBean();
		}
		JsonUtil.buildJsonStr(getList(getStringByRequest(request),null));
		return null;
	}
	
	/**
	 * 获取post body参数
	 * @return
	 */
	protected static String getStringByRequest(HttpServletRequest request) {
		StringBuffer jb = new StringBuffer();
		try {
			String line = null;
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				jb.append(line);
			}
			reader.close();
		} catch (Exception e) { /* report an error */
		}
		return jb.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = "/interface/getData.json", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
	public String getData(@RequestBody String jaStr,HttpServletResponse response) throws Exception {
		String result=null;
		try {
			String userId=request.getHeader("userId");
			userId=(userId!=null?URLDecoder.decode(userId,"utf-8"):null);
			LoginBean bean = getUserContext(userId,null);
			Context ctx=bean.getContext();
			result= wsFacade._getData(ctx, jaStr);
			if(!bean.isOrgContext) {
				ctx=null;
			}
		} catch (Exception e) {
//			result="[{\"result\":\"1\",\"message\":\""+e.getMessage()+"\"}]";
			throw new Exception(e);
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/interface/getDataByNum.json", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
	public String getDataByNum(@RequestBody String jaStr,HttpServletResponse response) throws Exception {
		String result=null;
		try {
			String userId=request.getHeader("userId");
			userId=(userId!=null?URLDecoder.decode(userId,"utf-8"):null);
			LoginBean bean = getUserContext(userId,null);
			Context ctx=bean.getContext();
			result= wsFacade._getDataByNum(ctx, jaStr);
			if(!bean.isOrgContext) {
				ctx=null;
			}
		} catch (Exception e) {
//			result="[{\"result\":\"1\",\"message\":\""+e.getMessage()+"\"}]";
			throw new Exception(e);
		}
		return result;
	}
	
	
	/**
	 * 更新数据
	 * @return
	 * @throws Exception
	 */
	public String updateData() throws Exception {
		String result=null;
		try {
			request = ServletActionContext.getRequest();
			session = request.getSession();
			
			if(wsFacade==null) {
				wsFacade=new OutAppInterfaceControllerBean();
			}
			
			String jaStr=getStringByRequest(request);
			String userId=request.getHeader("userId");
			userId=(userId!=null?URLDecoder.decode(userId,"utf-8"):null);
			LoginBean bean = getUserContext(userId,null);
			Context ctx=bean.getContext();
			result= wsFacade._getDataByNum(ctx, jaStr);
			if(!bean.isOrgContext) {
				ctx=null;
			}
		} catch (Exception e) {
//			result="[{\"result\":\"1\",\"message\":\""+e.getMessage()+"\"}]";
			throw new Exception(e);
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/interface/getEnumInfo.json", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
	public String getEnumInfo(@RequestBody String jaStr,HttpServletResponse response) throws Exception {
		String result=null;
		try {
			String userId=request.getHeader("userId");
			userId=(userId!=null?URLDecoder.decode(userId,"utf-8"):null);
			LoginBean bean = getUserContext(userId,null);
			Context ctx=bean.getContext();
			result= wsFacade._getEnumInfo(ctx, jaStr);
			if(!bean.isOrgContext) {
				ctx=null;
			}
		} catch (Exception e) {
//			result="[{\"result\":\"1\",\"message\":\""+e.getMessage()+"\"}]";
			throw new Exception(e);
		}
		return result;
	}
	
	 /**
     * struts用
     * @return
     * @throws Exception 
     */
	public String getEnumInfo() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		
		if(wsFacade==null) {
			wsFacade=new OutAppInterfaceControllerBean();
		}
		JsonUtil.buildJsonStr(getEnumInfo(getStringByRequest(request),null));
		return null;
	}
	
	/**
     * struts用
     * @return
     * @throws Exception 
     */
	public String getSqlResult() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		
//		if(wsFacade==null) {
//			wsFacade=new WSAppInterfaceControllerBean();
//		}
		JsonUtil.buildJsonStr(getSqlResult(getStringByRequest(request),null));
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/interface/getSqlResult.json", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
	public String getSqlResult(@RequestBody String joStr,HttpServletResponse response) throws Exception {
		JSONObject resultJson = ResultUtils.getResultSuccess();
		try {
			String userId=request.getHeader("userId");
			userId=(userId!=null?URLDecoder.decode(userId,"utf-8"):null);
			LoginBean bean = getUserContext(userId,null);
			Context ctx=bean.getContext();
//			result= wsFacade._getEnumInfo(ctx, jaStr);
			
			JSONArray ja=new JSONArray();
			JSONObject jo=JSONObject.parseObject(joStr);
			String replaceSplitStr=JUtils.getString(jo, "replaceSplitStr");
			IRowSet rs=DbUtil.executeQuery(ctx, jo.getString("sqlStr"));
			while(rs.next()) {
				jo=new JSONObject();
				for(int colIndex=1;colIndex<=rs.getMetaData().getColumnCount();colIndex++) {
					Object obj=rs.getObject(colIndex);
					if(obj instanceof Date&&obj!=null) {
						obj=sdf.format(rs.getObject(colIndex));
					}
					String s=rs.getMetaData().getColumnName(colIndex);
					if(replaceSplitStr!=null){
						s=s.replaceAll("\\.",replaceSplitStr);
					}
					jo.put(s,obj!=null?String.valueOf(obj):null);
				}
				ja.add(jo);
			}
			rs.close();
			resultJson.put("data", ja);
			if(!bean.isOrgContext) {
				ctx=null;
			}
		} catch (Exception e) {
//			result="[{\"result\":\"1\",\"message\":\""+e.getMessage()+"\"}]";
			throw new Exception(e);
		}
		return resultJson.toJSONString();
	}

    /**
     * struts用
     * @return
     * @throws Exception 
     */
	public String getData() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		
		if(wsFacade==null) {
			wsFacade=new OutAppInterfaceControllerBean();
		}
		JsonUtil.buildJsonStr(getData(getStringByRequest(request),null));
		return null;
	}
	
	  /**
     * struts用
     * @return
     * @throws Exception 
     */
	public String getDataByNum() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		
		if(wsFacade==null) {
			wsFacade=new OutAppInterfaceControllerBean();
		}
		JsonUtil.buildJsonStr(getDataByNum(getStringByRequest(request),null));
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/interface/uploadData.json", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
	public String uploadData(@RequestBody String jaStr,HttpServletResponse response) throws Exception {
		String result=null;
		try {
			String userId=request.getHeader("userId");
			userId=(userId!=null?URLDecoder.decode(userId,"utf-8"):null);
			LoginBean bean = getUserContext(userId,null);
			Context ctx=bean.getContext();
			result= wsFacade._uploadData(ctx, jaStr);
			if(!bean.isOrgContext) {
				ctx=null;
			}
		} catch (Exception e) {
//			result="[{\"result\":\"1\",\"message\":\""+e.getMessage()+"\"}]";
			throw new Exception(e);
		}
		return result;
	}

    /**
     * struts用
     * @return
     * @throws Exception 
     */
	public String uploadData() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		
		if(wsFacade==null) {
			wsFacade=new OutAppInterfaceControllerBean();
		}
		JsonUtil.buildJsonStr(uploadData(getStringByRequest(request),null));
		return null;
	}
	
	/**
     * struts用
     * 执行功能
     * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
     */
	public String exeFunction() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		try {
			String userId=request.getHeader("userId");
			LoginBean bean = getUserContext(userId,null);
			Context ctx=bean.getContext();
			if(wsFacade==null) {
				wsFacade=new OutAppInterfaceControllerBean();
			}
			String result = wsFacade._exeFunction(ctx, getStringByRequest(request));
			if(!bean.isOrgContext) {
				ctx=null;
			}
			JsonUtil.buildJsonStr(result);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/interface/deleteData.json", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
	public String deleteData(@RequestBody String jaStr,HttpServletResponse response) throws Exception {
		String result=null;
		try {
			String userId=request.getHeader("userId");
			LoginBean bean = getUserContext(userId,null);
			Context ctx=bean.getContext();
			result= wsFacade._deleteData(ctx, jaStr);
			if(!bean.isOrgContext) {
				ctx=null;
			}
		} catch (Exception e) {
//			result="[{\"result\":\"1\",\"message\":\""+e.getMessage()+"\"}]";
			throw new Exception(e);
		}
		return result;
	}

    /**
     * struts用
     * @return
     * @throws Exception 
     */
	public String deleteData() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		
		if(wsFacade==null) {
			wsFacade=new OutAppInterfaceControllerBean();
		}
		JsonUtil.buildJsonStr(deleteData(getStringByRequest(request),null));
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/interface/auditData.json", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
	public String auditData(@RequestBody String jaStr,HttpServletResponse response) throws Exception {
		String result=null;
		try {
			String userId=request.getHeader("userId");
			LoginBean bean = getUserContext(userId,null);
			Context ctx=bean.getContext();
			result= wsFacade._auditData(ctx, jaStr);
			if(!bean.isOrgContext) {
				ctx=null;
			}
		} catch (Exception e) {
//			result="[{\"result\":\"1\",\"message\":\""+e.getMessage()+"\"}]";
			throw new Exception(e);
		}
		return result;
	}

    /**
     * struts用
     * @return
     * @throws Exception 
     */
	public String auditData() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		
		if(wsFacade==null) {
			wsFacade=new OutAppInterfaceControllerBean();
		}
		JsonUtil.buildJsonStr(auditData(getStringByRequest(request),null));
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/interface/unAuditData.json", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
	public String unAuditData(@RequestBody String jaStr,HttpServletResponse response) throws Exception {
		String result=null;
		try {
			String userId=request.getHeader("userId");
			LoginBean bean = getUserContext(userId,null);
			Context ctx=bean.getContext();
			result= wsFacade._unAuditData(ctx, jaStr);
			if(!bean.isOrgContext) {
				ctx=null;
			}
		} catch (Exception e) {
//			result="[{\"result\":\"1\",\"message\":\""+e.getMessage()+"\"}]";
			throw new Exception(e);
		}
		return result;
	}
	

    /**
     * struts用
     * @return
     * @throws Exception 
     */
	public String unAuditData() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		
		if(wsFacade==null) {
			wsFacade=new OutAppInterfaceControllerBean();
		}
		JsonUtil.buildJsonStr(unAuditData(getStringByRequest(request),null));
		return null;
	}
	/*
     *采用spring提供的上传文件的方法
     */
	@ResponseBody
    @RequestMapping(value = "/interface/uploadAttachment.json",method = {RequestMethod.POST})
    public String uploadAttachment(HttpServletRequest request) throws Exception
    {
    	//需要上传单据信息
    	String jsonStr=request.getHeader("params");
        JSONObject jsonParam=null;//
        String boid = null;//
        if(jsonStr!=null) {
        	jsonParam=JSONObject.parseObject(jsonStr);
    	    boid = jsonParam.getString("billId");//单据id
        }
        
        JSONObject resultJson=ResultUtils.getResultSuccess();
    	
    	String userId=request.getHeader("userId");
    	userId=(userId!=null?URLDecoder.decode(userId,"utf-8"):null);
    	Context ctx=getUserContext(userId,null).getContext();
    	JSONArray ja=new JSONArray();
        //struts
        if(request instanceof MultiPartRequestWrapper) {
	        MultiPartRequestWrapper sd = ((MultiPartRequestWrapper)request);
	        Iterator itor = sd.getParameterMap().entrySet().iterator();
	        while(itor.hasNext()){
	        	Entry entry = (Entry) itor.next();
	        	if(entry.getKey().equals("params")){
	        		if(entry.getValue() instanceof String[]){
	        			jsonStr=((String[])entry.getValue())[0];
	        		}else {
	        			jsonStr=entry.getValue().toString();
	        		}
	        		jsonParam=JSONObject.parseObject(jsonStr);
	        		boid=jsonParam.getString("billId");
	        		break;
	        	}
	        }
	        
	        Enumeration<String> a = sd.getFileParameterNames();
	        while(a.hasMoreElements()) {
	        	String s = a.nextElement();
	        	String[] fileNames=sd.getFileNames(s);
	        	File[] files = sd.getFiles(s);
	        	for(int index=0;index<files.length;index++) {
	        		byte[] fileData =FileUtils.readFileToByteArray(files[index]);
        		    String[] fileName=fileNames[index].split("\\.");
//        		    mfile.transferTo(new File("e:\\444.png"));
        		    
        		    ja.add(exeUpload(ctx, boid, fileName, fileData));
	        	}
	        }
        }
        //spring 
        else if(request instanceof DefaultMultipartHttpServletRequest) {
        	MultiValueMap<String, MultipartFile> map = ((DefaultMultipartHttpServletRequest)request).getMultiFileMap();
        	Iterator<Entry<String, List<MultipartFile>>> itor = map.entrySet().iterator();

            while(itor.hasNext()) {
        	   Entry<String, List<MultipartFile>> files = itor.next();
        	   List<MultipartFile> fileList = files.getValue();
        	   for(MultipartFile mfile:fileList) {
        		    byte[] fileData = mfile.getBytes();
        		    String[] fileName=mfile.getOriginalFilename().split("\\.");
//        		    mfile.transferTo(new File("e:\\444.png"));
        			ja.add(exeUpload(ctx, boid, fileName, fileData));
        	   }
            }
        }
    	
        ctx=null;
        resultJson.put("data", ja);
//        HttpHeaders headers = new HttpHeaders(); 
//        //头部携带返回信息
//        headers.set("attachmentsJSONStr", resultJson.toJSONString());
        request.setAttribute("attachmentsJSONStr", resultJson.toJSONString());
        return resultJson.toJSONString();
    }
	
	/**
	 * 执行文件上传
	 * @return
	 */
	private JSONObject exeUpload(Context ctx,String boid,String[] fileName,byte[] fileData) {
		JSONObject tempJO=ResultUtils.getResultSuccess();

		Map m= new HashMap();//附件文件说明
		m.put("type", "getPicthur");
		m.put("fileName", fileName[0]);
		m.put("fileExt", fileName.length>1?fileName[1]:"");
		m.put("fileSize", String.valueOf(fileData.length));
		try {
			AttachmentUtils is = new AttachmentUtils(ctx);
			String attachmentId = is.addAttachment(boid, m, fileData);
			tempJO.put("id", attachmentId);
		} catch (Exception e) {
			tempJO.put("result", "1");
			tempJO.put("message", e.getMessage());
		} 
		return tempJO;
	}
	
	/**
     * struts用
     * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
     */
	public String uploadAttachment() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		
//		private File UpImg;
//		private String UpImgContentType;
//		private String UpImgFileName;
		
		JsonUtil.buildJsonStr(uploadAttachment(request));
		return null;
	}
	
    @ResponseBody
	@RequestMapping(value = "/interface/getAttachmentList.json", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
	public String getAttachmentList(@RequestBody String jsonStr,HttpServletResponse response) throws Exception {
//		if(true) {
//			return jaStr;
//		}
		String result=null;
		try {
			String userId=request.getHeader("userId");
			userId=(userId!=null?URLDecoder.decode(userId,"utf-8"):null);
			LoginBean bean = getUserContext(userId,null);
			Context ctx=bean.getContext();
			result= wsFacade._getAttachmentList(ctx, jsonStr);
			if(!bean.isOrgContext) {
				ctx=null;
			}
		} catch (Exception e) {
//			result="{\"result\":\"1\",\"message\":\""+e.getMessage()+"\"}";
			throw new Exception(e);
		}
		return result;
	}
    

    /**
     * struts用
     * @return
     * @throws Exception 
     */
	public String getAttachmentList() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		
		if(wsFacade==null) {
			wsFacade=new OutAppInterfaceControllerBean();
		}
		JsonUtil.buildJsonStr(getAttachmentList(getStringByRequest(request),null));
		return null;
	}
    
    /*
     *采用spring提供的下载文件的方法
     */
    @ResponseBody
    @RequestMapping(value = "/interface/getAttachmentData.json",method = {RequestMethod.POST})
    public ResponseEntity<byte[]> getAttachmentData(HttpServletRequest request)throws Exception {
    	//需要下载单据附件信息
       String jsonStr=request.getHeader("jsonStr");
       String userId=request.getHeader("userId");
	   Context ctx=getUserContext(userId,null).getContext();
	   //获取附件数据
       AttachmentBean bean = getAttachmentData(ctx, jsonStr);
       ctx=null;
       
       byte[] fileBytes=bean.getFileBytes();
       //下载文件路径
//       File file = new File("e:\\555.png");
//       fileBytes = FileUtils.readFileToByteArray(file);
       
       HttpHeaders headers = new HttpHeaders();
       //下载显示的文件名，解决中文名称乱码问题  
       String downloadFielName = new String(bean.getFileName().getBytes("UTF-8"),"iso-8859-1");
       //通知浏览器以attachment（下载方式）打开图片
       headers.setContentDispositionFormData("attachments", downloadFielName); 
       //application/octet-stream ： 二进制流数据（最常见的文件下载）。
       headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
       
       //头部携带返回信息
       headers.set("attachmentsJSONStr", bean.getJsonStr());
       return new ResponseEntity<byte[]>(fileBytes,headers, HttpStatus.CREATED);  
    }
    
    /**
     * struts用
     * @return
     * @throws Exception 
     */
	public String getAttachmentData() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();

		String jsonStr = request.getHeader("jsonStr");
		if(jsonStr==null){
			jsonStr=getStringByRequest(request);
		}
		String userId = request.getHeader("userId");
		LoginBean lbean = getUserContext(userId,null);
		Context ctx=lbean.getContext();
		// 获取附件数据
		AttachmentBean bean = getAttachmentData(ctx, jsonStr);
		ctx = null;

		byte[] fileBytes = bean.getFileBytes();
		// 下载文件路径
		// File file = new File("e:\\555.png");
		// fileBytes = FileUtils.readFileToByteArray(file);

		HttpHeaders headers = new HttpHeaders();
		// 下载显示的文件名，解决中文名称乱码问题
		String downloadFielName = new String(bean.getFileName().getBytes("UTF-8"), "iso-8859-1");
		// 通知浏览器以attachment（下载方式）打开图片
		headers.setContentDispositionFormData("attachments", downloadFielName);
		// application/octet-stream ： 二进制流数据（最常见的文件下载）。
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

		// 头部携带返回信息
		headers.set("attachmentsJSONStr", bean.getJsonStr());

		JsonUtil.buildJsonByte(bean.getJsonStr(), fileBytes);
		return null;
	}
	
	/**
     * struts用
     * 获取养户签名
     * @return
     * @throws Exception 
     */
	public String getFarmerSignData() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();

		String jsonStr = request.getHeader("jsonStr");
		if(jsonStr==null){
			jsonStr=getStringByRequest(request);
		}
		String userId = request.getHeader("userId");
		LoginBean lbean = getUserContext(userId,null);
		Context ctx=lbean.getContext();
		// 获取附件数据
		JSONObject resultJO=ResultUtils.getResultSuccess();
		String farmerId=JSONObject.parseObject(jsonStr).getString("farmerId");
		if(StringUtils.isEmpty(farmerId)) {
			resultJO.put("result", "1");
			resultJO.put("message", "养户id(farmerId)不能为空！");
			JsonUtil.buildJsonByte(resultJO.toJSONString(), null);
		}else {
			byte[] fileBytes =null;
			IRowSet rs = DbUtil.executeQuery(ctx, "select FsignatureData from T_BAS_YZ_RH_CUST where fid=?",new Object[]{farmerId});
			if(rs.next()) {
				SerialBlob ss = ((SerialBlob)rs.getObject("FsignatureData"));
				fileBytes=new byte[(int) ss.length()];//2M
				ss.getBinaryStream().read(fileBytes);
				ss.getBinaryStream().close();
			}
			rs.close();
			// 下载文件路径
			// File file = new File("e:\\555.png");
			// fileBytes = FileUtils.readFileToByteArray(file);
	
			HttpHeaders headers = new HttpHeaders();
			// 下载显示的文件名，解决中文名称乱码问题
			String downloadFielName = new String("养户签名".getBytes("UTF-8"), "iso-8859-1");
			// 通知浏览器以attachment（下载方式）打开图片
			headers.setContentDispositionFormData("signData", downloadFielName);
			// application/octet-stream ： 二进制流数据（最常见的文件下载）。
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	
			// 头部携带返回信息
			headers.set("signDataJSONStr", resultJO.toJSONString());
			if(fileBytes!=null) {
				JsonUtil.buildJsonByte(resultJO.toJSONString(), fileBytes);
			}
		}
		ctx = null;
		return null;
	}
	
	/**
     * struts用
     * 获取养户开户签名
     * @return
     * @throws Exception 
     */
	public String getCustStartSignData() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();

		String jsonStr = request.getHeader("jsonStr");
		if(jsonStr==null){
			jsonStr=getStringByRequest(request);
		}
		String userId = request.getHeader("userId");
		LoginBean lbean = getUserContext(userId,null);
		Context ctx=lbean.getContext();
		// 获取附件数据
		JSONObject resultJO=ResultUtils.getResultSuccess();
		String custStartId=JSONObject.parseObject(jsonStr).getString("custStartId");
		if(StringUtils.isEmpty(custStartId)) {
			resultJO.put("result", "1");
			resultJO.put("message", "养户开户id(custStartId)不能为空！");
			JsonUtil.buildJsonByte(resultJO.toJSONString(), null);
		}else {
			byte[] fileBytes =null;
			IRowSet rs = DbUtil.executeQuery(ctx, "select FsignatureData from CT_BAS_CustStart where fid=?",new Object[]{custStartId});
			if(rs.next()) {
				SerialBlob ss = ((SerialBlob)rs.getObject("FsignatureData"));
				fileBytes=new byte[(int) ss.length()];//2M
				ss.getBinaryStream().read(fileBytes);
				ss.getBinaryStream().close();
			}
			rs.close();
			// 下载文件路径
			// File file = new File("e:\\555.png");
			// fileBytes = FileUtils.readFileToByteArray(file);
	
			HttpHeaders headers = new HttpHeaders();
			// 下载显示的文件名，解决中文名称乱码问题
			String downloadFielName = new String("养户开户签名".getBytes("UTF-8"), "iso-8859-1");
			// 通知浏览器以attachment（下载方式）打开图片
			headers.setContentDispositionFormData("signData", downloadFielName);
			// application/octet-stream ： 二进制流数据（最常见的文件下载）。
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	
			// 头部携带返回信息
			headers.set("signDataJSONStr", resultJO.toJSONString());
			if(fileBytes!=null) {
				JsonUtil.buildJsonByte(resultJO.toJSONString(), fileBytes);
			}
		}
		ctx = null;
		return null;
	}
	
	
    
    @ResponseBody
	@RequestMapping(value = "/interface/deleteAttachment.json", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
	public String deleteAttachment(@RequestBody String joStr,HttpServletResponse response) {
		String result="[]";
		try {
			String userId=request.getHeader("userId");
			LoginBean bean = getUserContext(userId,null);
			Context ctx=bean.getContext();
			result= wsFacade._deleteAttachment(ctx, joStr);
			if(!bean.isOrgContext) {
				ctx=null;
			}
		} catch (Exception e) {
			result="[{\"result\":\"1\",\"message\":\""+e.getMessage()+"\"}]";
		}
		return result;
	}
    
    /**
     * struts用
     * @return
     */
    public String deleteAttachment() {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		
		if(wsFacade==null) {
			wsFacade=new OutAppInterfaceControllerBean();
		}
		JsonUtil.buildJsonStr(deleteAttachment(getStringByRequest(request),null));
		return null;
	}
	
    /**
     * 下载bean
     * @author dai_a
     *
     */
    private class AttachmentBean {
    	private String jsonStr;
    	private String fileName="";
    	private byte[] fileBytes;
		public String getJsonStr() {
			return jsonStr;
		}
		public void setJsonStr(String jsonStr) {
			this.jsonStr = jsonStr;
		}
		public byte[] getFileBytes() {
			return fileBytes;
		}
		public void setFileBytes(byte[] fileBytes) {
			this.fileBytes = fileBytes;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
    	
    }

	/**
	 * 获取附件数据
	 */
	protected AttachmentBean getAttachmentData(Context ctx, String jsonStr) throws BOSException, EASBizException {
		AttachmentBean bean=new AttachmentBean();
		JSONObject resultJson = ResultUtils.getResultSuccess();
		
		JSONObject jsonParam=JSONObject.parseObject(jsonStr);
		//参数
		String id=null;
		
		if(jsonParam.containsKey("id")) {
			id=jsonParam.getString("id");
		}
		
		if(id==null) {
			resultJson.put("result", "1");
			resultJson.put("message","id不能为空！");
			return bean;
		}

		try {
			String type="";
			AttachmentUtils is = new AttachmentUtils(ctx);
			bean.setFileBytes(is.getAttachmentAsBytes(id, type));
			AttachmentInfo info = AttachmentFactory.getLocalInstance(ctx).getAttachmentInfo("select name,simpleName where id='"+id+"'");
			type=info.getName()+"."+info.getSimpleName();
			bean.setFileName(type);
			resultJson.put("fileName", type);
		} catch (Exception e) {
			resultJson.put("result", "1");
			resultJson.put("message", e.getMessage());
		} 
		bean.setJsonStr(resultJson.toJSONString());
		return bean;
	}
	
	
	
	/**
	 * y验权
	 * @param ctx
	 * @param jsonStr
	 * @return
	 * @throws BOSException
	 * @throws SQLException
	 */
	public String checkPermission() {
		request = ServletActionContext.getRequest();
		session = request.getSession();

		JSONObject jo=JSONObject.parseObject(getStringByRequest(request));
		String userId=jo.getString("userId");
		JSONArray permissionNumber=jo.getJSONArray("permissionNumber");
		Context ctx=(Context) session.getAttribute("easContext");
		JSONObject resultJson = new JSONObject();
		List<String> permissionList=new ArrayList<String>();
		resultJson.put("result", "1");
		resultJson.put("data", permissionList);
		resultJson.put("message", "faile");
		
		
		String permissionStr="";
		
		if(StringUtils.isBlank(userId)||permissionNumber.size()<=0){
			resultJson.put("result", "1");
			resultJson.put("message", "参数不能为空");
		}
		for (int i = 0; i < permissionNumber.size(); i++) {
			permissionStr=permissionStr+"'"+permissionNumber.get(i)+"',";
		}
		
		
		String sql="select distinct pi.fnumber  per from T_PM_PermItem pi  "+
			"inner join T_PM_RolePerm  pp on pp.FPermItemID=pi.fid "+
			"inner join T_PM_Role     ro  on ro.fid=pp.FRoleID "+
			"inner join T_PM_UserRoleOrg  ro on ro.FRoleID=ro.fid "+
			"inner join t_pm_user  uu on uu.fid=ro.FUserID "+
			"where uu.fid='"+userId+"'  and pi.fnumber in("+permissionStr.substring(0, permissionStr.length()-1)+")";
		
//		String sql="select distinct pi.fnumber per from T_PM_UserOrgPerm  uop "+
//					"inner join   T_PM_PermItem     pi on pi.fid=uop.FPermItemID "+
//					"where  fowner='"+userId+"' and pi.fnumber in ("+permissionStr.substring(0, permissionStr.length()-1)+")" ;
		IRowSet rs=null;
		try {
			rs = DbUtil.executeQuery(ctx, sql);
		} catch (BOSException e) {
			resultJson.put("result", "1");
			resultJson.put("message", e.getMessage());
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				permissionList.add(rs.getString("per")); 
			}
			resultJson.put("result", "0");
			resultJson.put("data", permissionList);
			resultJson.put("message", "sucess");
		} catch (SQLException e) {
			resultJson.put("result", "1");
			resultJson.put("message", e.getMessage());
			e.printStackTrace();
		}
		  JsonUtil.buildJsonStr(resultJson.toJSONString());
		return null;
	}
	
}
