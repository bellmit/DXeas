package com.kingdee.eas.outinterface.workplatform.workflow;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
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
import com.kingdee.bos.workflow.AssignmentInfo;
import com.kingdee.bos.workflow.define.ManpowerActivityDef;
import com.kingdee.bos.workflow.mobile.server.ApproveUtilFactory;
import com.kingdee.bos.workflow.mobile.server.WorkflowServerBSFInstance;
import com.kingdee.bos.workflow.service.ormrpc.EnactmentServiceFactory;
import com.kingdee.bos.workflow.service.ormrpc.IEnactmentService;
import com.kingdee.eas.base.message.IMsgUnreadCount;
import com.kingdee.eas.base.message.MsgBizType;
import com.kingdee.eas.base.message.MsgPriority;
import com.kingdee.eas.base.message.MsgStatus;
import com.kingdee.eas.base.message.MsgType;
import com.kingdee.eas.base.message.MsgUnreadCountFactory;
import com.kingdee.eas.base.message.MsgUnreadCountInfo;
import com.kingdee.eas.base.multiapprove.ApproveResult;
import com.kingdee.eas.base.multiapprove.MultiApproveFactory;
import com.kingdee.eas.base.multiapprove.MultiApproveInfo;
import com.kingdee.eas.base.multiapprove.MultiApproveStatusEnum;
import com.kingdee.eas.base.permission.UserFactory;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.workplatform.workflow.utils.FileCommUtils;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 工作流
 * */
