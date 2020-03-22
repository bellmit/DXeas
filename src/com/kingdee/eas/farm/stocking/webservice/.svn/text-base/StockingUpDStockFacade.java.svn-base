package com.kingdee.eas.farm.stocking.webservice;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.stocking.webservice.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class StockingUpDStockFacade extends AbstractBizCtrl implements IStockingUpDStockFacade
{
    public StockingUpDStockFacade()
    {
        super();
        registerInterface(IStockingUpDStockFacade.class, this);
    }
    public StockingUpDStockFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IStockingUpDStockFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("09476CF1");
    }
    private StockingUpDStockFacadeController getController() throws BOSException
    {
        return (StockingUpDStockFacadeController)getBizController();
    }
    /**
     *reShareCoalAndDiesel-User defined method
     */
    public void reShareCoalAndDiesel() throws BOSException, EASBizException
    {
        try {
            getController().reShareCoalAndDiesel(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}