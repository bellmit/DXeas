package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarExcuteCircsFactory
{
    private CarExcuteCircsFactory()
    {
    }
    public static com.kingdee.eas.farm.food.ICarExcuteCircs getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICarExcuteCircs)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5A6D8CFC") ,com.kingdee.eas.farm.food.ICarExcuteCircs.class);
    }
    
    public static com.kingdee.eas.farm.food.ICarExcuteCircs getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICarExcuteCircs)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5A6D8CFC") ,com.kingdee.eas.farm.food.ICarExcuteCircs.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.ICarExcuteCircs getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICarExcuteCircs)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5A6D8CFC"));
    }
    public static com.kingdee.eas.farm.food.ICarExcuteCircs getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICarExcuteCircs)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5A6D8CFC"));
    }
}