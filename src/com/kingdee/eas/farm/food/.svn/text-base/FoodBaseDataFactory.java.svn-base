package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FoodBaseDataFactory
{
    private FoodBaseDataFactory()
    {
    }
    public static com.kingdee.eas.farm.food.IFoodBaseData getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFoodBaseData)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D0187A43") ,com.kingdee.eas.farm.food.IFoodBaseData.class);
    }
    
    public static com.kingdee.eas.farm.food.IFoodBaseData getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFoodBaseData)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D0187A43") ,com.kingdee.eas.farm.food.IFoodBaseData.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.IFoodBaseData getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFoodBaseData)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D0187A43"));
    }
    public static com.kingdee.eas.farm.food.IFoodBaseData getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFoodBaseData)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D0187A43"));
    }
}