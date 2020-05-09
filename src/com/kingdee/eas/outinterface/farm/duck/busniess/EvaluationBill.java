package com.kingdee.eas.outinterface.farm.duck.busniess;

import java.rmi.RemoteException;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;

public class EvaluationBill extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "B76CC7D2";
	}

	/**
	 * 返回哪些字段
	 */
	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","name","bizdate"
				,"evaluationType","satisfation","evaluation"
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
				,"evaluationType","satisfation","evaluation"
		};
	}

	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException,
	EASBizException, RemoteException {
		// TODO Auto-generated method stub
		return super.getData(ctx, jsonStr);
	}

	@Override
	public JSONObject dealAfterGetDataJSON(Context ctx, CoreBaseInfo model,
			JSONObject infoJSON) {
		// TODO Auto-generated method stub
		return super.dealAfterGetDataJSON(ctx, model, infoJSON);
	}

	@Override
	public CoreBaseInfo dealBeforeSave(Context ctx, CoreBaseInfo model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		return super.dealBeforeSave(ctx, model);
	}

}
