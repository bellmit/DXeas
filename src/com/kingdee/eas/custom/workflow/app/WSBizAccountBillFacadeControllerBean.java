package com.kingdee.eas.custom.workflow.app;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.ejb.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.EASResource;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.base.permission.UserFactory;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitFactory;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.FullOrgUnitFactory;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.basedata.org.PositionFactory;
import com.kingdee.eas.basedata.org.PositionInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.cp.bc.BizAccountBillAccountEntryInfo;
import com.kingdee.eas.cp.bc.BizAccountBillEntryCollection;
import com.kingdee.eas.cp.bc.BizAccountBillEntryFactory;
import com.kingdee.eas.cp.bc.BizAccountBillEntryInfo;
import com.kingdee.eas.cp.bc.BizAccountBillFactory;
import com.kingdee.eas.cp.bc.BizAccountBillInfo;
import com.kingdee.eas.cp.bc.CollectionAccountFactory;
import com.kingdee.eas.cp.bc.CollectionAccountInfo;
import com.kingdee.eas.cp.bc.EntryStateEnum;
import com.kingdee.eas.cp.bc.ExpenseTypeFactory;
import com.kingdee.eas.cp.bc.ExpenseTypeInfo;
import com.kingdee.eas.cp.bc.IBizAccountBill;
import com.kingdee.eas.cp.bc.IBizAccountBillEntry;
import com.kingdee.eas.cp.bc.ImageStateEnum;
import com.kingdee.eas.cp.bc.OperationTypeFactory;
import com.kingdee.eas.cp.bc.OperationTypeInfo;
import com.kingdee.eas.cp.bc.StateEnum;
import com.kingdee.eas.custom.workflow.constant.BizAccountBillConstant;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.im.inv.ws.ImportException;
import com.kingdee.eas.scm.im.inv.ws.util.ErrorCodeUtil;
import com.kingdee.eas.scm.im.inv.ws.util.InfoUtil;
import com.kingdee.eas.scm.im.inv.ws.util.XMLUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

import java.io.IOException;
import java.lang.String;
import java.math.BigDecimal;

