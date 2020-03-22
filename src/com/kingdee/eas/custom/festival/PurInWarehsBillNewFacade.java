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

public class PurInWarehsBillNewFacade extends AbstractBizCtrl implements IPurInWarehsBillNewFacade
{
    public PurInWarehsBillNewFacade()
    {
        super();
        registerInterface(IPurInWarehsBillNewFacade.class, this);
    }
    public PurInWarehsBillNewFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IPurInWarehsBillNewFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4D121344");
    }
    private PurInWarehsBillNewFacadeController getController() throws BOSException
    {
        return (PurInWarehsBillNewFacadeController)getBizController();
    }
    /**
     *importData-User defined method
     *@param xmlData xmlÊý¾Ý
     *@return
     */
    public String[] importData(String xmlData) throws BOSException
    {
        try {
            return getController().importData(getContext(), xmlData);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}