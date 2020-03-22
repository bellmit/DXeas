package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingBatchHouseEntryFactory
{
    private StockingBatchHouseEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBatchHouseEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBatchHouseEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0FE6CEEF") ,com.kingdee.eas.farm.stocking.basedata.IStockingBatchHouseEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBatchHouseEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBatchHouseEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0FE6CEEF") ,com.kingdee.eas.farm.stocking.basedata.IStockingBatchHouseEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBatchHouseEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBatchHouseEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0FE6CEEF"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBatchHouseEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBatchHouseEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0FE6CEEF"));
    }
}