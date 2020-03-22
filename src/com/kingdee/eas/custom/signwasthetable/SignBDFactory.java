package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SignBDFactory
{
    private SignBDFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignBD getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignBD)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5D6FB649") ,com.kingdee.eas.custom.signwasthetable.ISignBD.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.ISignBD getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignBD)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5D6FB649") ,com.kingdee.eas.custom.signwasthetable.ISignBD.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignBD getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignBD)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5D6FB649"));
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignBD getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignBD)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5D6FB649"));
    }
}