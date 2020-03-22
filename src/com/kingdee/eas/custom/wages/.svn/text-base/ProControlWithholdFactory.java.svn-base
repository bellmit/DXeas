package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProControlWithholdFactory
{
    private ProControlWithholdFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IProControlWithhold getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IProControlWithhold)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("614C0E9D") ,com.kingdee.eas.custom.wages.IProControlWithhold.class);
    }
    
    public static com.kingdee.eas.custom.wages.IProControlWithhold getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IProControlWithhold)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("614C0E9D") ,com.kingdee.eas.custom.wages.IProControlWithhold.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IProControlWithhold getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IProControlWithhold)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("614C0E9D"));
    }
    public static com.kingdee.eas.custom.wages.IProControlWithhold getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IProControlWithhold)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("614C0E9D"));
    }
}