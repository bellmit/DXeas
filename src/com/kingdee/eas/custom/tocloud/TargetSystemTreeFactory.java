package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TargetSystemTreeFactory
{
    private TargetSystemTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.tocloud.ITargetSystemTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.ITargetSystemTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C3F52BF7") ,com.kingdee.eas.custom.tocloud.ITargetSystemTree.class);
    }
    
    public static com.kingdee.eas.custom.tocloud.ITargetSystemTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.ITargetSystemTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C3F52BF7") ,com.kingdee.eas.custom.tocloud.ITargetSystemTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.tocloud.ITargetSystemTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.ITargetSystemTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C3F52BF7"));
    }
    public static com.kingdee.eas.custom.tocloud.ITargetSystemTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.ITargetSystemTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C3F52BF7"));
    }
}