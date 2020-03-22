package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeedFactoryTruckPlanEntryFactory
{
    private FeedFactoryTruckPlanEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("18476E34") ,com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanEntry.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("18476E34") ,com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("18476E34"));
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("18476E34"));
    }
}