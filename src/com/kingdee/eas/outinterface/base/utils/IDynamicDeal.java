package com.kingdee.eas.outinterface.base.utils;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseInfo;

/**
 * У��ӿ�
 * @author dai_andong
 *
 */
public interface IDynamicDeal {
	//��������ǰ
	CoreBaseInfo dealBeforeSave(Context ctx,CoreBaseInfo model) throws BOSException,EASBizException;
	//�������ݺ�
	void dealAfterSave(Context ctx,CoreBaseInfo model) throws BOSException,EASBizException;
	
	//��ȡ���ݺ�
	CoreBaseInfo dealBeforeGetDataJSON(Context ctx,CoreBaseInfo model);
	
	//��ȡ���ݺ�
	JSONObject dealAfterGetDataJSON(Context ctx,CoreBaseInfo model,JSONObject infoJSON) ;
}