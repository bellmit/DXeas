package com.kingdee.eas.outinterface.farm.duck.busniess;

import java.rmi.RemoteException;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;

public class Advice extends AbstractOutInterfaceImpl{

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "77968267";
	}

	/**
	 * ������Щ�ֶ�
	 */
	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","name","bizdate"
				,"adviceInfo","answer","status"
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
				,"adviceInfo","answer","status"
		};
	}

	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException,
	EASBizException, RemoteException {
		// TODO Auto-generated method stub
		return super.getData(ctx, jsonStr);
	}
	/**
	 * ����֮�����У�飬�ѻظ��Ĳ����Ա���
	 */
	@Override
	public CoreBaseInfo dealBeforeSave(Context ctx, CoreBaseInfo model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		return super.dealBeforeSave(ctx, model);
	}


}
