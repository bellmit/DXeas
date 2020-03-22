package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeedFettleEntryFactory
{
    private FeedFettleEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IFeedFettleEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IFeedFettleEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6157A502") ,com.kingdee.eas.farm.breed.IFeedFettleEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.IFeedFettleEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IFeedFettleEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6157A502") ,com.kingdee.eas.farm.breed.IFeedFettleEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IFeedFettleEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IFeedFettleEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6157A502"));
    }
    public static com.kingdee.eas.farm.breed.IFeedFettleEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IFeedFettleEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6157A502"));
    }
}