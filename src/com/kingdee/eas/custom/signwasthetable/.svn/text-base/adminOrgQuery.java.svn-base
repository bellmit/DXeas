package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.signwasthetable.app.*;
import com.kingdee.bos.util.*;

public class adminOrgQuery extends AbstractBizCtrl implements IadminOrgQuery
{
    public adminOrgQuery()
    {
        super();
        registerInterface(IadminOrgQuery.class, this);
    }
    public adminOrgQuery(Context ctx)
    {
        super(ctx);
        registerInterface(IadminOrgQuery.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FED22609");
    }
    private adminOrgQueryController getController() throws BOSException
    {
        return (adminOrgQueryController)getBizController();
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]行政组织类型是否匹配[%returndesc]-User defined method
     *@param preName 呈送者
     *@param depName 部门名称
     *@return
     */
    public boolean orgQuery(String preName, String depName) throws BOSException
    {
        try {
            return getController().orgQuery(getContext(), preName, depName);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}