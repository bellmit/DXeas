package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StatementsBillRewardsEntryFactory
{
    private StatementsBillRewardsEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillRewardsEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillRewardsEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FD6F157E") ,com.kingdee.eas.farm.stocking.processbizill.IStatementsBillRewardsEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillRewardsEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillRewardsEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FD6F157E") ,com.kingdee.eas.farm.stocking.processbizill.IStatementsBillRewardsEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillRewardsEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillRewardsEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FD6F157E"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillRewardsEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillRewardsEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FD6F157E"));
    }
}