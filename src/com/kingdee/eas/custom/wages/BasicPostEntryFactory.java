package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BasicPostEntryFactory
{
    private BasicPostEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IBasicPostEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IBasicPostEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4B5AB12C") ,com.kingdee.eas.custom.wages.IBasicPostEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IBasicPostEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IBasicPostEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4B5AB12C") ,com.kingdee.eas.custom.wages.IBasicPostEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IBasicPostEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IBasicPostEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4B5AB12C"));
    }
    public static com.kingdee.eas.custom.wages.IBasicPostEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IBasicPostEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4B5AB12C"));
    }
}