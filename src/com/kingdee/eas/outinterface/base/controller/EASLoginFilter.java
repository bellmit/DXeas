package com.kingdee.eas.outinterface.base.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.Context;

public class EASLoginFilter implements Filter {
	private static final Logger logger = Logger.getLogger(EASLoginFilter.class);
	
//	public static final String NO_INTERCEPTOR_PATH =".*/((.css)|(.js)|(images)|(login)|(register)|(anon)).*";
	public static final String NO_INTERCEPTOR_PATH =".*/((.css)|(.js)|(images)|(login)|(loginByUserNum)|(register)|(anon)).*";
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		//只允许POST请求
		if(!httpRequest.getMethod().equalsIgnoreCase("POST")) {
			return;
		}
//		HttpSession session = httpRequest.getSession();
//		logger.info("###########sessionId:"+session.getId()+"#######");
//		Context ctx=(Context) session.getAttribute("easContext");
//		String url=httpRequest.getRequestURI();
		
		HttpSession session = httpRequest.getSession();
		  Context ctx=(Context) session.getAttribute("easContext");
		  String url=httpRequest.getRequestURI();
		  
		  String tmpStr="\n ############################\n dir:"+System.getProperty("user.dir")
		    +"\n sessionId:"+session.getId()
		    +"\n ip:"+httpRequest.getRemoteAddr()
		    +"\n url:"+httpRequest.getRequestURI()
		    +"\n ctx:"+ctx
		    +" \n ############################";
		  
		  logger.info(tmpStr);
		  System.out.println(tmpStr);
		if(ctx==null) {
			if(url.matches(NO_INTERCEPTOR_PATH)){//url.equals("/outinterface/login.json")
				chain.doFilter(request, response);
			}else {
				JSONObject jo=new JSONObject();
				jo.put("result", "99");
				jo.put("message", "请先登陆EAS！");
				String str=jo.toString();
					
				if(httpRequest.getContentType().equalsIgnoreCase("application/json")) {
					String jstr = BaseInterfaceController.getStringByRequest(httpRequest);
					Object obj = JSON.parse(jstr);
					if(obj instanceof JSONArray) {
						str="["+str+"]";
					}
				}
				JsonUtil.buildJsonStr(str,(HttpServletResponse) response);
			}
		}else {
			if(!url.matches(NO_INTERCEPTOR_PATH)){//url.equals("/outinterface/login.json")
				chain.doFilter(request, response);
			}else {

				JSONObject reusltJO=new JSONObject();
				reusltJO.put("result", "0");
				reusltJO.put("message", "success");
				JSONObject jo=new JSONObject();
				jo.put("userId", ctx.getCaller().toString());
				jo.put("personId", (String)ctx.get("personId"));
				jo.put("sessionId",session.getId());
				reusltJO.put("data", jo);
				JsonUtil.buildJsonStr(reusltJO.toString(),(HttpServletResponse) response);
			}
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
