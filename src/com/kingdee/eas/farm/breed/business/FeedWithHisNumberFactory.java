package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeedWithHisNumberFactory
{
    private FeedWithHisNumberFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.business.IFeedWithHisNumber getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.IFeedWithHisNumber)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9B86E0C9") ,com.kingdee.eas.farm.breed.business.IFeedWithHisNumber.class);
    }
    
    public static com.kingdee.eas.farm.breed.business.IFeedWithHisNumber getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.IFeedWithHisNumber)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9B86E0C9") ,com.kingdee.eas.farm.breed.business.IFeedWithHisNumber.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.business.IFeedWithHisNumber getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.IFeedWithHisNumber)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9B86E0C9"));
    }
    public static com.kingdee.eas.farm.breed.business.IFeedWithHisNumber getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.IFeedWithHisNumber)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9B86E0C9"));
    }
}