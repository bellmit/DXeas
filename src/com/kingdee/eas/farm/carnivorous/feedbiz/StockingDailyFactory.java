package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingDailyFactory
{
    private StockingDailyFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDaily getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDaily)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CA396C89") ,com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDaily.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDaily getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDaily)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CA396C89") ,com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDaily.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDaily getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDaily)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CA396C89"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDaily getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDaily)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CA396C89"));
    }
}