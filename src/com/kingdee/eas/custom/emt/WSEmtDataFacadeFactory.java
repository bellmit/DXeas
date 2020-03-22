package com.kingdee.eas.custom.emt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WSEmtDataFacadeFactory
{
    private WSEmtDataFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.emt.IWSEmtDataFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.emt.IWSEmtDataFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A34B4C6D") ,com.kingdee.eas.custom.emt.IWSEmtDataFacade.class);
    }
    
    public static com.kingdee.eas.custom.emt.IWSEmtDataFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.emt.IWSEmtDataFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A34B4C6D") ,com.kingdee.eas.custom.emt.IWSEmtDataFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.emt.IWSEmtDataFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.emt.IWSEmtDataFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A34B4C6D"));
    }
    public static com.kingdee.eas.custom.emt.IWSEmtDataFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.emt.IWSEmtDataFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A34B4C6D"));
    }
}