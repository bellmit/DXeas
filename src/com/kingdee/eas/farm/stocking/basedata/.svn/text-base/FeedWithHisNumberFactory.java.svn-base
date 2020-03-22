package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeedWithHisNumberFactory
{
    private FeedWithHisNumberFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFeedWithHisNumber getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFeedWithHisNumber)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A2239F26") ,com.kingdee.eas.farm.stocking.basedata.IFeedWithHisNumber.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IFeedWithHisNumber getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFeedWithHisNumber)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A2239F26") ,com.kingdee.eas.farm.stocking.basedata.IFeedWithHisNumber.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFeedWithHisNumber getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFeedWithHisNumber)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A2239F26"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFeedWithHisNumber getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFeedWithHisNumber)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A2239F26"));
    }
}