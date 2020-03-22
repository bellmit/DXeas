package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingBreedDailyDrugEntryFactory
{
    private StockingBreedDailyDrugEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyDrugEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyDrugEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AAAE05FC") ,com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyDrugEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyDrugEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyDrugEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AAAE05FC") ,com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyDrugEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyDrugEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyDrugEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AAAE05FC"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyDrugEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyDrugEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AAAE05FC"));
    }
}