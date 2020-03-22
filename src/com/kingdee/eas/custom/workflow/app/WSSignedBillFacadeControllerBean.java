package com.kingdee.eas.custom.workflow.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.permission.UserFactory;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.FullOrgUnitFactory;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.basedata.org.IOrgSwitchFacade;
import com.kingdee.eas.basedata.org.OrgSwitchFacadeFactory;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.signwasthetable.ISignWasTheTable;
import com.kingdee.eas.custom.signwasthetable.SignBDCollection;
import com.kingdee.eas.custom.signwasthetable.SignBDFactory;
import com.kingdee.eas.custom.signwasthetable.SignBDInfo;
import com.kingdee.eas.custom.signwasthetable.SignTypeFactory;
import com.kingdee.eas.custom.signwasthetable.SignTypeInfo;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableCollection;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableFactory;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo;
import com.kingdee.eas.custom.signwasthetable.billStatus;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.scm.im.inv.ws.util.InfoUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class WSSignedBillFacadeControllerBean extends AbstractWSSignedBillFacadeControllerBean {

	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.workflow.app.WSBizAccountBillFacadeControllerBean");

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
			sql.append(" select p.fnumber as pNumber,p.fname_l2 as pName,pt.fnumber as ptNumber,pt.fname_l2 as ptName,d.fnumber as deptNumber,d.fname_l2 as deptName ");
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
			sql.append(" select torg.fnumber,torg.fname_l2 ");
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
	 * 根据fid获取单据信息 1
	 */
	@Override
	protected String _getBillInfoById(Context ctx, String fid)
	throws BOSException {

		JSONObject resultJson = new JSONObject();
		resultJson.put("result","sucess");
		if(StringUtils.isBlank(fid)){
			resultJson.put("result","false");
			resultJson.put("message", "ID不能为空");
		}

		try {

			SignWasTheTableInfo signWasTheTableInfo = SignWasTheTableFactory.getLocalInstance(ctx).getSignWasTheTableInfo(new ObjectUuidPK(fid));
			JSONObject dataObject = new JSONObject();
			dataObject.put("fid", fid);
			dataObject.put("fnumber", signWasTheTableInfo.getNumber());

			IObjectPK pk = null;
			pk = new ObjectUuidPK(signWasTheTableInfo.getPresentedPerson().getId());
			PersonInfo personInfo = PersonFactory.getLocalInstance(ctx).getPersonInfo(pk);
			dataObject.put("presentNumber", personInfo.getNumber());
			dataObject.put("presentName", personInfo.getName());

			pk = new ObjectUuidPK(signWasTheTableInfo.getAddresses().getId());
			personInfo = PersonFactory.getLocalInstance(ctx).getPersonInfo(pk);
			dataObject.put("addressNumber", personInfo.getNumber());
			dataObject.put("addressName", personInfo.getName());
			dataObject.put("addressID",pk.toString());

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String fbizdate = sdf.format(signWasTheTableInfo.getBizDate());
			dataObject.put("fbizdate", fbizdate);

			pk = new ObjectUuidPK(signWasTheTableInfo.getBillType().getId());
			//				SignBDInfo signBDInfo = SignBDFactory.getLocalInstance(ctx).getSignBDInfo(pk);
			SignBDInfo signBDInfo = SignBDFactory.getLocalInstance(ctx).getSignBDInfo(pk);
			dataObject.put("fsignBillTypeName", signBDInfo.getName());
			dataObject.put("fsignBillTypeNumber", signBDInfo.getNumber());

			pk = new ObjectUuidPK(signWasTheTableInfo.getCU().getId());
			CtrlUnitInfo cu = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(pk);
			dataObject.put("fcompanyName", cu.getName());
			dataObject.put("fcompanyNumber", cu.getNumber());

			pk = new ObjectUuidPK(signWasTheTableInfo.getAdminOrgUnit().getId());
			AdminOrgUnitInfo adminOrgUnitInfo = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(pk);
			dataObject.put("fadminName", adminOrgUnitInfo.getName());
			dataObject.put("fadminNumber", adminOrgUnitInfo.getNumber());

			dataObject.put("fkeyword", signWasTheTableInfo.getKeyWord());
			dataObject.put("freason", signWasTheTableInfo.getReason());

			BigDecimal predictAmt = signWasTheTableInfo.getPredictAmt();
			predictAmt = predictAmt == null ? BigDecimal.ZERO : predictAmt;
			dataObject.put("fpredictAmt", predictAmt);

			dataObject.put("fstatus", signWasTheTableInfo.getBillStatus().getAlias());


			resultJson.put("data", dataObject);

		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultJson.put("result","false");
			resultJson.put("message", "获取信息失败");
		}

		return resultJson.toString();
	}

	/**
	 * 获取用户签呈列表 2
	 */
	@Override
	protected String _getBillList(Context ctx, String userNumber,
			String fnumber, String dateS, String dateE) throws BOSException {
		JSONObject resultJson = new JSONObject();
		resultJson.put("result","sucess");
		if(StringUtils.isBlank(userNumber)){
			resultJson.put("result","false");
			resultJson.put("message", "用户编码不能为空");
		}

		StringBuffer sql = new StringBuffer();
		sql.append(" select fpersonid from t_pm_user where fnumber = '");
		sql.append(userNumber);
		sql.append("'");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try {
			if(rs.next()){
				String personId = rs.getString("fpersonid");

				EntityViewInfo ev = new EntityViewInfo();
				FilterInfo filterInfo = new FilterInfo();
				filterInfo.getFilterItems().add(new FilterItemInfo("presentedPerson.id",personId,CompareType.EQUALS));
				if(StringUtils.isNotBlank(fnumber)){
					filterInfo.getFilterItems().add(new FilterItemInfo("number","%"+fnumber+"%",CompareType.LIKE));
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				if(StringUtils.isNotBlank(dateS)){
					filterInfo.getFilterItems().add(new FilterItemInfo("bizDate",sdf.parse(dateS),CompareType.GREATER_EQUALS));
				}
				if(StringUtils.isNotBlank(dateE)){
					filterInfo.getFilterItems().add(new FilterItemInfo("bizDate",sdf.parse(dateE),CompareType.LESS_EQUALS));
				}

				ev.setFilter(filterInfo);

				SignWasTheTableCollection collection = SignWasTheTableFactory.getLocalInstance(ctx).getSignWasTheTableCollection(ev);

				JSONArray dataJson = new JSONArray();
				IObjectPK pk = null;

				for(int i=0,len=collection.size();i<len;i++){
					JSONObject jsonObject = new JSONObject();
					SignWasTheTableInfo signWasTheTableInfo = collection.get(i);

					jsonObject.put("fnumber", signWasTheTableInfo.getNumber());

					pk = new ObjectUuidPK(signWasTheTableInfo.getPresentedPerson().getId().toString());
					PersonInfo personInfo = PersonFactory.getLocalInstance(ctx).getPersonInfo(pk);

					jsonObject.put("presentName", personInfo.getName());

					jsonObject.put("fbizDate", sdf.format(signWasTheTableInfo.getBizDate()));

					jsonObject.put("keyWord", signWasTheTableInfo.getKeyWord());

					jsonObject.put("status", signWasTheTableInfo.getBillStatus().getAlias());

					jsonObject.put("fid", signWasTheTableInfo.getId().toString());

					dataJson.add(jsonObject);
				}
				resultJson.put("data", dataJson);
			}else {
				resultJson.put("result","false");
				resultJson.put("message", "没有找到对应职员");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			resultJson.put("result","false");
			resultJson.put("message", "查询出错");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			resultJson.put("result","false");
			resultJson.put("message", "日期转换出错");
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			resultJson.put("result","false");
			resultJson.put("message", e.getMessage());
		}

		return resultJson.toString();
	}

	/**
	 * 获取 签呈类型 
	 */
	@Override
	protected String _getBillType(Context ctx, String userNumber)
	throws BOSException {
		JSONObject resultJson = new JSONObject();
		resultJson.put("result","sucess");
		if(StringUtils.isBlank(userNumber)){
			resultJson.put("result","false");
			resultJson.put("message", "用户编码不能为空");
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
			sql.append(" select t.fnumber, t.fname_l2 from CT_SIG_SignBD t ");
			sql.append(" where t.fbillstatus = 1 ");
			sql.append(" order by t.fnumber asc ");
			IRowSet rsSignType = DbUtil.executeQuery(ctx, sql.toString());

			JSONArray dataJson = new JSONArray();
			while(rsSignType.next()){
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("billTypeNumber", rsSignType.getString("fnumber"));
				jsonObject.put("billTypeName", rsSignType.getString("fname_l2"));

				dataJson.add(jsonObject);
			}
			resultJson.put("data",dataJson);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			resultJson.put("result","false");
			resultJson.put("message", "查询出错");

		}

		return resultJson.toString();
	}

	/**
	 * 导入签呈  3
	 */
	@Override
	protected String _importBillInfo(Context ctx, String jsonData)
	throws BOSException {
		JSONObject resultJson = new JSONObject();
		resultJson.put("result","sucess");

		try{
			System.out.println(jsonData);
			JSONObject jsonObject = JSONObject.fromObject(jsonData);

			SignWasTheTableInfo info = new SignWasTheTableInfo();
			CoreBaseCollection coll;
			ISignWasTheTable iSignWasTheTable = SignWasTheTableFactory.getLocalInstance(ctx);
			String fid = (String) jsonObject.get("fid");
			//不为空 且 不等于0 
			if(StringUtils.isNotBlank(fid) && (!"0".equals(fid))){
				info = iSignWasTheTable.getSignWasTheTableInfo(new ObjectUuidPK(fid));
			}	

			String fbizdate = (String) jsonObject.get("fbizdate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			info.setBizDate(sdf.parse(fbizdate));

			String compayNumber = (String) jsonObject.get("compayNumber");
			//CU
			CtrlUnitInfo cuInfo = InfoUtil.getCtrolUnitInfo(ctx, compayNumber);
			info.setCU(cuInfo);
			ContextUtil.setCurrentCtrlUnit(ctx, cuInfo);
			IOrgSwitchFacade orgSwitch = OrgSwitchFacadeFactory.getLocalInstance(ctx);
			orgSwitch.orgSwitch(cuInfo.getId().toString());


			//单据编号
			if(StringUtils.isBlank(info.getNumber())){
				if(this.isCodeRuleEnable(ctx, info, cuInfo.getId().toString())){
					String fnumber = this.getAutoCode(ctx, info, cuInfo.getId().toString());
					info.setNumber(fnumber);
				}	
			}

			//公司
			cuInfo = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(new ObjectUuidPK(cuInfo.getId().toString()));
			info.setOrgSupp(cuInfo.getName());
			//部门
			String deptNumber = (String) jsonObject.get("deptNumber");
			AdminOrgUnitInfo adminOrgUnitInfo = (AdminOrgUnitInfo) InfoUtil.getLinkPropCoreBaseInfo(ctx, info, "adminOrgUnit", deptNumber);
			info.setAdminOrgUnit(adminOrgUnitInfo);
			info.setDepartments(adminOrgUnitInfo);
			//类型
			String signBillTypeNumber = (String) jsonObject.get("signBillTypeNumber");
			if(StringUtils.isNotEmpty(signBillTypeNumber)){
				coll = SignBDFactory.getLocalInstance(ctx).getCollection("where number='"+signBillTypeNumber+"'");
				if(coll.size()>0)
					info.setBillType((SignBDInfo) coll.get(0));
				//	        SignBDInfo signTypeInfo = (SignBDInfo) InfoUtil.getLinkPropCoreBaseInfo(ctx, info, "billType", signBillTypeNumber);
				//			SignBDInfo signTypeInfo1 = (SignBDInfo)InfoUtil.getLinkPropCoreBaseInfo(ctx, info, "billType", signBillTypeNumber, null);
				//			InfoUtil.getLinkPropCoreBaseInfo(ctx, info, "signType", signBillTypeNumber);
				//			info.setBillType(signTypeInfo);
				
//				if(StringUtils.isNotEmpty(signBillTypeNumber)){
//				IRowSet rs = DbUtil.executeQuery(ctx, "select * from CT_SIG_SignBD where fnumber=?",new String[]{signBillTypeNumber});
//				if(rs.next()){
//					info.setBOSUuid("billType", BOSUuid.read(rs.getString("FID")));
//				}}
//				
			}

			//主旨
			String keyword = (String) jsonObject.get("keyword");
			info.setKeyWord(keyword);
			//说明
			String reason = (String) jsonObject.get("reason");
			info.setReason(reason);
			//呈送者
			String presentNumber = (String) jsonObject.get("presentNumber");
			PersonInfo personInfo = (PersonInfo) InfoUtil.getLinkPropCoreBaseInfo(ctx, info, "presentedPerson", presentNumber);
			info.setPresentedPerson(personInfo);
			//受文者
			String addressesID = (String) jsonObject.get("addressesID");
			PersonInfo pInfo = PersonFactory.getLocalInstance(ctx).getPersonInfo(new ObjectUuidPK(addressesID));
			info.setAddresses(pInfo);

			//职位
			//			info.setPosition(PersonUtil.getPersonPositionByPerson(ctx, personInfo.getId().toString()));
			//			info.setUpperPosition(PersonUtil.getDirectUpperPositionByPerson(ctx, personInfo.getId().toString()));

			info.setText1("2、说明（理由、数据、附件、建议）");
			info.setText2("1.主旨");

			//预计金额
			String predictAmt = (String) jsonObject.get("predictAmt");
			if(StringUtils.isBlank(predictAmt)){
				predictAmt = "0";
			}
			BigDecimal prBigDecimal = BigDecimal.ZERO;
			try{
				prBigDecimal = new BigDecimal(predictAmt);
				info.setPredictAmt(prBigDecimal);
			}catch (Exception e) {
				prBigDecimal = BigDecimal.ZERO;
			}

			//			info.setPredictAmt(prBigDecimal);

			String userId = this.getUserIdByPersonId(ctx, personInfo.getId().toString());
			ctx.setCaller(new ObjectUuidPK(userId));
			UserInfo userInfo = UserFactory.getLocalInstance(ctx).getUserInfo(new ObjectUuidPK(userId));
			ContextUtil.setCurrentUserInfo(ctx, userInfo);

			IObjectPK pk = null;
			String status = (String) jsonObject.get("status");
			if("save".equals(status)){
				info.setBillStatus(billStatus.save);
				pk = iSignWasTheTable.save(info);
			} else if("submit".equals(status)){
				info.setBillStatus(billStatus.submit);
				pk = iSignWasTheTable.submit(info);
			}

			resultJson.put("easid", pk.toString());

		} catch (BOSException e) {
			// TODO: handle exception
			e.printStackTrace();

			resultJson.put("result","false");
			resultJson.put("message","操作失败");

		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			resultJson.put("result","false");
			resultJson.put("message",e.getMessage());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			resultJson.put("result","false");
			resultJson.put("message","日期格式有误");
		}

		return resultJson.toString();
	}

	// 得到自动编码
	private String getAutoCode(Context ctx, IObjectValue objValue, String companyId) throws EASBizException,
	BOSException {
		if(!isCodeRuleEnable(ctx,objValue,companyId)) {
			SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
			return format.format(new java.util.Date());
		}
		//IOrgSwitchFacade orgSwitch = OrgSwitchFacadeFactory.getLocalInstance(ctx);
		//orgSwitch.orgSwitch(companyId);
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory.getLocalInstance(ctx);
		if (codeRuleMgr.isUseIntermitNumber(objValue, companyId)) {
			return codeRuleMgr.readNumber(objValue, companyId);
		} else {
			return codeRuleMgr.getNumber(objValue, companyId);
		}
	}

	// 是否启用编码规则
	private boolean isCodeRuleEnable(Context ctx, IObjectValue objValue, String companyId) throws EASBizException,
	BOSException {
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory.getLocalInstance(ctx);
		return codeRuleMgr.isExist(objValue, companyId);
	}

	/**
	 * 根据personid获取userid
	 * @param ctx
	 * @param personId
	 * @return
	 */
	private String getUserIdByPersonId(Context ctx, String personId){
		StringBuffer sql = new StringBuffer();
		sql.append(" select fid from t_pm_user where fpersonid = '");
		sql.append(personId);
		sql.append("'");
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				return rs.getString("fid");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 根据fid删除签呈信息
	 */
	@Override
	protected String _deleteSignBillByFid(Context ctx, String fid)
	throws BOSException {
		JSONObject resultJson = new JSONObject();
		resultJson.put("result","sucess");

		if(StringUtils.isBlank(fid)){
			resultJson.put("result", "false");
			resultJson.put("message", "单据id不能为空");

			return resultJson.toString();
		}

		try {
			SignWasTheTableFactory.getLocalInstance(ctx).delete(new ObjectUuidPK(fid));

		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultJson.put("result", "false");
			resultJson.put("message", e.getMessage());
		}

		return resultJson.toString();
	}

	@Override
	protected String _getAddressesByName(Context ctx, String param)
			throws BOSException {
		// TODO Auto-generated method stub
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();
		JSONObject jo = JSONObject.fromObject(param);
		String name = jo.getString("name");
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("t3.FName_l2 AS orgUnitName,");
		sb.append("t2.FID AS personID,");
		sb.append("t2.FName_l2 AS personName,");
		sb.append("t2.FNumber AS personNumber ");
		sb.append("FROM ");
		sb.append("T_PM_USER                t1 ");
		sb.append("INNER JOIN ");
		sb.append("T_BD_PERSON              t2 ");
		sb.append("ON ");
		sb.append("t2.FID=t1.FPERSONID ");
		sb.append("INNER JOIN ");
		sb.append("T_ORG_BASEUNIT           t3 ");
		sb.append("ON ");
		sb.append("t1.FDefOrgUnitID=t3.FID ");
		sb.append("WHERE t2.FName_l2 like '%" + name + "%'");
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try {
			while(rs.next()){
				JSONObject jsonoObject = new JSONObject();
				String orgUnitName = rs.getString("orgUnitName");
				String personID = rs.getString("personID");
				String personName = rs.getString("personName");
				String personNumber = rs.getString("personNumber");
				jsonoObject.put("result", "true");
				jsonoObject.put("orgUnitName",orgUnitName);
				jsonoObject.put("personID",personID);
				jsonoObject.put("personName",personName);
				jsonoObject.put("personNumber",personNumber);
				arr.add(jsonoObject);
			}
			if(arr.isEmpty()){
				obj.put("result", "false");
				obj.put("message", "未查询到用户!");
			}else{
				obj.put("result", "true");
				obj.put("date", arr.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			obj.put("result", "false");
			obj.put("message", e.getMessage());
		}
		return obj.toString();
	}
}
