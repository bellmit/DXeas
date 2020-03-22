package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeedFactoryBaseDataFactory
{
    private FeedFactoryBaseDataFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseData getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseData)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E9089AA5") ,com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseData.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseData getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseData)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E9089AA5") ,com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseData.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseData getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseData)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E9089AA5"));
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseData getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseData)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E9089AA5"));
    }
}