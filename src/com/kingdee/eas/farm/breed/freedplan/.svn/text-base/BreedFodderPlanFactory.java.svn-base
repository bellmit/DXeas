package com.kingdee.eas.farm.breed.freedplan;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedFodderPlanFactory
{
    private BreedFodderPlanFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlan getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlan)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6CE20F2C") ,com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlan.class);
    }
    
    public static com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlan getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlan)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6CE20F2C") ,com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlan.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlan getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlan)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6CE20F2C"));
    }
    public static com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlan getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlan)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6CE20F2C"));
    }
}