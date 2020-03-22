package com.kingdee.eas.custom.test;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SignwasthetableFactory
{
    private SignwasthetableFactory()
    {
    }
    public static com.kingdee.eas.custom.test.ISignwasthetable getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.test.ISignwasthetable)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("747820B8") ,com.kingdee.eas.custom.test.ISignwasthetable.class);
    }
    
    public static com.kingdee.eas.custom.test.ISignwasthetable getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.test.ISignwasthetable)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("747820B8") ,com.kingdee.eas.custom.test.ISignwasthetable.class, objectCtx);
    }
    public static com.kingdee.eas.custom.test.ISignwasthetable getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.test.ISignwasthetable)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("747820B8"));
    }
    public static com.kingdee.eas.custom.test.ISignwasthetable getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.test.ISignwasthetable)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("747820B8"));
    }
}