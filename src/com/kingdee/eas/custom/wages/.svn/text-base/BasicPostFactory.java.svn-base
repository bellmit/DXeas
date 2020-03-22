package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BasicPostFactory
{
    private BasicPostFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IBasicPost getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IBasicPost)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1F8BC6E6") ,com.kingdee.eas.custom.wages.IBasicPost.class);
    }
    
    public static com.kingdee.eas.custom.wages.IBasicPost getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IBasicPost)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1F8BC6E6") ,com.kingdee.eas.custom.wages.IBasicPost.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IBasicPost getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IBasicPost)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1F8BC6E6"));
    }
    public static com.kingdee.eas.custom.wages.IBasicPost getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IBasicPost)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1F8BC6E6"));
    }
}