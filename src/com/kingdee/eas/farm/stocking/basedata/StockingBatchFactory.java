package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingBatchFactory
{
    private StockingBatchFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBatch getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBatch)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("00751DDD") ,com.kingdee.eas.farm.stocking.basedata.IStockingBatch.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBatch getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBatch)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("00751DDD") ,com.kingdee.eas.farm.stocking.basedata.IStockingBatch.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBatch getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBatch)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("00751DDD"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBatch getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBatch)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("00751DDD"));
    }
}