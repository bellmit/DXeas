package com.kingdee.eas.outinterface.base.impl;

import java.rmi.RemoteException;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.outinterface.base.IOutInterfaceDynamicBillFacade;
import com.kingdee.eas.outinterface.base.OutInterfaceDynamicBillFacadeFactory;
import com.kingdee.eas.outinterface.base.utils.IDynamicDeal;
import com.kingdee.eas.outinterface.base.utils.OutDynamicBillUtils;
import com.kingdee.eas.outinterface.base.utils.OutDynamicConstant;
import com.kingdee.eas.util.app.ContextUtil;

/**
 * app接口父类基类
 * @author dai_andong
 *
 */
public abstract class AbstractOutInterfaceImpl implements IDynamicDeal {
	
	/**
	 * 获取BOSTYPE
	 * @return
	 */
	protected abstract String getBosType();
	
	/**
	 * 添加BOSType
	 * @param str
	 * @return
	 */
	protected String getJSONStrWithBosType(String jsonStr) {
		return jsonStr.replace("{","{\"bosType\":\""+getBosType()+"\",");
	}
	
	protected ICoreBase getLocalInstance(Context ctx) throws BOSException {
		return OutDynamicBillUtils.getLocalInstance(ctx, OutDynamicBillUtils.getEntityObject(ctx, getBosType()));
	}
	
	@Override
	public JSONObject dealAfterGetDataJSON(Context ctx,CoreBaseInfo model,JSONObject infoJSON) {
		// TODO Auto-generated method stub
		return infoJSON;
	}

	/**
	 * 添加属性
	 * @param str
	 * @return
	 */
	protected String getFunctionJSONStrWithStr(String jsonStr,String functionName) {
		return jsonStr.replace("{","{\"functionName\":\""+functionName+"\",");
	}
	/**
	 * 获取查询条件
	 * @param jsonStr
	 * @param queryStr
	 * @return
	 */
	protected JSONObject getJSONWithQueryStr(JSONObject jo,String queryStr) {
		//完全使用用户自定义查询isCustomQuery=true
		if(jo.getBooleanValue("isCustomQuery")) {
			return jo;
		}
		queryStr=queryStr.trim();
		if(queryStr.toLowerCase().startsWith("where")) {
			queryStr=queryStr.substring(5);
		}else if(queryStr.toLowerCase().startsWith("and")) {
			queryStr=queryStr.substring(2);
		}
		
		//在原有过滤基础上增加过滤isCustomQuery=false isCustomQuery为空
		if(!jo.containsKey("queryStr")&&StringUtils.isBlank(jo.getString("queryStr"))) {
			jo.put("queryStr","where "+queryStr);
		}else {
			jo.put("queryStr",jo.getString("queryStr")+" and "+queryStr);
		}
		return jo;
	}
	
	protected String getListQueryStr(Context ctx,JSONObject jo) throws BOSException {
		return null;
	}
	
	/**
	 * 获取用户id
	 * @param ctx
	 * @return
	 */
	protected String getPersonIdByContext(Context ctx) {
		String personId=null;
		PersonInfo personInfo = ContextUtil.getCurrentUserInfo(ctx).getPerson();
		if(personInfo!=null) {
			personId=personInfo.getString("id");
		}
		return personId;
	}
	
	/**
	 * 获取selector
	 * @param jsonStr
	 * @param queryStr
	 * @return
	 */
	protected JSONObject getJSONWithSlorStr(JSONObject jo,String[] slor) {
		if(slor!=null&&slor.length>0) {
			jo.put("slor", slor);
		}
		return jo;
	}
	
	/**
	 * 获取QueryCols
	 * @param jsonStr
	 * @param queryStr
	 * @return
	 */
	protected JSONObject getJSONWithQueryCols(JSONObject jo,String[] queryCols) {
		if(queryCols==null){
			return jo;
		}
		JSONArray ja=new JSONArray();
		for(int index=0;index<queryCols.length;index++) {
			ja.add(queryCols[index]);
		}
		jo.put("queryCols", ja);
		return jo;
	}
	
	/**
	 * 获取接口
	 * @param ctx
	 * @return
	 * @throws BOSException 
	 */
	protected IOutInterfaceDynamicBillFacade getInstance(Context ctx) throws BOSException {
		return OutInterfaceDynamicBillFacadeFactory.getLocalInstance(ctx);
	}
	
//	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException {
		String[] slor = getDataSelector();
		if(slor!=null) {
			JSONObject jo=JSONObject.parseObject(jsonStr);
			jsonStr=getJSONWithSlorStr(jo, slor).toJSONString();
		}
		return getInstance(ctx).getDataByID(jsonStr,this); 
	}
	
