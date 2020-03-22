package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FreshCountBillFactory
{
    private FreshCountBillFactory()
    {
    }
    public static com.kingdee.eas.farm.food.IFreshCountBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFreshCountBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3E438F52") ,com.kingdee.eas.farm.food.IFreshCountBill.class);
    }
    
    public static com.kingdee.eas.farm.food.IFreshCountBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFreshCountBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3E438F52") ,com.kingdee.eas.farm.food.IFreshCountBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.IFreshCountBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFreshCountBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3E438F52"));
    }
    public static com.kingdee.eas.farm.food.IFreshCountBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFreshCountBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3E438F52"));
    }
}