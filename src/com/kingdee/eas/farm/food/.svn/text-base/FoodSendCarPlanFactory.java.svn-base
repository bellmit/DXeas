package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FoodSendCarPlanFactory
{
    private FoodSendCarPlanFactory()
    {
    }
    public static com.kingdee.eas.farm.food.IFoodSendCarPlan getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFoodSendCarPlan)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8291834D") ,com.kingdee.eas.farm.food.IFoodSendCarPlan.class);
    }
    
    public static com.kingdee.eas.farm.food.IFoodSendCarPlan getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFoodSendCarPlan)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8291834D") ,com.kingdee.eas.farm.food.IFoodSendCarPlan.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.IFoodSendCarPlan getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFoodSendCarPlan)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8291834D"));
    }
    public static com.kingdee.eas.farm.food.IFoodSendCarPlan getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFoodSendCarPlan)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8291834D"));
    }
}