package com.kingdee.eas.custom.workflow.util;

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

import sun.misc.BASE64Encoder;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.LinkPropertyInfo;
import com.kingdee.bos.metadata.entity.OwnPropertyInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.workflow.mobile.server.WorkflowServerBSFInstance;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 移动工作流功能类
 * @author dai_andong
 *
 */
public class WSWorkflowUtils {
	
	/**
	 * 传阅
	 * @param ctx
	 * @param map 
	 * 			元素：
	 * 			assignment 流程id
	 * 			billId单据id
	 * 			isproccloss
	 *			isAllowrepass 是否允许重新传阅
	 * 			opinion 传阅意见
	 * @param usetList 被传阅人personid列表 personID
	 * @param opinionMap {"personIdList":["id1","id2"]} 反馈人id/传阅人id
	 * @param localMap 国际化多语言Map {"zh","CN"}
	 * @throws Exception 
	 */
	public static void passAssign(Context ctx,Map map,String[] usetList, Map opinionMap, Map localMap) throws Exception {
		WorkflowServerBSFInstance.getInstance(ctx).passAssign(map, usetList, opinionMap, localMap);
	}
	
	/**
	 *  查询传阅信息
	 * @param ctx
	 * @param billID 单据id
	 * @param procInstId 流程实例Id
	 * @param personID 查阅人id
	 * @return
	 * @throws BOSException
	 * @throws SQLException
	 * @throws UnsupportedEncodingException
	 */
	public static String executeQueryForPassAssign(Context ctx,String billID,String procInstId,String personID) throws BOSException, SQLException,UnsupportedEncodingException {
		StringBuffer sql=new StringBuffer();
		sql.append(" select * from T_WFR_PassComment")
		.append(" where FbillId='").append(billID).append("'")//单据id
		//.append(" and FprocInstId='").append(procInstId).append("'")//流程实例Id
		.append(" and (fuserID='").append(personID).append("'")//意见发表人
		.append(" or FPERSONID='").append(personID).append("'")//反馈人id
		.append(" or FInitiator='").append(personID).append("'")//发起人
		.append(" )");
		JSONArray ja=new JSONArray();
		JSONObject jo=new JSONObject();
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		while(rs.next()) {
			jo.put("initiator", rs.getString("FInitiator"));//发起人
			jo.put("userID", rs.getString("FUserID"));//意见发表人
			jo.put("createTime", rs.getTimestamp("FCreateTime"));//发表意见时间
			jo.put("comment", rs.getString("FComment_l2"));//意见
			jo.put("personID", rs.getString("FPERSONID"));//反馈人id
			jo.put("personName", rs.getString("FPERSONNAME"));//反馈人name
			jo.put("updateTime", rs.getTimestamp("FUPDATETIME"));//反馈时间
			ja.add(jo);
		}
		return ja.toString();
	}
	
//	/**
//	 * 
//	 * @param ctx
//	 * @param id 单据id
//	 * @param type 下载类型
//	 * @return  {"fileBytes":jsonArray} 附件base64编码
//	 * @throws UnsupportedEncodingException 
//	 * @throws BOSException 
//	 * @throws EASBizException 
//	 */
//	public static String getAttachmentAsBytes(Context ctx,String id) throws EASBizException, BOSException, UnsupportedEncodingException {
//		StringBuffer sql=new StringBuffer();
//		sql.append(" select fid from T_BAS_BillAttachment")
//		.append(" where FBillId=?")
//		;
//		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString(), new Object[]{id});
//		String type="BILLATTACH";
//		JSONObject result=new JSONObject();
//		JSONArray ja=new JSONArray();
//		result.put("fileBytes", ja);
//		WorkflowServerBSFInstance is = WorkflowServerBSFInstance.getInstance(ctx);
//		try {
//			BASE64Encoder encoder = new BASE64Encoder();
//			while(rs.next()) {
//				ja.add(encoder.encode(is.getAttachmentAsBytes(id, type)));
//			}
//		} catch (SQLException e) {
//			throw new BOSException(e);
//		}
//		return result.toString(0);
//	}
	
