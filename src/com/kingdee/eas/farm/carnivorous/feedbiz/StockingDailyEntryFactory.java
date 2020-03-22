package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingDailyEntryFactory
{
    private StockingDailyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EA921969") ,com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EA921969") ,com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EA921969"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EA921969"));
    }
}