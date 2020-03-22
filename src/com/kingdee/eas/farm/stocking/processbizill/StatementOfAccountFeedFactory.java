package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StatementOfAccountFeedFactory
{
    private StatementOfAccountFeedFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccountFeed getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccountFeed)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7ACBE78A") ,com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccountFeed.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccountFeed getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccountFeed)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7ACBE78A") ,com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccountFeed.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccountFeed getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccountFeed)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7ACBE78A"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccountFeed getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccountFeed)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7ACBE78A"));
    }
}