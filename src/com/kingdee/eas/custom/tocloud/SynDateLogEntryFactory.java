package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SynDateLogEntryFactory
{
    private SynDateLogEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.tocloud.ISynDateLogEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.ISynDateLogEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EC86100B") ,com.kingdee.eas.custom.tocloud.ISynDateLogEntry.class);
    }
    
    public static com.kingdee.eas.custom.tocloud.ISynDateLogEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.ISynDateLogEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EC86100B") ,com.kingdee.eas.custom.tocloud.ISynDateLogEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.tocloud.ISynDateLogEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.ISynDateLogEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EC86100B"));
    }
    public static com.kingdee.eas.custom.tocloud.ISynDateLogEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.ISynDateLogEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EC86100B"));
    }
}