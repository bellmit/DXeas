package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmFeedStockBillFactory
{
    private FarmFeedStockBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3A06FAE4") ,com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3A06FAE4") ,com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3A06FAE4"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFarmFeedStockBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3A06FAE4"));
    }
}