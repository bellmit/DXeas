package com.kingdee.eas.custom.mobileRPT.functions;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.mobileRPT.IDownload;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class HRRpt implements IDownload {

	@Override
	public JSONArray downloadData(Context ctx, JSONObject queryJSON)
			throws Exception {
		// TODO Auto-generated method stub
		IRowSet rs = null;
		JSONObject jo = null;
		JSONArray ja = new JSONArray();
//		HashMap<String,JSONObject> map = null;
		String bizDate = null;
		if(queryJSON.containsKey("date") && StringUtils.isNotBlank(queryJSON.getString("date"))){
			bizDate = queryJSON.getString("date");
		}
		//前区人数
		StringBuffer sql = new StringBuffer();
//		sql.append("").append("\n");
		sql.append("select companyID,companyName,sum(qqrs) qqrs,sum(ktrs) ktrs,sum(rzrs) rzrs,sum(cqrs) cqrs,sum(lzrs) lzrs,sum(qjrs) qjrs,sum(xbrs) xbrs from ( ").append("\n");
		sql.append("select companyID,companyName,sum(qqrs) qqrs,sum(ktrs) ktrs,sum(rzrs) rzrs,sum(cqrs) cqrs,sum(lzrs) lzrs,sum(qjrs) qjrs,sum(xbrs) xbrs from ( ").append("\n");
		sql.append("select t5.FID companyID,t5.FName_l2 companyName,count(t1.FPersonID) qqrs,0 ktrs,0 rzrs,0 cqrs,0 lzrs,0 qjrs,0 xbrs from T_ORG_PositionMember t1 ").append("\n");
		sql.append("inner join T_ORG_Position t2 on t1.FPositionID=t2.FID ").append("\n");
		sql.append("inner join T_ORG_ADMIN t3 on t2.FAdminOrgUnitID=t3.FID ").append("\n");
		sql.append("inner join T_ORG_ADMIN t4 on t3.FParentID=t4.FID ").append("\n");
		sql.append("inner join T_ORG_ADMIN t5 on t4.FParentID=t5.FID ").append("\n");
		sql.append("where t2.FAdminOrgUnitID in (select fid from T_ORG_Admin where FName_l2='前区') ").append("\n");
		sql.append("group by t5.FName_l2,t5.FID ").append("\n");
		sql.append("union all ").append("\n");
		sql.append("select t6.FID companyID,t6.FName_l2 companyName,count(t1.FPersonID) qqrs,0 ktrs,0 rzrs,0 cqrs,0 lzrs,0 qjrs,0 xbrs from T_ORG_PositionMember t1 ").append("\n");
		sql.append("inner join T_ORG_Position t2 on t1.FPositionID=t2.FID ").append("\n");
		sql.append("inner join T_ORG_ADMIN t3 on t2.FAdminOrgUnitID=t3.FID ").append("\n");
		sql.append("inner join T_ORG_ADMIN t4 on t3.FParentID=t4.FID ").append("\n");
		sql.append("inner join T_ORG_ADMIN t5 on t4.FParentID=t5.FID ").append("\n");
		sql.append("inner join t_org_admin t6 on t5.FParentID=t6.FID ").append("\n");
		sql.append("where t2.FAdminOrgUnitID in (select ttow.fid from T_ORG_Admin tone inner join T_ORG_Admin ttow on ttow.FParentID=tone.FID where tone.FName_l2='前区') ").append("\n");
		sql.append("group by t6.FName_l2,t6.FID) group by companyID,CompanyName ").append("\n");
		sql.append("union all ").append("\n");
		sql.append("select companyID,companyName,sum(qqrs) qqrs,sum(ktrs) ktrs,sum(rzrs) rzrs,sum(cqrs) cqrs,sum(lzrs) lzrs,sum(qjrs) qjrs,sum(xbrs) xbrs from ( ").append("\n");
		sql.append("select t5.FID companyID,t5.FName_l2 companyName,0 qqrs,count(t1.FPersonID) ktrs,0 rzrs,0 cqrs,0 lzrs,0 qjrs,0 xbrs from T_ORG_PositionMember t1 ").append("\n");
		sql.append("inner join T_ORG_Position t2 on t1.FPositionID=t2.FID ").append("\n");
		sql.append("inner join T_ORG_ADMIN t3 on t2.FAdminOrgUnitID=t3.FID ").append("\n");
		sql.append("inner join T_ORG_ADMIN t4 on t3.FParentID=t4.FID ").append("\n");
		sql.append("inner join T_ORG_ADMIN t5 on t4.FParentID=t5.FID ").append("\n");
		sql.append("where t2.FAdminOrgUnitID in (select fid from T_ORG_Admin where FName_l2='库台') ").append("\n");
		sql.append("group by t5.FName_l2,t5.FID ").append("\n");
		sql.append("union all ").append("\n");
		sql.append("select t6.FID companyID,t6.FName_l2 companyName,0 qqrs,count(t1.FPersonID) ktrs,0 rzrs,0 cqrs,0 lzrs,0 qjrs,0 xbrs from T_ORG_PositionMember t1 ").append("\n");
		sql.append("inner join T_ORG_Position t2 on t1.FPositionID=t2.FID ").append("\n");
		sql.append("inner join T_ORG_ADMIN t3 on t2.FAdminOrgUnitID=t3.FID ").append("\n");
		sql.append("inner join T_ORG_ADMIN t4 on t3.FParentID=t4.FID ").append("\n");
		sql.append("inner join T_ORG_ADMIN t5 on t4.FParentID=t5.FID ").append("\n");
		sql.append("inner join t_org_admin t6 on t5.FParentID=t6.FID ").append("\n");
		sql.append("where t2.FAdminOrgUnitID in (select ttow.fid from T_ORG_Admin tone inner join T_ORG_Admin ttow on ttow.FParentID=tone.FID where tone.FName_l2='库台') ").append("\n");
		sql.append("group by t6.FName_l2,t6.FID) group by companyID,CompanyName ").append("\n");
		sql.append("union all ").append("\n");
//		--入职人数
		sql.append("select t3.FID companyID,t3.FName_l2 companyName,0 qqrs,0 ktrs,count(FPersonID) rzrs,0 cqrs,0 lzrs,0 qjrs,0 xbrs ").append("\n");
		sql.append("from T_HR_EmpEnrollBizBill t1 inner join T_HR_EmpEnrollBizBillEntry t2 on t2.FBillID=t1.FID ").append("\n");
		sql.append("inner join T_ORG_Admin t3 on t3.Fid=t1.FAdminOrgUnitId ").append("\n");
		sql.append("where to_char(t1.FbizDate,'yyyy-MM-dd')='"+bizDate+"' group by t3.FName_l2,t3.FID ").append("\n");
//		--出勤人数
		sql.append("union all ").append("\n");
		sql.append("select CFCOMPANYID,FName_l2 companyName,0 qqrs,0 ktrs,0 rzrs,count(cfPersonName) cqrs,0 lzrs,0 qjrs,0 xbrs from(  ").append("\n");
		sql.append("select distinct t1.CFPersonName,t2.CFCOMPANYID,t3.FName_l2  ").append("\n");
		sql.append("from ").append("\n");
		sql.append("CT_WAG_AttendanceBillEntry t1 ").append("\n");
		sql.append("inner join CT_WAG_AttendanceBill t2 on t1.FParentID=t2.FID ").append("\n");
		sql.append("inner join T_ORG_COMPANY t3  on t2.CFCOMPANYID=t3.FID ").append("\n");
		sql.append("where t2.CFCOMPANYID in ").append("\n");
		sql.append("('E3sAAAAAAV3M567U','E3sAAAAAAZPM567U','E3sAAAAAAPHM567U','E3sAAAAAB2vM567U','E3sAAAAAASfM567U','E3sAAAAAALvM567U','E3sAAAAABzXM567U') ").append("\n");
		sql.append("and to_char(t2.FBizDate,'yyyy-mm-dd')='"+bizDate+"' group by t2.CFCOMPANYID,t1.CFPersonName,t3.FName_l2 ").append("\n");
		sql.append("order by t1.CFPersonName)  group by CFCOMPANYID,FName_l2  ").append("\n");
//		--离职人数
		sql.append("union all ").append("\n");
		sql.append("select t2.FID companyID,t2.FName_l2 companyName,0 qqrs,0 ktrs,0 rzrs,0 cqrs,count(t1.FApplierID) lzrs,0 qjrs,0 xbrs from T_HR_ResignBizBill t1 ").append("\n");
		sql.append("inner join T_ORG_ADMIN t2 on t1.FAdminOrgUnitID=t2.FID ").append("\n");
		sql.append("where to_char(t1.FbizDate,'yyyy-MM-dd')='"+bizDate+"' ").append("\n");
		sql.append("group by t2.FName_l2,t2.FID ").append("\n");
//		--请假人数
		sql.append("union all ").append("\n");
		sql.append("select t1.CFCompanyID companyID,t2.FName_l2 companyName,0 qqrs,0 ktrs,0 rzrs,0 cqrs,0 lzrs,t1.CFLeavenumber qjrs,t1.CFOffduty xbrs ").append("\n");
		sql.append("from ").append("\n");
		sql.append("CT_SZC_FreshDaily t1 inner join T_ORG_Company t2 on t1.CFCompanyID=t2.FID ").append("\n");
		sql.append("where to_char(t1.FBizDate,'yyyy-MM-dd')='"+bizDate+"') group by companyID,companyName ").append("\n");
		rs = DbUtil.executeQuery(ctx, sql.toString());
//		rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		System.out.println(sql.toString());
		while(rs.next()){
			jo = new JSONObject();
			jo.put("companyID", rs.getString("companyID"));
			jo.put("companyName", rs.getString("companyName"));
			jo.put("qqrs", rs.getBigDecimal("qqrs"));//前区人数
			jo.put("ktrs", rs.getBigDecimal("ktrs"));//库台人数
			jo.put("rzrs", rs.getBigDecimal("rzrs"));//入职人数
			jo.put("cqrs", rs.getBigDecimal("cqrs"));//出勤人数
			jo.put("lzrs", rs.getBigDecimal("lzrs"));//离职人数
			jo.put("qjrs", rs.getBigDecimal("qjrs"));//请假人数
			jo.put("xbrs", rs.getBigDecimal("xbrs"));//休班人数
			ja.add(jo);
		}
		return ja;
	}

}