	/**
	 * 上传附件
	 * @param ctx
	 * @param boid URLDecoder
	 * @param m 附件文件说明
	 * 			元素：
	 * 			type 传 "getPicthur"
	 * 			attatchid null
	 * 			fileSize 文件大小
	 * 			fileName 文件名称
	 * 			fileExt 文件拓展名
	 * @param fileData 文件加密字符串 BASE64加密
	 * @return JSON String {"success:"true/false}
	 * @throws EASBizException
	 * @throws BOSException
	 * @throws IOException
	 */
//	public static String addAttachment(Context ctx,String boid, Map m, String fileData) throws EASBizException, BOSException, IOException {
//		Map map= WorkflowServerBSFInstance.getInstance(ctx).addAttachment(boid, m, fileData);
//		return JSONObject.fromObject(map).toString();
//	}
	
//	/**
//	 * 删除附件
//	 * @param ctx
//	 * @param billId 单据Id
//	 * @param id 附件id
//	 * @return JSON String {"success:"true/false}
//	 * @throws EASBizException
//	 * @throws BOSException
//	 * @throws IOException
//	 */
//	public static String deleteAttachment(Context ctx,String billId, String id) throws EASBizException, BOSException {
//		Map map= WorkflowServerBSFInstance.getInstance(ctx).deleteAttachment(billId, id);
//		return JSONObject.fromObject(map).toString();
//	}
	
//	/**提交审批
//	 * @param ctx
//	 * @param assignID 工作流id
//	 * @param ifpass 是否审批通过 1：审批通过 0:审批不通过
//	 * @param listperSons 传入null
//	 * @param opinion 审批意见 
//	 * @param policy 决策选项 默认为0(决策值，"同意")
//	 * @param editParam 单据修改保存json ,如果不保存传入Null
//	 * 				示例 [{"单据id1","{"number":"123","bizDate":"2017-10-01"}"},{"单据id2","{"number":"1234","bizDate":"2017-10-02"}"}]
//	 * 				F7传入对象id
//	 * @param billId 单据内码
//	 * result json字符串{"success":true/false,"result":"审批成功/错误信息"}
//	 */
//	public static String submitApprove(Context ctx,String assignID, String ifpass, ArrayList listperSons, String opinion, String policy, String editParam, String billId) {
//		Map map= WorkflowServerBSFInstance.getInstance(ctx).submitApprove(assignID, ifpass, listperSons, opinion, policy, editParam, billId);
//		return JSONObject.fromObject(map).toString();
//	}
	
