package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OtherReceptionBillEntryFactory
{
    private OtherReceptionBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AD12F4C7") ,com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AD12F4C7") ,com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AD12F4C7"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AD12F4C7"));
    }
}