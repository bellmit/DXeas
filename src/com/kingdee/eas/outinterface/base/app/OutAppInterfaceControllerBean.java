package com.kingdee.eas.outinterface.base.app;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.activation.DataHandler;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.wlhllicensemanager.DynamicFacadeFactory;
import com.kingdee.eas.outinterface.base.utils.ResultUtils;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

@Component
public class OutAppInterfaceControllerBean extends AbstractOutAppInterfaceControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.custom.baseapp.app.WSAppInterfaceControllerBean");

	
	/**
	 * 根据用户编码获取名称
	 * @param ctx
	 * @param userNum
	 * @return
	 * @throws BOSException 
	 */
	public static IObjectPK getUserIdByNum(Context ctx,String userNum) throws Exception {
		IRowSet rs = DbUtil.executeQuery(ctx, "select fid from t_pm_user where fnumber=?",new Object[]{userNum});
		if(rs.next()) {
			return new ObjectUuidPK(rs.getString("fid"));
		}
		throw new Exception("用户不存在！");
	}

	@Override
	public String _getData(Context ctx, String jarrayStr) throws BOSException, EASBizException {
		Object obj = JSON.parse(jarrayStr);
		try {
			if (obj instanceof JSONArray) {
				JSONArray resultJSONArray = new JSONArray();

				JSONArray jarray = (JSONArray) obj;
				for (int index = 0; index < jarray.size(); index++) {
					JSONObject jo = jarray.getJSONObject(index);
					String jstr = getMethodResult(ctx, "getData", jo);
					resultJSONArray.add(JSONObject.parseObject(jstr));
				}
				return resultJSONArray.toJSONString();
			} else {
				JSONObject jo = (JSONObject) obj;
				String jstr= getMethodResult(ctx, "getData", jo);
				return jstr;
			}
		} catch (Exception e) {
			throw new BOSException(e);
		}
	}
	
	
	
	/**
	 * 更新数据
	 */
	
	@Override
	protected String _updateData(Context ctx, String jsonStr) throws BOSException, EASBizException {
		Object obj = JSON.parse(jsonStr);
		try {
			if (obj instanceof JSONArray) {
				JSONArray resultJSONArray = new JSONArray();

				JSONArray jarray = (JSONArray) obj;
				for (int index = 0; index < jarray.size(); index++) {
					JSONObject jo = jarray.getJSONObject(index);
					String jstr = getMethodResult(ctx, "updateData", jo);
					resultJSONArray.add(JSONObject.parseObject(jstr));
				}
				return resultJSONArray.toJSONString();
			} else {
				JSONObject jo = (JSONObject) obj;
				String jstr= getMethodResult(ctx, "updateData", jo);
				return jstr;
			}
		} catch (Exception e) {
			throw new BOSException(e);
		}
	}

	@Override
	public String _getDataByNum(Context ctx, String jarrayStr) throws BOSException, EASBizException {
		Object obj = JSON.parse(jarrayStr);
		try {
			if (obj instanceof JSONArray) {
				JSONArray resultJSONArray = new JSONArray();

				JSONArray jarray = (JSONArray) obj;
				for (int index = 0; index < jarray.size(); index++) {
					JSONObject jo = jarray.getJSONObject(index);
					String jstr = getMethodResult(ctx, "getDataByNum", jo);
					resultJSONArray.add(JSONObject.parseObject(jstr));
				}
				return resultJSONArray.toJSONString();
			} else {
				JSONObject jo = (JSONObject) obj;
				String jstr= getMethodResult(ctx, "getDataByNum", jo);
				return jstr;
			}
		} catch (Exception e) {
			throw new BOSException(e);
		}
	}

	@Override
	public String _getEnumInfo(Context ctx, String jarrayStr) throws BOSException, EASBizException {
		Object obj = JSON.parse(jarrayStr);
		try {
			if (obj instanceof JSONArray) {
				JSONArray resultJSONArray = new JSONArray();

				JSONArray jarray = (JSONArray) obj;
				for (int index = 0; index < jarray.size(); index++) {
					JSONObject jo = jarray.getJSONObject(index);
					String jstr = DynamicFacadeFactory.getLocalInstance(ctx).getEumInfo(jo.toJSONString());
					resultJSONArray.add(JSONObject.parseObject(jstr));
				}
				return resultJSONArray.toJSONString();
			} else {
				JSONObject jo = (JSONObject) obj;
				String jstr = DynamicFacadeFactory.getLocalInstance(ctx).getEumInfo(jo.toJSONString());
				return jstr;
			}
		} catch (Exception e) {
			throw new BOSException(e);
		}
	}

	/**
	 * 获取类路径
	 * @param jo
	 * @return
	 * @throws ClassNotFoundException
	 */
	private static Class getFunctionClass(JSONObject jo) throws ClassNotFoundException {
		String patch="impl";
		if(jo.containsKey("_EAS_BIZ_PATH_")) {
			patch=jo.getString("_EAS_BIZ_PATH_");
		}
		Class cls=null;
		try {
			cls=Class.forName("com.kingdee.eas.outinterface."+patch+"Ex");
		}catch(Exception err){
			cls=Class.forName("com.kingdee.eas.outinterface."+patch);
		}
		return cls;
	}
	
	/**
	 * 
	 * 调用方法获取结果
	 * @param ctx
	 * @param methodName
	 * @param jo
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	private static String getMethodResult(Context ctx,String methodName,JSONObject jo) throws SecurityException, NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Class cls =getFunctionClass(jo);
		Method mtd = cls.getMethod(methodName, new Class[] { com.kingdee.bos.Context.class, String.class });
		Object obj =  mtd.invoke(cls.newInstance(), new Object[] { ctx, jo.toJSONString() });
		return obj.toString();
	}

	@Override
	public String _getList(Context ctx, String jarrayStr) throws BOSException, EASBizException {
		Object obj = JSON.parse(jarrayStr);
		try {
			if (obj instanceof JSONArray) {
				JSONArray resultJSONArray = new JSONArray();
				JSONArray jarray = (JSONArray) obj;
				for (int index = 0; index < jarray.size(); index++) {
					JSONObject jo = jarray.getJSONObject(index);
					String jstr = getMethodResult(ctx, "getList", jo);
					resultJSONArray.add(JSONObject.parseObject(jstr));
				}
				return resultJSONArray.toJSONString();
			} else {
				JSONObject jo = (JSONObject) obj;
				String jstr = getMethodResult(ctx, "getList", jo);
				return jstr;
			}
		} catch (Exception e) {
			throw new BOSException(e);
		}
	}

	@Override
	public String _exeFunction(Context ctx, String jsonStr) throws BOSException, EASBizException {
		Object obj = JSON.parse(jsonStr);
		try {
			if (obj instanceof JSONArray) {
				JSONArray resultJSONArray = new JSONArray();
				JSONArray jarray = (JSONArray) obj;
				for (int index = 0; index < jarray.size(); index++) {
					JSONObject jo = jarray.getJSONObject(index);
					String jstr = getMethodResult(ctx, "_functionName_", jo);
					resultJSONArray.add(JSONObject.parseObject(jstr));
				}
				return resultJSONArray.toJSONString();
			} else {
				JSONObject jo = (JSONObject) obj;
				String jstr = getMethodResult(ctx,jo.getString("_functionName_"), jo);
				return jstr;
			}
		} catch (Exception e) {
			throw new BOSException(e);
		}
	}

	@Override
	public String _uploadData(Context ctx, String jarrayStr) throws BOSException, EASBizException {
		Object obj = JSON.parse(jarrayStr);
		try {
			if (obj instanceof JSONArray) {
				JSONArray resultJSONArray = new JSONArray();
				JSONArray jarray = (JSONArray) obj;
				for (int index = 0; index < jarray.size(); index++) {
					JSONObject jo = jarray.getJSONObject(index);
					String jstr = getMethodResult(ctx, "uploadData", jo);
					resultJSONArray.add(JSONObject.parseObject(jstr));
				}
				return resultJSONArray.toJSONString();
			} else {
				JSONObject jo = (JSONObject) obj;
				String jstr = getMethodResult(ctx, "uploadData", jo);
				return jstr;
			}
		} catch (Exception e) {
			throw new BOSException(e);
		}
	}
	@Override
	public String _uploadAttachment(Context ctx, String jarrayStr) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		return super._uploadAttachment(ctx, jarrayStr);
	}
	
	/**
	 * 上传附件
	 */
	 @Override
	 public String _uploadAttachment(Context ctx, DataHandler handler, String jarrayStr) throws BOSException {
		// TODO Auto-generated method stub
		return super._uploadAttachment(ctx, handler, jarrayStr);
	}

	
	@Override
	public String _deleteAttachment(Context ctx, String jsonStr) throws BOSException, EASBizException {
		return DynamicFacadeFactory.getLocalInstance(ctx).deleteAttachment(jsonStr);
	}

	@Override
	public String _getAttachment(Context ctx, String jsonStr) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		return super._getAttachment(ctx, jsonStr);
	}

	@Override
	public String _auditData(Context ctx, String jarrayStr) throws BOSException, EASBizException {
		Object obj = JSON.parse(jarrayStr);
		try {
			if (obj instanceof JSONArray) {
				JSONArray resultJSONArray = new JSONArray();
				JSONArray jarray = (JSONArray) obj;
				for (int index = 0; index < jarray.size(); index++) {
					JSONObject jo = jarray.getJSONObject(index);
					String jstr = getMethodResult(ctx, "auditData", jo);
					resultJSONArray.add(JSONObject.parseObject(jstr));
				}
				return resultJSONArray.toJSONString();
			} else {
				JSONObject jo = (JSONObject) obj;
				String jstr = getMethodResult(ctx, "auditData", jo);
				return jstr;
			}
		} catch (Exception e) {
			throw new BOSException(e);
		}
	}
	

	@Override
	public String _unAuditData(Context ctx, String jarrayStr) throws BOSException, EASBizException {
		Object obj = JSON.parse(jarrayStr);
		try {
			if (obj instanceof JSONArray) {
				JSONArray resultJSONArray = new JSONArray();
				JSONArray jarray = (JSONArray) obj;
				for (int index = 0; index < jarray.size(); index++) {
					JSONObject jo = jarray.getJSONObject(index);
					String jstr = getMethodResult(ctx, "unAuditData", jo);
					resultJSONArray.add(JSONObject.parseObject(jstr));
				}
				return resultJSONArray.toJSONString();
			} else {
				JSONObject jo = (JSONObject) obj;
				String jstr = getMethodResult(ctx, "unAuditData", jo);
				return jstr;
			}
		} catch (Exception e) {
			throw new BOSException(e);
		}
	}

	@Override
	public String _chekPwd(Context ctx, String jarrayStr) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		return super._chekPwd(ctx, jarrayStr);
	}

	@Override
	public String _deleteData(Context ctx, String jarrayStr) throws BOSException, EASBizException {
		Object obj = JSON.parse(jarrayStr);
		try {
			if (obj instanceof JSONArray) {
				JSONArray resultJSONArray = new JSONArray();
				JSONArray jarray = (JSONArray) obj;
				for (int index = 0; index < jarray.size(); index++) {
					JSONObject jo = jarray.getJSONObject(index);
					String jstr = getMethodResult(ctx, "deleteData", jo);
					resultJSONArray.add(JSONObject.parseObject(jstr));
				}
				return resultJSONArray.toJSONString();
			} else {
				JSONObject jo = (JSONObject) obj;
				String jstr = getMethodResult(ctx, "deleteData", jo);
				return jstr;
			}
		} catch (Exception e) {
			throw new BOSException(e);
		}
	}

	@Override
	public String _getAttachmentList(Context ctx, String jsonStr) throws BOSException, EASBizException {
		JSONObject resultJson = ResultUtils.getResultSuccess();
		
		JSONObject jsonParam=JSONObject.parseObject(jsonStr);
		//参数
		String billId = null,id=null;
		if(jsonParam.containsKey("billId")) {
			billId=jsonParam.getString("billId");
		}
		
		if(billId==null) {
			resultJson.put("result", "1");
			resultJson.put("message","id不能为空！");
			return resultJson.toJSONString();
		}

		StringBuffer sql=new StringBuffer();
		sql.append(" select ta.fid,ta.fsize,ta.FName_l2 fname,ta.fnumber,ta.fsimpleName,ta.ftype from T_BAS_BoAttchAsso tbo")
		.append(" inner join T_BAS_Attachment ta on ta.fid=tbo.FAttachmentID")
		.append(" where 1=1 ")
		.append(" and FBoId='").append(billId).append("'");

		JSONArray ja=new JSONArray();
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()) {
				JSONObject JO = new JSONObject();
				JO.put("id", rs.getString("fid"));
				JO.put("billId", id);
				JO.put("number", rs.getString("fnumber"));
				JO.put("name", rs.getString("FName"));
				JO.put("type", rs.getString("ftype"));
				JO.put("simpleName", rs.getString("fsimpleName"));
				JO.put("size", rs.getString("fsize"));
				ja.add(JO);
			}
		} catch (Exception e) {
			resultJson.put("result", "1");
			resultJson.put("message", e.getMessage());
		} 
		resultJson.put("data", ja);
		return resultJson.toJSONString();
	}

}