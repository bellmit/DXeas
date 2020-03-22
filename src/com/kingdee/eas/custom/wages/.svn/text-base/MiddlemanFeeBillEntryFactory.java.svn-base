package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MiddlemanFeeBillEntryFactory
{
    private MiddlemanFeeBillEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IMiddlemanFeeBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMiddlemanFeeBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F2597102") ,com.kingdee.eas.custom.wages.IMiddlemanFeeBillEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IMiddlemanFeeBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMiddlemanFeeBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F2597102") ,com.kingdee.eas.custom.wages.IMiddlemanFeeBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IMiddlemanFeeBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMiddlemanFeeBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F2597102"));
    }
    public static com.kingdee.eas.custom.wages.IMiddlemanFeeBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMiddlemanFeeBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F2597102"));
    }
}