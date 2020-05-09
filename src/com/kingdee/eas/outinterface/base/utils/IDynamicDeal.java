package com.kingdee.eas.outinterface.base.utils;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseInfo;

/**
 * 校验接口
 * @author dai_andong
 *
 */
public interface IDynamicDeal {
	//保存数据前
	CoreBaseInfo dealBeforeSave(Context ctx,CoreBaseInfo model) throws BOSException,EASBizException;
	//保存数据后
	void dealAfterSave(Context ctx,CoreBaseInfo model) throws BOSException,EASBizException;
	
	//获取数据后
	CoreBaseInfo dealBeforeGetDataJSON(Context ctx,CoreBaseInfo model);
	
	//获取数据后
	JSONObject dealAfterGetDataJSON(Context ctx,CoreBaseInfo model,JSONObject infoJSON) ;
}