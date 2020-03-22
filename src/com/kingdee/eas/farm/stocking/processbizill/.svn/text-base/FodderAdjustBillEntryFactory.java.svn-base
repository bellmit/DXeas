package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FodderAdjustBillEntryFactory
{
    private FodderAdjustBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("62110341") ,com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("62110341") ,com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("62110341"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderAdjustBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("62110341"));
    }
}