	/**
	 * 获得决策值
	 * @param ctx
	 * @param assignID 任务id
	 * @param ifPass 1审批通过，0审批不通过
	 * @return {result=0,同意,;}
	 * @throws Exception 
	 */
//	public static String getSelectPolicy(Context  ctx,String assignID, String ifPass) throws Exception {
//		Map map=WorkflowServerBSFInstance.getInstance(ctx).getSelectPolicy(assignID,ifPass);
//		return JSONObject.fromObject(map).toString();
//	}
	
	
	/**
	 * 获取单据摘要 --动态单据配置
	 * @param ctx
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public String _getBillDigest(Context ctx, String param)throws BOSException, EASBizException
	{
		JSONObject jsonParam=JSONObject.fromObject(param);
		JSONObject resultJson = new JSONObject();
		resultJson.put("result", true);

		String billID = jsonParam.getString("billID");

		BOSObjectType bosType = BOSUuid.read(billID).getType();
		IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
		IMetaDataPK te=loader.getEntityObjectPK(bosType);

		EntityObjectInfo eo = getEntityObject(ctx, bosType.toString());
		
		HashMap<String, LinkedHashMap<String,Object>> entryPropMap=new HashMap<String,  LinkedHashMap<String,Object>>();//分录属性
		//查询集合
		SelectorItemCollection selector=new SelectorItemCollection();

		StringBuffer sql=new StringBuffer();
		sql.append(" select * from T_WM_BillDigest ")
		.append(" where FMetadataPK='").append(te.getFullName()).append("'")
		.append(" order by FIndex asc")
		;
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
				jo.put("propertyGroup", propGroup);//分组
				jo.put("propertyName", proName);//字段属性名
				jo.put("index", rs.getInt("Findex"));//顺序
				jo.put("showFormate", rs.getString("FShowFormate"));//显示格式
				jo.put("editable", rs.getString("FEditable"));//是否可修改
				jo.put("displayName", rs.getString("FAlias_l2"));//显示名称
				jo.put("value", "");//值
				jo.put("dataType", "");//数据类型
				//非分录
				if(StringUtils.isBlank(propGroup)) {
					if(StringUtils.isNotBlank(proName)) {
						dataJSON.put(proName, jo);
					}
				}
				//分录
				else {
					if(!entryPropMap.containsKey(propGroup)){
						entryPropMap.put(propGroup, new LinkedHashMap<String,Object>());
					}
					if(StringUtils.isNotBlank(proName)) {
						selector.add(propGroup+"."+proName);
						entryPropMap.get(propGroup).put(proName,jo.toString());
					}
				}
			}
		} catch (Exception e) {
			throw new BOSException(e);
		}

		//测试用*************
		selector.add("creator.name");
		selector.add("number");
		selector.add("Entrys.weighBillType");
		selector.add("Entrys.isAuto2Inv");
		dataJSON.put("creator.name", new JSONObject());
		dataJSON.put("number", new JSONObject());
		
		entryPropMap.put("Entrys", new LinkedHashMap<String,Object>());
		((LinkedHashMap)entryPropMap.get("Entrys")).put("weighBillType", new JSONObject());
		((LinkedHashMap)entryPropMap.get("Entrys")).put("isAuto2Inv", new JSONObject());
		//*********************
		
		ICoreBase is = getLocalInstance(ctx, eo);
		CoreBaseInfo info = is.getValue(new ObjectUuidPK(billID),selector);
		String proValue;
		//表头值填充
		Iterator itr = dataJSON.keys();
		while(itr.hasNext()){
			proName=(String) itr.next();
			proValue=getValueByProName(ctx,info,proName,eo);
			dataJSON.getJSONObject(proName).put("value", proValue);
		}
		
		//分录值填充
		itr=entryPropMap.entrySet().iterator();
		Map.Entry<String,LinkedHashMap<String,Object>> entry;
		Iterator itr2;//分录属性
		EntityObjectInfo tempeo;
		IObjectCollection tempCols;
		JSONObject tempJO;
		JSONArray tempJA;
		while(itr.hasNext()) {
			entry= (Entry<String, LinkedHashMap<String,Object>>) itr.next();
			propGroup=entry.getKey();//分录名称
			
			jo=new JSONObject();
			jo.put("columns",entry.getValue());
			tempJA=new JSONArray();//分录行
			//分录info属性
			tempeo = ((LinkPropertyInfo)eo.getPropertyByName(propGroup)).getRelationship().getSupplierObject();
			tempCols=(IObjectCollection) info.get(propGroup);
			for(int j=0;j<tempCols.size();j++) {
				tempJO=new JSONObject();
				tempJO.put("index", j);
				//分录字段
				itr2=entry.getValue().keySet().iterator();
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
			//分录属性、值
			dataJSON.put(entry.getKey(),jo);
		}
		
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
	 * 获取属性值
	 * @param model
	 * @param proName
	 * @return
	 */
	private String getValueByProName(Context ctx,IObjectValue model ,String orgProName,EntityObjectInfo eo) {
		//获取第一个属性
		int index=orgProName.indexOf(".");
		String proName=index>=0?orgProName.substring(0,index):orgProName;
		//连接属性
		if(eo.getPropertyByName(proName) instanceof LinkPropertyInfo) {
			if(model.get(proName) instanceof IObjectCollection) {
				return " 不支持子分录";
			}else if(model.get(proName) instanceof IObjectValue) {
				eo=getEntityObject(ctx, model.getObjectValue(proName).getBOSType().toString());
				return getValueByProName(ctx,model.getObjectValue(proName),orgProName.substring(index+1,orgProName.length()),eo);
			}else {
				return "";
			}
		}
		//自有属性
		else if(eo.getPropertyByName(proName) instanceof OwnPropertyInfo) { 
			OwnPropertyInfo ss = ((OwnPropertyInfo)eo.getPropertyByName(proName));
			if(ss.getDataType().getAlias().equalsIgnoreCase("Enum")) {
				try {
					Class cls = Class.forName(ss.getMetaDataRef());
					Method mtd = cls.getMethod("getEnum", new Class[] {model.get(proName).getClass()});
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
	
}
