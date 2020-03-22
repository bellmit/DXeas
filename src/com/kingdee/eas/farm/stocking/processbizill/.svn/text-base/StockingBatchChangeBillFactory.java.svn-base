package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingBatchChangeBillFactory
{
    private StockingBatchChangeBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBatchChangeBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBatchChangeBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1CCA4700") ,com.kingdee.eas.farm.stocking.processbizill.IStockingBatchChangeBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBatchChangeBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBatchChangeBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1CCA4700") ,com.kingdee.eas.farm.stocking.processbizill.IStockingBatchChangeBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBatchChangeBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBatchChangeBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1CCA4700"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStockingBatchChangeBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStockingBatchChangeBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1CCA4700"));
    }
}