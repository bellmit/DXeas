package com.kingdee.eas.custom.wlhllicensemanager.util;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityObjectCollection;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.wlhllicensemanager.beans.DynamicCalParamsBean;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;


public class WlhlDynamicCalUtils {

	/**
	 * ���ش����ļ���ű�
	 * @param formulaTxt
	 */
	public static String getCalDealedFormulaTxt(String formulaTxt) throws EASBizException {
		try {
			if(StringUtils.isEmpty(formulaTxt)) {
				return null;
			}
			String tempStr,resultStr="";
			int strLength=formulaTxt.length();
			int beginIndex=0;
			int index;
			for(index=0;index<strLength;index++) {
				if(formulaTxt.indexOf("[")<0) {
					resultStr+=formulaTxt.substring(0,formulaTxt.length());
					break;
				}
				resultStr+=formulaTxt.substring(0,formulaTxt.indexOf("["));
				tempStr=formulaTxt.substring(formulaTxt.indexOf("["), formulaTxt.indexOf("]")+1);
				beginIndex=tempStr.indexOf("\"");
				resultStr+=tempStr.substring(beginIndex,tempStr.indexOf("\"", beginIndex+1)+1);
				formulaTxt=formulaTxt.substring(formulaTxt.indexOf("]")+1,formulaTxt.length());
				strLength=formulaTxt.length();
			}
			resultStr+=formulaTxt;
//			System.out.println(resultStr);
			return resultStr;
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}
	}
	
	/**
	 * ���ش����ļ���ű�
	 * @param formulaTxt
	 */
	public static String getCalDealedFormulaTxtNew(Map<String, String> keyMap,String formulaTxt) throws EASBizException {
		try {
			if(StringUtils.isEmpty(formulaTxt)) {
				return null;
			}
			String tempStr,resultStr="";
			int strLength=formulaTxt.length();
			int beginIndex=0;
			int index;
//			for(index=0;index<strLength;index++) {
			while(strLength>0) {
				if(formulaTxt.indexOf("[")<0) {
					resultStr+=formulaTxt.substring(0,formulaTxt.length());
					formulaTxt="";
					break;
				}
				resultStr+=formulaTxt.substring(0,formulaTxt.indexOf("["));
				tempStr=formulaTxt.substring(formulaTxt.indexOf("[")+1, formulaTxt.indexOf("]"));
//				beginIndex=tempStr.indexOf("\"");
//				resultStr+=tempStr.substring(beginIndex,tempStr.indexOf("\"", beginIndex+1)+1);
				if(keyMap.containsKey(tempStr)) {
					resultStr+="["+keyMap.get(tempStr)+"]";
				}else {
					if(tempStr.equals("���")) {
						resultStr+="if";
					}else if(tempStr.equals("����")) {
						resultStr+="else";
					}else if(tempStr.equals("��ʽ���")) {
						resultStr+="result";
					}else if(tempStr.contains("[")&&tempStr.contains("]")) {
						resultStr+=tempStr;
					}else {
						throw new EASBizException(new NumericExceptionSubItem("","���� ["+tempStr+"] ��Ч"));
					}
				}
				formulaTxt=formulaTxt.substring(formulaTxt.indexOf("]")+1,formulaTxt.length());
				strLength=formulaTxt.length();
			}
			resultStr+=formulaTxt;
//			System.out.println(resultStr);
			return resultStr;
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}
	}
	
	/**
	 * ͨ���ű����м���
	 * @throws BOSException 
	 */
	public static BigDecimal getCalResultByJsTxt(Context ctx,CoreBaseCollection cols,String jsTxt) throws BOSException {
		int strLength=jsTxt.length();
		String tempStr="",resultStr="";
		String[] ifp;
		CoreBaseInfo info;
		EntityObjectInfo eo;
		int beginIndex;
		HashMap<String,EntityObjectInfo> map=new HashMap<String, EntityObjectInfo>();
		for(int index=0;index<strLength;index++) {
			if(jsTxt.indexOf("\"")<0) {
				resultStr+=jsTxt.substring(0,jsTxt.length());
				jsTxt="";
				break;
			}
			resultStr+=jsTxt.substring(0,jsTxt.indexOf("\""));
			beginIndex=jsTxt.indexOf("\"");
			tempStr=jsTxt.substring(beginIndex, jsTxt.indexOf("\"",beginIndex+1)+1);
			tempStr=tempStr.replaceAll("\"", "");
			if(tempStr.contains(".")) {
				ifp=tempStr.split("\\.");
				for(int j=0;j<cols.size();j++) {
					info = cols.get(j);
					if(info==null) {
						continue;
					}
					if(map.containsKey(info.getBOSType().toString())){
						eo=map.get(info.getBOSType().toString());
					}else {
						eo = WlhlDynamicBillUtils.getEntityObject(ctx, info.getBOSType().toString());
						map.put(info.getBOSType().toString(), eo);
					}
					//����������ͬ
					if(eo.getName().equals(ifp[0])) {
						if(info.containsKey(ifp[1])) {
							resultStr+=info.get(ifp[1])!=null?info.get(ifp[1]).toString():"0";
						}
					}
				}
			}else{
				resultStr+=tempStr;
			}
			jsTxt=jsTxt.substring(jsTxt.indexOf("\"",beginIndex+1)+1,jsTxt.length());
			strLength=jsTxt.length();
		}
		resultStr+=jsTxt;
		//		resultStr="result"+resultStr;
		System.out.println(resultStr);
		String paramsStr="";
		//js�ű�ȡֵ
		try {
			resultStr="function getValue(params)\n{  var result=0.0;\n "+resultStr+"\n return result;\n}";
			ScriptEngineManager mgr = new ScriptEngineManager();    
			ScriptEngine engine = mgr.getEngineByMimeType("application/javascript");
			engine.eval(resultStr);   
			Invocable inv = (Invocable) engine;   
			Object res = inv.invokeFunction("getValue",paramsStr); 
			return new BigDecimal(String.valueOf(res));
		}catch(Exception err) {
			throw new BOSException("��ʽ�ű��������:\n"+err.getMessage());
		}
	}
	
