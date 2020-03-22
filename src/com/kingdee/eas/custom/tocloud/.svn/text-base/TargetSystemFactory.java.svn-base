package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TargetSystemFactory
{
    private TargetSystemFactory()
    {
    }
    public static com.kingdee.eas.custom.tocloud.ITargetSystem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.ITargetSystem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("940248B9") ,com.kingdee.eas.custom.tocloud.ITargetSystem.class);
    }
    
    public static com.kingdee.eas.custom.tocloud.ITargetSystem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.ITargetSystem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("940248B9") ,com.kingdee.eas.custom.tocloud.ITargetSystem.class, objectCtx);
    }
    public static com.kingdee.eas.custom.tocloud.ITargetSystem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.ITargetSystem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("940248B9"));
    }
    public static com.kingdee.eas.custom.tocloud.ITargetSystem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.ITargetSystem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("940248B9"));
    }
}