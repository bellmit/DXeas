package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ServiceItemsFactory
{
    private ServiceItemsFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IServiceItems getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IServiceItems)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("29354319") ,com.kingdee.eas.farm.hatch.IServiceItems.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IServiceItems getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IServiceItems)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("29354319") ,com.kingdee.eas.farm.hatch.IServiceItems.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IServiceItems getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IServiceItems)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("29354319"));
    }
    public static com.kingdee.eas.farm.hatch.IServiceItems getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IServiceItems)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("29354319"));
    }
}