//	@Override
	public JSONObject getDataByNum(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException {
		String[] slor = getDataSelector();
		if(slor!=null) {
			JSONObject jo=JSONObject.parseObject(jsonStr);
			jsonStr=getJSONWithSlorStr(jo, slor).toJSONString();
		}
		return getInstance(ctx).getDataByNumber(getJSONStrWithBosType(jsonStr),this); 
	}
	
	protected String[] getDataSelector() {
		return null;
	}
	
	protected String[] getListSelector() {
		return null;
	}

//	@Override
	public JSONObject getList(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException {
		JSONObject jo=JSONObject.parseObject(jsonStr);
		String[] slor = getListSelector();
		if(slor!=null) {
//			jo=JSONObject.parseObject(jsonStr);
			jo=getJSONWithQueryCols(jo,getListSelector());
		}
		String queryStr=getListQueryStr(ctx,jo);
		if(queryStr!=null) {
			jo=getJSONWithQueryStr(jo, queryStr);
		}
		String sortStr=getSortStr(jo);
		if(sortStr!=null){
			jo.put("queryStr", jo.getString("queryStr")+" "+sortStr);
		}
		
		String queryInfo=getQueryInfo();
		if(queryInfo!=null) {
			jo.put("queryInfo", queryInfo);
		}
		jo.put("bosType", getBosType());
		jo.put("replaceSplitStr","_");
		return getInstance(ctx).getBillList(jo.toString()); 
	}

	/**
	 * 自定义query
	 * @return
	 */
	protected String getQueryInfo() {
		return null;
	}

	/**
	 * 排序字符串
	 * @param jo
	 * @return
	 */
	protected String getSortStr(JSONObject jo) {
		return null;
	}

	public JSONObject uploadData(Context ctx, String jsonStr,IDynamicDeal ideal) throws BOSException, EASBizException, RemoteException {
		// TODO Auto-generated method stub
		return getInstance(ctx).uploadDataByBosType(getBosType(), jsonStr,ideal);
	}
	
//	@Override
	public JSONObject uploadData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException {
		// TODO Auto-generated method stub
		JSONObject jo=getInstance(ctx).uploadDataByBosType(getBosType(), jsonStr,this);
		if(jo.getString("result").equals("0")&&jo.containsKey("id")) {
			JSONObject tempJO=new JSONObject();
			tempJO.put("id", jo.getString("id"));
			tempJO.put("number", jo.getString("number"));
			jo.put("data",tempJO);
		}
		try {
			dealAfterUploadData(ctx,jo);
		}catch(Exception err) {
			JSONObject tempJO=new JSONObject();
			tempJO.put("result", "1");
			tempJO.put("message", err.getCause().getMessage());
			return tempJO;
		}
		return jo;
	}
	/**
	 * 上传完后执行
	 * @param jo
	 * @return
	 */
	protected JSONObject dealAfterUploadData(Context ctx,JSONObject jo) {
		return jo;
	}
	
//	@Override
	public JSONObject auditData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException {
		return getInstance(ctx).exeFunciton(getFunctionJSONStrWithStr(jsonStr, OutDynamicConstant.OP_AUDIT));
	}

//	@Override
	public JSONObject unAuditData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException {
		return getInstance(ctx).exeFunciton(getFunctionJSONStrWithStr(jsonStr, OutDynamicConstant.OP_UNAUDIT));
	}
	
	public JSONObject deleteData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException {
		// TODO Auto-generated method stub
		return getInstance(ctx).deleteData(getJSONStrWithBosType(jsonStr));
	}
	
//	@Override
	public JSONObject chekPwd(Context ctx, String jarrayStr) throws BOSException, EASBizException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	


//	@Override
	public JSONObject getAttachment(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
	public JSONObject getEnumInfo(Context ctx, String jarrayStr) throws BOSException, EASBizException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 解析完成Info,系统保存之后执行
	 * 在此可以执行提交，审核，下推等操作
	 */
	@Override
	public void dealAfterSave(Context ctx,CoreBaseInfo model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 解析完成Info,系统保存之前执行
	 * 在此可以数数据进行补充完整
	 */
	@Override
	public CoreBaseInfo dealBeforeSave(Context ctx,CoreBaseInfo model) throws BOSException, EASBizException {
		return model;
	}

//	@Override
	public JSONObject exeFunction(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 更新数据
	 * @param ctx
	 * @param jsonStr
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public JSONObject updateData(Context ctx,String jsonStr) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 获取更新selector
	 * @return
	 */
	protected String[] getUpdateSelector() {
		return null;
	}

	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		// TODO Auto-generated method stub
		return model;
	}
	
	

}
