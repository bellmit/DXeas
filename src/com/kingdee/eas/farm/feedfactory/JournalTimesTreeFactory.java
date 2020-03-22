package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class JournalTimesTreeFactory
{
    private JournalTimesTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.IJournalTimesTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IJournalTimesTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("69B6A46F") ,com.kingdee.eas.farm.feedfactory.IJournalTimesTree.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.IJournalTimesTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IJournalTimesTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("69B6A46F") ,com.kingdee.eas.farm.feedfactory.IJournalTimesTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.IJournalTimesTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IJournalTimesTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("69B6A46F"));
    }
    public static com.kingdee.eas.farm.feedfactory.IJournalTimesTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IJournalTimesTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("69B6A46F"));
    }
}