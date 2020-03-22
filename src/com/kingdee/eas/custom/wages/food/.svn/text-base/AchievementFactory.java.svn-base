package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AchievementFactory
{
    private AchievementFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.food.IAchievement getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAchievement)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2726E4ED") ,com.kingdee.eas.custom.wages.food.IAchievement.class);
    }
    
    public static com.kingdee.eas.custom.wages.food.IAchievement getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAchievement)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2726E4ED") ,com.kingdee.eas.custom.wages.food.IAchievement.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.food.IAchievement getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAchievement)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2726E4ED"));
    }
    public static com.kingdee.eas.custom.wages.food.IAchievement getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAchievement)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2726E4ED"));
    }
}