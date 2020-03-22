package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ByThePieceBillEntryFactory
{
    private ByThePieceBillEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IByThePieceBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IByThePieceBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EE32378F") ,com.kingdee.eas.custom.wages.IByThePieceBillEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IByThePieceBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IByThePieceBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EE32378F") ,com.kingdee.eas.custom.wages.IByThePieceBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IByThePieceBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IByThePieceBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EE32378F"));
    }
    public static com.kingdee.eas.custom.wages.IByThePieceBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IByThePieceBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EE32378F"));
    }
}