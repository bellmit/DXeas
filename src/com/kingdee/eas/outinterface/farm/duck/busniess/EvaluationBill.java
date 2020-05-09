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
	 * ������Щ�ֶ�
	 */
	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","name","bizdate"
				,"evaluationType","satisfation","evaluation"
		};
	}
	/**
	 * �б���淵���ֶ�����
	 */
	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		return "order by number";
	}

	/**
	 * ����id��ȡĳ�ŵ��ݵ�������Ϣ��������Щ�ֶ�
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
