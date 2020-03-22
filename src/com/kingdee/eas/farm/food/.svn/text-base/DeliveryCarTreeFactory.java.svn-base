package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DeliveryCarTreeFactory
{
    private DeliveryCarTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.food.IDeliveryCarTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.IDeliveryCarTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("88F0B914") ,com.kingdee.eas.farm.food.IDeliveryCarTree.class);
    }
    
    public static com.kingdee.eas.farm.food.IDeliveryCarTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IDeliveryCarTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("88F0B914") ,com.kingdee.eas.farm.food.IDeliveryCarTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.IDeliveryCarTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IDeliveryCarTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("88F0B914"));
    }
    public static com.kingdee.eas.farm.food.IDeliveryCarTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IDeliveryCarTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("88F0B914"));
    }
}