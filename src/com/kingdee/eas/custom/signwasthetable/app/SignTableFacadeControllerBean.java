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
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

import java.lang.String;

public class SignTableFacadeControllerBean extends AbstractSignTableFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.signwasthetable.app.SignTableFacadeControllerBean");

	@Override
	public String getdepartment(Context ctx, String prePerson)
			throws BOSException {
		// TODO Auto-generated method stub
		String sql="select a.FName_L2 from T_BD_Person pe inner join T_ORG_PositionMember pm on pe.FID=pm.FPersonID inner join T_ORG_Position po on po.FID=pm.FPositionID inner join T_ORG_Admin a on a.FID= po.FAdminOrgUnitID where pe.FID=? ";
    	String[]  arg={prePerson};
    	IRowSet rs=DbUtil.executeQuery(ctx, sql, arg);
    	try {
			if(rs.next()){
				String departmentName=rs.getString("FName_L2");
				return  departmentName;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.getdepartment(ctx, prePerson);
	}
    
}