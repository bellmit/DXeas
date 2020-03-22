package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MonthFoodBillFactory
{
    private MonthFoodBillFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.food.IMonthFoodBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IMonthFoodBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D6D82A63") ,com.kingdee.eas.custom.wages.food.IMonthFoodBill.class);
    }
    
    public static com.kingdee.eas.custom.wages.food.IMonthFoodBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IMonthFoodBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D6D82A63") ,com.kingdee.eas.custom.wages.food.IMonthFoodBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.food.IMonthFoodBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IMonthFoodBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D6D82A63"));
    }
    public static com.kingdee.eas.custom.wages.food.IMonthFoodBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IMonthFoodBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D6D82A63"));
    }
}