package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class getSHRinfoFacade extends AbstractBizCtrl implements IgetSHRinfoFacade
{
    public getSHRinfoFacade()
    {
        super();
        registerInterface(IgetSHRinfoFacade.class, this);
    }
    public getSHRinfoFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IgetSHRinfoFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B8AFBB97");
    }
    private getSHRinfoFacadeController getController() throws BOSException
    {
        return (getSHRinfoFacadeController)getBizController();
    }
    /**
     *获取员工信息-User defined method
     */
    public void getPersonInfo() throws BOSException
    {
        try {
            getController().getPersonInfo(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}