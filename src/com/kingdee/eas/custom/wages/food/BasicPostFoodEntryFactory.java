package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BasicPostFoodEntryFactory
{
    private BasicPostFoodEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.food.IBasicPostFoodEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IBasicPostFoodEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("89D6C0E8") ,com.kingdee.eas.custom.wages.food.IBasicPostFoodEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.food.IBasicPostFoodEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IBasicPostFoodEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("89D6C0E8") ,com.kingdee.eas.custom.wages.food.IBasicPostFoodEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.food.IBasicPostFoodEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IBasicPostFoodEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("89D6C0E8"));
    }
    public static com.kingdee.eas.custom.wages.food.IBasicPostFoodEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IBasicPostFoodEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("89D6C0E8"));
    }
}