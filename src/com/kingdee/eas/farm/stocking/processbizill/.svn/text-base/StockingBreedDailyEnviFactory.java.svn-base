package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingBreedDailyEnviFactory
{
    private StockingBreedDailyEnviFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEnvi getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEnvi)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8A0B1592") ,com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEnvi.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEnvi getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEnvi)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8A0B1592") ,com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEnvi.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEnvi getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEnvi)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8A0B1592"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEnvi getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDailyEnvi)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8A0B1592"));
    }
}