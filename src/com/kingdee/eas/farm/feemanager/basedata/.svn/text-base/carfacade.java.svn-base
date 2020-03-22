package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.farm.feemanager.basedata.app.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class carfacade extends AbstractBizCtrl implements Icarfacade
{
    public carfacade()
    {
        super();
        registerInterface(Icarfacade.class, this);
    }
    public carfacade(Context ctx)
    {
        super(ctx);
        registerInterface(Icarfacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C52FEB62");
    }
    private carfacadeController getController() throws BOSException
    {
        return (carfacadeController)getBizController();
    }
    /**
     *∫À…Û-User defined method
     */
    public void review() throws BOSException
    {
        try {
            getController().review(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}