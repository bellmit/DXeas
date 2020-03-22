package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AdjustFoodmoneyEntryFactory
{
    private AdjustFoodmoneyEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.food.IAdjustFoodmoneyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAdjustFoodmoneyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C4467BE1") ,com.kingdee.eas.custom.wages.food.IAdjustFoodmoneyEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.food.IAdjustFoodmoneyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAdjustFoodmoneyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C4467BE1") ,com.kingdee.eas.custom.wages.food.IAdjustFoodmoneyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.food.IAdjustFoodmoneyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAdjustFoodmoneyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C4467BE1"));
    }
    public static com.kingdee.eas.custom.wages.food.IAdjustFoodmoneyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAdjustFoodmoneyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C4467BE1"));
    }
}