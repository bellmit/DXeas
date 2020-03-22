package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingBreedDailyEggEntryFactory
{
    private StockingBreedDailyEggEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEggEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEggEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2ED620E3") ,com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEggEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEggEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEggEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2ED620E3") ,com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEggEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEggEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEggEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2ED620E3"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEggEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEggEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2ED620E3"));
    }
}