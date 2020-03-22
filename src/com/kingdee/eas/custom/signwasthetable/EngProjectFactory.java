package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EngProjectFactory
{
    private EngProjectFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.IEngProject getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IEngProject)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C178BAE5") ,com.kingdee.eas.custom.signwasthetable.IEngProject.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.IEngProject getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IEngProject)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C178BAE5") ,com.kingdee.eas.custom.signwasthetable.IEngProject.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.IEngProject getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IEngProject)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C178BAE5"));
    }
    public static com.kingdee.eas.custom.signwasthetable.IEngProject getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IEngProject)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C178BAE5"));
    }
}