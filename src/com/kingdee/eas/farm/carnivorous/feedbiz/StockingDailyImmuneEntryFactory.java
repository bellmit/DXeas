package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingDailyImmuneEntryFactory
{
    private StockingDailyImmuneEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyImmuneEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyImmuneEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("56CC8166") ,com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyImmuneEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyImmuneEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyImmuneEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("56CC8166") ,com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyImmuneEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyImmuneEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyImmuneEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("56CC8166"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyImmuneEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyImmuneEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("56CC8166"));
    }
}