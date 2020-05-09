package com.kingdee.eas.outinterface.farm.duck.busniess;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;

public class FarmerGroup extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "EA2D1CC3";
	}

	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","name","number"};
	}
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		String queryStr="";
		//获取组别
		StringBuffer sql =new StringBuffer();
		sql.append("id in(select distinct FTreeID  from CT_FM_Farmer )");
		queryStr=queryStr+sql.toString();
		return queryStr;
	}

	@Override
	protected String getQueryInfo() {
		// TODO Auto-generated method stub
		return "com.kingdee.eas.farm.carnivorous.basedata.app.FarmerGroupQuery";
	}
	

}
