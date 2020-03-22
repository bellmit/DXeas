package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProdasseindexFactory
{
    private ProdasseindexFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.food.IProdasseindex getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IProdasseindex)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("015C8215") ,com.kingdee.eas.custom.wages.food.IProdasseindex.class);
    }
    
    public static com.kingdee.eas.custom.wages.food.IProdasseindex getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IProdasseindex)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("015C8215") ,com.kingdee.eas.custom.wages.food.IProdasseindex.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.food.IProdasseindex getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IProdasseindex)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("015C8215"));
    }
    public static com.kingdee.eas.custom.wages.food.IProdasseindex getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IProdasseindex)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("015C8215"));
    }
}