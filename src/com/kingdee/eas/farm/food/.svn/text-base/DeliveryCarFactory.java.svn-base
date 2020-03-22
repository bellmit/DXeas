package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DeliveryCarFactory
{
    private DeliveryCarFactory()
    {
    }
    public static com.kingdee.eas.farm.food.IDeliveryCar getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.IDeliveryCar)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0762EC56") ,com.kingdee.eas.farm.food.IDeliveryCar.class);
    }
    
    public static com.kingdee.eas.farm.food.IDeliveryCar getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IDeliveryCar)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0762EC56") ,com.kingdee.eas.farm.food.IDeliveryCar.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.IDeliveryCar getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IDeliveryCar)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0762EC56"));
    }
    public static com.kingdee.eas.farm.food.IDeliveryCar getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IDeliveryCar)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0762EC56"));
    }
}