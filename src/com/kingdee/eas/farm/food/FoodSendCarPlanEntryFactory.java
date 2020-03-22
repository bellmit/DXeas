package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FoodSendCarPlanEntryFactory
{
    private FoodSendCarPlanEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.food.IFoodSendCarPlanEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFoodSendCarPlanEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("824D9D25") ,com.kingdee.eas.farm.food.IFoodSendCarPlanEntry.class);
    }
    
    public static com.kingdee.eas.farm.food.IFoodSendCarPlanEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFoodSendCarPlanEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("824D9D25") ,com.kingdee.eas.farm.food.IFoodSendCarPlanEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.IFoodSendCarPlanEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFoodSendCarPlanEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("824D9D25"));
    }
    public static com.kingdee.eas.farm.food.IFoodSendCarPlanEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFoodSendCarPlanEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("824D9D25"));
    }
}