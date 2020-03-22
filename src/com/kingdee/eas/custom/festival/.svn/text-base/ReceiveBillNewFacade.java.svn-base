package com.kingdee.eas.custom.festival;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.festival.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class ReceiveBillNewFacade extends AbstractBizCtrl implements IReceiveBillNewFacade
{
    public ReceiveBillNewFacade()
    {
        super();
        registerInterface(IReceiveBillNewFacade.class, this);
    }
    public ReceiveBillNewFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IReceiveBillNewFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D001187B");
    }
    private ReceiveBillNewFacadeController getController() throws BOSException
    {
        return (ReceiveBillNewFacadeController)getBizController();
    }
    /**
     *submit-User defined method
     *@param xml xml
     *@return
     */
    public String[] submit(String xml) throws BOSException
    {
        try {
            return getController().submit(getContext(), xml);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}