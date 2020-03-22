package com.kingdee.eas.custom.dx.baseset;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FoodDailyFactory
{
    private FoodDailyFactory()
    {
    }
    public static com.kingdee.eas.custom.dx.baseset.IFoodDaily getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IFoodDaily)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3BA82B8F") ,com.kingdee.eas.custom.dx.baseset.IFoodDaily.class);
    }
    
    public static com.kingdee.eas.custom.dx.baseset.IFoodDaily getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IFoodDaily)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3BA82B8F") ,com.kingdee.eas.custom.dx.baseset.IFoodDaily.class, objectCtx);
    }
    public static com.kingdee.eas.custom.dx.baseset.IFoodDaily getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IFoodDaily)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3BA82B8F"));
    }
    public static com.kingdee.eas.custom.dx.baseset.IFoodDaily getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IFoodDaily)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3BA82B8F"));
    }
}