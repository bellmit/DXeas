package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProdasseindexEntryFactory
{
    private ProdasseindexEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.food.IProdasseindexEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IProdasseindexEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("75FA9B5D") ,com.kingdee.eas.custom.wages.food.IProdasseindexEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.food.IProdasseindexEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IProdasseindexEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("75FA9B5D") ,com.kingdee.eas.custom.wages.food.IProdasseindexEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.food.IProdasseindexEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IProdasseindexEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("75FA9B5D"));
    }
    public static com.kingdee.eas.custom.wages.food.IProdasseindexEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IProdasseindexEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("75FA9B5D"));
    }
}