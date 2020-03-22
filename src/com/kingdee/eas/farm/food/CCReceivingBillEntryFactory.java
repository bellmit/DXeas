package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCReceivingBillEntryFactory
{
    private CCReceivingBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.food.ICCReceivingBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICCReceivingBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("172EF5B5") ,com.kingdee.eas.farm.food.ICCReceivingBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.food.ICCReceivingBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICCReceivingBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("172EF5B5") ,com.kingdee.eas.farm.food.ICCReceivingBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.ICCReceivingBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICCReceivingBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("172EF5B5"));
    }
    public static com.kingdee.eas.farm.food.ICCReceivingBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICCReceivingBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("172EF5B5"));
    }
}