package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WageFoodOrganFactory
{
    private WageFoodOrganFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.food.IWageFoodOrgan getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IWageFoodOrgan)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("37D2DA49") ,com.kingdee.eas.custom.wages.food.IWageFoodOrgan.class);
    }
    
    public static com.kingdee.eas.custom.wages.food.IWageFoodOrgan getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IWageFoodOrgan)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("37D2DA49") ,com.kingdee.eas.custom.wages.food.IWageFoodOrgan.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.food.IWageFoodOrgan getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IWageFoodOrgan)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("37D2DA49"));
    }
    public static com.kingdee.eas.custom.wages.food.IWageFoodOrgan getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IWageFoodOrgan)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("37D2DA49"));
    }
}