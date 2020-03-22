package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PostSubsidyFactory
{
    private PostSubsidyFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IPostSubsidy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPostSubsidy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("52F0D5E3") ,com.kingdee.eas.custom.wages.IPostSubsidy.class);
    }
    
    public static com.kingdee.eas.custom.wages.IPostSubsidy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPostSubsidy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("52F0D5E3") ,com.kingdee.eas.custom.wages.IPostSubsidy.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IPostSubsidy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPostSubsidy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("52F0D5E3"));
    }
    public static com.kingdee.eas.custom.wages.IPostSubsidy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPostSubsidy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("52F0D5E3"));
    }
}