package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingBreedDailyImmuneEntryFactory
{
    private StockingBreedDailyImmuneEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyImmuneEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyImmuneEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4D657479") ,com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyImmuneEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyImmuneEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyImmuneEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4D657479") ,com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyImmuneEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyImmuneEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyImmuneEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4D657479"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyImmuneEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyImmuneEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4D657479"));
    }
}