package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeedFettleFactory
{
    private FeedFettleFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IFeedFettle getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IFeedFettle)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E6EF4550") ,com.kingdee.eas.farm.breed.IFeedFettle.class);
    }
    
    public static com.kingdee.eas.farm.breed.IFeedFettle getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IFeedFettle)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E6EF4550") ,com.kingdee.eas.farm.breed.IFeedFettle.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IFeedFettle getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IFeedFettle)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E6EF4550"));
    }
    public static com.kingdee.eas.farm.breed.IFeedFettle getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IFeedFettle)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E6EF4550"));
    }
}