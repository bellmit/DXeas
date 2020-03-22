package com.kingdee.eas.custom.workflow.app;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
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
import com.kingdee.eas.scm.im.inv.ws.util.InfoUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.ToolFacadeFactory;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.UuidException;

public class WSWorkFlowFacadeControllerBean extends AbstractWSWorkFlowFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.workflow.app.WSWorkFlowFacadeControllerBean");
    
    /**
     * 提交审批
     */
	@Override
	protected String _submitApprove(Context ctx, String jsonStr)
			throws BOSException {
		JSONObject resultJson = new JSONObject();
		resultJson.put("result", "success");
		
		if(StringUtils.isBlank(jsonStr)){
			resultJson.put("result", "success");
			resultJson.put("message", "传入参数不能为空");
			
			return resultJson.toString();
		}
		
		//TODO 暂时不做校验  后续完善
		JSONObject conditionJson = JSONObject.fromObject(jsonStr);
		String userNumber = conditionJson.getString("userNumber");
		String assignID = conditionJson.getString("assignID");
		String ifpass = conditionJson.getString("ifpass");
		String opinion = conditionJson.getString("opinion");
		String policy = conditionJson.getString("policy");
		String editParam = conditionJson.getString("editParam");
		String billId = conditionJson.getString("billId");
		
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
				
//				Map map= WorkflowServerBSFInstance.getInstance(ctx).submitApprove(assignID, ifpass, null, opinion, policy, editParam, billId);
				Map map= WorkflowServerBSFInstance.getInstance(ctx).submitApprove(assignID, ifpass, null, opinion, policy);

				JSONObject dataJson = JSONObject.fromObject(map);
				
				resultJson.put("data", dataJson);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultJson.put("result", "success");
			resultJson.put("message", "SQL查询失败");
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultJson.put("result", "success");
			resultJson.put("message", "EAS异常");
		} catch (Exception e) {
			e.printStackTrace();
			resultJson.put("result", "success");
			resultJson.put("message", "返回失败");
		}
		
		return resultJson.toString();
	}
    
    /**
     * 更新 工作流通知 状态
     */
    @Override
	protected void _updateMesStatusById(Context ctx, String messageId)
			throws BOSException {
		StringBuffer sql = new StringBuffer();
		sql.append(" update t_bas_message set fstatus = 10 where fid = '");
		sql.append(messageId);
		sql.append("'");
		
		DbUtil.execute(ctx, sql.toString());
	}

	/**
     * 获取 已办 任务
     * 改为按照json传递
     */
    @Override
	protected String _getMessageDetailList(Context ctx, String json)
			throws BOSException {
    	//传入为json
    	
    	JSONObject jsonObject = JSONObject.fromObject(json);
    	String userNumber = jsonObject.getString("userNumber");	
    	int m = jsonObject.getInt("m");
    	int n = jsonObject.getInt("n");
    	
		IRowSet wfRowSet;
        StringBuffer data = new StringBuffer();
        logger.debug("-----------_getMessageDetailList----------");
        
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
            logger.error("\u66F4\u65B0\u672A\u8BFB\u8BB0\u5F55\uFF08\u5199\u5165\u53D6\u6570\u636E\u65F6\u4FE1\u606F\uFF09\u65F6\u51FA\u9519", e);
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
            logger.error("\u7528\u7528\u6237\u540D\u83B7\u53D6\u63A5\u6536\u7528\u6237\u4FE1\u606F\u65F6\u51FA\u9519", e1);
        }
        
        String userID = userInfo.getId().toString();
        String personId = userInfo.getPerson().getId().toString();
