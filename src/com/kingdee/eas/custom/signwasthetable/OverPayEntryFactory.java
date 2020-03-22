package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OverPayEntryFactory
{
    private OverPayEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.IOverPayEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IOverPayEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6A2B19A8") ,com.kingdee.eas.custom.signwasthetable.IOverPayEntry.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.IOverPayEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IOverPayEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6A2B19A8") ,com.kingdee.eas.custom.signwasthetable.IOverPayEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.IOverPayEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IOverPayEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6A2B19A8"));
    }
    public static com.kingdee.eas.custom.signwasthetable.IOverPayEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IOverPayEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6A2B19A8"));
    }
}