package com.kingdee.eas.custom.shr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MyTestEntryFactory
{
    private MyTestEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.shr.IMyTestEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IMyTestEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8537081E") ,com.kingdee.eas.custom.shr.IMyTestEntry.class);
    }
    
    public static com.kingdee.eas.custom.shr.IMyTestEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IMyTestEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8537081E") ,com.kingdee.eas.custom.shr.IMyTestEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.shr.IMyTestEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IMyTestEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8537081E"));
    }
    public static com.kingdee.eas.custom.shr.IMyTestEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IMyTestEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8537081E"));
    }
}