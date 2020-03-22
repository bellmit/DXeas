package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ChickenDailyFactory
{
    private ChickenDailyFactory()
    {
    }
    public static com.kingdee.eas.farm.food.IChickenDaily getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.IChickenDaily)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C522B70E") ,com.kingdee.eas.farm.food.IChickenDaily.class);
    }
    
    public static com.kingdee.eas.farm.food.IChickenDaily getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IChickenDaily)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C522B70E") ,com.kingdee.eas.farm.food.IChickenDaily.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.IChickenDaily getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IChickenDaily)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C522B70E"));
    }
    public static com.kingdee.eas.farm.food.IChickenDaily getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IChickenDaily)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C522B70E"));
    }
}