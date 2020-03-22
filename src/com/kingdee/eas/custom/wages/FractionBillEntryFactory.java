package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FractionBillEntryFactory
{
    private FractionBillEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IFractionBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IFractionBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("ADA015C1") ,com.kingdee.eas.custom.wages.IFractionBillEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IFractionBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IFractionBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("ADA015C1") ,com.kingdee.eas.custom.wages.IFractionBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IFractionBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IFractionBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("ADA015C1"));
    }
    public static com.kingdee.eas.custom.wages.IFractionBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IFractionBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("ADA015C1"));
    }
}