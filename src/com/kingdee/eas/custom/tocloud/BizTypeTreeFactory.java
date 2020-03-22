package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BizTypeTreeFactory
{
    private BizTypeTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.tocloud.IBizTypeTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBizTypeTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D467A772") ,com.kingdee.eas.custom.tocloud.IBizTypeTree.class);
    }
    
    public static com.kingdee.eas.custom.tocloud.IBizTypeTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBizTypeTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D467A772") ,com.kingdee.eas.custom.tocloud.IBizTypeTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.tocloud.IBizTypeTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBizTypeTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D467A772"));
    }
    public static com.kingdee.eas.custom.tocloud.IBizTypeTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBizTypeTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D467A772"));
    }
}