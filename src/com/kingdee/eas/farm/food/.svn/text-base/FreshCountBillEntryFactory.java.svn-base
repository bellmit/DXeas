package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FreshCountBillEntryFactory
{
    private FreshCountBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.food.IFreshCountBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFreshCountBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C88B4C40") ,com.kingdee.eas.farm.food.IFreshCountBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.food.IFreshCountBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFreshCountBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C88B4C40") ,com.kingdee.eas.farm.food.IFreshCountBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.IFreshCountBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFreshCountBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C88B4C40"));
    }
    public static com.kingdee.eas.farm.food.IFreshCountBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFreshCountBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C88B4C40"));
    }
}