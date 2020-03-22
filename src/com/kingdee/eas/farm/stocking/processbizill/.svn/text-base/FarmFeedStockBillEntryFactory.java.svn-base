package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmFeedStockBillEntryFactory
{
    private FarmFeedStockBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3E564BEE") ,com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3E564BEE") ,com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3E564BEE"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3E564BEE"));
    }
}