package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeedTruckFactory
{
    private FeedTruckFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedTruck getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedTruck)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6C0C89BF") ,com.kingdee.eas.farm.feedfactory.IFeedTruck.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.IFeedTruck getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedTruck)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6C0C89BF") ,com.kingdee.eas.farm.feedfactory.IFeedTruck.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedTruck getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedTruck)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6C0C89BF"));
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedTruck getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedTruck)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6C0C89BF"));
    }
}