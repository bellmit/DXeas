package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class JournalTimesFactory
{
    private JournalTimesFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.IJournalTimes getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IJournalTimes)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1082BD31") ,com.kingdee.eas.farm.feedfactory.IJournalTimes.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.IJournalTimes getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IJournalTimes)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1082BD31") ,com.kingdee.eas.farm.feedfactory.IJournalTimes.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.IJournalTimes getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IJournalTimes)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1082BD31"));
    }
    public static com.kingdee.eas.farm.feedfactory.IJournalTimes getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IJournalTimes)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1082BD31"));
    }
}