package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingBreedDailyFactory
{
    private StockingBreedDailyFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDaily getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDaily)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2859A756") ,com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDaily.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDaily getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDaily)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2859A756") ,com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDaily.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDaily getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDaily)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2859A756"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDaily getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDaily)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2859A756"));
    }
}