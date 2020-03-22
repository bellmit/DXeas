package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingBreedDailyTransEntryFactory
{
    private StockingBreedDailyTransEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyTransEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyTransEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("90985EA0") ,com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyTransEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyTransEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyTransEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("90985EA0") ,com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyTransEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyTransEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyTransEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("90985EA0"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyTransEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyTransEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("90985EA0"));
    }
}