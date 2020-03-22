package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SignTypeFactory
{
    private SignTypeFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C0644BA1") ,com.kingdee.eas.custom.signwasthetable.ISignType.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.ISignType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C0644BA1") ,com.kingdee.eas.custom.signwasthetable.ISignType.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C0644BA1"));
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C0644BA1"));
    }
}