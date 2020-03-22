package com.kingdee.eas.custom.signwasthetable.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.rpts.statistics.util.ServiceUtil.DBUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

import java.lang.String;

public class adminOrgQueryControllerBean extends AbstractadminOrgQueryControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.signwasthetable.app.adminOrgQueryControllerBean");
    
    /**
     *查询某个人员是否存在于某个部门中，返回一个boolean的结果
     *不足之处：传入的参数是名字  而不是id或者number
     */
	@Override
	public boolean _orgQuery(Context ctx, String preName, String depName)
			throws BOSException {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer();
		sql.append("select a.FName_L2 from T_BD_Person pe inner join T_ORG_PositionMember pm on pe.FID=pm.FPersonID inner join T_ORG_Position po on po.FID=pm.FPositionID inner join T_ORG_Admin a on a.FID= po.FAdminOrgUnitID where pe.FID=’ ").append(preName).append(" ' ");
		sql.append(" and a.FName_L2=' ").append(depName).append(" ' ");
		IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
		String orgUnit=null;
			try {
				while(rs.next()){
					orgUnit=rs.getString("Fname_L2");
					if(orgUnit=="")
						return false;
					else
						return true;
				
								}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		return super._orgQuery(ctx, preName, depName);
	}
}