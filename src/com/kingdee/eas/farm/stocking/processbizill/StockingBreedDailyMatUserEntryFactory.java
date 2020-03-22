package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingBreedDailyMatUserEntryFactory
{
    private StockingBreedDailyMatUserEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyMatUserEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyMatUserEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FAB7045D") ,com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyMatUserEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyMatUserEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyMatUserEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FAB7045D") ,com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyMatUserEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyMatUserEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyMatUserEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FAB7045D"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyMatUserEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyMatUserEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FAB7045D"));
    }
}