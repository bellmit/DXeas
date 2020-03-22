package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StatementsPolicyRecycleEntryFactory
{
    private StatementsPolicyRecycleEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyRecycleEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyRecycleEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6FF69FC6") ,com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyRecycleEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyRecycleEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyRecycleEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6FF69FC6") ,com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyRecycleEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyRecycleEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyRecycleEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6FF69FC6"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyRecycleEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyRecycleEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6FF69FC6"));
    }
}