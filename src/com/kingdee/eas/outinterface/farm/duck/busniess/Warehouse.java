package com.kingdee.eas.outinterface.farm.duck.busniess;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;

public class Warehouse extends com.kingdee.eas.outinterface.base.impl.Warehouse{


	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		String queryStr=" ";
		String batchContractID=jo.getString("storageOrgUnit.id");
		if(batchContractID != null){
		StringBuffer sql =new StringBuffer();
		sql.append("storageOrg.id ='");sql.append(batchContractID);sql.append("'");
		queryStr=queryStr+sql.toString();
		}
		return queryStr;
	}
}
