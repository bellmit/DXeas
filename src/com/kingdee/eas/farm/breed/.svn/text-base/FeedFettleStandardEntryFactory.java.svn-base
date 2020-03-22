package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeedFettleStandardEntryFactory
{
    private FeedFettleStandardEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IFeedFettleStandardEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IFeedFettleStandardEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2980B445") ,com.kingdee.eas.farm.breed.IFeedFettleStandardEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.IFeedFettleStandardEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IFeedFettleStandardEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2980B445") ,com.kingdee.eas.farm.breed.IFeedFettleStandardEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IFeedFettleStandardEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IFeedFettleStandardEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2980B445"));
    }
    public static com.kingdee.eas.farm.breed.IFeedFettleStandardEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IFeedFettleStandardEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2980B445"));
    }
}