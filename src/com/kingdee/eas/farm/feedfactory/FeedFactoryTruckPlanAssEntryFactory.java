package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeedFactoryTruckPlanAssEntryFactory
{
    private FeedFactoryTruckPlanAssEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanAssEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanAssEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C539B16F") ,com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanAssEntry.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanAssEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanAssEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C539B16F") ,com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanAssEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanAssEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanAssEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C539B16F"));
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanAssEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryTruckPlanAssEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C539B16F"));
    }
}