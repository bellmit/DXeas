package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SignTableFacadeFactory
{
    private SignTableFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignTableFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignTableFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("443417C1") ,com.kingdee.eas.custom.signwasthetable.ISignTableFacade.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.ISignTableFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignTableFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("443417C1") ,com.kingdee.eas.custom.signwasthetable.ISignTableFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignTableFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignTableFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("443417C1"));
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignTableFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignTableFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("443417C1"));
    }
}