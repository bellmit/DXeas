package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DeliveryCarEditFacadeFactory
{
    private DeliveryCarEditFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.food.IDeliveryCarEditFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.IDeliveryCarEditFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("61ADB03A") ,com.kingdee.eas.farm.food.IDeliveryCarEditFacade.class);
    }
    
    public static com.kingdee.eas.farm.food.IDeliveryCarEditFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IDeliveryCarEditFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("61ADB03A") ,com.kingdee.eas.farm.food.IDeliveryCarEditFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.IDeliveryCarEditFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IDeliveryCarEditFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("61ADB03A"));
    }
    public static com.kingdee.eas.farm.food.IDeliveryCarEditFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IDeliveryCarEditFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("61ADB03A"));
    }
}