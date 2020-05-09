package com.kingdee.eas.outinterface.base.impl;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;

public class Storage extends AbstractOutInterfaceImpl{

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "EB1F7FD2";
	}
	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","name"};
	}



	@Override
	protected String getQueryInfo() {
		// TODO Auto-generated method stub
		return "com.kingdee.eas.basedata.org.app.StorageItemQuery";
	}

	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		return "order by number";
	}

	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		String queryStr=" ";

		return queryStr;
	}

	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return super.getDataSelector();
	}
}
