package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingDailyEnviFactory
{
    private StockingDailyEnviFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEnvi getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEnvi)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FF4F0945") ,com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEnvi.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEnvi getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEnvi)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FF4F0945") ,com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEnvi.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEnvi getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEnvi)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FF4F0945"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEnvi getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDailyEnvi)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FF4F0945"));
    }
}