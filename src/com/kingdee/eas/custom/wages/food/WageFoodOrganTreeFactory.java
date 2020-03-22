package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WageFoodOrganTreeFactory
{
    private WageFoodOrganTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.food.IWageFoodOrganTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IWageFoodOrganTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("03027587") ,com.kingdee.eas.custom.wages.food.IWageFoodOrganTree.class);
    }
    
    public static com.kingdee.eas.custom.wages.food.IWageFoodOrganTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IWageFoodOrganTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("03027587") ,com.kingdee.eas.custom.wages.food.IWageFoodOrganTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.food.IWageFoodOrganTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IWageFoodOrganTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("03027587"));
    }
    public static com.kingdee.eas.custom.wages.food.IWageFoodOrganTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IWageFoodOrganTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("03027587"));
    }
}