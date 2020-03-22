package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OverPayFactory
{
    private OverPayFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.IOverPay getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IOverPay)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("930300EA") ,com.kingdee.eas.custom.signwasthetable.IOverPay.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.IOverPay getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IOverPay)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("930300EA") ,com.kingdee.eas.custom.signwasthetable.IOverPay.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.IOverPay getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IOverPay)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("930300EA"));
    }
    public static com.kingdee.eas.custom.signwasthetable.IOverPay getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IOverPay)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("930300EA"));
    }
}