package com.kingdee.eas.outinterface.base.utils;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kingdee.bos.Context;
import com.kingdee.bos.framework.session.ILoginModule;
import com.kingdee.bos.framework.session.LoginContext;
import com.kingdee.bos.framework.session.LoginModuleFactory;
import com.kingdee.bos.framework.session.LoginType;
import com.kingdee.bos.sql.DbType;
import com.kingdee.bos.util.CryptoTean;
import com.kingdee.eas.cp.common.web.util.WebContextUtil;
import com.kingdee.eas.cp.eip.sso.ltpa.LtpaToken;
import com.kingdee.eas.cp.eip.sso.ltpa.LtpaTokenManager;
import com.kingdee.lightapp.xt.LightAppServiceFacade;
import com.kingdee.lightapp.xt.XTServiceConfig;
import com.kingdee.lightapp.xt.util.OrgSwitchUtil;

public class LoginHelper {
	private static final Logger logger = LoggerFactory.getLogger(LightAppServiceFacade.class);
	
	public static Context loginEASWithPassWord(String eid, String user, String password)
	  throws Exception {
		return loginEASWithPassWord(eid, user, password, "UNKNOW");
	}
	
	public static Context loginEASWithPassWord(String eid, String user, String password,String clientIP)
	  throws Exception
	{
	  try
	  {
	    XTServiceConfig cfg = XTServiceConfig.getInstance();
	    String sln = cfg.getSlnName(eid);
	    String aix = cfg.getDbCode(eid);
	    Locale locale = new Locale(cfg.getLocale(eid));
//	    String clientIP = "UNKNOW";
	    if(StringUtils.isEmpty(clientIP)) {
	    	clientIP = "UNKNOW";
	    }
	    LoginContext loginCtx = new LoginContext(user, password, sln, aix, locale);
	    loginCtx.put("dbTypeCode", Integer.valueOf(cfg.getDbType(eid)));
	    loginCtx.put("dbType", DbType.getName(cfg.getDbType(eid)));
	    loginCtx.put("ClientIP", clientIP);

	    Context userContext = new Context(null, loginCtx.getSlnName(), loginCtx.getAis(), loginCtx.getLocale(), loginCtx.getContextID());
	    loginCtx.setContextID(userContext.getContextID());
	    WebContextUtil.initRpcConfig(userContext);
	    ILoginModule loginModule = LoginModuleFactory.getRemoteInstance();
	    Context userCtx = loginModule.fullLogin(loginCtx);
	    OrgSwitchUtil.switchForLogin(userCtx);
	    return userCtx;
	  }
	  catch (Exception e)
	  {
	    logger.error(e.getMessage());
	  }
	  return null;
	}
	
	public static Context loginEASByUserNum(String eid, String userNum) throws Exception {
		return loginEASByUserNum(eid, userNum,"UNKNOW");
	}
	
	public static Context loginEASByUserNum(String eid, String userNum,String clientIP)
	  throws Exception
	{
	  String userName = userNum;//user.getNumber();
//	  String eid = xtparamsDto.getEid();
	  String authType = "BaseTrdLtpaToken";
	  System.out.println(" ------------login from web ------------" + userName);
	  LtpaToken token = LtpaTokenManager.generate(userName, LtpaTokenManager.getDefaultLtpaConfig());
	  String authPassword = token.getTokenStr();
	  XTServiceConfig cfg = XTServiceConfig.getInstance();

	  String encodePwd = CryptoTean.encrypt(userName, authPassword);
	  Locale locale = new Locale(cfg.getLocale(eid));
//	  String clientIP = "UNKNOW";
	  if(StringUtils.isEmpty(clientIP)) {
	    	clientIP = "UNKNOW";
	    }

	  LoginContext loginCtx = new LoginContext(userName, encodePwd, cfg.getSlnName(eid), cfg.getDbCode(eid), locale, clientIP, clientIP);
	  loginCtx.put("UserAuthPattern", authType);
	  loginCtx.put("dbTypeCode", Integer.valueOf(cfg.getDbType(eid)));

	  loginCtx.put("dbType", DbType.getName(cfg.getDbType(eid)));
	  loginCtx.put("ClientIP", clientIP);
	  loginCtx.setLoginType(LoginType.MOBILE);
	  String contextID = (String)loginCtx.get("contextID");
	  if (contextID != null)
	  {
	    loginCtx.setContextID(contextID);
	  }
	  Context userContext = new Context(null, loginCtx.getSlnName(), loginCtx.getAis(), loginCtx.getLocale(), loginCtx.getContextID());
	  loginCtx.setContextID(userContext.getContextID());
	  WebContextUtil.initRpcConfig(userContext);
	  ILoginModule loginModule = LoginModuleFactory.getRemoteInstance();
	  Context userCtx = loginModule.fullLogin(loginCtx);
	  OrgSwitchUtil.switchForLogin(userCtx);
	  return userCtx;
	}
	
	public static void logOut(Context ctx) throws Exception {
		  ILoginModule loginModule = LoginModuleFactory.getRemoteInstance();
		  loginModule.logout(ctx.getContextID());
	}
}
