package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CommSqlFacadeFactory
{
    private CommSqlFacadeFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.ICommSqlFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ICommSqlFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A2BC1A61") ,com.kingdee.eas.weighbridge.ICommSqlFacade.class);
    }
    
    public static com.kingdee.eas.weighbridge.ICommSqlFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ICommSqlFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A2BC1A61") ,com.kingdee.eas.weighbridge.ICommSqlFacade.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.ICommSqlFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ICommSqlFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A2BC1A61"));
    }
    public static com.kingdee.eas.weighbridge.ICommSqlFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ICommSqlFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A2BC1A61"));
    }
}