//        
//        IQueryExecutor exec = null;
//        wfRowSet = null;
//        IMetaDataPK WFQueryPK = new MetaDataPK("com.kingdee.eas.custom.workflow.app", "WFAssignDetailQuery");
//        EntityViewInfo WFEntityView = new EntityViewInfo();
//        FilterInfo filterInfo = new FilterInfo();
//        FilterItemInfo filterItemInfo = new FilterItemInfo("type", new Integer(10)); //0
//        filterInfo.getFilterItems().add(filterItemInfo);
//        filterItemInfo = new FilterItemInfo("sourceStatus", new Integer(8));  //1
//        filterInfo.getFilterItems().add(filterItemInfo);
//        filterItemInfo = new FilterItemInfo("sourceStatus", new Integer(16));	//2
//        filterInfo.getFilterItems().add(filterItemInfo);
//        filterItemInfo = new FilterItemInfo("personEmpID", personId, CompareType.EQUALS);	//3
//        filterInfo.getFilterItems().add(filterItemInfo);
//        filterItemInfo = new FilterItemInfo("receiveTime", lastUpdataTime, CompareType.GREATER_EQUALS); //4
//        filterInfo.getFilterItems().add(filterItemInfo);
//        //暂时只过滤 费用报销单 签呈 的流程 根据实体类型过滤
//        filterItemInfo = new FilterItemInfo("billEntity", "com.kingdee.eas.cp.bc.app.BizAccountBill", CompareType.EQUALS); //5
//        filterInfo.getFilterItems().add(filterItemInfo);
//        filterItemInfo = new FilterItemInfo("billEntity", "%signwasthe table.app.SignWasTheTable", CompareType.LIKE); //6
//        filterInfo.getFilterItems().add(filterItemInfo);
//        
//        filterInfo.setMaskString(" #0 AND ( #1 OR #2 ) AND #3 AND #4 AND ( #5 or #6 ) ");
////        filterInfo.setMaskString(" #0 AND ( #1 OR #2 ) AND #3 AND #6 )");
//        SorterItemInfo sorterItemInfo = null;
//        sorterItemInfo = new SorterItemInfo("receiveTime");
//        sorterItemInfo.setSortType(SortType.DESCEND);
//        WFEntityView.getSorter().add(sorterItemInfo);
//        WFEntityView.setFilter(filterInfo);
//        exec = QueryExecutorFactory.getLocalInstance(ctx, WFQueryPK);
//        exec.setObjectView(WFEntityView);
//        wfRowSet = exec.executeQuery();
        
        data = new StringBuffer();
//        if(wfRowSet == null){
//        	return null;
//        }
        
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
        sql.append(" AND t.fbillEntity in ('com.kingdee.eas.cp.bc.app.BizAccountBill', 'com.kingdee.eas.custom.signwasthetable.app.SignWasTheTable','com.kingdee.eas.bdm.bdapply.app.SupplierReq') ");
        sql.append(" AND t.fpersonEmpID = '");
        sql.append(personId);
        sql.append("') ");
        sql.append(" where num > ").append(m).append(" ");
        sql.append(" and num <= ").append(m+n);
        wfRowSet = DbUtil.executeQuery(ctx, sql.toString());
        
        int num = 1;
        data.append("<?xml version=\"1.0\" encoding=\"GBK\" ?>");
        data.append("\n");
        data.append("<ROWSET>");
        data.append("\n");
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
			    data.append((new StringBuilder()).append("<TITLE>").append(wfRowSet.getString("title")).append("</TITLE>").toString());
			    data.append("\n");
