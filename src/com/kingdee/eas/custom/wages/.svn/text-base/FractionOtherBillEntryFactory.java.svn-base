package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FractionOtherBillEntryFactory
{
    private FractionOtherBillEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IFractionOtherBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IFractionOtherBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2B3DFC25") ,com.kingdee.eas.custom.wages.IFractionOtherBillEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IFractionOtherBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IFractionOtherBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2B3DFC25") ,com.kingdee.eas.custom.wages.IFractionOtherBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IFractionOtherBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IFractionOtherBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2B3DFC25"));
    }
    public static com.kingdee.eas.custom.wages.IFractionOtherBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IFractionOtherBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2B3DFC25"));
    }
}