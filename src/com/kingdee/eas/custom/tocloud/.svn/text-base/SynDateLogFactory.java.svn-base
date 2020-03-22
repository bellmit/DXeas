package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SynDateLogFactory
{
    private SynDateLogFactory()
    {
    }
    public static com.kingdee.eas.custom.tocloud.ISynDateLog getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.ISynDateLog)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("892A58A7") ,com.kingdee.eas.custom.tocloud.ISynDateLog.class);
    }
    
    public static com.kingdee.eas.custom.tocloud.ISynDateLog getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.ISynDateLog)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("892A58A7") ,com.kingdee.eas.custom.tocloud.ISynDateLog.class, objectCtx);
    }
    public static com.kingdee.eas.custom.tocloud.ISynDateLog getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.ISynDateLog)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("892A58A7"));
    }
    public static com.kingdee.eas.custom.tocloud.ISynDateLog getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.ISynDateLog)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("892A58A7"));
    }
}