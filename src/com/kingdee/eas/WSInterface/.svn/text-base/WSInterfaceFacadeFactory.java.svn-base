package com.kingdee.eas.WSInterface;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WSInterfaceFacadeFactory
{
    private WSInterfaceFacadeFactory()
    {
    }
    public static com.kingdee.eas.WSInterface.IWSInterfaceFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.WSInterface.IWSInterfaceFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3E2587C1") ,com.kingdee.eas.WSInterface.IWSInterfaceFacade.class);
    }
    
    public static com.kingdee.eas.WSInterface.IWSInterfaceFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.WSInterface.IWSInterfaceFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3E2587C1") ,com.kingdee.eas.WSInterface.IWSInterfaceFacade.class, objectCtx);
    }
    public static com.kingdee.eas.WSInterface.IWSInterfaceFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.WSInterface.IWSInterfaceFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3E2587C1"));
    }
    public static com.kingdee.eas.WSInterface.IWSInterfaceFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.WSInterface.IWSInterfaceFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3E2587C1"));
    }
}