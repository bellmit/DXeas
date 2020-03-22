package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MonthFoodBillEntryFactory
{
    private MonthFoodBillEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.food.IMonthFoodBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IMonthFoodBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("08A1F3CF") ,com.kingdee.eas.custom.wages.food.IMonthFoodBillEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.food.IMonthFoodBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IMonthFoodBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("08A1F3CF") ,com.kingdee.eas.custom.wages.food.IMonthFoodBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.food.IMonthFoodBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IMonthFoodBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("08A1F3CF"));
    }
    public static com.kingdee.eas.custom.wages.food.IMonthFoodBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IMonthFoodBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("08A1F3CF"));
    }
}