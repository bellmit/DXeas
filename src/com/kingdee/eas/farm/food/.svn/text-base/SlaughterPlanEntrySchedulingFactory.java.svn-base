package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SlaughterPlanEntrySchedulingFactory
{
    private SlaughterPlanEntrySchedulingFactory()
    {
    }
    public static com.kingdee.eas.farm.food.ISlaughterPlanEntryScheduling getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISlaughterPlanEntryScheduling)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1934CC74") ,com.kingdee.eas.farm.food.ISlaughterPlanEntryScheduling.class);
    }
    
    public static com.kingdee.eas.farm.food.ISlaughterPlanEntryScheduling getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISlaughterPlanEntryScheduling)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1934CC74") ,com.kingdee.eas.farm.food.ISlaughterPlanEntryScheduling.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.ISlaughterPlanEntryScheduling getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISlaughterPlanEntryScheduling)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1934CC74"));
    }
    public static com.kingdee.eas.farm.food.ISlaughterPlanEntryScheduling getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISlaughterPlanEntryScheduling)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1934CC74"));
    }
}