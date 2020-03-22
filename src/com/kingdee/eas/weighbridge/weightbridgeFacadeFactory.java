package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class weightbridgeFacadeFactory
{
    private weightbridgeFacadeFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IweightbridgeFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IweightbridgeFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2452CEF6") ,com.kingdee.eas.weighbridge.IweightbridgeFacade.class);
    }
    
    public static com.kingdee.eas.weighbridge.IweightbridgeFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IweightbridgeFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2452CEF6") ,com.kingdee.eas.weighbridge.IweightbridgeFacade.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IweightbridgeFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IweightbridgeFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2452CEF6"));
    }
    public static com.kingdee.eas.weighbridge.IweightbridgeFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IweightbridgeFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2452CEF6"));
    }
}