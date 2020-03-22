package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeedFactoryBaseDataTreeFactory
{
    private FeedFactoryBaseDataTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseDataTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseDataTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A868A7E3") ,com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseDataTree.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseDataTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseDataTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A868A7E3") ,com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseDataTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseDataTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseDataTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A868A7E3"));
    }
    public static com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseDataTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IFeedFactoryBaseDataTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A868A7E3"));
    }
}