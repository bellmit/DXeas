package com.kingdee.eas.custom;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class testFacade extends AbstractBizCtrl implements ItestFacade
{
    public testFacade()
    {
        super();
        registerInterface(ItestFacade.class, this);
    }
    public testFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ItestFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("724717B1");
    }
    private testFacadeController getController() throws BOSException
    {
        return (testFacadeController)getBizController();
    }
    /**
     *getTest-User defined method
     *@param params params
     *@return
     */
    public Object getTest(Object params) throws BOSException
    {
        try {
            return getController().getTest(getContext(), params);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}