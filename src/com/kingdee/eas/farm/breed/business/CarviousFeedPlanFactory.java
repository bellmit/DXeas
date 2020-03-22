package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarviousFeedPlanFactory
{
    private CarviousFeedPlanFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.business.ICarviousFeedPlan getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICarviousFeedPlan)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C6D0BFBB") ,com.kingdee.eas.farm.breed.business.ICarviousFeedPlan.class);
    }
    
    public static com.kingdee.eas.farm.breed.business.ICarviousFeedPlan getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICarviousFeedPlan)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C6D0BFBB") ,com.kingdee.eas.farm.breed.business.ICarviousFeedPlan.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.business.ICarviousFeedPlan getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICarviousFeedPlan)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C6D0BFBB"));
    }
    public static com.kingdee.eas.farm.breed.business.ICarviousFeedPlan getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICarviousFeedPlan)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C6D0BFBB"));
    }
}