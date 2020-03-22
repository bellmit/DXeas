package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeedBusinessDailyFactory
{
    private FeedBusinessDailyFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedBusinessDaily getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedBusinessDaily)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0489F399") ,com.kingdee.eas.farm.feedfactory.IFeedBusinessDaily.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.IFeedBusinessDaily getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedBusinessDaily)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0489F399") ,com.kingdee.eas.farm.feedfactory.IFeedBusinessDaily.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedBusinessDaily getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedBusinessDaily)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0489F399"));
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedBusinessDaily getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedBusinessDaily)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0489F399"));
    }
}