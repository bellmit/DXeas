package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SignWasTheTablePayStatuFactory
{
    private SignWasTheTablePayStatuFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignWasTheTablePayStatu getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignWasTheTablePayStatu)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("23CED398") ,com.kingdee.eas.custom.signwasthetable.ISignWasTheTablePayStatu.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.ISignWasTheTablePayStatu getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignWasTheTablePayStatu)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("23CED398") ,com.kingdee.eas.custom.signwasthetable.ISignWasTheTablePayStatu.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignWasTheTablePayStatu getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignWasTheTablePayStatu)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("23CED398"));
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignWasTheTablePayStatu getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignWasTheTablePayStatu)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("23CED398"));
    }
}