	/**
	 * ͨ���ű����м���
	 * @throws BOSException 
	 */
	public static BigDecimal getCalResultByJsTxtNew(Context ctx,EntityObjectCollection cols,HashMap<String,DynamicCalParamsBean> paramsMap,String jsTxt,boolean isV) throws BOSException {
		int strLength=jsTxt.length();
		String tempStr="",resultStr="";
		String[] ifp;
		EntityObjectInfo eo;
		int beginIndex;
		String bosType;
		for(int index=0;index<strLength;index++) {
			if(jsTxt.indexOf("[")<0||jsTxt.indexOf("]")<0) {
				resultStr+=jsTxt.substring(0,jsTxt.length());
				jsTxt="";
				break;
			}
			beginIndex=jsTxt.indexOf("[");
			if(beginIndex<0) {
				beginIndex=0;
			}
			resultStr+=jsTxt.substring(0,beginIndex);
			tempStr=jsTxt.substring(beginIndex, jsTxt.indexOf("]",beginIndex+1)+1);
			tempStr=tempStr.replaceAll("\\[", "");
			tempStr=tempStr.replaceAll("\\]", "");
			if(tempStr.contains(".")) {
				if(!isV) {
					String calResult="0";
					ifp=tempStr.split("\\.");
					for(int j=0;j<cols.size();j++) {
						eo = cols.get(j);
						if(eo==null) {
							continue;
						}
						//����������ͬ
						if(eo.getName().equals(ifp[0])) {
							//�������ֶ�
							if(eo.getPropertyByName(ifp[1])!=null) {
								bosType=eo.getType().toString();
								String tableName = eo.getTable().getName();
								String filedName=eo.getPropertyByName(ifp[1]).getMappingField().getName();
								boolean isSum=true;
								String filterStr="";
								if(paramsMap!=null&&paramsMap.containsKey(bosType)&&paramsMap.get(bosType)!=null) {
									filterStr+=" where "+paramsMap.get(bosType).getFilterStr();
									isSum=paramsMap.get(bosType).isSum();
								}
								if(isSum) {
									filedName="sum("+filedName+")";
								}
								String sql=" select isnull("+filedName+",0) Fqty from "+tableName+filterStr;
								try {
									 IRowSet rs = null;
									 if(ctx!=null){
										 rs=SQLExecutorFactory.getLocalInstance(ctx, sql).executeSQL();
									 }else {
										 rs=SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
									 }
									if(rs.next()) {
										calResult=String.valueOf(rs.getBigDecimal("FQty"));
									}
								} catch (SQLException err) {
									throw new BOSException("��ʽȡ������:\n"+err.getMessage());
								}
							}
						}
					}
					resultStr+=calResult;
				}else {
					resultStr+="1";
				}
			}else{
				resultStr+=tempStr;
			}
			jsTxt=jsTxt.substring(jsTxt.indexOf("]",beginIndex+1)+1,jsTxt.length());
			strLength=jsTxt.length();
		}
		resultStr+=jsTxt;
		System.out.println(resultStr);
		String paramsStr="";
		//js�ű�ȡֵ
		try {
			resultStr="function getValue(params)\n{  var result=0.0;\n "+resultStr+"\n return result;\n}";
			ScriptEngineManager mgr = new ScriptEngineManager();    
			ScriptEngine engine = mgr.getEngineByMimeType("application/javascript");
			engine.eval(resultStr);   
			Invocable inv = (Invocable) engine;   
			Object res = inv.invokeFunction("getValue",paramsStr); 
			return new BigDecimal(String.valueOf(res));
		}catch(Exception err) {
			throw new BOSException("��ʽ�ű��������:\n"+err.getMessage());
		}
	}
	/**
	 * ��ȡ��������
	 * @param bosType
	 * @param filterMap
	 * @return
	 */
	private static String getFilterStr(EntityObjectInfo eo,HashMap<String,List<String>> filterMap) {
		String bosType=eo.getBOSType().toString();
		if(filterMap.containsKey(bosType)) {
			for(String str:filterMap.get(bosType)) {
				
			}
		}
		return null;
	}
	
}
