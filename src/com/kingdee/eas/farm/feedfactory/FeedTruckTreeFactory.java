package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeedTruckTreeFactory
{
    private FeedTruckTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedTruckTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedTruckTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1B4B79FD") ,com.kingdee.eas.farm.feedfactory.IFeedTruckTree.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.IFeedTruckTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedTruckTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1B4B79FD") ,com.kingdee.eas.farm.feedfactory.IFeedTruckTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedTruckTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedTruckTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1B4B79FD"));
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedTruckTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedTruckTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1B4B79FD"));
    }
}