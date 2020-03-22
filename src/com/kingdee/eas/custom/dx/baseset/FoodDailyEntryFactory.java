package com.kingdee.eas.custom.dx.baseset;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FoodDailyEntryFactory
{
    private FoodDailyEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.dx.baseset.IFoodDailyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IFoodDailyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("25BFCE23") ,com.kingdee.eas.custom.dx.baseset.IFoodDailyEntry.class);
    }
    
    public static com.kingdee.eas.custom.dx.baseset.IFoodDailyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IFoodDailyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("25BFCE23") ,com.kingdee.eas.custom.dx.baseset.IFoodDailyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.dx.baseset.IFoodDailyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IFoodDailyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("25BFCE23"));
    }
    public static com.kingdee.eas.custom.dx.baseset.IFoodDailyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IFoodDailyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("25BFCE23"));
    }
}