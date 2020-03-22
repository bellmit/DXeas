package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AchievementEntryFactory
{
    private AchievementEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.food.IAchievementEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAchievementEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("09F43F85") ,com.kingdee.eas.custom.wages.food.IAchievementEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.food.IAchievementEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAchievementEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("09F43F85") ,com.kingdee.eas.custom.wages.food.IAchievementEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.food.IAchievementEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAchievementEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("09F43F85"));
    }
    public static com.kingdee.eas.custom.wages.food.IAchievementEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.IAchievementEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("09F43F85"));
    }
}