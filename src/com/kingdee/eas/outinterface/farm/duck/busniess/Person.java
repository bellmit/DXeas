package com.kingdee.eas.outinterface.farm.duck.busniess;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;

public class Person extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "80EF7DED";
	}

	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","name","number"};
	}
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		String queryStr= "";
		//获取所有养殖户档案的业务员
		StringBuffer sql =new StringBuffer();
		sql.append("id in(select distinct cfpersonid from CT_FM_Farmer )");
		queryStr=queryStr+sql.toString();
		return queryStr;
	}
}