public class WorkFlowBill extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return null;
//		return "0E74B6E6";
//		return BOSUuid.read(billID).getType();
	}


	/**
	 * 我的待办、已办
	 */
	public String myTodoAndFinished(Context ctx, String param)
			throws BOSException, EASBizException {
		
//		StringBuffer data = new StringBuffer();
//		data.append("<?xml version=\"1.0\" encoding=\"GBK\" ?>");
//        data.append("\n");
//        data.append("<ROWSET>");
//        data.append("\n");
//        data.append("</ROWSET>");
//        return data.toString();
		
		// TODO Auto-generated method stub
		JSONObject dataJson = new JSONObject();
		JSONObject jsonObject = JSONObject.fromObject(param);
		UserInfo userInfo = null;
    	String userNumber = jsonObject.getString("userNumber");
    	try{
           userInfo = UserFactory.getLocalInstance(ctx).getUserInfoByNumber(userNumber);
        }
        catch(EASBizException e1){
//            logger.error("\u7528\u7528\u6237\u540D\u83B7\u53D6\u63A5\u6536\u7528\u6237\u4FE1\u606F\u65F6\u51FA\u9519", e1);
        }
        String userID = userInfo.getId().toString();
        int num = 1;
        StringBuffer data = new StringBuffer();
        data.append("<?xml version=\"1.0\" encoding=\"GBK\" ?>");
        data.append("\n");
        data.append("<ROWSET>");
        data.append("\n");
    	int m = jsonObject.getInt("m");
    	int n = jsonObject.getInt("n");
    	String dataType = jsonObject.getString("type");
		Calendar ca = Calendar.getInstance();//得到一个Calendar的实例
		String date = ca.get(Calendar.YEAR)-1 + "-1-1 00:00:00";
		StringBuffer sql = new StringBuffer("/*dialect*/");
		sql.append(" select * from (");
		sql.append(" select row_number() over ( ORDER BY a.receiveTime DESC) as num,a.* from ( ");
		if("inprogress".equalsIgnoreCase(dataType)){
			sql.append(" SELECT DISTINCT  t1.FASSIGNID AS assignID,  10 as type, 0 as bizType, ");
			sql.append(" t2.FStatus AS status, t1.FSUBJECT_l2 AS title, t1.fsubject_l2 AS body, ");
			sql.append(" t2.FSender_l2 AS sender, t1.FCREATEDTIME AS receiveTime, t1.FBILLENTITY AS billEntity, ");
			sql.append(" t1.FBIZOBJID AS bizObjID ,t1.FCREATEDTIME AS createdTIME,t1.FACTDEFNAME_l2 actDefName,t1.FPROCINSTID AS procInstId ");
			sql.append(" FROM T_WFR_Assign t1 ");
			sql.append(" INNER JOIN T_BAS_AssignRead t2 ON t1.FASSIGNID = t2.FAssignID ");
			sql.append(" WHERE t1.FIsSendMsg = 1 ");
			sql.append(" and t1.FCREATEDTIME>=to_date('"  + date + "','yyyy-MM-dd hh24:mi:ss') ");
			sql.append(" and t1.FSTATE in (1,2) ");
			sql.append(" and t1.FBIZOBJID is not null ");
			sql.append(" and t2.fSenderID='").append(userID).append("' ");
		}
		else if("finish".equalsIgnoreCase(dataType)){
			sql.append("select DISTINCT  t1.FASSIGNID AS assignID,  10 as type, 0 as bizType,");
			sql.append("t3.FStatus status,t1.FSUBJECT_l2 AS title, t1.fsubject_l2 AS body,");
			sql.append("t1.FCREATEDTIME AS receiveTime, t1.FBILLENTITY AS billEntity,t3.FSender_l2 AS sender,");
			sql.append("t1.FBIZOBJID AS bizObjID ,t1.FCREATEDTIME AS createdTIME,t2.FSTATE ");
			sql.append("from T_WFR_AssignDetail t1 ");
			sql.append("inner join T_WFR_ProcInst t2 on t2.FPROCINSTID=t1.FPROCINSTID ");
			sql.append("INNER JOIN T_BAS_AssignRead t3 ON t1.FASSIGNID = t3.FAssignID ");
			sql.append("where t2.FSTATE='closed.completed' ");
			sql.append("and t3.fSenderID='").append(userID).append("' ");
		}
		sql.append(") a ) t");
		sql.append(" where t.num > ").append(m).append(" ");
        sql.append(" and t.num <= ").append(m+n);
        IRowSet mesRowSet = DbUtil.executeQuery(ctx, sql.toString());
        JSONArray jsonArr = new JSONArray();
		try {
			while(mesRowSet.next()){
				JSONObject object = new JSONObject();
				object.put("assignID", mesRowSet.getString("assignID"));
				object.put("type", mesRowSet.getInt("type"));
				object.put("bizType", mesRowSet.getInt("bizType"));
				object.put("status", mesRowSet.getInt("status"));
				object.put("title", mesRowSet.getString("title"));
				object.put("body", mesRowSet.getString("body"));
				object.put("actDefName", mesRowSet.getString("actDefName"));
				object.put("procInstId", mesRowSet.getString("procInstId"));
				object.put("sender", mesRowSet.getString("sender"));
				object.put("receiveTime", mesRowSet.getTimestamp("receiveTime"));
				object.put("billEntity", StringUtils.isBlank(mesRowSet.getString("billEntity")) ? "" : mesRowSet.getString("billEntity"));
				object.put("bizObjID", mesRowSet.getString("bizObjID"));	
//				object.put("actDefID", mesRowSet.getString("actDefID"));
//				object.put("procDefID", mesRowSet.getString("procDefID"));
				jsonArr.add(object);
				
			    
			   
			   
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        data.append("</ROWSET>");
        System.out.println(data.toString());
//        return data.toString();
        dataJson.put("result", 0);
        dataJson.put("data", jsonArr);
        return dataJson.toString();
	}
	
	
	/**
     * 获取待办任务列表
     */
	public String _getMessageList(Context ctx, String json)
			throws BOSException {
        
		JSONObject jsonObject = JSONObject.fromObject(json);
    	String userNumber = jsonObject.getString("userNumber");	
    	int m = jsonObject.getInt("m");
    	int n = jsonObject.getInt("n");
    	String dataType = jsonObject.getString("type");
    	

		IRowSet wfRowSet;
        StringBuffer data = new StringBuffer();
        
        Timestamp sendtime = new Timestamp((new Date()).getTime());
        MsgUnreadCountInfo unReadInfo = getUnreadCountInfo(ctx, userNumber);
        if(unReadInfo == null) {
//        	throw new BOSException(MessageFormat.format(EASResource.getString("com.kingdee.eas.base.message.MessageCenter", "readCurrentUserMessageListError"), new String[] {
//                userNumber
//            }));
        	return "";
        }
        JSONObject dataJson = new JSONObject();
        unReadInfo.setSendMsgNum(unReadInfo.getAccount());
        unReadInfo.setSendTime(sendtime);
        IMsgUnreadCount imuc = MsgUnreadCountFactory.getLocalInstance(ctx);
        IObjectPK unReadPK = new ObjectUuidPK(unReadInfo.getId().toString());
        try{ 
            imuc.update(unReadPK, unReadInfo);
        }
        catch(EASBizException e){
        }
        
        Timestamp lastUpdataTime = unReadInfo.getLastUpdateTime();
        if(lastUpdataTime == null){
        	lastUpdataTime = new Timestamp((new Date()).getTime());
        }  
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String lastUpdateTimeStr = sdf.format(lastUpdataTime);
        UserInfo userInfo = null;
        try{
            userInfo = UserFactory.getLocalInstance(ctx).getUserInfoByNumber(userNumber);
        }
        catch(EASBizException e1){
        }
        
        String userID = userInfo.getId().toString();

        int num = 1;
        data.append("<?xml version=\"1.0\" encoding=\"GBK\" ?>");
        data.append("\n");
        data.append("<ROWSET>");
        data.append("\n");
        
		//获取 工作流通知  未读状态  start
		StringBuffer sql = new StringBuffer("/*dialect*/");
        sql.append(" select * from (");
        sql.append(" select row_number() over ( ORDER BY a.receiveTime DESC) as num,a.* from ( ");
        if("todo".equalsIgnoreCase(dataType)){
        	sql.append(" SELECT t1.FASSIGNID AS assignID,  10 as type, 0 as bizType, ");
    		sql.append(" t2.FStatus AS status, t1.FSUBJECT_l2 AS title, t1.fsubject_l2 AS body, ");
    		sql.append(" t2.FSender_l2 AS sender, t1.FCREATEDTIME AS receiveTime, t1.FBILLENTITY AS billEntity, ");
    		sql.append(" t1.FBIZOBJID AS bizObjID ,t1.FCREATEDTIME AS createdTIME");
    		sql.append(" FROM T_WFR_Assign t1 ");
    		sql.append(" INNER JOIN T_BAS_AssignRead t2 ON t1.FASSIGNID = t2.FAssignID ");
    		sql.append(" WHERE t1.FIsSendMsg = 1 ");
    		sql.append(" and t1.FSTATE in (1,2) ");
    		sql.append(" and t1.FBIZOBJID is not null ");
//    		sql.append(" and t1.FBILLENTITY in ('com.kingdee.eas.cp.bc.app.BizAccountBill','com.kingdee.eas.custom.signwasthetable.app.SignWasTheTable') ");
    		sql.append(" and t1.FPERSONUSERID = '").append(userID).append("' ");
//    		sql.append(" and to_char(t1.FCREATEDTIME,'yyyy-mm-dd HH:mm:ss') > '").append(lastUpdateTimeStr).append("' ");
//    		sql.append(" order by t1.FCREATEDTIME desc");
        } else if("notice".equalsIgnoreCase(dataType)){
        	sql.append(" select t.fid as assignID, t.ftype as type, t.fbiztype as bizType, ");
    		sql.append(" t.fstatus as status,t.ftitle_l2 as title,t.FBody_l2 as body,t.fsender_l2 as sender, ");
    		sql.append(" t.fsendtime as receiveTime, '' as billEntity, '' as bizObjID ");
    		sql.append(" from t_bas_message t ");
    		sql.append(" where t.fstatus = 0 ");	//未读
    		sql.append(" and t.freceiver = '");
    		sql.append(userID);
    		sql.append("' ");
        }
 
		sql.append(") a ) t");
		sql.append(" where t.num > ").append(m).append(" ");
        sql.append(" and t.num <= ").append(m+n);
        
		IRowSet mesRowSet = DbUtil.executeQuery(ctx, sql.toString());
		JSONArray jsonArray = new JSONArray();
		try {
			while(mesRowSet.next()){
				JSONObject object = new JSONObject();
				object.put("assignID", mesRowSet.getString("assignID"));
				object.put("type", mesRowSet.getInt("type"));
				object.put("bizType", mesRowSet.getInt("bizType"));
				object.put("status", mesRowSet.getInt("status"));
				object.put("title", mesRowSet.getString("title"));
				object.put("body", mesRowSet.getString("body"));
				object.put("sender", mesRowSet.getString("sender"));
				object.put("billEntity", mesRowSet.getString("billEntity"));
				object.put("bizObjID", mesRowSet.getString("bizObjID"));
				object.put("receiveTime", mesRowSet.getTimestamp("receiveTime"));
				jsonArray.add(object);
				
				data.append((new StringBuilder()).append("<ROW num=\"").append(num).append("\">").toString());
			    data.append("\n");
			    data.append((new StringBuilder()).append("<ID>").append(mesRowSet.getString("assignID")).append("</ID>").toString());
			    data.append("\n");
			    String type = MsgType.getEnum(mesRowSet.getInt("type")).getAlias();
			    data.append((new StringBuilder()).append("<TYPE>").append(type).append("</TYPE>").toString());
			    data.append("\n");
			    String bizType = MsgBizType.getEnum(mesRowSet.getInt("bizType")).getAlias();
			    data.append((new StringBuilder()).append("<BIZTYPE>").append(bizType).append("</BIZTYPE>").toString());
			    data.append("\n");
			    data.append((new StringBuilder()).append("<PRIORITY>").append(MsgPriority.MIDDLE.getAlias()).append("</PRIORITY>").toString());
			    data.append("\n");
			    String status = MsgStatus.getEnum(mesRowSet.getInt("status")).getAlias();
			    data.append((new StringBuilder()).append("<STATUS>").append(status).append("</STATUS>").toString());
			    data.append("\n");
			    data.append("<SOURCEIDS></SOURCEIDS>");
			    data.append("\n");
			    String title = mesRowSet.getString("title");
			    if(StringUtils.isNotBlank(title)){
			    	title = title.replace("<","&lt;").replace(">","&lt;");	
			    }
			    data.append((new StringBuilder()).append("<TITLE>").append(title).append("</TITLE>").toString());
			    data.append("\n");
			    String body = mesRowSet.getString("body");
			    if(StringUtils.isNotBlank(body)){
			    	body = body.replace("<","&lt;").replace(">","&lt;");	
			    }
			    data.append((new StringBuilder()).append("<BODY>").append(body).append("</BODY>").toString());
			    data.append("\n");
			    data.append((new StringBuilder()).append("<SENDER>").append(mesRowSet.getString("sender")).append("</SENDER>").toString());
			    data.append("\n");
			    String time = mesRowSet.getTimestamp("receiveTime").toString();
			    int location = time.lastIndexOf(".");
			    time = time.substring(0, location);
			    data.append((new StringBuilder()).append("<RTIME>").append(time).append("</RTIME>").toString());
			    data.append("\n");
			    String billEntity = mesRowSet.getString("billEntity");
			    billEntity = StringUtils.isBlank(billEntity) ? "" : billEntity;
			    data.append((new StringBuilder()).append("<BILLENTITY>").append(billEntity).append("</BILLENTITY>").toString());
			    data.append("\n");
			    String bizObjID = mesRowSet.getString("bizObjID");
			    bizObjID = StringUtils.isBlank(bizObjID) ? "" : bizObjID;
			    data.append((new StringBuilder()).append("<BILLID>").append(bizObjID).append("</BILLID>").toString());
			    data.append("\n");
//			    String billInfo = this.getBillInfoByIdAndEntity(ctx, bizObjID, billEntity);
//			    if(StringUtils.isNotBlank(billInfo)){
//			    	billInfo = billInfo.replace("<","&lt;").replace(">","&lt;");
//			    }
//			    data.append((new StringBuilder()).append("<BILLINFO>").append(billInfo).append("</BILLINFO>").toString());
			    data.append("\n");
			    
			    data.append("</ROW>");
			    data.append("\n");
			    num++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        return "";
		}
		
        data.append("</ROWSET>");
        
//        return data.toString();
        dataJson.put("data", jsonArray);
        dataJson.put("result", 0);
        return dataJson.toString();
        
	}
	
	
	/**
	 * 获取待办已办详情
	 */
	public String getBillDigest(Context ctx, String param)throws BOSException
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
				jo.put("propertyGroup", propGroup);//分组
				jo.put("propertyName", proName);//字段属性名
				jo.put("index", rs.getInt("Findex"));//顺序
				jo.put("showFormate", rs.getString("FShowFormate"));//显示格式
				jo.put("editable", rs.getString("FEditable"));//是否可修改
				jo.put("displayName", rs.getString("FAlias_l2"));//显示名称
				jo.put("value", "");//值
				jo.put("dataType", "");
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
						selector.add(propGroup + "." + proName);
						entryPropMap.get(propGroup).put(proName,jo.toString());
					}
				}
			}
		} catch (Exception e) {
			throw new BOSException(e);
		}

		//测试用*************
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
				//分录字段
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
			//分录属性、值
			dataJSON.put(entry.getKey(),jo);
		}

		if(StringUtils.isNotBlank(dataJSON.toString())){
			resultJson.put("data", dataJSON.toString());
			resultJson.put("result", 0);
			System.out.println(resultJson.toString());
		}
		return resultJson.toString();
	}
	
	/**
	 * 获取单据审批历史 
	 */
	@SuppressWarnings("unchecked")
	public String _getApproveHistory(Context ctx, String param) throws BOSException {
		JSONObject jsonParam=JSONObject.fromObject(param);

		String billId = jsonParam.getString("billID");
		
		JSONObject resultJson = new JSONObject();
		resultJson.put("result", 0);
		
		if(StringUtils.isBlank(billId)){
			resultJson.put("result", 0);
			resultJson.put("message", "单据ID不能为空");
			
			return resultJson.toString();
		}
		WorkflowServerBSFInstance instance = WorkflowServerBSFInstance.getInstance(ctx);
		List list = instance.getApproveHistory(billId);
		
		JSONArray dataArray = new JSONArray();
		if(list.size() > 0){
			for(int i=0,len=list.size();i<len;i++){
				Map<String,String> map = (Map) list.get(i);
				JSONObject dataObject = new JSONObject();
				for (Map.Entry<String,String> entry : map.entrySet()) {
					dataObject.put(entry.getKey() , entry.getValue());
				}
				
				dataArray.add(dataObject);
			}
			
			resultJson.put("data", dataArray);
			
		}else {
			resultJson.put("data", null);
		}
		
		//先获取代办任务下一节点审批信息  如果没有 则为审批完成 不需要获取
		JSONObject nextApproveInfo = this.getNextApprovePerson(ctx, billId);
		if(!nextApproveInfo.isEmpty()){
			dataArray.add(nextApproveInfo);
		}
		resultJson.put("data", dataArray);
		return resultJson.toString();
	}
	
	
	/**
     * 获取 已办 任务
     * 改为按照json传递
     */
	public String getMessageDetailList(Context ctx, String json)
			throws BOSException {
    	
    	/*StringBuffer data = new StringBuffer();
		data.append("<?xml version=\"1.0\" encoding=\"GBK\" ?>");
        data.append("\n");
        data.append("<ROWSET>");
        data.append("\n");
        data.append("</ROWSET>");
        return data.toString();*/
        
		JSONObject dataJson = new JSONObject();
		
    	//传入为json
    	
    	JSONObject jsonObject = JSONObject.fromObject(json);
    	String userNumber = jsonObject.getString("userNumber");	
    	int m = jsonObject.getInt("m");
    	int n = jsonObject.getInt("n");
    	
    	
		IRowSet wfRowSet;
        StringBuffer data = new StringBuffer();
        
        Timestamp sendtime = new Timestamp((new Date()).getTime());
        MsgUnreadCountInfo unReadInfo = getUnreadCountInfo(ctx, userNumber);
        if(unReadInfo == null) {
//        	throw new BOSException(MessageFormat.format(EASResource.getString("com.kingdee.eas.base.message.MessageCenter", "readCurrentUserMessageListError"), new String[] {
//                userNumber
//            }));
        	return "";
        }
        
        unReadInfo.setSendMsgNum(unReadInfo.getAccount());
        unReadInfo.setSendTime(sendtime);
        IMsgUnreadCount imuc = MsgUnreadCountFactory.getLocalInstance(ctx);
        IObjectPK unReadPK = new ObjectUuidPK(unReadInfo.getId().toString());
        try{
            imuc.update(unReadPK, unReadInfo);
        }
        catch(EASBizException e){
        }
        
        Timestamp lastUpdataTime = unReadInfo.getLastUpdateTime();
        if(lastUpdataTime == null){
        	lastUpdataTime = new Timestamp((new Date()).getTime());
        }   
           
        UserInfo userInfo = null;
        try{
            userInfo = UserFactory.getLocalInstance(ctx).getUserInfoByNumber(userNumber);
        }
        catch(EASBizException e1){
        }
        
        String userID = userInfo.getId().toString();
        String personId = userInfo.getPerson().getId().toString();
        
        data = new StringBuffer();
        
        StringBuffer sql = new StringBuffer("/*dialect*/");
        sql.append(" select * from (");
        sql.append(" select row_number() over ( ORDER BY t.FCREATEDTIME DESC) as num, ");
        sql.append(" t.fassignid as assignID, ");
        sql.append(" 10 as type, 0 as bizType,10 as status, ");
        sql.append(" t.FSUBJECT_l2 as title, ");
        sql.append(" t.FInitiatorName_l2 as sender, ");
        sql.append(" t.FCREATEDTIME as receiveTime, ");
        sql.append(" t.FBILLENTITY as billEntity, ");
        sql.append(" t.FBIZOBJID as bizObjID ");
        sql.append(" from T_WFR_AssignDetail t ");
        sql.append(" where t.FSTATE in (8,16) ");
        sql.append(" and t.FIsSendMsg = 1 ");
        sql.append(" AND t.fpersonEmpID = '");
        sql.append(personId);
        sql.append("'  order by t.FCREATEDTIME desc) ");
        sql.append(" where num > ").append(m).append(" ");
        sql.append(" and num <= ").append(m+n);
        wfRowSet = DbUtil.executeQuery(ctx, sql.toString());
        
        int num = 1;
        data.append("<?xml version=\"1.0\" encoding=\"GBK\" ?>");
        data.append("\n");
        data.append("<ROWSET>");
        data.append("\n");
        JSONArray jsonArr = new JSONArray();
        try {
			while(wfRowSet.next()) 
			{
			    data.append((new StringBuilder()).append("<ROW num=\"").append(num).append("\">").toString());
			    data.append("\n");
			    //id改为 委派id
			    data.append((new StringBuilder()).append("<ID>").append(wfRowSet.getString("assignID")).append("</ID>").toString());
			    data.append("\n");
			    String type = MsgType.getEnum(wfRowSet.getInt("type")).getAlias();
			    data.append((new StringBuilder()).append("<TYPE>").append(type).append("</TYPE>").toString());
			    data.append("\n");
			    String bizType = MsgBizType.getEnum(wfRowSet.getInt("bizType")).getAlias();
			    data.append((new StringBuilder()).append("<BIZTYPE>").append(bizType).append("</BIZTYPE>").toString());
			    data.append("\n");
			    data.append((new StringBuilder()).append("<PRIORITY>").append(MsgPriority.MIDDLE.getAlias()).append("</PRIORITY>").toString());
			    data.append("\n");
			    String status = MsgStatus.getEnum(wfRowSet.getInt("status")).getAlias();
			    data.append((new StringBuilder()).append("<STATUS>").append(status).append("</STATUS>").toString());
			    data.append("\n");
			    data.append("<SOURCEIDS></SOURCEIDS>");
			    data.append("\n");
			    data.append((new StringBuilder()).append("<TITLE>").append(org.apache.commons.lang.StringUtils.isEmpty(wfRowSet.getString("title"))?wfRowSet.getString("title"):wfRowSet.getString("title").replace("<","&lt;").replace(">","&lt;")).append("</TITLE>").toString());
			    data.append("\n");
//			    data.append((new StringBuilder()).append("<BODY>").append(wfRowSet.getString("body")).append("</BODY>").toString());
//			    data.append("\n");
			    data.append((new StringBuilder()).append("<SENDER>").append(org.apache.commons.lang.StringUtils.isEmpty(wfRowSet.getString("sender"))?wfRowSet.getString("sender"):wfRowSet.getString("sender").replace("<","&lt;").replace(">","&lt;")).append("</SENDER>").toString());
			    data.append("\n");
			    String time = wfRowSet.getTimestamp("receiveTime").toString();
			    int location = time.lastIndexOf(".");
			    time = time.substring(0, location).replace("<","&lt;").replace(">","&lt;");
			    data.append((new StringBuilder()).append("<RTIME>").append(time).append("</RTIME>").toString());
			    data.append("\n");
			    data.append((new StringBuilder()).append("<BILLENTITY>").append(org.apache.commons.lang.StringUtils.isEmpty(wfRowSet.getString("billEntity"))?wfRowSet.getString("billEntity"):wfRowSet.getString("billEntity").replace("<","&lt;").replace(">","&lt;")).append("</BILLENTITY>").toString());
			    data.append("\n");
			    data.append((new StringBuilder()).append("<BILLID>").append(org.apache.commons.lang.StringUtils.isEmpty(wfRowSet.getString("bizObjID"))?wfRowSet.getString("bizObjID"):wfRowSet.getString("bizObjID").replace("<","&lt;").replace(">","&lt;")).append("</BILLID>").toString());
			    data.append("\n");
			    data.append("</ROW>");
			    data.append("\n");
			    
			    
				JSONObject object = new JSONObject();
				object.put("assignID", wfRowSet.getString("assignID"));
				object.put("type", wfRowSet.getInt("type"));
				object.put("bizType", wfRowSet.getInt("bizType"));
				object.put("status", wfRowSet.getInt("status"));
				object.put("title", wfRowSet.getString("title"));
//				object.put("body", wfRowSet.getString("body"));
//				object.put("actDefName", wfRowSet.getString("actDefName"));
//				object.put("procInstId", wfRowSet.getString("procInstId"));
				object.put("sender", wfRowSet.getString("sender"));
				object.put("receiveTime", wfRowSet.getTimestamp("receiveTime"));
				object.put("billEntity", StringUtils.isBlank(wfRowSet.getString("billEntity")) ? "" : wfRowSet.getString("billEntity"));
				object.put("bizObjID", wfRowSet.getString("bizObjID"));	
//				object.put("opinion", wfRowSet.getString("opinion"));
//				object.put("actDefID", mesRowSet.getString("actDefID"));
//				object.put("procDefID", mesRowSet.getString("procDefID"));
//				object.put("billId", value)
//				object.put("billInfo", billInfo);
				jsonArr.add(object);
			    
			    num++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        return "";
		}
        
        data.append("</ROWSET>");
        
        dataJson.put("result", 0);
        dataJson.put("data", jsonArr);
        
        return dataJson.toString();
	}
	
	
	/**
	 * 根据单据获取附件
	 */
	public String _getAttachmentBillByBillID(Context ctx, String parma)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject paramJson = JSONObject.fromObject(parma);
		JSONObject jsonData = new JSONObject();
		
		if(paramJson.containsKey("billID")&&paramJson.get("billID")!=null){
			try {
				jsonData.put("result", 0);
				jsonData.put("data", FileCommUtils.getAttachments(ctx, paramJson.getString("billID")));
				return jsonData.toString();
			
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JSONObject resultjson = new JSONObject();
				resultjson.put("error", e.getMessage());
				resultjson.put("errorLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getClassName());
				jsonData.put("result", 999);
				jsonData.put("data", resultjson);
				return jsonData.toString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JSONObject resultjson = new JSONObject();
				resultjson.put("error", e.getMessage());
				resultjson.put("errorLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getClassName());
				jsonData.put("result", 999);
				jsonData.put("data", resultjson);
				return jsonData.toString();
			}
		}else
			return null;
	}
	
	
	/**
	 * 根据单据获取附件详情
	 */
	public String _getAttachmentBillByBillIDDetail(Context ctx, String parma)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject paramJson = JSONObject.fromObject(parma);
		JSONObject jsonData = new JSONObject();
		
		if(paramJson.containsKey("billID")&&paramJson.get("billID")!=null){
			try {
				jsonData.put("result", 0);
				jsonData.put("data", FileCommUtils.getAttachmentsDetail(ctx, paramJson.getString("billID")));
				return jsonData.toString();
			
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JSONObject resultjson = new JSONObject();
				resultjson.put("error", e.getMessage());
				resultjson.put("errorLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getClassName());
				jsonData.put("result", 999);
				jsonData.put("data", resultjson);
				return jsonData.toString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JSONObject resultjson = new JSONObject();
				resultjson.put("error", e.getMessage());
				resultjson.put("errorLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getClassName());
				jsonData.put("result", 999);
				jsonData.put("data", resultjson);
				return jsonData.toString();
			}
		}else
			return null;
	}
	
	/**
	 * 审批
	 */
	public String _quickApprove(Context ctx, String json) throws BOSException {
		
		
		
		JSONObject jsonInfo = JSONObject.fromObject(json);
		String assignIds = jsonInfo.getString("assignIds");
		String ifpass = jsonInfo.getString("ifpass");
		String opinion =jsonInfo.getString("opinion");
		String policy =jsonInfo.getString("policy");
		String userNumber =jsonInfo.getString("userNumber");
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select fid from t_pm_user where fnumber = '");
		sql.append(userNumber);
		sql.append("'");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try {
			if(rs.next()){
				
				String userId = rs.getString("fid");
				UserInfo userInfo = UserFactory.getLocalInstance(ctx).getUserInfo(new ObjectUuidPK(userId));
				
				ContextUtil.setCurrentUserInfo(ctx, userInfo);
				ctx.setCaller(new ObjectUuidPK(userId));
				
				JSONObject jsonObject = new JSONObject();
//				 Map map = WorkflowServerBSFInstance.getInstance(ctx).quickApprove(assignIds, ifpass, opinion, policy);
				Map map=quickApprove(ctx,assignIds, ifpass, opinion, policy);
				JSONObject jsonObject2 = new JSONObject();
				jsonObject2.put("failedCouunt", map.get("failedCouunt"));
				 jsonObject2.put("successCouunt", map.get("successCouunt"));
				 jsonObject2.put("success", map.get("success"));
				 jsonObject2.put("result", map.get("result"));
				 jsonObject.put("result", 0);
				 jsonObject.put("data", jsonObject2);
				 return jsonObject.toString();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	     
	}
	
	
	private boolean needSetNextPerson(Context ctx,String assignID)
	/*      */   {
	/*      */     try
	/*      */     {
	/* 1842 */       IEnactmentService service = EnactmentServiceFactory.createEnactService(ctx);
	/* 1843 */       AssignmentInfo assign = service.getAssignmentById(assignID);
	/* 1844 */       Map map = service.getExtendedAttributesFromActivityInst(assign.getActInstId());
	/* 1845 */       String alwaysSetNextPersons = (String)map.get("alwaysSetNextPersons");
	/* 1846 */       map = service.getActivityDefAndActivityInstInfo(assignID);
	/* 1847 */       ManpowerActivityDef activityDef = (ManpowerActivityDef)map.get("ACTIVITYDEF");
	/*      */ 
	/* 1849 */       boolean showAllEmptyManpowerActivites = activityDef.isShowAllEmptyManpowerActivites();
	/*      */ 
	/* 1851 */       if ("true".equals(alwaysSetNextPersons))
	/*      */       {
	/* 1853 */         if (showAllEmptyManpowerActivites)
	/*      */         {
	/* 1855 */           String ifEmpty = ifExistEmptyPersonWhenPostParticipants(ctx,assignID);
	/*      */
	/*      */ 
	/* 1858 */           return ("true".equals(ifEmpty));
	/*      */
	/*      */         }
	/*      */ 
	/* 1865 */         return true;
	/*      */
	/*      */       }
	/*      */ 
	/*      */     }
	/*      */     catch (Exception e)
	/*      */     {
	/* 1878 */       return true;
	/*      */     }
	/* 1880 */     return false;
	/*      */   }
	
	public String ifExistEmptyPersonWhenPostParticipants(Context ctx,String assignId)
	/*      */     throws Exception
	/*      */   {
	/* 1618 */     List list = ApproveUtilFactory.getInstance(ctx).findPostParticipants(assignId, null);
	/* 1619 */     for (Iterator iter = list.iterator(); iter.hasNext(); )
	/*      */     {
	/* 1621 */       Map map = (Map)iter.next();
	/* 1622 */       Map persons = (HashMap)map.get("persons");
	/* 1623 */       if (persons.isEmpty()) {
	/* 1624 */         return "true";
	/*      */       }
	/*      */     }
	/* 1627 */     return "false";
	/*      */   }
	
	public Map quickApprove(Context ctx,String assignIds, String ifpass, String opinion, String policy)
	/*      */   {
	/* 1769 */     long t1 = System.currentTimeMillis();
	/* 1770 */     HashMap map = new HashMap();
	/* 1771 */     String[] assignID = assignIds.split(",");
	/* 1772 */     int successCount = 0;
	/* 1773 */     int failedCount = 0;
	/* 1774 */     String reason = "";
	/*      */     try
	/*      */     {
	/* 1777 */       for (int i = 0; i < assignID.length; ++i)
	/*      */       {
	/* 1779 */         boolean ifNeedSetNextPerson = needSetNextPerson(ctx,assignID[i]);
	/* 1780 */         if (ifNeedSetNextPerson)
	/*      */         {
	/* 1782 */           ++failedCount;
	/* 1783 */           reason = "需指定下一步参与人";}
	/*      */         else {
	/* 1786 */           MultiApproveInfo info = new MultiApproveInfo();
	/* 1787 */           IEnactmentService service = EnactmentServiceFactory.createEnactService(ctx);
	/* 1788 */           AssignmentInfo assignInfo = service.getAssignmentById(assignID[i]);
	/* 1789 */           if (StringUtils.isEmpty(policy))
	/*      */           {
	/* 1791 */             policy = "0";
	/*      */           }
	/* 1793 */           info.setAssignment(assignID[i]);
	/* 1794 */           String billId = "";
	/* 1795 */           String[] bizObjectId = assignInfo.getBizObjectIdArray();
	/* 1796 */           if ((bizObjectId != null) && (bizObjectId.length > 0))
	/*      */           {
	/* 1798 */             billId = bizObjectId[0];
	/*      */           }
	/* 1800 */           info.setBillId(BOSUuid.read(billId));
	/* 1801 */           info.setExtendedProperty("businuessObjectId", bizObjectId.toString());
	/* 1802 */           info.setExtendedProperty("assignmentID", assignID[i]);
	/* 1803 */           info.setExtendedProperty("isAddNew", "isAddNew");
	/*      */ 
	/* 1805 */           if ("1".equals(ifpass))
	/*      */           {
	/* 1807 */             info.setIsPass(ApproveResult.getEnum("true"));
//	/* 1808 */             opinion = "同意";
	/*      */           }
	/*      */           else
	/*      */           {
	/* 1812 */             info.setIsPass(ApproveResult.getEnum("false"));
//	/* 1813 */             opinion = "不同意";
	/*      */           }
	/* 1815 */           info.setOpinion(opinion);
	/* 1816 */           info.setHandlerOpinion(Integer.parseInt(policy));
	/* 1817 */           info.setHandlerContent("");
	/* 1818 */           info.setStatus(MultiApproveStatusEnum.SUBMIT);
	/* 1819 */           MultiApproveFactory.getLocalInstance(ctx).submit(info);
	/* 1821 */           ++successCount;
	/*      */         }
	/*      */       }
	/*      */     }
	/*      */     catch (Exception e) {
	/* 1826 */       ++failedCount;
	/* 1827 */       reason = "审批失败";
	/*      */     }
	/* 1831 */     map.put("success", Boolean.valueOf(true));
	/* 1832 */     map.put("result", reason);
	/* 1833 */     map.put("failedCouunt", Integer.valueOf(failedCount));
	/* 1834 */     map.put("successCouunt", Integer.valueOf(successCount));
	/* 1835 */     return map;
	/*      */   }
	
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

	//根据单据id获取当前单据的执行人
	private JSONObject getNextApprovePerson (Context ctx, String billId) {
		
		JSONObject jsonObject = new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
		
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT fpersonempname_l2, factdefname_l2, fcreatedtime,FIsSendMsg ");
		sql.append(" FROM T_WFR_Assign ");
		sql.append(" where fbizobjid = '");
		sql.append(billId);
		sql.append("' ");
		
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.size() == 1){
				if(rs.next()){
					Date createtime = rs.getDate("fcreatedtime");
					if(createtime != null){
						jsonObject.put("createTime",sdf.format(createtime));
					}
					
					jsonObject.put("ispass","");
					jsonObject.put("opinion","未开始");
					jsonObject.put("actdefName",rs.getString("factdefname_l2"));
					jsonObject.put("personName",rs.getString("fpersonempname_l2"));
				}
			}else if(rs.size()>=2){
				while(rs.next()){
					if(!rs.getBoolean("FIsSendMsg")){continue;}
					Date createtime = rs.getDate("fcreatedtime");
					if(createtime != null){
						jsonObject.put("createTime",sdf.format(createtime));
					}
					
					jsonObject.put("ispass","");
					jsonObject.put("opinion","未开始");
					jsonObject.put("actdefName",rs.getString("factdefname_l2"));
					jsonObject.put("personName",rs.getString("fpersonempname_l2"));
				}
			}
			return jsonObject;
			
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private EntityObjectInfo getEntityObject(Context ctx,String bosType) {
		IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
		EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(bosType));
		return eo;
	}
	
	private MsgUnreadCountInfo getUnreadCountInfo(Context ctx, String userNumber)
			throws BOSException {
		IRowSet rs;
		String id;
		MsgUnreadCountInfo info = null;
		StringBuffer sql = new StringBuffer();
		rs = null;
		sql.append("select FID from T_BAS_MsgUnreadCount where FUserNumber='");
		sql.append(userNumber);
		sql.append("'");
		rs = DbUtil.executeQuery(ctx, sql.toString());
		id = "";
		if (rs.size() == 0) {
			return null;
		}

		try {
			if (rs.next()) {
				id = rs.getString("FID");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}

		IMsgUnreadCount imuc = MsgUnreadCountFactory.getLocalInstance(ctx);
		IObjectPK pk = new ObjectUuidPK(id);
		try {
			info = imuc.getMsgUnreadCountInfo(pk);
		} catch (EASBizException e) {
			return null;
		}
		return info;
	}


}
