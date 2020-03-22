package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FoodSendCarPlanOrgEntryFactory
{
    private FoodSendCarPlanOrgEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.food.IFoodSendCarPlanOrgEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFoodSendCarPlanOrgEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4FBA625B") ,com.kingdee.eas.farm.food.IFoodSendCarPlanOrgEntry.class);
    }
    
    public static com.kingdee.eas.farm.food.IFoodSendCarPlanOrgEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFoodSendCarPlanOrgEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4FBA625B") ,com.kingdee.eas.farm.food.IFoodSendCarPlanOrgEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.IFoodSendCarPlanOrgEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFoodSendCarPlanOrgEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4FBA625B"));
    }
    public static com.kingdee.eas.farm.food.IFoodSendCarPlanOrgEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFoodSendCarPlanOrgEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4FBA625B"));
    }
}