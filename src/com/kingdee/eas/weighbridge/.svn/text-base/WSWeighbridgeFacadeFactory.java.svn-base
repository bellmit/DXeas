package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WSWeighbridgeFacadeFactory
{
    private WSWeighbridgeFacadeFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IWSWeighbridgeFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IWSWeighbridgeFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BB1525E8") ,com.kingdee.eas.weighbridge.IWSWeighbridgeFacade.class);
    }
    
    public static com.kingdee.eas.weighbridge.IWSWeighbridgeFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IWSWeighbridgeFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BB1525E8") ,com.kingdee.eas.weighbridge.IWSWeighbridgeFacade.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IWSWeighbridgeFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IWSWeighbridgeFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BB1525E8"));
    }
    public static com.kingdee.eas.weighbridge.IWSWeighbridgeFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IWSWeighbridgeFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BB1525E8"));
    }
}