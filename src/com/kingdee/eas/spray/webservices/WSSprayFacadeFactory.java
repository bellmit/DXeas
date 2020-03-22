package com.kingdee.eas.spray.webservices;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WSSprayFacadeFactory
{
    private WSSprayFacadeFactory()
    {
    }
    public static com.kingdee.eas.spray.webservices.IWSSprayFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.spray.webservices.IWSSprayFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0E3A2C09") ,com.kingdee.eas.spray.webservices.IWSSprayFacade.class);
    }
    
    public static com.kingdee.eas.spray.webservices.IWSSprayFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.spray.webservices.IWSSprayFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0E3A2C09") ,com.kingdee.eas.spray.webservices.IWSSprayFacade.class, objectCtx);
    }
    public static com.kingdee.eas.spray.webservices.IWSSprayFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.spray.webservices.IWSSprayFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0E3A2C09"));
    }
    public static com.kingdee.eas.spray.webservices.IWSSprayFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.spray.webservices.IWSSprayFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0E3A2C09"));
    }
}