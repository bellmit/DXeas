package com.kingdee.eas.outinterface.base.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;

public class JsonUtil {
	
	public static void buildJsonStr(Object obj) {
		HttpServletResponse response = ServletActionContext.getResponse();
		buildJsonStr(obj, response);
	}
	
	public static void buildJsonStr(Object obj, HttpServletResponse response)
	  {
	    try
	    {
		  
	      String str = null;
	     
	      if(!(obj instanceof String)) {
	    	  Gson gson = new Gson();
		      Map jsonMap = new HashMap();
		      jsonMap.put("data", obj);
		      if ((obj instanceof List))
		      {
		        List objList = (List)obj;
		        if (objList.size() == 0)
		        {
		          jsonMap.put("result", "1");
		          jsonMap.put("message", "1");
		        }
		        else
		        {
		          jsonMap.put("result", "1");
		          jsonMap.put("message", "0");
		        }
		      }
		      else if ((obj.equals("")) || (obj == null))
		      {
		        jsonMap.put("result", "1");
		        jsonMap.put("message", "1");
		      }
		      else
		      {
		        jsonMap.put("result", "1");
		        jsonMap.put("message", "0");
		      }
		      
	    	  str=gson.toJson(jsonMap);
	      }else {
	    	  str=obj.toString();//new String(obj.toString().getBytes("GBK"),"UTF-8");
	      }

	      response.setContentType("application/json;charset=utf-8");
	      response.setHeader("cache-control", "no-cache");
//	      PrintWriter out = response.getWriter();
	      ServletOutputStream dd = response.getOutputStream();
	      dd.write(str.getBytes("utf-8"));
	      dd.flush();
	      dd.close();
//	      System.out.println("--return--json-->" + str);
//	      out.print(str);
//	      out.flush();
//	      out.close();
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	  }
	
	public static void buildJsonByte(String jsonStr,byte[] obj)
	  {
	    try
	    {
	      HttpServletResponse response = ServletActionContext.getResponse();
    	  Gson gson = new Gson();
	      Map jsonMap = new HashMap();
	      jsonMap.put("data", obj);
	      jsonMap.put("result", "0");
	      jsonMap.put("message", "success");
		      
	      response.setContentType("charset=utf-8");
	      response.setContentLength(obj.length);
//	      response.setContentType("");
	      response.setHeader("cache-control", "no-cache");
	      response.setHeader("attachmentsJSONStr",jsonStr);
//	      PrintWriter out = response.getWriter();
	      ServletOutputStream dd = response.getOutputStream();
	      dd.write(obj);
	      dd.flush();
	      dd.close();
	      System.out.println("--return--byte-->" + obj.length);
//	      out.print(str);
//	      out.flush();
//	      out.close();
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	  }
}
