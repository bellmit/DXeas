package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ChickenDailyBodyEntryFactory
{
    private ChickenDailyBodyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.food.IChickenDailyBodyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.IChickenDailyBodyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7DB00C82") ,com.kingdee.eas.farm.food.IChickenDailyBodyEntry.class);
    }
    
    public static com.kingdee.eas.farm.food.IChickenDailyBodyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IChickenDailyBodyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7DB00C82") ,com.kingdee.eas.farm.food.IChickenDailyBodyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.IChickenDailyBodyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IChickenDailyBodyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7DB00C82"));
    }
    public static com.kingdee.eas.farm.food.IChickenDailyBodyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IChickenDailyBodyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7DB00C82"));
    }
}