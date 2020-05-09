package com.kingdee.eas.outinterface.base.impl;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;

/**
 * 基础物料处理
 * @author alex_dai
 *
 */
public class Material extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "4409E7F0";
	}

	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
	return new String[]{"id","number","unitQty","name","model"};
	}
	
	
	
	@Override
	protected String getQueryInfo() {
		// TODO Auto-generated method stub
		return "com.kingdee.eas.basedata.master.material.app.MaterialQuery";
	}

	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		return "order by number";
	}

	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		String queryStr=" status=1 ";//EffectedStatus= and 
		String materialGroup =jo.getString("materialGroup.number");
		if(StringUtils.isNotEmpty(jo.getString("number"))) {
			queryStr+=" and (number like '%"+jo.getString("number")+"%' or  name like '%"+jo.getString("number")+"%')";
		}
		if(StringUtils.isNotEmpty(jo.getString("name"))) {
			queryStr+=" and (number like '%"+jo.getString("name")+"%' or  name like '%"+jo.getString("name")+"%')";
		}
		
//		if(StringUtils.isNotEmpty(jo.getString("materialGroup.number"))) {
//			queryStr+=" and materialGroup.number like '"+jo.getString("materialGroup.number")+"%'";
//		}
//		if(queryStr.length()>0){
//			jo.put("queryStr", queryStr);
//		}
//		if(StringUtils.isNotEmpty(jo.getString("materialGroup.number"))&&jo.getString("materialGroup.number").equals("0103")){
//			queryStr+=" and materialGroup.number like '4%' or materialGroup.number like '5%'";
//		}else{
//			queryStr+=" and materialGroup.number like '3100%'";
//		}
//		queryStr=" status=1 ";
		return queryStr;
	}

	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return super.getDataSelector();
	}
	

	
	
}
