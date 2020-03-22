package com.kingdee.eas.custom;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class testFacadeFactory
{
    private testFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.ItestFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.ItestFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("724717B1") ,com.kingdee.eas.custom.ItestFacade.class);
    }
    
    public static com.kingdee.eas.custom.ItestFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.ItestFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("724717B1") ,com.kingdee.eas.custom.ItestFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.ItestFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.ItestFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("724717B1"));
    }
    public static com.kingdee.eas.custom.ItestFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.ItestFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("724717B1"));
    }
}