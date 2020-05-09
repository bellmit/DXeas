package com.kingdee.eas.outinterface.base.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;

public class JUtils {
	public static final SimpleDateFormat SDF_DAY=new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat SDF_SECOND=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static Date getDate(JSONObject json,String key) throws BOSException {
		try {
			if(json.containsKey(key)&&StringUtils.isNotBlank(json.getString(key))) {
				if(json.getString(key).length()<13) {
					return SDF_DAY.parse(json.getString(key));
				}else {
					return SDF_SECOND.parse(json.getString(key));
				}
			}
		}catch(Exception err) {
			throw new BOSException("非法日期格式！");
		}
		return null;
	}
	
	
	public static String getDateStr(JSONObject json,String key,SimpleDateFormat sdf) throws BOSException {
		try {
			Date date = json.getDate(key);
			if(date==null) {
				return null;
			}
			return sdf.format(date);
		}catch(Exception err) {
			throw new BOSException("非法日期格式！");
		}
	}
	
	public static Timestamp getTimestamp(JSONObject json,String key) throws BOSException {
		try {
			if(json.containsKey(key)) {
				return json.getTimestamp(key);
			}
		}catch(Exception err) {
			throw new BOSException("非法日期格式！");
		}
		return null;
	}
	
	public static BigDecimal getBigDecimal(JSONObject json,String key) throws BOSException {
		try {
			if(json.containsKey(key)) {
				return json.getBigDecimal(key);
			}
		}catch(Exception err) {
			throw new BOSException("非法数值格式！");
		}
		return BigDecimal.ZERO;
	}
	
	public static String getString(JSONObject json,String key) throws BOSException {
		try {
			if(json.containsKey(key)) {
				return  json.getString(key);
			}
		}catch(Exception err) {
			throw new BOSException("非法字符格式！");
		}
		return null;
	}
	
	public static int getInt(JSONObject json,String key) throws BOSException {
		try {
			if(json.containsKey(key)) {
				return  json.getIntValue(key);
			}
		}catch(Exception err) {
			throw new BOSException("非法数字格式！");
		}
		return 0;
	}
	public static Boolean getBoolean(JSONObject json,String key) throws BOSException {
		try {
			if(json.containsKey(key)) {
				return json.getBoolean(key);
			}
		}catch(Exception err) {
			throw new BOSException("非法数值格式！");
		}
		return false;
	}
}
