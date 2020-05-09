package com.kingdee.eas.outinterface.farm.duck.busniess;

import java.rmi.RemoteException;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;

public class Complain extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "F2B18698";
	}
	/**
	 * 返回哪些字段
	 */
	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","name","bizdate"
				,"complainInfo"
		};
	}
	/**
	 * 列表界面返回字段排序
	 */
	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		return "order by number";
	}

	/**
	 * 根据id获取某张单据的详情信息，返回哪些字段
	 */
	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","name","bizdate"
				,"complainInfo"
		};
	}

	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException,
	EASBizException, RemoteException {
		// TODO Auto-generated method stub
		return super.getData(ctx, jsonStr);
	}

}
