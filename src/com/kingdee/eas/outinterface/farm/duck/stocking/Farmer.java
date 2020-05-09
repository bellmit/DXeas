package com.kingdee.eas.outinterface.farm.duck.stocking;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;

/**
 * 养殖户
 * @author alex_dai
 *
 */
public class Farmer extends AbstractOutInterfaceImpl {
	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "183114FF";
	}

	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","name","sex","identity","mobileTel","company.name","baseStatus"};
	}
	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		StringBuffer queryStr=new StringBuffer();
		queryStr.append(" baseStatus=3 ");//启用状态
		if(StringUtils.isNotEmpty(jo.getString("number"))) {
			queryStr.append(" and (number like '%"+jo.getString("number")+"%' or  name like '%"+jo.getString("number")+"%')");
		}
		if(StringUtils.isNotEmpty(jo.getString("name"))) {
			queryStr.append(" and (number like '%"+jo.getString("name")+"%' or  name like '%"+jo.getString("name")+"%')");
		}
		
		//角色
		String rolesStr=StockingInterfaceUtils.getRoleFilterStr(jo, "id");
		if(rolesStr.length()>0) {
			queryStr.append(" AND (").append(rolesStr).append(")");
		}
		
		return queryStr.toString();
	}
}
