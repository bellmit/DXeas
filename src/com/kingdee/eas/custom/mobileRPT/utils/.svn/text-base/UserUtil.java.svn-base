package com.kingdee.eas.custom.mobileRPT.utils;

import java.sql.SQLException;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class UserUtil {

	public static String getUserOrgPerm(Context ctx, String userNumber){
		String companyIds = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct t4.FID,t4.FName_l2 from T_PM_UserOrgPerm t1 ");
		sql.append("inner join T_ORG_Admin t2 on t1.FOrgID=t2.FID ");
		sql.append("inner join T_Org_LayerType t3 on t2.FLayerTypeID=t3.FID ");
		sql.append("inner join T_ORG_Admin t4 on t4.FparentID=t2.FID ");
		sql.append("where t2.FIsCompanyOrgUnit=1 and t3.FID='00000000-0000-0000-0000-00000000000262824988' ");
		sql.append("and t1.Fowner=(select fid from T_PM_USER where FNumber='"+userNumber+"')");
		IRowSet rs;
//		Set<String> idSet = null;
		boolean flag = true;
		try {
			rs = DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				if(flag){
					companyIds = companyIds + "'" + rs.getString("fid")+"'";
					flag = false;
				}else{
					companyIds = companyIds + ",'" + rs.getString("fid")+"'";
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return companyIds;
	}
}
