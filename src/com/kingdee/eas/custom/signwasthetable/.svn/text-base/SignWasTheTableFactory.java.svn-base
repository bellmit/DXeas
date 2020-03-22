package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SignWasTheTableFactory
{
    private SignWasTheTableFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignWasTheTable getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignWasTheTable)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F132319F") ,com.kingdee.eas.custom.signwasthetable.ISignWasTheTable.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.ISignWasTheTable getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignWasTheTable)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F132319F") ,com.kingdee.eas.custom.signwasthetable.ISignWasTheTable.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignWasTheTable getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignWasTheTable)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F132319F"));
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignWasTheTable getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignWasTheTable)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F132319F"));
    }
}