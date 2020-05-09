package com.kingdee.eas.outinterface.base.app;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import sun.misc.BASE64Encoder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.ctrl.data.modal.types.rows.OutputColumn;
import com.kingdee.bos.ctrl.data.modal.types.rows.OutputColumns;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.framework.DynamicObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.permission.UserCollection;
import com.kingdee.eas.base.permission.UserFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.outinterface.base.utils.AttachmentUtils;
import com.kingdee.eas.outinterface.base.utils.IDynamicDeal;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.outinterface.base.utils.OutDynamicBillUtils;
import com.kingdee.eas.outinterface.base.utils.ResultUtils;
import com.kingdee.eas.rpts.ctrlreport.bo.KSQLReportBO;
import com.kingdee.eas.rpts.ctrlsqldesign.data.DesignParameter;
import com.kingdee.eas.rpts.ctrlsqldesign.industry.InnerParam;
import com.kingdee.eas.rpts.ctrlsqldesign.model.CtrlDesignDataExecutor;
import com.kingdee.eas.rpts.ctrlsqldesign.model.CtrlDesignQueryModel;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class OutInterfaceDynamicBillFacadeControllerBean extends AbstractOutInterfaceDynamicBillFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.outinterface.base.app.OutInterfaceDynamicBillFacadeControllerBean");
    protected JSONObject _getDataByID(Context ctx, String jsonStr,IDynamicDeal ideal)throws BOSException, EASBizException
    {
        JSONObject json=ResultUtils.getResultSuccess();
    	try {
    		json.put("data", OutDynamicBillUtils.getDataByID(ctx, jsonStr,ideal));
    	}catch(Exception err) {
    		json.put("result", "1");
        	json.put("message", err.getMessage());
    	}
    	return json;
    }
    
    @Override
	protected JSONObject _getDataByNumber(Context ctx, String jsonStr,IDynamicDeal ideal) throws BOSException, EASBizException {
    	JSONObject json=ResultUtils.getResultSuccess();
    	try {
    		JSONObject querJson=JSONObject.parseObject(jsonStr);
    		if(!querJson.containsKey("bosType")) {
    			throw new Exception("bosType不能为空！");
    		}
    		if(!querJson.containsKey("number")) {
    			throw new Exception("number不能为空！");
    		}
    		json.put("data", OutDynamicBillUtils.getDataByNumber(ctx,jsonStr,ideal));
    	}catch(Exception err) {
    		json.put("result", "1");
        	json.put("message", err.getMessage());
    	}
    	return json;
	}
    @Override
    protected JSONObject _uploadDataByBosType(Context ctx, String bosType, String jsonStr,IDynamicDeal ideal)throws BOSException, EASBizException
    {
    	JSONObject json=ResultUtils.getResultSuccess();
    	try {
    		if(bosType==null) {
    			JSONObject tempJO=JSONObject.parseObject(jsonStr);
    			bosType=tempJO.getString("APP_BIZBOSTYPE_CONSTANT");
    		}
    		String id=OutDynamicBillUtils.uploadDataByBosType(ctx, bosType,jsonStr,ideal).toString();
    		if(StringUtils.isNotBlank(id)){
	    		IObjectValue ob=DynamicObjectFactory.getLocalInstance(ctx).getValue(new BOSObjectType(bosType), new ObjectUuidPK(id));
	    		json.put("number", ob.get("number"));
    		}
    		json.put("id", id);
    		
    	}catch(Exception err) {
    		json.put("result", "1");
        	json.put("message", err.getMessage());
    	}
    	return json;
    }
    
    /**
     * 更新数据
     */
    @Override
	protected JSONObject _updateData(Context ctx, String jsonStr) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    protected JSONObject _getBillList(Context ctx, String jsonStr)throws BOSException
    {
    	JSONObject json=ResultUtils.getResultSuccess();
    	try {
    		JSONObject queryJson=JSONObject.parseObject(jsonStr);
    		String bosType=queryJson.getString("bosType");
    		String queryStr=null;
    		if(queryJson.containsKey("queryStr")) {
    			queryStr=queryJson.getString("queryStr");
    		}
    		if(StringUtils.isBlank(queryStr)) {
    			queryStr="id is not null";
    		}
    		if(queryStr.trim().length()>5&&!queryStr.trim().substring(0, 5).equalsIgnoreCase("where")) {
        		queryStr="where "+queryStr;
    		}
    		
    		String queryInfo=null;
    		if(queryJson.containsKey("queryInfo")) {
    			queryInfo=queryJson.getString("queryInfo");
    		}
    		String[] queryCols=null;
    		if(queryJson.containsKey("queryCols")) {
    			queryCols=new String[queryJson.getJSONArray("queryCols").size()];
    			for(int index=0;index<queryCols.length;index++) {
    				queryCols[index]=queryJson.getJSONArray("queryCols").getString(index);
    			}
    		}
    		int beginRow=0,rowCount=1000;
    		if(queryJson.containsKey("beginRow")) {
    			beginRow=Integer.valueOf(queryJson.getString("beginRow"));
    		}
    		if(queryJson.containsKey("rowLength")) {
    			rowCount=Integer.valueOf(queryJson.getString("rowLength"));
    		}
    		boolean isReplaceSplit=false;
    		isReplaceSplit=JUtils.getBoolean(queryJson, "isReplaceSplit");
    		String replaceSplitStr=JUtils.getString(queryJson, "replaceSplitStr");
    		if(isReplaceSplit&&replaceSplitStr==null) {
    			replaceSplitStr="_";
    		}
    		
    		json.put("data",OutDynamicBillUtils.getBillList(ctx, bosType, queryInfo, queryStr, queryCols, beginRow, rowCount,replaceSplitStr));
    	}catch(Exception err) {
    		json.put("result", "1");
        	json.put("message", err.getMessage());
    	}
    	return json;
    }
    
	@Override
	protected JSONObject _getEumInfo(Context ctx, String jsonStr) throws BOSException, EASBizException {
		JSONObject json=ResultUtils.getResultSuccess();
	    	try {
	    		JSONObject queryJson=JSONObject.parseObject(jsonStr);
	    		String enumPath=queryJson.getString("enumPath");
	    		json.put("data", OutDynamicBillUtils.getEnumArray(ctx, enumPath));
	    	}catch(Exception err) {
	    		json.put("result", "1");
	        	json.put("message", err.getMessage());
	    	}
    	return json;
	}
	
	@Override
	protected JSONObject _uploadData(Context ctx, String bosType, String jsonStr,IDynamicDeal ideal) throws BOSException, EASBizException {
		JSONObject json=ResultUtils.getResultSuccess();
    	try {
    		IObjectPK[] pks = OutDynamicBillUtils.uploadDataWithArray(ctx, bosType,jsonStr,ideal);
    		String[] ids=new String[pks.length];
    		for(int index=0;index<pks.length;index++) {
    			ids[index]=pks[index].toString();
    		}
    		json.put("id", ids);
    	}catch(Exception err) {
    		logger.error(err);
    		json.put("result", "1");
        	json.put("message", err.getMessage());
    	}
    	return json;
	}
	@Override
	protected JSONObject _deleteData(Context ctx, String jsonStr) throws BOSException, EASBizException {
		JSONObject json=ResultUtils.getResultSuccess();
	    	try {
	    		JSONObject queryJson=JSONObject.parseObject(jsonStr);
	    		String bosType=queryJson.getString("bosType");
	    		String id=queryJson.getString("id");
	    		ICoreBase is = OutDynamicBillUtils.getLocalInstance(ctx, OutDynamicBillUtils.getEntityObject(ctx, bosType));
	    		//单张删除
	    		if(id!=null) {
	    			is.delete(new ObjectUuidPK(id));
	    		}
	    		if(queryJson.containsKey("Ids")) {
		    		//批量删除
		    		JSONArray ja=queryJson.getJSONArray("Ids");	
		    		if(ja.size()>0) {
		    			IObjectPK[] pks=new ObjectUuidPK[ja.size()];
			    		for(int index=0;index<pks.length;index++) {
			    			pks[index]=new ObjectUuidPK(ja.getString(index));
			    		}
			    	
		    			is.delete(pks);
		    			
		    		}
	    		}
	    		
	    		json.put("message", "delete success");
	    	}catch(Exception err) {
	    		json.put("result", "1");
	        	json.put("message", err.getMessage());
	    	}
    	return json;
	}
	
	@Override
	protected JSONObject _exeFunciton(Context ctx, String jsonStr) throws BOSException, EASBizException {
		JSONObject json=ResultUtils.getResultSuccess();
	    	try {
	    		JSONObject queryJson=JSONObject.parseObject(jsonStr);
	    		String bosType=queryJson.getString("bosType");
	    		String functionName=queryJson.getString("_functionName_");
	    		ICoreBase is = OutDynamicBillUtils.getLocalInstance(ctx, OutDynamicBillUtils.getEntityObject(ctx, bosType));
	    		Object obj=null;
    			exeFuncitonOther(ctx, jsonStr);
	    		json.put("message", String.valueOf(obj));
	    	}catch(Exception err) {
	    		json.put("result", "1");
	        	json.put("message", err.getMessage());
	    	}
    	return json;
	}
	
	protected JSONObject exeFuncitonOther(Context ctx, String jsonStr) throws BOSException, EASBizException {
		JSONObject json=ResultUtils.getResultSuccess();
	    	try {
	    		JSONObject queryJson=JSONObject.parseObject(jsonStr);
	    		String id=queryJson.getString("id");
	    		if(!BOSUuid.isValid(id, true)) {
	    			throw new Exception("id无效");
	    		}
	    		String bosType=BOSUuid.read(id).getType().toString();
	    		String functionName=queryJson.getString("_functionName_");
	    		Object[] paramValues=null;
	    		if(queryJson.containsKey("paramValues")) {
		    		JSONArray paramArray = queryJson.getJSONArray("paramValues");
		    		paramValues=new Object[paramArray.size()];
		    		for(int index=0;index<paramArray.size();index++) {
		    			paramValues[index]=paramArray.getString(index);
		    		}
	    		}
				Class<?>[] paramsTypes=null;
				if(queryJson.containsKey("paramsTypes")) {
					JSONArray paramArray = queryJson.getJSONArray("paramValues");
					paramsTypes=new Class<?>[paramArray.size()];
		    		for(int index=0;index<paramArray.size();index++) {
		    			paramsTypes[index]=Class.forName(paramArray.getString(index));
		    		}
				}
				Object result=OutDynamicBillUtils.exeFunciton(ctx, bosType, id, functionName, paramsTypes,paramValues);
	    		json.put("exeMsg", result!=null?result.toString():"success");
	    	}catch(Exception err) {
	    		json.put("result", "1");
	        	json.put("message", err.getMessage());
	    	}
    	return json;
	}
	
	/**
	 * 删除附件
	 */
	@Override
	protected JSONObject _deleteAttachment(Context ctx, String jsonStr) throws BOSException, EASBizException {
		JSONObject resultJson = ResultUtils.getResultSuccess();
    	
		JSONObject jsonParam=JSONObject.parseObject(jsonStr);

		String billId = jsonParam.getString("billId");
		String id = jsonParam.getString("id");

		Map map=null;
		try {
			AttachmentUtils is = new AttachmentUtils(ctx);
			map = is.deleteAttachment(billId, id);
			//不成功
			if(!(Boolean)map.get("success")) {
				throw new EASBizException(new NumericExceptionSubItem("",(String)map.get("message")));
			}
		} catch (Exception e) {
			resultJson.put("result", "1");
			resultJson.put("message", e.getMessage());
		} 
		return resultJson;
	}
	/**
	 * 获取附件数据
	 */
	@Override
	protected JSONObject _getAttachmentData(Context ctx, String jsonStr) throws BOSException, EASBizException {
		JSONObject resultJson = ResultUtils.getResultSuccess();
		
		JSONObject jsonParam=JSONObject.parseObject(jsonStr);
		//参数
		String billId = null,id=null;
		if(jsonParam.containsKey("billId")) {
			billId=jsonParam.getString("billId");
		}
		
		if(jsonParam.containsKey("id")) {
			id=jsonParam.getString("id");
		}
		
		if(billId==null&&id==null) {
			resultJson.put("result", "1");
			resultJson.put("message","id和billId不能同时为空！");
			return resultJson;
		}

		StringBuffer sql=new StringBuffer();
		sql.append(" select fid,FAttachmentid from T_BAS_BoAttchAsso")
		.append(" where 1=1 ");
		if(billId!=null) {
			sql.append(" and FBoId='").append(billId).append("'");
		}
		if(id!=null) {
			sql.append(" and FAttachmentid='").append(id).append("'");
		}

		String type="";//BILLATTACH
		JSONArray ja=new JSONArray();
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
//			WorkflowServerBSFInstance is = WorkflowServerBSFInstance.getInstance(ctx);
			AttachmentUtils is = new AttachmentUtils(ctx);
			BASE64Encoder encoder = new BASE64Encoder();
			while(rs.next()) {
				ja.add(encoder.encode(is.getAttachmentAsBytes(rs.getString("FAttachmentid"), type)));
			}
			resultJson.put("fileData", ja);
		} catch (Exception e) {
			resultJson.put("result", "1");
			resultJson.put("message", e.getMessage());
		} 
		return resultJson;
	}
	@Override
	protected JSONObject _getAttachmentList(Context ctx, String jsonStr) throws BOSException, EASBizException {
		JSONObject resultJson = new JSONObject();
		resultJson.put("result", "0");
		resultJson.put("message", "success");
		
		return resultJson;
	}
	/**
	 * 上传附件
	 */
	@Override
	protected JSONObject _uploadAttachment(Context ctx, String jsonStr) throws BOSException, EASBizException {
		JSONObject resultJson = ResultUtils.getResultSuccess();
		
		JSONObject jsonParam=JSONObject.parseObject(jsonStr);
		String userNumber = null;
		try{
			if(jsonParam.containsKey("userNum") && StringUtils.isNotBlank(jsonParam.getString("userNum"))){
				userNumber = jsonParam.getString("userNum");
				UserCollection ucoll = UserFactory.getLocalInstance(ctx).getUserCollection("where number='" + userNumber + "'");
				ContextUtil.setCurrentUserInfo(ctx, ucoll.get(0));
				ctx.setCaller(new ObjectUuidPK(ucoll.get(0).getId().toString()));
			}
		}catch (Exception e) {
			logger.error(e);
			resultJson.put("result", "1");
			resultJson.put("message", e.getMessage());
		}
		
		String boid = jsonParam.getString("billId");//URLDecoder
		Map m= new HashMap();//附件文件说明
		m.put("type", "getPicthur");
		m.put("fileName", jsonParam.getString("fileName"));
		m.put("fileExt", jsonParam.getString("fileExt"));
		String fileData = jsonParam.getString("fileData");//文件加密字符串 BASE64加密
		Map map = null;
		try {
			AttachmentUtils is = new AttachmentUtils(ctx);
			map = is.addAttachment(boid, m, fileData);
		} catch (Exception e) {
			resultJson.put("result", "1");
			resultJson.put("message", e.getMessage());
			logger.error(e);
		} 
		return resultJson;
	}
	@Override
	protected JSONObject _getRptData(Context ctx, String jsonStr) throws BOSException, EASBizException {
		JSONObject resultJson = ResultUtils.getResultSuccess();
		
		try {
			CtrlDesignQueryModel model=new CtrlDesignQueryModel();
			
			JSONObject json=JSONObject.parseObject(jsonStr);
			String id=json.getString("id");
			model=KSQLReportBO.initModel(ctx,null,null,null,id,null,null);
			if(model!=null) {
				//初始化查询参数
//				CtrlDesignUtil.toFilterSolutionXml((ArrayList) model.getCommonQuery().getParameters());
//				String parameterXmlString="";
//				HashMap mapDesignParameter= RunReportParam.ChangWhereValueToMapParams(parameterXmlString);
				HashMap mapDesignParameter=new HashMap();
				InnerParam.putClientDefalutListParamsMap(mapDesignParameter);

				JSONObject jo;
				//填充查询条件
				json=json.getJSONObject("params");
				//查询条件
				JSONArray queryParamsArray=new JSONArray();
				if(json!=null&&!json.isEmpty()) {
					for(int index=0;index< model.getCommonQuery().getParameters().size();index++) {
						DesignParameter d=(DesignParameter) model.getCommonQuery().getParameters().get(index);
						if(json.containsKey(d.getName())) {
							d.setCurentValue(json.getString(d.getName()));
							d.setCurentValueAlias(d.getAlias());
							mapDesignParameter.put(d.getName(), d);
						}
						//报表联查id
						if(d.getName().equalsIgnoreCase("relationId")) {
							resultJson.put("relationId", d.getDefaultValue());
						}
						//查询条件
						jo=new JSONObject();
						jo.put("name", d.getName());
						jo.put("alias", d.getAlias());
						jo.put("dataType", d.getDesignDataType()!=null?d.getDesignDataType().getName():null);
						queryParamsArray.add(jo);
					}
					model.getCommonQuery().getProperties();
				}
				//查询条件
				resultJson.put("queryParams", queryParamsArray);
				
				HashMap mapResult = CtrlDesignDataExecutor.execute(ctx, model,mapDesignParameter, null, 0, -1, true, null);
				IRowSet rs = (IRowSet)mapResult.get("6xx8xxRowset");
				JSONArray ja=new JSONArray();
				while(rs.next()) {
					jo=new JSONObject();
					for(int j=1;j<=rs.getMetaData().getColumnCount();j++) {
						jo.put(rs.getMetaData().getColumnName(j), rs.getString(j));
					}
					ja.add(jo);
				}
//				System.out.println(rs.size());
				resultJson.put("data", ja);
				//列信息
				JSONArray headJa=new JSONArray();
				for(int index=0;index<model.getCommonQuery().getOutputs().size();index++) {
					OutputColumns ds = (OutputColumns) model.getCommonQuery().getOutputs().get(index);
					for(int j=0;j<ds.size();j++) {
						jo=new JSONObject();
						jo.put("name", ((OutputColumn)ds.get(j)).getName());
						jo.put("alias", ((OutputColumn)ds.get(j)).getAlias());
						jo.put("dataType", ((OutputColumn)ds.get(j)).getDataType().getName());
						headJa.add(jo);
					}
				}
				resultJson.put("headColumns", headJa);
				
			}
		} catch (Exception e) {
			resultJson.put("result", "1");
			resultJson.put("message", e.getMessage());
		}
//		System.out.println("报表结果"+resultJson.toJSONString());
		return resultJson;
	}
}