package com.kingdee.eas.custom.workflow.app;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import sun.misc.BASE64Encoder;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.entity.DataType;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.LinkPropertyInfo;
import com.kingdee.bos.metadata.entity.OwnPropertyInfo;
import com.kingdee.bos.metadata.entity.PropertyInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.workflow.mobile.server.WorkflowServerBSFInstance;
import com.kingdee.eas.base.permission.UserFactory;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.workflow.util.FileCommUtils;
import com.kingdee.eas.custom.workflow.util.JUtils;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;



public class WSWorkFlowDADFacadeControllerBean extends AbstractWSWorkFlowDADFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.workflow.app.WSWorkFlowDADFacadeControllerBean");
	private HashMap<String, LinkedHashMap<String,Object>> entryPropMap=new HashMap<String,  LinkedHashMap<String,Object>>();//��¼����
//	private JSONObject entryPropMap=new JSONObject();
	private HashMap<String, LinkedList<HashMap<String,Object>>> entryValueMap=new HashMap<String,  LinkedList<HashMap<String,Object>>>();//��¼ֵ
	/**
	 * ����
	 * @param ctx
	 * @param map 
	 * 			Ԫ�أ�
	 * 			assignment ����id
	 * 			billId����id
	 * 			isproccloss
	 *			isAllowrepass �Ƿ��������´���
	 * 			opinion �������
	 * @param usetList ��������personid�б� personID
	 * @param opinionMap {"personIdList":["id1","id2"]} ������id/������id
	 * @param localMap ���ʻ�������Map {"zh","CN"}
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	protected String _passAssign(Context ctx, String param)
	{
		JSONObject jsonParam=JSONObject.fromObject(param);
		JSONObject resultJson = new JSONObject();
		resultJson.put("result", true);

		HashMap map = (HashMap)jsonParam.get("map");
		HashMap opinionMap = (HashMap)jsonParam.get("opinionMap");
		HashMap localMap = (HashMap)jsonParam.get("localMap");
		String[] usetList=(String[])jsonParam.get("usetList");
		try {
			WorkflowServerBSFInstance.getInstance(ctx).passAssign(map, usetList, opinionMap, localMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
		}
		return resultJson.toString();
	}
	/**
	 *  ��ѯ������Ϣ
	 * @param ctx
	 * @param billID ����id
	 * @param procInstId ����ʵ��Id
	 * @param personID ������id
	 * @return
	 * @throws BOSException
	 * @throws SQLException
	 * @throws UnsupportedEncodingException
	 */
	protected String _executeQueryForPassAssign(Context ctx, String param)
	{
		JSONObject jsonParam=JSONObject.fromObject(param);
		JSONObject resultJson = new JSONObject();
		resultJson.put("result", true);

		String billID=jsonParam.getString("billID");
		String personID=jsonParam.getString("personID");



		StringBuffer sql=new StringBuffer();
		sql.append(" select * from T_WFR_PassComment")
		.append(" where FbillId='").append(billID).append("'")//����id
		//.append(" and FprocInstId='").append(procInstId).append("'")//����ʵ��Id
		.append(" and (fuserID='").append(personID).append("'")//���������
		.append(" or FPERSONID='").append(personID).append("'")//������id
		.append(" or FInitiator='").append(personID).append("'")//������
		.append(" )");
		JSONArray ja=new JSONArray();
		JSONObject jo=new JSONObject();
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()) {
				jo.put("initiator", rs.getString("FInitiator"));//������
				jo.put("userID", rs.getString("FUserID"));//���������
				jo.put("createTime", rs.getTimestamp("FCreateTime"));//�������ʱ��
				jo.put("comment", rs.getString("FComment_l2"));//���
				jo.put("personID", rs.getString("FPERSONID"));//������id
				jo.put("personName", rs.getString("FPERSONNAME"));//������name
				jo.put("updateTime", rs.getTimestamp("FUPDATETIME"));//����ʱ��
				ja.add(jo);
			}
			resultJson.put("data", ja.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
		}
		return resultJson.toString();
	}
	/**
	 * 
	 * @param ctx
	 * @param id ����id
	 * @param type ��������
	 * @return  {"fileBytes":jsonArray} ����base64����
	 * @throws UnsupportedEncodingException 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	//protected String _getAttachmentAsBytes(Context ctx, String param)
//	{
//		JSONObject jsonParam=JSONObject.fromObject(param);
//		JSONObject resultJson = new JSONObject();
//		resultJson.put("result", true);
//
//		//����
//		String id = jsonParam.getString("id");
//
//		StringBuffer sql=new StringBuffer();
//		sql.append(" select fid from T_BAS_BillAttachment")
//		.append(" where FBillId=?")
//		;
//
//		String type="BILLATTACH";
//		JSONObject result=new JSONObject();
//		JSONArray ja=new JSONArray();
//		result.put("fileBytes", ja);
//		try {
//			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString(), new Object[]{id});
//			WorkflowServerBSFInstance is = WorkflowServerBSFInstance.getInstance(ctx);
//			BASE64Encoder encoder = new BASE64Encoder();
//			while(rs.next()) {
//				//ja.add(encoder.encode(is.getAttachmentAsBytes(id, type)));
//			}
//		} catch (SQLException e) {
//			resultJson.put("result", false);
//			resultJson.put("failReason", e.getMessage());
//			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
//		} catch (EASBizException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			resultJson.put("result", false);
//			resultJson.put("failReason", e.getMessage());
//			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			resultJson.put("result", false);
//			resultJson.put("failReason", e.getMessage());
//			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
//		} catch (BOSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			resultJson.put("result", false);
//			resultJson.put("failReason", e.getMessage());
//			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
//		}
//		resultJson.put("data", result.toString(0));
//		return resultJson.toString(0);
//	}
//	/**
//	 * �ϴ�����
//	 * @param ctx
//	 * @param boid URLDecoder
//	 * @param m �����ļ�˵��
//	 * 			Ԫ�أ�
//	 * 			type �� "getPicthur"
//	 * 			attatchid null
//	 * 			fileSize �ļ���С
//	 * 			fileName �ļ�����
//	 * 			fileExt �ļ���չ��
//	 * @param fileData �ļ������ַ��� BASE64����
//	 * @return JSON String {"success:"true/false}
//	 * @throws EASBizException
//	 * @throws BOSException
//	 * @throws IOException
//	 */
//	protected String _addAttachment(Context ctx, String param)
//	{
//		JSONObject jsonParam=JSONObject.fromObject(param);
//		JSONObject resultJson = new JSONObject();
//		resultJson.put("result", true);
//
//		String boid = jsonParam.getString("boid");
//		HashMap m= (HashMap) jsonParam.get("boid");
//		String fileData = jsonParam.getString("boid");
//
//		Map map = null;
//		try {
//			map = WorkflowServerBSFInstance.getInstance(ctx).addAttachment(boid, m, fileData);
//		} catch (EASBizException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			resultJson.put("result", false);
//			resultJson.put("failReason", e.getMessage());
//			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			resultJson.put("result", false);
//			resultJson.put("failReason", e.getMessage());
//			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
//		} catch (BOSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			resultJson.put("result", false);
//			resultJson.put("failReason", e.getMessage());
//			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
//		}
//		if(map!=null)
//			resultJson.put("data", map);
//
//		return resultJson.toString();
//	}
//	/**
//	 * ɾ������
//	 * @param ctx
//	 * @param billId ����Id
//	 * @param id ����id
//	 * @return JSON String {"success:"true/false}
//	 * @throws EASBizException
//	 * @throws BOSException
//	 * @throws IOException
//	 */
//	protected String _deleteAttachment(Context ctx, String param)
//	{
//		JSONObject jsonParam=JSONObject.fromObject(param);
//		JSONObject resultJson = new JSONObject();
//		resultJson.put("result", true);
//
//		String billId = jsonParam.getString("billId");
//		String id = jsonParam.getString("id");
//
//		Map map=null;
//		try {
//			map = WorkflowServerBSFInstance.getInstance(ctx).deleteAttachment(billId, id);
//		} catch (EASBizException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			resultJson.put("result", false);
//			resultJson.put("failReason", e.getMessage());
//			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
//		} catch (BOSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			resultJson.put("result", false);
//			resultJson.put("failReason", e.getMessage());
//			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
//		}
//		if(map!=null)
//			resultJson.put("data", map);
//		return resultJson.toString();
//	}
	/**�ύ����
	 * @param ctx
	 * @param assignID ������id
	 * @param ifpass �Ƿ�����ͨ�� 1������ͨ�� 0:������ͨ��
	 * @param listperSons ����null
	 * @param opinion ������� 
	 * @param policy ����ѡ�� Ĭ��Ϊ0(����ֵ��"ͬ��")
	 * @param editParam �����޸ı���json ,��������洫��Null
	 * 				ʾ�� [{"����id1","{"number":"123","bizDate":"2017-10-01"}"},{"����id2","{"number":"1234","bizDate":"2017-10-02"}"}]
	 * 				F7�������id
	 * @param billId ��������
	 * result json�ַ���{"success":true/false,"result":"�����ɹ�/������Ϣ"}
	 */
	protected String _submitApprove(Context ctx, String param)throws BOSException
	{
		JSONObject jsonParam=JSONObject.fromObject(param);
		JSONObject resultJson = new JSONObject();
		resultJson.put("result", true);

		String assignID = jsonParam.getString("assignID");
		String ifpass = jsonParam.getString("ifpass");
		ArrayList  listperSons=null;
		if(jsonParam.containsKey("listperSons")&&UIRuleUtil.isNotNull(jsonParam.get("listperSons"))&&!jsonParam.get("listperSons").toString().equals(""))
			 listperSons = (ArrayList) jsonParam.get("listperSons");
		String opinion = jsonParam.getString("opinion");
		String policy = jsonParam.getString("policy");
		String editParam = jsonParam.getString("editParam");
		String billId = jsonParam.getString("billId");
		String userName = jsonParam.getString("userName");//53PiGWiITpWcZVIjDm1nChO33n8=
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT FID FROM T_PM_USER WHERE FNUMBER='"+ userName +"'");
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
			String userId = "";
			if(rs.next()){
				userId = rs.getString("FID");
			}
			UserInfo userInfo = UserFactory.getLocalInstance(ctx).getUserInfo(new ObjectUuidPK(userId));
			ContextUtil.setCurrentUserInfo(ctx, userInfo);
			ctx.setCaller(new ObjectUuidPK(userId));
			
			Map map= WorkflowServerBSFInstance.getInstance(ctx).submitApprove(assignID, ifpass, listperSons, opinion, policy);
			
			if(map!=null)
				resultJson.put("data", map);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultJson.toString();
		

	}
	/**
	 * ��þ���ֵ
	 * @param ctx
	 * @param assignID ����id
	 * @param ifPass 1����ͨ����0������ͨ��
	 * @return {result=0,ͬ��,;}
	 * @throws Exception 
	 */
	protected String _getSelectPolicy(Context ctx, String param)throws BOSException
	{
		JSONObject jsonParam=JSONObject.fromObject(param);
		JSONObject resultJson = new JSONObject();
		resultJson.put("result", true);

		String assignID = jsonParam.getString("assignID");
		String ifPass = jsonParam.getString("ifPass");

		Map map=null;
		try {
			map = WorkflowServerBSFInstance.getInstance(ctx).getSelectPolicy(assignID,ifPass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(map!=null)
			resultJson.put("data", map);
		return resultJson.toString();

	}
	/**
	 * ��ȡ����ժҪ --��̬��������
	 * @param ctx
	 * @throws BOSException 
	 */
	public String _getBillDigest(Context ctx, String param)throws BOSException
	{
		JSONObject jsonParam=JSONObject.fromObject(param);
		JSONObject resultJson = new JSONObject();
		resultJson.put("result", true);

		String billID = jsonParam.getString("billID");

		BOSObjectType bosType = BOSUuid.read(billID).getType();
		IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
		IMetaDataPK te=loader.getEntityObjectPK(bosType);

		EntityObjectInfo eo = getEntityObject(ctx, bosType.toString());
		
		HashMap<String, LinkedHashMap<String,Object>> entryPropMap=new HashMap<String,  LinkedHashMap<String,Object>>();//��¼����
		//��ѯ����
		SelectorItemCollection selector=new SelectorItemCollection();

		StringBuffer sql=new StringBuffer();
		sql.append(" select * from T_WM_BillDigest ")
		.append(" where FMetadataPK='").append(te.getFullName()).append("'")
		.append(" order by FIndex asc");
		JSONObject dataJSON=new JSONObject();
		JSONObject jo;
		String propGroup,proName;
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()) {
				propGroup=rs.getString("FPropertyGroup");
				proName=rs.getString("FPropertyName");
				
				selector.add(proName);

				jo=new JSONObject();
				jo.put("propertyGroup", propGroup);//����
				jo.put("propertyName", proName);//�ֶ�������
				jo.put("index", rs.getInt("Findex"));//˳��
				jo.put("showFormate", rs.getString("FShowFormate"));//��ʾ��ʽ
				jo.put("editable", rs.getString("FEditable"));//�Ƿ���޸�
				jo.put("displayName", rs.getString("FAlias_l2"));//��ʾ����
				jo.put("value", "");//ֵ
				jo.put("dataType", "");
				//�Ƿ�¼
				if(StringUtils.isBlank(propGroup)) {
					if(StringUtils.isNotBlank(proName)) {
						dataJSON.put(proName, jo);
					}
				}
				//��¼
				else {
					if(!entryPropMap.containsKey(propGroup)){
						entryPropMap.put(propGroup, new LinkedHashMap<String,Object>());
					}
					if(StringUtils.isNotBlank(proName)) {
						selector.add(propGroup + "." + proName);
						entryPropMap.get(propGroup).put(proName,jo.toString());
					}
				}
			}
		} catch (Exception e) {
			throw new BOSException(e);
		}

		//������*************
//		selector.add("creator.name");
//		selector.add("number");
//		selector.add("Entrys.weighBillType");
//		selector.add("Entrys.isAuto2Inv");
//		dataJSON.put("creator.name", new JSONObject());
//		dataJSON.put("number", new JSONObject());
//		
//		entryPropMap.put("Entrys", new LinkedHashMap<String,Object>());
//		((LinkedHashMap)entryPropMap.get("Entrys")).put("weighBillType", new JSONObject());
//		((LinkedHashMap)entryPropMap.get("Entrys")).put("isAuto2Inv", new JSONObject());
		//*********************
		
		ICoreBase is = getLocalInstance(ctx, eo);
		CoreBaseInfo info = null;
		try {
			info = is.getValue(new ObjectUuidPK(billID),selector);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String proValue;
		//��ͷֵ���
		Iterator itr = dataJSON.keys();
		while(itr.hasNext()){
			proName=(String) itr.next();
			proValue=getValueByProName(ctx,info,proName,eo);
			dataJSON.getJSONObject(proName).put("value", proValue);
		}
		
		//��¼ֵ���
		itr=entryPropMap.entrySet().iterator();
		Map.Entry<String,LinkedHashMap<String,Object>> entry;
		Iterator itr2;//��¼����
		EntityObjectInfo tempeo;
		IObjectCollection tempCols;
		JSONObject tempJO;
		JSONArray tempJA,entrysJA=new JSONArray();
		while(itr.hasNext()) {
			entry= (Entry<String, LinkedHashMap<String,Object>>) itr.next();
			propGroup=entry.getKey();//��¼����
			
			jo=new JSONObject();
			jo.put("columns",entry.getValue());
			tempJA=new JSONArray();//��¼��
			//��¼info����
			tempeo = ((LinkPropertyInfo)eo.getPropertyByName(propGroup)).getRelationship().getSupplierObject();
			tempCols=(IObjectCollection) info.get(propGroup);
			for(int j=0;j<tempCols.size();j++) {
				tempJO=new JSONObject();
				//��¼�ֶ�
				itr2=entry.getValue().keySet().iterator();
				tempJO.put("dateType","entry");
				tempJO.put("index",j);
				while(itr2.hasNext()) {
					proName=(String)itr2.next();
					proValue=getValueByProName(ctx, tempCols.getObject(j),proName, tempeo);
					tempJO.put(proName, proValue);
//					tempJO.put("propertyName", proName);
//					tempJO.put("value", proValue);
				}
				tempJA.add(tempJO);
			}
			jo.put("values",tempJA);
			jo.put("entryName",propGroup);
			//��¼���ԡ�ֵ
//			dataJSON.put(propGroup,jo);
			entrysJA.add(jo);//modify
		}
		dataJSON.put("entrysArray",entrysJA);//modify
		
		if(StringUtils.isNotBlank(dataJSON.toString())){
			resultJson.put("data", dataJSON.toString());
			System.out.println(resultJson.toString());
		}
		return resultJson.toString();
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

	private EntityObjectInfo getEntityObject(Context ctx,String bosType) {
		IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
		EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(bosType));
		return eo;
	}
	
	/**
	 * ��ȡ����ֵ
	 * @param model
	 * @param proName
	 * @return
	 */
	private String getValueByProName(Context ctx,IObjectValue model ,String orgProName,EntityObjectInfo eo) {
		//��ȡ��һ������
		int index=orgProName.indexOf(".");
		String proName=index>=0?orgProName.substring(0,index):orgProName;
		//��������
		if(eo.getPropertyByName(proName) instanceof LinkPropertyInfo) {
			if(model.get(proName) instanceof IObjectCollection) {
				return " ��֧���ӷ�¼";
			}else if(model.get(proName) instanceof IObjectValue) {
				eo=getEntityObject(ctx, model.getObjectValue(proName).getBOSType().toString());
				return getValueByProName(ctx,model.getObjectValue(proName),orgProName.substring(index+1,orgProName.length()),eo);
			}else {
				return "";
			}
		}
		//��������
		else if(eo.getPropertyByName(proName) instanceof OwnPropertyInfo) { 
			OwnPropertyInfo ss = ((OwnPropertyInfo)eo.getPropertyByName(proName));
			if(ss.getDataType().getAlias().equalsIgnoreCase("Enum")) {
				try {
					Class cls = Class.forName(ss.getMetaDataRef());
					Class className=model.get(proName).getClass();
					if(className .equals(Integer.class)) {
						className=int.class;
					}else if(className .equals(Double.class)) {
						className=double.class;
					}else if(className .equals(Float.class)) {
						className=float.class;
					}else if(className .equals(Long.class)) {
						className=long.class;
					}
					Method mtd = cls.getMethod("getEnum", new Class[] {className});
					Object cusEnum=mtd.invoke(null, new Object[] {model.get(proName)});
					mtd = cls.getMethod("getAlias");
					return String.valueOf(mtd.invoke(cusEnum));
				}catch(Exception err) {
					return  String.valueOf(model.get(proName));
				}
			}if(ss.getDataType().getAlias().equalsIgnoreCase("boolean")) {
				return String.valueOf(model.getBoolean(proName));
			}else {
				if(model.get(proName)!=null) {
					return String.valueOf(model.get(proName));
				}else {
					return "";
				}
			}
		}else {
			return "";
		}
	}
	
	/**
	 * ���ݵ��ݻ�ȡ����
	 */
	@Override
	protected String _getAttachmentBillByBillID(Context ctx, String parma)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject paramJson = JSONObject.fromObject(parma);
		if(paramJson.containsKey("billID")&&paramJson.get("billID")!=null){
			try {
				return FileCommUtils.getAttachments(ctx,paramJson.getString("billID"));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JSONObject resultjson = new JSONObject();
				resultjson.put("error", e.getMessage());
				resultjson.put("errorLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getClassName());
				return resultjson.toString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JSONObject resultjson = new JSONObject();
				resultjson.put("error", e.getMessage());
				resultjson.put("errorLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getClassName());
				return resultjson.toString();
			}
		}else
			return null;
	}
	@Override
	protected String _addAttachment(Context ctx, String param)
			throws BOSException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String _deleteAttachment(Context ctx, String param)
			throws BOSException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String _getAttachmentAsBytes(Context ctx, String param)
			throws BOSException {
		// TODO Auto-generated method stub
		return null;
	}
		
}