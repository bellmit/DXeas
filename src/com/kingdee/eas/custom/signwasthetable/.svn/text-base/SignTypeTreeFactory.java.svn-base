package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SignTypeTreeFactory
{
    private SignTypeTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignTypeTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignTypeTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("184B7ADF") ,com.kingdee.eas.custom.signwasthetable.ISignTypeTree.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.ISignTypeTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignTypeTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("184B7ADF") ,com.kingdee.eas.custom.signwasthetable.ISignTypeTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignTypeTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignTypeTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("184B7ADF"));
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignTypeTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignTypeTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("184B7ADF"));
    }
}