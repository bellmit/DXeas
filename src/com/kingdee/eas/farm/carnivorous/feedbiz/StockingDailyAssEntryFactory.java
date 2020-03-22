package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingDailyAssEntryFactory
{
    private StockingDailyAssEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyAssEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyAssEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A4833E1A") ,com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyAssEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyAssEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyAssEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A4833E1A") ,com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyAssEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyAssEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyAssEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A4833E1A"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyAssEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyAssEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A4833E1A"));
    }
}