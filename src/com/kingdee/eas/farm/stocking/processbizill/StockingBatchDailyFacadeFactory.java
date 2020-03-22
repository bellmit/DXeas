package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingBatchDailyFacadeFactory
{
    private StockingBatchDailyFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBatchDailyFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBatchDailyFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BABE360A") ,com.kingdee.eas.farm.stocking.processbizill.IStockingBatchDailyFacade.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBatchDailyFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBatchDailyFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BABE360A") ,com.kingdee.eas.farm.stocking.processbizill.IStockingBatchDailyFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBatchDailyFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBatchDailyFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BABE360A"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBatchDailyFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBatchDailyFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BABE360A"));
    }
}