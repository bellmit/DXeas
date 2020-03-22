package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WSFoodFacadeFactory
{
    private WSFoodFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.food.IWSFoodFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.IWSFoodFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DD61C81E") ,com.kingdee.eas.farm.food.IWSFoodFacade.class);
    }
    
    public static com.kingdee.eas.farm.food.IWSFoodFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IWSFoodFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DD61C81E") ,com.kingdee.eas.farm.food.IWSFoodFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.IWSFoodFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IWSFoodFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DD61C81E"));
    }
    public static com.kingdee.eas.farm.food.IWSFoodFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IWSFoodFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DD61C81E"));
    }
}