public class WSBizAccountBillFacadeControllerBean extends AbstractWSBizAccountBillFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.workflow.app.WSBizAccountBillFacadeControllerBean");
	
    /**
     * 获取费用报销单列表
     */
    @Override
	protected String _getBizAccountBillList(Context ctx, String dataJson)
			throws BOSException {
    	
    	JSONObject resultJson = new JSONObject();
		resultJson.put("result", "success");
		
    	JSONObject jsonObject = JSONObject.fromObject(dataJson);
    	if(!jsonObject.containsKey("userNumber")){
    		resultJson.put("result", "false");
			resultJson.put("message", "用户编号不能为空");
			return resultJson.toString();
    	}
    	int m = 0;
    	int n = 0;
    	if((!jsonObject.containsKey("m")) || (!jsonObject.containsKey("n"))){
    		resultJson.put("result", "false");
			resultJson.put("message", "分页为空");
			return resultJson.toString();
    	}
    	
    	String userNumber = jsonObject.getString("userNumber");
    	m = jsonObject.getInt("m");
    	n = jsonObject.getInt("n");

    	String personId = "";
    	StringBuffer sql = new StringBuffer();
		sql.append(" select fpersonid from t_pm_user where fnumber = '");
		sql.append(userNumber);
		sql.append("'");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
    	try {
			if(rs.next()){
				personId = rs.getString("fpersonid");
			}else {
				resultJson.put("result", "false");
				resultJson.put("message", "未找到对应职员");
				return resultJson.toString();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			resultJson.put("result", "false");
			resultJson.put("message", "未找到对应职员");
			return resultJson.toString();
		}
		
    	sql = new StringBuffer("/*dialect*/");
    	sql.append(" select * from ( ");
    	sql.append(" select row_number() over ( ORDER BY t.fcreatetime DESC) as num, ");
    	sql.append(" t.fid,t.fnumber,to_char(t.fbizdate,'yyyy-mm-dd') as fbizdate, ");
    	sql.append(" p.fname_l2 as personName,t.famount,t.fstate ");
    	sql.append(" from t_bc_bizaccountbill t ");
    	sql.append(" inner join t_bd_person p on p.fid = t.fapplierid ");
    	sql.append(" where p.fid = '");
    	sql.append(personId);
    	sql.append("') ");
    	sql.append(" where num > ").append(m).append(" ");
        sql.append(" and num <= ").append(m+n);
    	
        IRowSet rsData = DbUtil.executeQuery(ctx, sql.toString());
        try {
        	JSONArray dataArray = new JSONArray();
			while(rsData.next()){
				JSONObject dataObject = new JSONObject();
				dataObject.put("fid", rsData.getString("fid"));
				dataObject.put("fnumber", rsData.getString("fnumber"));
				dataObject.put("fbizdate", rsData.getString("fbizdate"));
				dataObject.put("personName", rsData.getString("personName"));
				dataObject.put("famount", rsData.getString("famount"));
				String state = rsData.getString("fstate");
				StateEnum stateEnum = StateEnum.getEnum(Integer.parseInt(state));
				dataObject.put("status", stateEnum.getAlias());
				
				dataArray.add(dataObject);
			}
			
			resultJson.put("data", dataArray);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			resultJson.put("result", "false");
			resultJson.put("message", "查询费用报销单报错");
			return resultJson.toString();
		}
        
    	return resultJson.toString();
	}

	/**
     * 根据委派id 获取 单据信息 
     * 20170310 macheng edit 改为按照billid取数
     */
    @Override
	protected String _getBizAccountBillByAssignId(Context ctx, String billId) throws BOSException {
		
    	JSONObject resultJson = new JSONObject();
		resultJson.put("result", "success");
		
		if(StringUtils.isBlank(billId)){
			resultJson.put("result", "false");
			resultJson.put("message", "ID不能为空");
			return resultJson.toString();
		}
		
		String bizAccountBillId = billId;
		
//		StringBuffer sql = new StringBuffer();
//		sql.append(" select fbizobjid from t_wfr_assign where fassignid = '");
//		sql.append(assignId);
//		sql.append("' ");
//		
//		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
//		try {
//			if(rs.next()){
//				bizAccountBillId = rs.getString("fbizobjid");
//			}else {
//				sql = new StringBuffer();
//				sql.append(" select fbizobjid from T_WFR_AssignDetail where fassignid = '");
//				sql.append(assignId);
//				sql.append("' ");
//				
//				rs = DbUtil.executeQuery(ctx, sql.toString());
//				
//				if(rs.next()){
//					bizAccountBillId = rs.getString("fbizobjid");
//				}
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//			resultJson.put("result", "false");
//			resultJson.put("message", "查询出错");
//			return resultJson.toString();
//		}
    	
		if(StringUtils.isNotBlank(bizAccountBillId)){
			System.out.println("bizAccountBillId:"+bizAccountBillId);
			try {
				BizAccountBillInfo accountBillInfo = BizAccountBillFactory.getLocalInstance(ctx).getBizAccountBillInfo(new ObjectUuidPK(bizAccountBillId));
				
				JSONObject dataJson = new JSONObject();

				dataJson.put("feasid", accountBillInfo.getId().toString());
				dataJson.put("fnumber", accountBillInfo.getNumber());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				dataJson.put("fbizdate", sdf.format(accountBillInfo.getBillDate()));

				PersonInfo personInfo = accountBillInfo.getApplier();
//				String userid = "";
//				sql = new StringBuffer();
//				sql.append(" select fid from t_pm_user where fpersonid = '");
//				sql.append(personInfo.getId().toString());
//				sql.append("'");
//				rs = DbUtil.executeQuery(ctx, sql.toString());
//				if(rs.next()){
//					userid = rs.getString("fid");
//				}
//				UserInfo useInfo = UserFactory.getLocalInstance(ctx).getUserInfo(new ObjectUuidPK(userid));
				personInfo = PersonFactory.getLocalInstance(ctx).getPersonInfo(new ObjectUuidPK(personInfo.getId().toString()));
				dataJson.put("fappliernumber", personInfo.getNumber());
				dataJson.put("fappliername", personInfo.getName());
				
				CompanyOrgUnitInfo companyOrgUnitInfo = accountBillInfo.getApplierCompany();
				companyOrgUnitInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(companyOrgUnitInfo.getId().toString()));
				dataJson.put("fappliercompanynumber", companyOrgUnitInfo.getNumber());
				dataJson.put("fappliercompanyname", companyOrgUnitInfo.getName());
				
				AdminOrgUnitInfo adminOrgUnitInfo = accountBillInfo.getOrgUnit();
				adminOrgUnitInfo = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(adminOrgUnitInfo.getId().toString()));
				dataJson.put("fapplierdeptnumber", adminOrgUnitInfo.getNumber());
				dataJson.put("fapplierdeptname", adminOrgUnitInfo.getName());
				
				PositionInfo positionInfo = accountBillInfo.getPosition();
				positionInfo = PositionFactory.getLocalInstance(ctx).getPositionInfo(new ObjectUuidPK(positionInfo.getId().toString()));
				dataJson.put("fapplierpositionnumber", positionInfo.getNumber());
				dataJson.put("fapplierpositionname", positionInfo.getName());
				
				companyOrgUnitInfo = accountBillInfo.getCompany();
				companyOrgUnitInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(companyOrgUnitInfo.getId().toString()));
				dataJson.put("fcostedcompanynumber", companyOrgUnitInfo.getNumber());
				dataJson.put("fcostedcompanyname", companyOrgUnitInfo.getName());
				
				CostCenterOrgUnitInfo centerOrgUnitInfo = accountBillInfo.getCostedDept();
				centerOrgUnitInfo = CostCenterOrgUnitFactory.getLocalInstance(ctx).getCostCenterOrgUnitInfo(new ObjectUuidPK(centerOrgUnitInfo.getId().toString()));
				dataJson.put("fcosteddeptnumber", centerOrgUnitInfo.getNumber());
				dataJson.put("fcosteddeptname", centerOrgUnitInfo.getName());
				
				dataJson.put("famount", accountBillInfo.getAmount());
				dataJson.put("fcause", accountBillInfo.getCause());
				
				dataJson.put("fstate", accountBillInfo.getState().getValue());
				dataJson.put("fstatename", accountBillInfo.getState().getAlias());
				
				JSONArray entryDataJSON = new JSONArray();
				
				BizAccountBillEntryCollection collection = accountBillInfo.getEntries();
				for(int i=0,len=collection.size();i<len;i++){
					JSONObject entryJSON = new JSONObject();
					BizAccountBillEntryInfo entryInfo = collection.get(i);
					
					OperationTypeInfo operationTypeInfo = entryInfo.getOperationType();
					operationTypeInfo = OperationTypeFactory.getLocalInstance(ctx).getOperationTypeInfo(new ObjectUuidPK(operationTypeInfo.getId().toString()));
					entryJSON.put("foperationtypenumber", operationTypeInfo.getNumber());
					entryJSON.put("foperationtypename", operationTypeInfo.getName());
					
					ExpenseTypeInfo expenseTypeInfo = entryInfo.getExpenseType();
					expenseTypeInfo = ExpenseTypeFactory.getLocalInstance(ctx).getExpenseTypeInfo(new ObjectUuidPK(expenseTypeInfo.getId().toString()));
					entryJSON.put("fexpensetypenumber",  expenseTypeInfo.getNumber());
					entryJSON.put("fexpensetypename", expenseTypeInfo.getName());
					
					centerOrgUnitInfo = entryInfo.getCostCenter();
					centerOrgUnitInfo = CostCenterOrgUnitFactory.getLocalInstance(ctx).getCostCenterOrgUnitInfo(new ObjectUuidPK(centerOrgUnitInfo.getId().toString()));
					entryJSON.put("fcosteddeptnumber", centerOrgUnitInfo.getNumber());
					entryJSON.put("fcosteddeptname", centerOrgUnitInfo.getName());
					
					companyOrgUnitInfo = entryInfo.getCompany();
					companyOrgUnitInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(companyOrgUnitInfo.getId().toString()));
					entryJSON.put("fcostedcompanynumber", companyOrgUnitInfo.getNumber());
					entryJSON.put("fcostedcompanyname", companyOrgUnitInfo.getName());
					
					entryJSON.put("fseq", entryInfo.getSeq());
					entryJSON.put("fhappentime", sdf.format(entryInfo.getHappenTime()));
					entryJSON.put("fpurpose", entryInfo.getPurpose());
					entryJSON.put("famount", entryInfo.getAmount());
					
					entryDataJSON.add(entryJSON);
				}
				
				dataJson.put("entrys", entryDataJSON);
				
				resultJson.put("data", dataJson);
				
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				resultJson.put("result", "false");
				resultJson.put("message", "查询出错");
			} 
			
		}else {
			resultJson.put("result", "false");
			resultJson.put("message", "未找到对应的单据");
			
		}
    	
		return resultJson.toString();
	}
    
    /**
     * 获取业务类型
     */
    @Override
	protected String _getBizType(Context ctx, String userId)
			throws BOSException {
		
    	JSONObject resultJson = new JSONObject();
		resultJson.put("result", "success");
		
		if(StringUtils.isBlank(userId)){
			resultJson.put("result", "false");
			resultJson.put("message", "用户编号不能为空");
			
			return resultJson.toString();
		}
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select fpersonid from t_pm_user where fnumber = '");
		sql.append(userId);
		sql.append("' ");
		
		String personid = "";
		try {
			
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				personid = rs.getString("fpersonid");
			}else {
				resultJson.put("result","false");
				resultJson.put("message", "没有找到对应职员");
				return resultJson.toString();
			}
			
			sql = new StringBuffer();
			sql.append(" select t.fnumber,t.fname_l2 ");
			sql.append(" from T_BC_OperationType t ");
			sql.append(" left join t_bc_bizaccountbillentry te on te.foperationtypeid = t.fid ");
			sql.append(" inner join t_bc_bizaccountbill tb on tb.fid = te.fbillid ");
			sql.append(" where t.fisenable = 1 ");
			sql.append(" and (tb.FApplierID = '");
			sql.append(personid);
			sql.append("' ");
			sql.append(" or tb.FApplierID is null) ");
			sql.append(" group by t.fnumber, t.fname_l2 ");
			sql.append(" order by count(1) desc, t.fnumber asc ");
			IRowSet rsType = DbUtil.executeQuery(ctx, sql.toString());
			
			JSONArray dataJson = new JSONArray();
			
			while(rsType.next()){
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("fnumber", rsType.getString("fnumber"));
				jsonObject.put("fname", rsType.getString("fname_l2"));
				
				dataJson.add(jsonObject);
				
			}
			
			resultJson.put("data", dataJson);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			resultJson.put("result", "false");
			resultJson.put("message", "查询出错");
		}
    	return resultJson.toString();
	}

    /**
     * 根据业务类型获取费用类型
     */
	@Override
	protected String _getExpTypeByBizType(Context ctx, String bizType, String userNumber)
			throws BOSException {
		JSONObject resultJson = new JSONObject();
		resultJson.put("result", "success");
		
		if(StringUtils.isBlank(bizType)){
			resultJson.put("result", "false");
			resultJson.put("message", "业务类型不能为空");
			
			return resultJson.toString();
		}
		if(StringUtils.isBlank(userNumber)){
			resultJson.put("result", "false");
			resultJson.put("message", "用户编号不能为空");
			
			return resultJson.toString();
		}
		StringBuffer sql = new StringBuffer();
		sql.append(" select fpersonid from t_pm_user where fnumber = '");
		sql.append(userNumber);
		sql.append("' ");
		
		String personid = "";
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				personid = rs.getString("fpersonid");
			}else {
				resultJson.put("result","false");
				resultJson.put("message", "没有找到对应职员");
				return resultJson.toString();
			}
		
			sql = new StringBuffer();
			sql.append(" select t.fnumber, t.fname_l2 from t_bc_expensetype t ");
			sql.append(" inner join t_bc_operationtype t1 on t1.fid = t.foperationtypeid ");
			sql.append(" left join t_bc_bizaccountbillentry te on te.fexpensetypeid = t.fid ");
			sql.append(" inner join t_bc_bizaccountbill tb on tb.fid = te.fbillid ");
			sql.append(" where t.fisstart = 1 and t1.fisenable = 1 ");
			sql.append(" and t1.fnumber = '");
			sql.append(bizType);
			sql.append("' ");
			sql.append(" and (tb.FApplierID = '");
			sql.append(personid);
			sql.append("' ");
			sql.append(" or tb.FApplierID is null) ");
			sql.append(" group by t.fnumber,t.fname_l2 ");
			sql.append(" order by count(1) desc, t.fnumber asc ");
		

			IRowSet rsType = DbUtil.executeQuery(ctx, sql.toString());
			
			JSONArray dataJson = new JSONArray();
			
			while(rsType.next()){
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("fnumber", rsType.getString("fnumber"));
				jsonObject.put("fname", rsType.getString("fname_l2"));
				
				dataJson.add(jsonObject);
			}
			
			resultJson.put("data", dataJson);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			resultJson.put("result", "false");
			resultJson.put("message", "查询出错");
		}
		return resultJson.toString();
	}

	/**
     * 根据组织获取下级部门列表
     */
	@Override
	protected String _getDeptListByCompany(Context ctx, String company)
			throws BOSException {
		JSONObject resultJson = new JSONObject();
		resultJson.put("result", "success");
		
		if(StringUtils.isBlank(company)){
			resultJson.put("result", "false");
			resultJson.put("message", "组织编号不能为空");
			
			return resultJson.toString();
		}
		
		StringBuffer sql = new StringBuffer("/*dialect*/");
		sql.append(" select t.fnumber,t.fname_l2 ");
		sql.append(" from t_org_admin t ");
		sql.append(" where t.fiscostorgunit = 1 ");
		sql.append(" and t.fisleaf = 1 ");
		sql.append(" connect by prior t.fid = t.fparentid ");
		sql.append(" start with t.fnumber = '");
		sql.append(company);
		sql.append("'");
		sql.append(" order by t.fnumber asc ");
		
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try {
			
			JSONArray dataJson = new JSONArray();
			
			while(rs.next()){
				JSONObject dataObject = new JSONObject();
				dataObject.put("deptNumber", rs.getString("fnumber"));
				dataObject.put("deptName", rs.getString("fname_l2"));
				
				dataJson.add(dataObject);
			}
			
			resultJson.put("data", dataJson);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			resultJson.put("result", "false");
			resultJson.put("message", "查询出错");
			
		}

		return resultJson.toString();
	}

	/**
	 * 根据用户获取 组织 部门  职位信息
	 */
	@Override
	protected String _getOrgInfoByUser(Context ctx, String user)
			throws BOSException {
		JSONObject resultJson = new JSONObject();
		resultJson.put("result", "success");
		
		JSONObject dataObject = new JSONObject();
		
		if(StringUtils.isBlank(user)){
			resultJson.put("result", "false");
			resultJson.put("message", "用户编号不能为空");
			
			return resultJson.toString();
		}
		
		String easUserId = "";
		String easPersonId = "";
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select t.fid ,t.fpersonid from t_pm_user t where t.fnumber = '");
		sql.append(user);
		sql.append("'");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try {
			if(rs.next()){
				easUserId = rs.getString("fid");
				easPersonId = rs.getString("fpersonid");
			}
			
			if(StringUtils.isBlank(easUserId)){
				resultJson.put("result", "false");
				resultJson.put("message", "没有找到对应EAS用户");
				
				return resultJson.toString();
			}
			//获取 缺省组织 
			UserInfo userInfo = UserFactory.getLocalInstance(ctx).getUserInfo(new ObjectUuidPK(easUserId));
			FullOrgUnitInfo orgUnitInfo = userInfo.getDefOrgUnit();
			orgUnitInfo = FullOrgUnitFactory.getLocalInstance(ctx).getFullOrgUnitInfo(new ObjectUuidPK(orgUnitInfo.getId()));
			dataObject.put("orgNumber", orgUnitInfo.getNumber());
			dataObject.put("orgName", orgUnitInfo.getName());
			
			if(StringUtils.isBlank(easPersonId)){
				resultJson.put("result", "false");
				resultJson.put("message", "没有找到对应EAS职员");
				
				return resultJson.toString();
			}
			
			sql = new StringBuffer();
			sql.append(" select p.fid as pID,p.fnumber as pNumber,p.fname_l2 as pName,pt.fnumber as ptNumber,pt.fname_l2 as ptName,d.fnumber as deptNumber,d.fname_l2 as deptName ");
			sql.append(" from t_bd_person p ");
			sql.append(" inner join T_ORG_PositionMember m on m.fpersonid = p.fid ");
			sql.append(" inner join t_org_position pt on pt.fid = m.fpositionid ");
			sql.append(" inner join t_org_admin d on d.fid = pt.fadminorgunitid ");
			sql.append(" where p.fid = '").append(easPersonId).append("'");
			sql.append(" and m.fisprimary = 1");
			
			rs = DbUtil.executeQuery(ctx, sql.toString());
			
			if(rs.next()){
				dataObject.put("pNumber", rs.getString("pNumber"));
				dataObject.put("pName", rs.getString("pName"));
				dataObject.put("ptNumber", rs.getString("ptNumber"));
				dataObject.put("ptName", rs.getString("ptName"));
				dataObject.put("deptNumber", rs.getString("deptNumber"));
				dataObject.put("deptName", rs.getString("deptName"));
				dataObject.put("pID", rs.getString("pID"));
				dataObject.put("UID", easUserId);
			}
			
			resultJson.put("data", dataObject);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			resultJson.put("result", "false");
			resultJson.put("message", "查询出错");
			
			return resultJson.toString();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			resultJson.put("result", "false");
			resultJson.put("message", "获取用户报错");
			
			return resultJson.toString();
		}
		
		return resultJson.toString();
	}
	
	/**
	 * 根据用户获取 可选 组织列表
	 */
	@Override
	protected String _getOrgListByUser(Context ctx, String userId)
			throws BOSException {
		
		JSONObject resultJson = new JSONObject();
		resultJson.put("result", "success");
		
		if(StringUtils.isBlank(userId)){
			resultJson.put("result", "false");
			resultJson.put("message", "用户编号不能为空");
			
			return resultJson.toString();
		}
		
		String easUserId = "";
		String easPersonId = "";
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select t.fid ,t.fpersonid from t_pm_user t where t.fnumber = '");
		sql.append(userId);
		sql.append("'");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try {
			if(rs.next()){
				easUserId = rs.getString("fid");
				easPersonId = rs.getString("fpersonid");
			}
			
			if(StringUtils.isBlank(easUserId)){
				resultJson.put("result", "false");
				resultJson.put("message", "没有找到对应EAS用户");
				
				return resultJson.toString();
			}
			
			if(StringUtils.isBlank(easPersonId)){
				resultJson.put("result", "false");
				resultJson.put("message", "没有找到对应EAS职员");
				
				return resultJson.toString();
			}
			
			JSONArray dataJson = new JSONArray();
			
			sql.setLength(0);
			sql.append(" select torg.fnumber,torg.fname_l2,torg.fid ");
			sql.append(" from t_pm_orgRange tRange");
			sql.append(" inner join t_org_company torg on torg.fid=tRange.FOrgID");
			sql.append(" where FUserID='").append(easUserId).append("'");
			sql.append(" and FType=10 ");
			sql.append(" order by fnumber asc ");
			rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				JSONObject dataObject = new JSONObject();
				dataObject.put("orgNumber", rs.getString("fnumber"));
				dataObject.put("orgName", rs.getString("fname_l2"));
				dataObject.put("orgID", rs.getString("fid"));
				dataJson.add(dataObject);
			}
			
			resultJson.put("data", dataJson);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			resultJson.put("result", "false");
			resultJson.put("message", "");
			
			return resultJson.toString();
		}
		
		return resultJson.toString();
	}

	/**
	 * 导入费用报销单
	 */
	@Override
	protected String _importBizAccountBill(Context ctx, String dataXml)
			throws BOSException {
		JSONObject resultJson = new JSONObject();
		resultJson.put("result", "success");
		JSONObject dataJson = new JSONObject();
		try {
			Document doc = XMLUtil.builderDocument(dataXml);
			if (doc != null) {
				Element rootElement = doc.getDocumentElement();
				if (!rootElement.getTagName().equals("BizAccountBill"))
					throw new ImportException(
							ImportException.BILLXMLFORMATEXCEPTION);
				BizAccountBillInfo bizAccountBillInfo = new BizAccountBillInfo();
				HashMap billHeadMap = XMLUtil.getBillHead(doc);
				if (billHeadMap == null)
					throw new ImportException(
							ImportException.XMLBILHEADEXCEPTION);
				ArrayList billEntriesList = XMLUtil.getBillEntries(doc);
				if (billEntriesList == null)
					throw new ImportException(
							ImportException.XMLBUILDENTRYEXCEPTION);
				validateProperty(billHeadMap, billEntriesList);
				CtrlUnitInfo cuInfo = InfoUtil.getCtrolUnitInfo(ctx,
						(String) billHeadMap.get("CU"));
				if (cuInfo == null)
					throw new ImportException(ImportException.CUEXCEPTION);
				ContextUtil.setCurrentCtrlUnit(ctx, cuInfo);
				
//				CompanyOrgUnitInfo company = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK("BUYAAAAAAATM567U"));
//				ContextUtil.setCurrentFIUnit(ctx, company);
				
				IBizAccountBill bizAccountBill = BizAccountBillFactory.getLocalInstance(ctx);
				IObjectPK pk = null;
				IBizAccountBillEntry bizAccountBillEntry = BizAccountBillEntryFactory.getLocalInstance(ctx);
				
				String fid = "";
				if(billHeadMap.containsKey("fid")){
					fid = (String) billHeadMap.get("fid");
					System.out.println("fid:"+fid);
					if(StringUtils.isNotBlank(fid)){
						bizAccountBillInfo = bizAccountBill.getBizAccountBillInfo(new ObjectUuidPK(fid));	
					}
					
				} 

				if(bizAccountBillInfo.getCollectionEntries().size() > 0){
					IObjectPK[] pks = new IObjectPK[bizAccountBillInfo.getCollectionEntries().size()];
					for(int i=0;i<bizAccountBillInfo.getCollectionEntries().size();i++){
						pks[i] = new ObjectUuidPK(bizAccountBillInfo.getCollectionEntries().get(i).getId());
					}
					bizAccountBillEntry.delete(pks);
					System.out.println("size:"+bizAccountBillInfo.getCollectionEntries().size());
					
//					bizAccountBillInfo.getCollectionEntries().clear();
				}
				
				buildBillHead(ctx, bizAccountBillInfo, billHeadMap, cuInfo.getId()
						.toString());
				
				builBillEntries(ctx, bizAccountBillInfo, billEntriesList, null);
				
				ContextUtil.setCurrentFIUnit(ctx, bizAccountBillInfo.getCompany());
				ContextUtil.setCurrentUserInfo(ctx, bizAccountBillInfo.getBiller());
				ctx.setCaller(new ObjectUuidPK(bizAccountBillInfo.getBiller().getId()));

				
					StateEnum status = bizAccountBillInfo.getState();
					
					
//					pk = bizAccountBill.save(bizAccountBillInfo);
//					bizAccountBillInfo = bizAccountBill.getBizAccountBillInfo(pk);
//					bizAccountBill.submit(bizAccountBillInfo);
					
					System.out.println("pk:"+pk);
					if (StateEnum.SUBMIT.equals(status)){
						pk = bizAccountBill.submit(bizAccountBillInfo);
//						if(bizAccountBillInfo.getId() == null){
//							pk = bizAccountBill.submit(bizAccountBillInfo);
//						} else {
//							CoreBaseCollection collection = new CoreBaseCollection();
//							collection.add(bizAccountBillInfo);
//							bizAccountBill.update(collection);
//							pk = new ObjectUuidPK(bizAccountBillInfo.getId());
//						};
						
					} else if (StateEnum.DRAFT.equals(status)) {
						pk = bizAccountBill.save(bizAccountBillInfo);
//						if(bizAccountBillInfo.getId() == null){
//							pk = bizAccountBill.save(bizAccountBillInfo);	
//						} else {
//							CoreBaseCollection collection = new CoreBaseCollection();
//							collection.add(bizAccountBillInfo);
//							bizAccountBill.update(collection);
//							
//							pk = new ObjectUuidPK(bizAccountBillInfo.getId());
//						};
						
					}
					
					if(pk != null){
						bizAccountBillInfo = bizAccountBill.getBizAccountBillInfo(pk);
					}
				
					dataJson.put("id", bizAccountBillInfo.getId().toString());
					dataJson.put("number", bizAccountBillInfo.getNumber());
					resultJson.put("data", dataJson);
				}
		} catch (EASBizException e) {
			
			logger.error("EASBizException-----"+e);
			
			resultJson.put("result", "false");
			resultJson.put("message", e.getMessage());
		} catch (SAXException e) {
			ImportException excep = new ImportException(
					ImportException.PRASERXMLEXCEPTION);
			
			logger.error("SAXException-----"+excep);
			
			resultJson.put("result", "false");
			resultJson.put("message", e.getMessage());
		} catch (IOException e) {
			ImportException excep = new ImportException(
					ImportException.READXMLIOEXCEPTION);
			
			resultJson.put("result", "false");
			resultJson.put("message", e.getMessage());
			
		} catch (ParserConfigurationException e) {
			ImportException excep = new ImportException(
					ImportException.CONVERFORMATEXCEPTION);

			
			logger.error("ParserConfigurationException--------"+excep);
			
			resultJson.put("result", "false");
			resultJson.put("message", e.getMessage());
		} catch (TransformerException e) {
			ImportException excep = new ImportException(
					ImportException.WRITERXMLEXCEPTION);
			
			logger.error("TransformerException------"+excep);
			
			resultJson.put("result", "false");
			resultJson.put("message", e.getMessage());
		} catch (BOSException e) {
			ImportException excep = new ImportException(
					new NumericExceptionSubItem("bosException", e.getMessage()));
			
			logger.error("BOSException------"+excep);
			
			resultJson.put("result", "false");
			resultJson.put("message", e.getMessage());
		}
		
		return resultJson.toString();
	}
	/**
	 * 验证单据头与单据体字段
	 * @param billHeadMap
	 * @param billEntriesList
	 * @throws EASBizException
	 */
	private void validateProperty(HashMap billHeadMap, ArrayList billEntriesList)
			throws EASBizException {
		String bilHeadProps[] = BizAccountBillConstant.getMustValidateHeadProperties();
		HashMap errorMap = ErrorCodeUtil.getHeadErrorMap();
		for (int i = 0; i < bilHeadProps.length; i++)
			if (!InfoUtil.validateProperty(billHeadMap, bilHeadProps[i])) {
				NumericExceptionSubItem numberExc = (NumericExceptionSubItem) errorMap
						.get(bilHeadProps[i]);
				if (numberExc == null)
					numberExc = new NumericExceptionSubItem(bilHeadProps[i],
							(new StringBuilder()).append(bilHeadProps[i])
									.append(" must fill!!").toString());
				throw new ImportException(numberExc);
			}
		HashMap entryMap = null;
		errorMap = ErrorCodeUtil.getEntryErrorMap();
		String bilEntriesProps[] = BizAccountBillConstant
				.getMustValidateEntryProperties();
		for (int i = 0; i < billEntriesList.size(); i++) {
			entryMap = (HashMap) billEntriesList.get(i);
			for (int j = 0; j < bilEntriesProps.length; j++){
				if (!InfoUtil.validateProperty(entryMap, bilEntriesProps[j])) {
					NumericExceptionSubItem numberExc = (NumericExceptionSubItem) errorMap
					.get(bilEntriesProps[j]);
					if (numberExc == null)
						numberExc = new NumericExceptionSubItem(
								bilEntriesProps[j], (new StringBuilder())
								.append(bilEntriesProps[j]).append(
								" must fill!!").toString());
					throw new ImportException(numberExc);
				}
			}
		}
	}
	
	private void buildBillHead(Context ctx, BizAccountBillInfo info,
			HashMap billHeadMap, String cuId) throws EASBizException, BOSException {
		setStrProperties(info, billHeadMap, true);
		setBooleanProperties(info, billHeadMap, true);
		setIntProperties(info, billHeadMap, true);
		setDeciamlProperties(info, billHeadMap, true);
		seTimeStampProperties(info, billHeadMap, true);
		setDateProperties(info, billHeadMap, true);
		setLinkProperties(ctx, info, billHeadMap, cuId, true);
		
//		UserInfo userInfo = ContextUtil.getCurrentUserInfo(ctx);
//		info.setBiller();
//		Date day = new Date();
//		info.setBillDate(day);
//		info.setAuditor(userInfo);
//		info.setAuditDate(day);
		
		//处理单据头字段
		//名称
		info.setName("费用报销单");
		//影像状态
		info.setIsRefPaperPark(ImageStateEnum.NO_IMAGE);
		//核定金额
		info.setAmountApproved(info.getAmount());
		//付现金额
		info.setAmountEncashed(info.getAmount());
		//未付金额
//		info.setAmountNotPaid(info.getAmount());
		//业务日期 默认为当前日期
		info.setBizDate(new Date());
		info.setBizReqDate(new Date());
		info.setBillDate(new Date());
		
		info.setCreator(info.getBiller());
		info.setLastUpdateUser(info.getBiller());
		info.setCreateTime(new Timestamp((new Date()).getTime()));
		info.setLastUpdateTime(new Timestamp((new Date()).getTime()));
		
	}
	
	private void builBillEntries(Context ctx, BizAccountBillInfo info,
			ArrayList entriesList, String cuID) throws BOSException, 
			EASBizException {
		if (entriesList == null) {
			return;
		}
		if (entriesList != null) {
			for (int i = 0; i < entriesList.size(); i++) {
				HashMap<?, ?> entryMap = (HashMap) entriesList.get(i);
				BizAccountBillEntryInfo entryInfo = new BizAccountBillEntryInfo();
//				CompanyOrgUnitInfo company = info.getCompany();
//				if(company == null){
//					company = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(info.getCU().getId()));
//					
//				}else{
//					company = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(company.getId()));
//				}
//				String oppAccount = (String)entryMap.get("account");
//				String fid = getAccountIdByAccountNo(ctx, oppAccount, company.getId().toString());
//				entryMap.put("account", fid);

				setStrProperties(entryInfo, entryMap, false);
				setBooleanProperties(entryInfo, entryMap, false);
				setIntProperties(entryInfo, entryMap, false);
				setDeciamlProperties(entryInfo, entryMap, false);
				seTimeStampProperties(entryInfo, entryMap, false);
				setDateProperties(entryInfo, entryMap, false);
				setLinkProperties(ctx, entryInfo, entryMap, cuID, false);
				entryInfo.setSeq(i);
				
				//处理分录字段
				//汇率
				entryInfo.setExchangeRate(new BigDecimal("1.00"));
				//核定金额
				entryInfo.setAmountApproved(entryInfo.getAmount());
				entryInfo.setAmountApprovedOri(entryInfo.getAmount());
				//金额原币
				entryInfo.setAmountOri(entryInfo.getAmount());
				//币种
				entryInfo.setCurrencyType(info.getCurrencyType());
				
				entryInfo.setBudgetDo(entryInfo.getAmount());
				entryInfo.setBudgetUsed(entryInfo.getAmount());
				
				entryInfo.setReceiveState(EntryStateEnum.UNDONE);
				entryInfo.setPayState(EntryStateEnum.UNDONE);
				
				info.getEntries().add(entryInfo);
			}
		}
		//收款信息
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select fid from T_BC_CollectionAccount where cfstate = 1 ");
		sql.append(" and cfapplierid = '");
		sql.append(info.getApplier().getId().toString());
		sql.append("' ");
		sql.append(" order by cfisdefault desc ");
		
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try {
			if(rs.next()){
				String fid = rs.getString("fid");
				CollectionAccountInfo accountInfo = CollectionAccountFactory.getLocalInstance(ctx).getCollectionAccountInfo(new ObjectUuidPK(fid));
				
				BizAccountBillAccountEntryInfo entryInfo = new BizAccountBillAccountEntryInfo();
				entryInfo.setSeq(0);
				entryInfo.setPayMode(info.getPayMode());
				entryInfo.setPayerBank(accountInfo.getBebankStr());
				entryInfo.setPayerAccount(accountInfo.getBankAccount());
				entryInfo.setPayerName(accountInfo.getPayee());
				entryInfo.setOpenArea(accountInfo.getOpenArea());
				entryInfo.setCurrencyType(info.getCurrencyType());
				entryInfo.setExchangeRate(new BigDecimal("1"));
				entryInfo.setAmount(info.getAmount());
				entryInfo.setAmountOri(info.getAmount());
				
				info.getCollectionEntries().add(entryInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BOSException(e);
		}
		
		
	}
	private void setStrProperties(CoreBaseInfo info, HashMap billHeadMap,
			boolean isBillHead) {
		String strProperties[] = null;
		if (isBillHead)
			strProperties = BizAccountBillConstant.getHeadStrProperties();
		else
			strProperties = BizAccountBillConstant.getEntryStrProperties();
		for (int i = 0; i < strProperties.length; i++)
			info.setString(strProperties[i], (String) billHeadMap
					.get(strProperties[i]));

	}

	private void setBooleanProperties(CoreBaseInfo info, HashMap billHeadMap,
			boolean isBillHead) throws ImportException {
		String booleanProperties[] = null;
		HashMap erroMap = null;
		String propertyName = null;
		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			booleanProperties = BizAccountBillConstant.getHeadBooleanProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			booleanProperties = BizAccountBillConstant.getEntryBooleanProperties();
		}
		try {
			boolean boolValue = false;
			String propValue = null;
			for (int i = 0; i < booleanProperties.length; i++) {
				propertyName = booleanProperties[i];
				propValue = (String) billHeadMap.get(propertyName);
				if (propValue != null
						&& (propValue.equals("1") || propValue.equals("true")))
					boolValue = true;
				else
					boolValue = false;
				info.setBoolean(propertyName, boolValue);
			}
		} catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem) erroMap
					.get(propertyName);
			if (numberExc == null)
				numberExc = new NumericExceptionSubItem(propertyName, e
						.getMessage());
			throw new ImportException(numberExc);
		}
	}

	private void setIntProperties(CoreBaseInfo info, HashMap billHeadMap,
			boolean isBillHead) throws ImportException {
		String intProperties[] = null;
		String propertyName = null;
		HashMap erroMap = null;
		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			intProperties = BizAccountBillConstant.getHeadintProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			intProperties = BizAccountBillConstant.getEntryintProperties();
		}
		try {
			String value = null;
			for (int i = 0; i < intProperties.length; i++) {
				propertyName = intProperties[i];
				if (billHeadMap.get(propertyName) == null)
					value = "0";
				else
					value = (String) billHeadMap.get(propertyName);
				info.setInt(propertyName, Integer.parseInt(value));
			}

		} catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem) erroMap
					.get(propertyName);
			if (numberExc == null)
				numberExc = new NumericExceptionSubItem(propertyName, e
						.getMessage());
			throw new ImportException(numberExc);
		}
	}

	private void setDeciamlProperties(CoreBaseInfo info, HashMap billHeadMap,
			boolean isBillHead) throws ImportException {
		String decimalProperties[] = null;
		String propertyName = null;
		HashMap erroMap = null;
		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			decimalProperties = BizAccountBillConstant.getHeadDecimalProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			decimalProperties = BizAccountBillConstant.getEntryDecimalProperties();
		}
		try {
			String value = null;
			for (int i = 0; i < decimalProperties.length; i++) {
				propertyName = decimalProperties[i];
				if (billHeadMap.get(propertyName) == null)
					value = "0";
				else
					value = (String) billHeadMap.get(propertyName);
				info.setBigDecimal(propertyName, new BigDecimal(value));
			}

		} catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem) erroMap
					.get(propertyName);
			if (numberExc == null)
				numberExc = new NumericExceptionSubItem(propertyName, e
						.getMessage());
			throw new ImportException(numberExc);
		}
	}

	private void seTimeStampProperties(CoreBaseInfo info, HashMap billHeadMap,
			boolean isBillHead) throws ImportException {
		String stampProperties[] = null;
		HashMap erroMap = null;
		String propertyName = null;
		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			stampProperties = BizAccountBillConstant.getHeadTimeStampProperties();
		} else {
			stampProperties = new String[0];
		}
		try {
			for (int i = 0; i < stampProperties.length; i++) {
				propertyName = stampProperties[i];
				java.sql.Timestamp timeStamp = InfoUtil
						.getTimeStampFromStr((String) billHeadMap
								.get(propertyName));
				info.setTimestamp(stampProperties[i], timeStamp);
			}

		} catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem) erroMap
					.get(propertyName);
			if (numberExc == null)
				numberExc = new NumericExceptionSubItem(propertyName, e
						.getMessage());
			throw new ImportException(numberExc);
		}
	}

	private void setDateProperties(CoreBaseInfo info, HashMap billHeadMap,
			boolean isBillHead) throws EASBizException {
		String dateProperties[] = null;
		HashMap erroMap = null;
		String propertyName = null;
		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			dateProperties = BizAccountBillConstant.getHeadDateProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			dateProperties = BizAccountBillConstant.getEntryDateProperties();
		}
		java.util.Date date = null;
		try {
			for (int i = 0; i < dateProperties.length; i++) {
				propertyName = dateProperties[i];
				date = InfoUtil.convertStrToDate((String) billHeadMap
						.get(dateProperties[i]), "yyyy-MM-dd");
				info.setDate(dateProperties[i], date);
			}

		} catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem) erroMap
					.get(propertyName);
			if (numberExc == null)
				numberExc = new NumericExceptionSubItem(propertyName, e
						.getMessage());
			throw new ImportException(numberExc);
		}
	}

	private void setLinkProperties(Context ctx, CoreBaseInfo info,
			HashMap billHeadMap, String cuId, boolean isBillHead)
			throws ImportException {
		String linkProperties[] = null;
		String propertyName = null;
		HashMap erroMap = null;
		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			linkProperties = BizAccountBillConstant.getHeadLinkProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			linkProperties = BizAccountBillConstant.getEntryLinkProperties();
		}
		CoreBaseInfo linkBaseInfo = null;
		try {
			for (int i = 0; i < linkProperties.length; i++) {
				propertyName = linkProperties[i];
				if (isNoCuFilterProperties(propertyName) || isBillHead) {
					linkBaseInfo = InfoUtil.getLinkPropCoreBaseInfo(ctx, info,
							propertyName, (String) billHeadMap
									.get(propertyName), null);
					if (linkBaseInfo == null)
						linkBaseInfo = InfoUtil.getLinkPropCoreBaseInfo(ctx,
								info, propertyName, (String) billHeadMap
										.get(propertyName), cuId);
				} else {
					linkBaseInfo = InfoUtil.getLinkPropCoreBaseInfo(ctx, info,
							propertyName, (String) billHeadMap
									.get(propertyName), cuId);
				}
				String propertyValue = (String) billHeadMap
				.get(propertyName);
				if (linkBaseInfo == null
						&& isMustValidateProperty(propertyName, isBillHead))
					throw new Exception(
							(new StringBuilder())
									.append(propertyName).append(":").append(propertyValue)
									.append(" ")
									.append(
											EASResource
													.getString(
															"com.kingdee.eas.scm.im.inv.ws.WebserviceResource",
															"NUMBERNOTFOUND"))
									.toString());
				info.put(propertyName, linkBaseInfo);
			}

		} catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem) erroMap
					.get(propertyName);
			if (numberExc == null)
				numberExc = new NumericExceptionSubItem(propertyName, e
						.getMessage());
			throw new ImportException(numberExc);
		}
	}

	private boolean isMustValidateProperty(String propName, boolean isHeadBill) {
		String musValidateProp[] = null;
		if (isHeadBill)
			musValidateProp = BizAccountBillConstant.getMustValidateHeadProperties();
		else
			musValidateProp = BizAccountBillConstant.getMustValidateEntryProperties();
		for (int i = 0; i < musValidateProp.length; i++)
			if (musValidateProp[i].equals(propName))
				return true;

		return false;
	}
	
	private boolean isNoCuFilterProperties(String propertyName) {
		String noCuProp[] = BizAccountBillConstant.getNOTCUFILTERPROPERTIES();
		for (int i = 0; i < noCuProp.length; i++)
			if (noCuProp[i].equals(propertyName))
				return true;

		return false;
	}

}