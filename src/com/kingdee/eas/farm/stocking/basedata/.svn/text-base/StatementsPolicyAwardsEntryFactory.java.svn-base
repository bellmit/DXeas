package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StatementsPolicyAwardsEntryFactory
{
    private StatementsPolicyAwardsEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyAwardsEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyAwardsEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("21B2B155") ,com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyAwardsEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyAwardsEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyAwardsEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("21B2B155") ,com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyAwardsEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyAwardsEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyAwardsEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("21B2B155"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyAwardsEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyAwardsEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("21B2B155"));
    }
}