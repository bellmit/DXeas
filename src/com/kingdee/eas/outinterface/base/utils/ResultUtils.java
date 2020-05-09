package com.kingdee.eas.outinterface.base.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 返回结果类
 * @author alex_dai
 *
 */
public class ResultUtils {
	
	public static JSONObject getResultSuccess() {
		JSONObject json=new JSONObject();
		json.put("result", "0");
		json.put("message", "success");
		return json;
	}
	
	public static JSONObject getResultSuccess(JSON jsonData) {
		JSONObject json=new JSONObject();
		json.put("result", "0");
		json.put("message", "success");
		json.put("data", jsonData);
		return json;
	}
	
	public static JSONObject getResultSuccess(String msg,JSON jsonData) {
		JSONObject json=new JSONObject();
		json.put("result", "0");
		json.put("message",msg);
		json.put("data", jsonData);
		return json;
	}
	
	public static JSONObject getResultError(Exception e) {
		JSONObject json=new JSONObject();
		json.put("result", "99");
		json.put("message", e.getMessage());
		return json;
	}
	
	public static JSONObject getResultError(String errorMsg) {
		JSONObject json=new JSONObject();
		json.put("result", "99");
		json.put("message", errorMsg);
		return json;
	}
	
	public static JSONObject getResultError(int code,Exception e) {
		JSONObject json=new JSONObject();
		json.put("result", String.valueOf(code));
		json.put("message", e.getMessage());
		return json;
	}
	
	public static JSONObject getResultError(int code,String errorMsg) {
		JSONObject json=new JSONObject();
		json.put("result", String.valueOf(code));
		json.put("message", errorMsg);
		return json;
	}
}
