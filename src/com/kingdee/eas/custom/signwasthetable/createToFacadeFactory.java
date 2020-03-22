package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class createToFacadeFactory
{
    private createToFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.IcreateToFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IcreateToFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A42E417B") ,com.kingdee.eas.custom.signwasthetable.IcreateToFacade.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.IcreateToFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IcreateToFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A42E417B") ,com.kingdee.eas.custom.signwasthetable.IcreateToFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.IcreateToFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IcreateToFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A42E417B"));
    }
    public static com.kingdee.eas.custom.signwasthetable.IcreateToFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IcreateToFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A42E417B"));
    }
}