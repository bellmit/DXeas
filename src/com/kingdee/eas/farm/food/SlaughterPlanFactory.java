package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SlaughterPlanFactory
{
    private SlaughterPlanFactory()
    {
    }
    public static com.kingdee.eas.farm.food.ISlaughterPlan getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISlaughterPlan)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C95AD0D2") ,com.kingdee.eas.farm.food.ISlaughterPlan.class);
    }
    
    public static com.kingdee.eas.farm.food.ISlaughterPlan getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISlaughterPlan)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C95AD0D2") ,com.kingdee.eas.farm.food.ISlaughterPlan.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.ISlaughterPlan getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISlaughterPlan)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C95AD0D2"));
    }
    public static com.kingdee.eas.farm.food.ISlaughterPlan getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISlaughterPlan)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C95AD0D2"));
    }
}