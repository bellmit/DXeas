package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.stocking.hatch.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class StockingHatchFacade extends AbstractBizCtrl implements IStockingHatchFacade
{
    public StockingHatchFacade()
    {
        super();
        registerInterface(IStockingHatchFacade.class, this);
    }
    public StockingHatchFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IStockingHatchFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3E6C2824");
    }
    private StockingHatchFacadeController getController() throws BOSException
    {
        return (StockingHatchFacadeController)getBizController();
    }
    /**
     *÷¥––÷÷µ∞Ω·À„-User defined method
     *@param param param
     *@return
     */
    public Object exeEggSettle(Object param) throws BOSException, EASBizException
    {
        try {
            return getController().exeEggSettle(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *createToEggSettleBill-User defined method
     *@param obj obj
     *@return
     */
    public Object createToEggSettleBill(Object obj) throws BOSException, EASBizException
    {
        try {
            return getController().createToEggSettleBill(getContext(), obj);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}