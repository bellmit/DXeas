package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BasicPostFoodFactory
{
    private BasicPostFoodFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.food.IBasicPostFood getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IBasicPostFood)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C5FBD1AA") ,com.kingdee.eas.custom.wages.food.IBasicPostFood.class);
    }
    
    public static com.kingdee.eas.custom.wages.food.IBasicPostFood getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IBasicPostFood)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C5FBD1AA") ,com.kingdee.eas.custom.wages.food.IBasicPostFood.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.food.IBasicPostFood getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IBasicPostFood)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C5FBD1AA"));
    }
    public static com.kingdee.eas.custom.wages.food.IBasicPostFood getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IBasicPostFood)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C5FBD1AA"));
    }
}