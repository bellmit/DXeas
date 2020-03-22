package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeedFactoryTruckPlanFactory
{
    private FeedFactoryTruckPlanFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlan getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlan)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F34F04DE") ,com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlan.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlan getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlan)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F34F04DE") ,com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlan.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlan getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlan)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F34F04DE"));
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlan getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlan)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F34F04DE"));
    }
}