//			    data.append((new StringBuilder()).append("<BODY>").append(wfRowSet.getString("body")).append("</BODY>").toString());
//			    data.append("\n");
			    data.append((new StringBuilder()).append("<SENDER>").append(wfRowSet.getString("sender")).append("</SENDER>").toString());
			    data.append("\n");
			    String time = wfRowSet.getTimestamp("receiveTime").toString();
			    int location = time.lastIndexOf(".");
			    time = time.substring(0, location);
			    data.append((new StringBuilder()).append("<RTIME>").append(time).append("</RTIME>").toString());
			    data.append("\n");
			    data.append((new StringBuilder()).append("<BILLENTITY>").append(wfRowSet.getString("billEntity")).append("</BILLENTITY>").toString());
			    data.append("\n");
			    data.append((new StringBuilder()).append("<BILLID>").append(wfRowSet.getString("bizObjID")).append("</BILLID>").toString());
			    data.append("\n");
			    data.append("</ROW>");
			    data.append("\n");
			    num++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("\u62FC\u88C5\u8FD4\u56DE\u6570\u636E\u6D41\u65F6\u51FA\u9519", e);
	        return "";
		}
        
        data.append("</ROWSET>");
        return data.toString();
	}

	/**
     * 获取待办任务列表
     */
	@Override
	protected String _getMessageList(Context ctx, String json)
			throws BOSException {
		JSONObject jsonObject = JSONObject.fromObject(json);
    	String userNumber = jsonObject.getString("userNumber");	
    	int m = jsonObject.getInt("m");
    	int n = jsonObject.getInt("n");
    	String dataType = jsonObject.getString("type");
    	
		
		IRowSet wfRowSet;
        StringBuffer data = new StringBuffer();
        logger.debug("-----------_getMessageList----------");
        
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
            logger.error("\u66F4\u65B0\u672A\u8BFB\u8BB0\u5F55\uFF08\u5199\u5165\u53D6\u6570\u636E\u65F6\u4FE1\u606F\uFF09\u65F6\u51FA\u9519", e);
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
            logger.error("\u7528\u7528\u6237\u540D\u83B7\u53D6\u63A5\u6536\u7528\u6237\u4FE1\u606F\u65F6\u51FA\u9519", e1);
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
//    		sql.append(" and t1.FBILLENTITY in ('com.kingdee.eas.cp.bc.app.BizAccountBill','com.kingdee.eas.custom.signwasthetable.app.SignWasTheTable') ");
    		sql.append(" and t1.FPERSONUSERID = '").append(userID).append("' ");
    		//sql.append(" and to_char(t1.FCREATEDTIME,'yyyy-mm-dd HH:mm:ss') <'").append(lastUpdateTimeStr).append("' ");
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
		try {
			while(mesRowSet.next()){
				
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
			    
			    String billInfo = this.getBillInfoByIdAndEntity(ctx, bizObjID, billEntity);
			    if(StringUtils.isNotBlank(billInfo)){
			    	billInfo = billInfo.replace("<","&lt;").replace(">","&lt;");
			    }
			    data.append((new StringBuilder()).append("<BILLINFO>").append(billInfo).append("</BILLINFO>").toString());
			    data.append("\n");
			    
			    data.append("</ROW>");
			    data.append("\n");
			    num++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("\u62FC\u88C5\u8FD4\u56DE\u6570\u636E\u6D41\u65F6\u51FA\u9519", e);
	        return "";
		} catch (BOSException e) {
			e.printStackTrace();
			logger.error("\u62FC\u88C5\u8FD4\u56DE\u6570\u636E\u6D41\u65F6\u51FA\u9519", e);
	        return "";
		}
		//获取 工作流通知  未读状态  end
		
        data.append("</ROWSET>");
        return data.toString();
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
			logger
					.error(
							"\u83B7\u53D6\u672A\u8BFB\u6D88\u606F\u8BB0\u5F55id\u65F6\u51FA\u9519",
							e1);
			return null;
		}

		IMsgUnreadCount imuc = MsgUnreadCountFactory.getLocalInstance(ctx);
		IObjectPK pk = new ObjectUuidPK(id);
		try {
			info = imuc.getMsgUnreadCountInfo(pk);
		} catch (EASBizException e) {
			logger
					.error(
							"\u83B7\u53D6\u672A\u8BFB\u8BB0\u5F55info\u5BF9\u8C61\u65F6\u51FA\u9519",
							e);
			return null;
		}
		return info;
	}
	
	/**
	 * 审批
	 */
	@Override
	protected String _quickApprove(Context ctx, String assignIds, String ifpass,
			String opinion, String policy, String userNumber) throws BOSException {
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
				 jsonObject.put("success", map.get("success"));
				 jsonObject.put("result", map.get("result"));
				 jsonObject.put("failedCouunt", map.get("failedCouunt"));
				 jsonObject.put("successCouunt", map.get("successCouunt"));
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
	/* 1783 */           reason = "需指定下一步参与人";
	/*      */         }
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
	/* 1820 */           this.logger.debug("quickApprove timeout :: " + (System.currentTimeMillis() - t1));
	/* 1821 */           ++successCount;
	/*      */         }
	/*      */       }
	/*      */     }
	/*      */     catch (Exception e) {
	/* 1826 */       ++failedCount;
	/* 1827 */       reason = "审批失败";
	/* 1828 */       this.logger.error("lightapp quickApprove error :: ", e);
	/*      */     }
	/* 1830 */     this.logger.debug("submitApprove timeout :: " + (System.currentTimeMillis() - t1));
	/* 1831 */     map.put("success", Boolean.valueOf(true));
	/* 1832 */     map.put("result", reason);
	/* 1833 */     map.put("failedCouunt", Integer.valueOf(failedCount));
	/* 1834 */     map.put("successCouunt", Integer.valueOf(successCount));
	/* 1835 */     return map;
	/*      */   }
	
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
	/*      */
	/*      */
	/*      */
	/*      */         }
	/*      */ 
	/* 1865 */         return true;
	/*      */
	/*      */
	/*      */
	/*      */
	/*      */
	/*      */
	/*      */       }
	/*      */ 
	/*      */     }
	/*      */     catch (Exception e)
	/*      */     {
	/* 1877 */       this.logger.error("lightapp getDecisionItems error :: " + e.getMessage(), e);
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
	

	
	/**
	 * 获取单据审批历史 
	 */
	@Override
	protected String _getApproveHistory(Context ctx, String billId) throws BOSException {
		JSONObject resultJson = new JSONObject();
		resultJson.put("result", "success");
		
		if(StringUtils.isBlank(billId)){
			resultJson.put("result", "success");
			resultJson.put("message", "单据ID不能为空");
			
			return resultJson.toString();
		}
		List list = WorkflowServerBSFInstance.getInstance(ctx).getApproveHistory(billId);
		
		if(list.size() > 0){
			JSONArray dataArray = new JSONArray();
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
		return resultJson.toString();
	}


	
	/**
	 * 根据xtid获取用户信息
	 */
	@Override
	protected String _getUserInfoByXtId(Context ctx, String xtId)
			throws BOSException {
		JSONObject resultJson = new JSONObject();
		resultJson.put("result", "success");
		
		if(StringUtils.isBlank(xtId)){
			resultJson.put("result", "success");
			resultJson.put("message", "xtid不能为空");
			
			return resultJson.toString();
		}
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select t1.fnumber,t1.fname_l2,t.fuserName,t.fuserNumber from t_pm_easxtusermap t ");
		sql.append(" inner join t_bd_person t1 on t1.fid = t.fpersonid ");
		sql.append(" where fxtid = '");
		sql.append(xtId);
		sql.append("'");
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				JSONObject dataObj = new JSONObject();
				dataObj.put("pNumber", rs.getString("fnumber"));
				dataObj.put("pName", rs.getString("fname_l2"));
				dataObj.put("uNumber", rs.getString("fuserNumber"));
				dataObj.put("uName", rs.getString("fuserName"));
				
				resultJson.put("data", dataObj);
			} else {
				resultJson.put("result","false");
				resultJson.put("message", "没有找到对应员工");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			resultJson.put("result","false");
			resultJson.put("message", "查询出错");
		} catch (BOSException e) {
			e.printStackTrace();
			resultJson.put("result","false");
			resultJson.put("message", "查询出错");
		}
		
		return resultJson.toString();
	}
	
	/**
	 * 根据单据id和实体类型 获取 单据详细信息
	 * @param ctx
	 * @param billId
	 * @param billEntity
	 * @return
	 * @throws BOSException 
	 */
	private String getBillInfoByIdAndEntity(Context ctx, String billId, String billEntity) throws BOSException{
		
		if(StringUtils.isBlank(billId) || StringUtils.isBlank(billEntity)){
			return null;
		}
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			JSONObject dataJson = new JSONObject();
			JSONArray aliasArray = new JSONArray();
			JSONArray valueArray = new JSONArray();
			
			BOSUuid uuid = BOSUuid.read(billId);
	    	BOSObjectType bosType = uuid.getType();
			
	    	CoreBaseInfo coreBaseInfo = InfoUtil.getCoreBaseInfo(ctx, bosType.toString(), uuid);
	    	StringBuffer data = new StringBuffer();
	    	
	    	StringBuffer sql = new StringBuffer("/*dialect*/");
	    	sql.append(" select t.fpropertygroup,t.fpropertyname,t.falias_l2 ");
	    	sql.append(" from t_wm_billdigest t ");
	    	sql.append(" where t.fmetadatapk = '");
	    	sql.append(billEntity);
	    	sql.append("' ");
	    	sql.append(" order by t.fpropertygroup desc,nvl(t.findex,-1) asc ");
	    	
		
			IRowSet rs = ToolFacadeFactory.getLocalInstance(ctx).executeQuery(sql.toString());
			
			while (rs.next()) {
	    		String propertygroup = rs.getString(1);
	    		String propertyname = rs.getString(2);
	    		String alias = rs.getString(3);
	    		
//	    		if(StringUtils.isNotBlank(propertygroup)){
//	    			data.append(propertygroup);
//	    		}
	    		
	    		if(StringUtils.isNotBlank(alias)){
	    			data.append(alias).append(": ");
	    			aliasArray.add(alias);
	    		}
	    		
	    		if(StringUtils.isNotBlank(propertyname)){
//	    			System.out.println(propertyname);
	    			if(propertyname.contains(".")){
	    				String[] propertyNames = propertyname.split("\\.");
	    				
	    				CoreBaseInfo propertyCoreBaseInfo = (CoreBaseInfo) coreBaseInfo.get(propertyNames[0]);
	    				if(propertyCoreBaseInfo != null && propertyCoreBaseInfo.getId() != null){
	    					uuid = BOSUuid.read(propertyCoreBaseInfo.getId().toString());
		    		    	bosType = uuid.getType();
		    		    	propertyCoreBaseInfo = InfoUtil.getCoreBaseInfo(ctx, bosType.toString(), uuid);
		    				
		    				if(propertyCoreBaseInfo != null) {
		    					Object valueObj = propertyCoreBaseInfo.get(propertyNames[1]) == null ? "" : propertyCoreBaseInfo.get(propertyNames[1]);
		    					if(valueObj instanceof Date){
		    						data.append(sdf.format(valueObj));	
		    						valueArray.add(sdf.format(valueObj));
		    					} else if (valueObj instanceof String) {
		    						data.append(valueObj.toString());	
		    						valueArray.add(valueObj.toString());
		    					} else {
		    						data.append(valueObj);	
		    						valueArray.add(valueObj);
		    					}
		    				
		    				}	
	    				}
	    				
	    			
	    			} else {
	    				Object valueObj = coreBaseInfo.get(propertyname) == null ? "" : coreBaseInfo.get(propertyname);
	    				if(valueObj instanceof Date){
    						data.append(sdf.format(valueObj));	
    						valueArray.add(sdf.format(valueObj));
    					} else if (valueObj instanceof String) {
    						data.append(valueObj.toString());	
    						valueArray.add(valueObj.toString());
    					} else {
    						data.append(valueObj);	
    						valueArray.add(valueObj);
    					}

	    			}
	    			
	    		} else {
	    			valueArray.add("");
	    		}
	    		data.append("\n");
	    		
	    	}
			
			dataJson.put("alias", aliasArray);
			dataJson.put("value", valueArray);
			
			return dataJson.toString();
			
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (UuidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	//通过手机号码获取人员FNumber
	@Override
	protected String _getFNumberByPhone(Context ctx, String phone)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		String fnumber = "";
		JSONObject resultJson = new JSONObject();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT FNUMBER FROM T_PM_USER WHERE ");
		sb.append("FCELL='");
		sb.append(phone);
		sb.append("'");
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try {
			if(rs.next()){
				fnumber = rs.getString("FNUMBER");
				resultJson.put("result", true);
				resultJson.put("FNumber", fnumber);
			}else{
				resultJson.put("result", false);
				resultJson.put("failReason", "此号码人员不存在!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultJson.toString();
	}

}