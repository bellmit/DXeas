package com.kingdee.eas.outinterface.farm.duck.busniess;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;

public class Driver  extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "68E9FED4";
	}

	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","drivername","drivercardid","CompanyOrgUnit.name"};
	}
	
	

	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		return "order by CompanyOrgUnit.name,drivername";
	}

	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
//		String queryStr=" status=1 ";//EffectedStatus= and 
		String queryStr="";
		if(StringUtils.isNotEmpty(jo.getString("name"))) {
			queryStr+=" drivername like '%"+jo.getString("name")+"%'";
		}
		if(StringUtils.isNotEmpty(jo.getString("drivercardid"))) {
			queryStr+=" drivercardid='"+jo.getString("drivercardid")+"'";
		}
		
		//角色
		StringBuffer rolesStr=new StringBuffer();
		JSONArray rolesArray = jo.getJSONArray("roles");
		for(int index=0;index<rolesArray.size();index++) {
			String role=rolesArray.getString(index);
			if(rolesStr.length()>0) {
				rolesStr.append(" OR ");
			}
			if(StringUtils.equalsIgnoreCase(role,"farmer")){
				rolesStr.append(" CompanyOrgUnit.id in (")
				.append(" select FCompanyID")
				.append(" from CT_FM_Farmer")
				.append(" where FIdentity='").append(jo.getString("idNo")).append("'")
				.append(" )")
				;
			}
			if(StringUtils.equalsIgnoreCase(role,"manager")){
				rolesStr.append(" CompanyOrgUnit.id in (")
				.append(" select distinct tmain.FCompanyID")
				.append(" from T_FM_PersonFarmerRange tmain")
				.append(" inner join T_FM_PersonFarmerRangeEntry tentry on tentry.fparentid=tmain.fid")
				.append(" inner join t_pm_user tuser on tuser.fpersonid=tmain.FPersonID")
				.append(" where tuser.fnumber='").append(jo.getString("userNum")).append("'")
				.append(" and tmain.FBaseStatus=2")
				.append(")");
			}
			//司机只查自己的
			if(StringUtils.equalsIgnoreCase(role,"driver")){
				rolesStr.append(" drivercardid='").append(jo.getString("idNo")).append("'");
			}
		}
		if(rolesStr.length()>0) {
			if(queryStr.length()>0) {
				queryStr+=" AND ";
			}
//			queryStr+=rolesStr.toString();
		}
		
		return queryStr;
	}
}