package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingBatchTreeFactory
{
    private StockingBatchTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBatchTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBatchTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("62F0CF1B") ,com.kingdee.eas.farm.stocking.basedata.IStockingBatchTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBatchTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBatchTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("62F0CF1B") ,com.kingdee.eas.farm.stocking.basedata.IStockingBatchTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBatchTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBatchTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("62F0CF1B"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBatchTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBatchTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("62F0CF1B"));
    }
}