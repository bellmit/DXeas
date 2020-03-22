package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AdjustFoodmoneyFactory
{
    private AdjustFoodmoneyFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.food.IAdjustFoodmoney getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAdjustFoodmoney)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F07F5F11") ,com.kingdee.eas.custom.wages.food.IAdjustFoodmoney.class);
    }
    
    public static com.kingdee.eas.custom.wages.food.IAdjustFoodmoney getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAdjustFoodmoney)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F07F5F11") ,com.kingdee.eas.custom.wages.food.IAdjustFoodmoney.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.food.IAdjustFoodmoney getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAdjustFoodmoney)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F07F5F11"));
    }
    public static com.kingdee.eas.custom.wages.food.IAdjustFoodmoney getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAdjustFoodmoney)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F07F5F11"));
    }
}