package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.eas.common.EASBizException;
import java.util.HashMap;
import com.kingdee.bos.util.*;

public class StockingBatchDailyFacade extends AbstractBizCtrl implements IStockingBatchDailyFacade
{
    public StockingBatchDailyFacade()
    {
        super();
        registerInterface(IStockingBatchDailyFacade.class, this);
    }
    public StockingBatchDailyFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IStockingBatchDailyFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BABE360A");
    }
    private StockingBatchDailyFacadeController getController() throws BOSException
    {
        return (StockingBatchDailyFacadeController)getBizController();
    }
    /**
     *修正存栏信息-User defined method
     *@param param 参数
     *@return
     */
    public HashMap correctBatchStocking(HashMap param) throws BOSException, EASBizException
    {
        try {
            return getController().correctBatchStocking(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}