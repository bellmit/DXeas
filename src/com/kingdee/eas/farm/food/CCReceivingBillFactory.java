package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCReceivingBillFactory
{
    private CCReceivingBillFactory()
    {
    }
    public static com.kingdee.eas.farm.food.ICCReceivingBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICCReceivingBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4C3F10BD") ,com.kingdee.eas.farm.food.ICCReceivingBill.class);
    }
    
    public static com.kingdee.eas.farm.food.ICCReceivingBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICCReceivingBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4C3F10BD") ,com.kingdee.eas.farm.food.ICCReceivingBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.ICCReceivingBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICCReceivingBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4C3F10BD"));
    }
    public static com.kingdee.eas.farm.food.ICCReceivingBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICCReceivingBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4C3F10BD"));
    }
}