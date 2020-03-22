package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DayrateCalFacadeFactory
{
    private DayrateCalFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.dayratecost.IDayrateCalFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayrateCalFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("95361A51") ,com.kingdee.eas.farm.dayratecost.IDayrateCalFacade.class);
    }
    
    public static com.kingdee.eas.farm.dayratecost.IDayrateCalFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayrateCalFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("95361A51") ,com.kingdee.eas.farm.dayratecost.IDayrateCalFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.dayratecost.IDayrateCalFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayrateCalFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("95361A51"));
    }
    public static com.kingdee.eas.farm.dayratecost.IDayrateCalFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayrateCalFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("95361A51"));
    }
}