package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EngProjectTreeFactory
{
    private EngProjectTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.IEngProjectTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IEngProjectTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8F4EA823") ,com.kingdee.eas.custom.signwasthetable.IEngProjectTree.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.IEngProjectTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IEngProjectTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8F4EA823") ,com.kingdee.eas.custom.signwasthetable.IEngProjectTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.IEngProjectTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IEngProjectTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8F4EA823"));
    }
    public static com.kingdee.eas.custom.signwasthetable.IEngProjectTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IEngProjectTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8F4EA823"));
    }
}