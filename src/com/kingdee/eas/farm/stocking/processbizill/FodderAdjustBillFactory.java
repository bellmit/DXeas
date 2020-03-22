package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FodderAdjustBillFactory
{
    private FodderAdjustBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3755BBB1") ,com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3755BBB1") ,com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3755BBB1"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3755BBB1"));
    }
}