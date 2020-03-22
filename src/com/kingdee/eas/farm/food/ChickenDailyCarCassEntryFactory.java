package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ChickenDailyCarCassEntryFactory
{
    private ChickenDailyCarCassEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.food.IChickenDailyCarCassEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.IChickenDailyCarCassEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C3B2088E") ,com.kingdee.eas.farm.food.IChickenDailyCarCassEntry.class);
    }
    
    public static com.kingdee.eas.farm.food.IChickenDailyCarCassEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IChickenDailyCarCassEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C3B2088E") ,com.kingdee.eas.farm.food.IChickenDailyCarCassEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.IChickenDailyCarCassEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IChickenDailyCarCassEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C3B2088E"));
    }
    public static com.kingdee.eas.farm.food.IChickenDailyCarCassEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IChickenDailyCarCassEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C3B2088E"));
    }
}