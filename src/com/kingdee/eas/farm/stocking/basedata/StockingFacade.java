package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.eas.farm.stocking.basedata.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class StockingFacade extends AbstractBizCtrl implements IStockingFacade
{
    public StockingFacade()
    {
        super();
        registerInterface(IStockingFacade.class, this);
    }
    public StockingFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IStockingFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("14FA3E57");
    }
    private StockingFacadeController getController() throws BOSException
    {
        return (StockingFacadeController)getBizController();
    }
    /**
     *CreateCostObject-User defined method
     *@param param param
     *@return
     */
    public String CreateCostObject(Object param) throws BOSException
    {
        try {
            return getController().CreateCostObject(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *自养日报转放养日报-User defined method
     *@param param param
     */
    public void Internal2StockingDaily(String param) throws BOSException
    {
        try {
            getController().Internal2StockingDaily(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}