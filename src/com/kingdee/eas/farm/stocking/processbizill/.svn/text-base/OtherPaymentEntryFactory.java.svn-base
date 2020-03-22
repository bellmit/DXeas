package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OtherPaymentEntryFactory
{
    private OtherPaymentEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IOtherPaymentEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IOtherPaymentEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2E935077") ,com.kingdee.eas.farm.stocking.processbizill.IOtherPaymentEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IOtherPaymentEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IOtherPaymentEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2E935077") ,com.kingdee.eas.farm.stocking.processbizill.IOtherPaymentEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IOtherPaymentEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IOtherPaymentEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2E935077"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IOtherPaymentEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IOtherPaymentEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2E935077"));
    }
}