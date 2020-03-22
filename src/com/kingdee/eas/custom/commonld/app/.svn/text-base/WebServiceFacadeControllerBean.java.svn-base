package com.kingdee.eas.custom.commonld.app;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.WebServiceUtil;
//import com.kingdee.eas.custom.commonld.comm.FoodFacatoryConstants;
import com.kingdee.eas.custom.commonld.comm.FoodFacatoryConstants;
import com.kingdee.eas.custom.commonld.comm.WebServiceComm;
import com.kingdee.eas.custom.wlhllicensemanager.util.WlhlDynamicBillUtils;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class WebServiceFacadeControllerBean extends AbstractWebServiceFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.commonld.app.WebServiceFacadeControllerBean");

	protected String [] slorList = null;
	protected JSONArray slor = new JSONArray();
	protected JSONObject entryJson = new JSONObject();
	protected String bosType = null;


	//创建新的表单
	protected String _createNewBill(Context ctx, String param)
	{
		//定义一个JSON对象
		JSONObject resultJson=new JSONObject();
		resultJson.put("result", true);
		try {
			param = beforeDealWithBill(param);
			//String转JSONobject类型
			JSONObject jo=JSONObject.fromObject(param);
			String bosType= jo.getString("bosType");
			beforeCreateNewBill(ctx,jo.getJSONObject("data"),entryJson);
			IObjectPK pk = new WlhlDynamicBillUtils().uploadDataByBosType(ctx, bosType,jo.getJSONObject("data").toString(),null);
			afterCreateNewBill(ctx,pk,entryJson);
			resultJson.put("id",pk.toString());
		} catch (EASBizException e) {
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			System.out.println(resultJson.toString());
			return resultJson.toString();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			System.out.println(resultJson.toString());
			return resultJson.toString();
		}
		return resultJson.toString();
	}


	/**
	 * 获取单据详细信息
	 */
	protected String _getBillDetailInfo(Context ctx, String param)  
	{

		JSONObject resultJson=new JSONObject();
		resultJson.put("result", true);
		try {
			param = beforeDealWithBill(param);
			//把String转化为JSONObject格式
			JSONObject paramJson = JSONObject.fromObject(param);
			if(!paramJson.containsKey("bosType") || StringUtils.isEmpty(paramJson.getString("bosType"))){
				paramJson.put("bosType", BOSUuid.read(paramJson.getString("id")).getType().toString());
			}
			if(slorList == null){
				slorList = WebServiceComm.getSlorList(ctx, paramJson.getString("bosType"), "", new ArrayList<String>());
			}
			initSlorList(slorList);
			paramJson.put("slor",slor);
			resultJson.put("data", new WlhlDynamicBillUtils().getDataByID(ctx, paramJson.toString()));
		} catch (EASBizException e) {
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			return resultJson.toString();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			return resultJson.toString();
		}
		return resultJson.toString();
	}
	/*
	 * 得到单据列表(non-Javadoc)
	 * @see com.kingdee.eas.custom.commonld.app.AbstractWebServiceFacadeControllerBean#_getBillList(com.kingdee.bos.Context, java.lang.String)
	 */
	protected String _getBillList(Context ctx, String param)
	{
		JSONObject resultJson=new JSONObject();
		resultJson.put("result", true);


		param = beforeDealWithBill(param);
		JSONObject fromObject = JSONObject.fromObject(param);

		JSONObject fJson = JSONObject.fromObject(param);
		fJson.put("bosType", fromObject.getString("bosType"));

		if(fromObject.containsKey("beginRow"))
			fJson.put("beginRow", fromObject.getInt("beginRow"));
//		if(!fromObject.containsKey("endRow"))
//			fJson.put("endRow", Integer.MAX_VALUE);
		//20190309 macheng 分页
		if(fromObject.containsKey("endRow")) {
			fJson.put("endRow", fromObject.getInt("endRow"));			
		}

		if(fromObject.containsKey("queryStr"))
			fJson.put("queryStr", fromObject.get("queryStr").toString());
		else
			fJson.put("queryStr", " id is not null");
		try {
			String downloadBillList = WebServiceUtil.downloadBillList(ctx, fJson.toString());
			return downloadBillList;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			return resultJson.toString();
		}
	}
	protected String beforeDealWithBill(String param) {
		// TODO Auto-generated method stub
		return param;
	}


	/**
	 * 删除单据
	 */
	protected String _deleteBill(Context ctx, String param)
	{
		JSONObject resultJson = new JSONObject();
		resultJson.put("result",true);

		param = beforeDealWithBill(param);
		JSONObject json=JSONObject.fromObject(param);
		String bosType = json.getString("bosType");
		EntityObjectInfo eo = getEntityObject(ctx, bosType);
		ICoreBase is;
		try {
			is = getLocalInstance(ctx, eo);
			IObjectPK pk = new ObjectUuidPK(json.getString("id"));
			is.delete(pk);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			return resultJson.toString();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			return resultJson.toString();
		}
		return resultJson.toString();
	}
	//建完新的表单之后
	protected void afterCreateNewBill(Context ctx, IObjectPK pk,
			JSONObject entryJson) throws BOSException, EASBizException {
		// TODO Auto-generated method stub

	}
	//建立新的表单之前
	protected void beforeCreateNewBill(Context ctx, JSONObject dataJson,
			JSONObject entryJson) {
		// TODO Auto-generated method stub
		checkBillBeforeCreate(ctx,dataJson,entryJson);
	}
	protected void checkBillBeforeCreate(Context ctx, JSONObject dataJson,
			JSONObject entryJson2) {
		// TODO Auto-generated method stub
		
	}


	private EntityObjectInfo getEntityObject(Context ctx,String bosType) {
		IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
		EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(bosType));
		return eo;
	}

	public static ICoreBase getLocalInstance(Context ctx,EntityObjectInfo eo) throws BOSException {
		ICoreBase iCoreBase = null;
		try {
			Class cls = Class.forName(eo.getBusinessImplFactory());
			Method mtd = cls.getMethod("getLocalInstance", new Class[] {com.kingdee.bos.Context.class });
			iCoreBase = (ICoreBase) mtd.invoke(cls, new Object[] { ctx });
		} catch (Exception e) {
			throw new BOSException(e);
		}
		return iCoreBase;
	}
	/**
	 * 初始化slor
	 * @param slorArray2 
	 */
	protected void initSlorList(String[] slorArray2){
		if(slorList == null){
			slor.add("*");
			return;
		}
		for(int i=0;i<slorList.length;i++){
			if(!slor.contains(slorList[i])){
				slor.add(slorList[i]);
			}
		}
	}


	@Override
	protected String _getRptData(Context ctx, String param)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		JSONObject fromObject = JSONObject.fromObject(param);
		String rptType = fromObject.getString("rptType");
		if(rptType.equalsIgnoreCase("pinpai")){
			String brandType = fromObject.getString("brandType");
			JSONObject checkPermission = checkPermission(ctx,fromObject,rptType,brandType);
			if(!checkPermission.getBoolean("result")){
				return "{\"result\":\"false\",\"reason\":\"权限不足\"}";
			}
			return FoodFacatoryConstants.getPinPaiRpt(ctx,fromObject);
		}
		return null;
	}

	/**
	 * 权限校验
	 * @param ctx
	 * @param fromObject
	 * @param brandType 
	 * @param string 
	 */
	private JSONObject checkPermission(Context ctx, JSONObject fromObject,String rptType, String brandType) {
		// TODO Auto-generated method stub
		JSONObject resultJson = new JSONObject();
		resultJson.put("result",false);

		String rptDbID = "";
		String userNum = fromObject.getString("userNum");
		if(rptType.equalsIgnoreCase("pinpai")){
			if(brandType.equalsIgnoreCase("XiongYing")){
				rptDbID = "75QAAAENHzsae/PX";
			}else if(brandType.equalsIgnoreCase("QiangYing")){
				rptDbID = "75QAAAENHqwae/PX";
			}else if(brandType.equalsIgnoreCase("JingYing")){
				rptDbID = "75QAAAENHzwae/PX";
			}else if(brandType.equalsIgnoreCase("BigBang")){
				rptDbID = "75QAAAENHz0ae/PX";
			}else if(brandType.equalsIgnoreCase("All")){
				rptDbID = "75QAAAENH/wae/PX";
			}
		}

		if(StringUtils.isEmpty(rptDbID) || StringUtils.isEmpty(userNum)){
			return resultJson;
		}

		//当前用户是否拥有该权限
		IRowSet rs;
		try {
			String company = "";
			rs = DbUtil.executeQuery(ctx,"select distinct t2.FID,t1.FCompanyID from T_RPT_RptPermissionEntry t1 inner join T_RPT_RptPermission t2 on t2.FID=t1.FParentID inner join T_PM_User t3 on t3.FID=t1.FUserID where t3.FNumber=? and t2.FRptID=?",new Object[]{userNum,rptDbID});
			if(rs.size() > 0)
				resultJson.put("result",true);
			if(rs.next()){
				if(StringUtils.isNotEmpty(rs.getString("FCompanyID"))){
					if(StringUtils.isNotEmpty(company)){
						company +=",";
					}
					company += "'"+rs.getString("FCompanyID")+"'";
				}
			}
			resultJson.put("company",company);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return resultJson;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return resultJson;
		}
		return resultJson;
	}


	@Override
	protected String _uploadBillWithArray(Context ctx, String param)
			throws BOSException {
		//定义一个JSON对象
		JSONObject resultJson=new JSONObject();
		resultJson.put("result", true);
		try {
			IObjectPK[] pk = new WlhlDynamicBillUtils().uploadDataWithArray(ctx, bosType,param);
			StringBuffer result = new StringBuffer();
			for(int i=0;i<pk.length;i++){
				result.append(pk[i].toString()).append("\n");
			}
			resultJson.put("id",result.toString());
		} catch (EASBizException e) {
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			System.out.println(resultJson.toString());
			return resultJson.toString();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			System.out.println(resultJson.toString());
			return resultJson.toString();
		}
		return resultJson.toString();
	}


	private Object StringBuffer() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected String _otherMethord(Context ctx, String param)
			throws BOSException {
		// TODO Auto-generated method stub
		return null;
	}
}