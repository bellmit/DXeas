package com.kingdee.eas.outinterface.farm.duck.busniess;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;

/**
 * º¶…·
 * @author zhanzg
 *
 */
public class carviousFarmHouse extends AbstractOutInterfaceImpl  {
	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "CF39BC2A";
	}

	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
	return new String[]{"id","name","number","area"};
	}
	
	
	
	@Override
	protected String getQueryInfo() {
		// TODO Auto-generated method stub
		return "com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery";
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
