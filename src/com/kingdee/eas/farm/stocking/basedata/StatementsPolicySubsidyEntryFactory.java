package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StatementsPolicySubsidyEntryFactory
{
    private StatementsPolicySubsidyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicySubsidyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicySubsidyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("424585AE") ,com.kingdee.eas.farm.stocking.basedata.IStatementsPolicySubsidyEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicySubsidyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicySubsidyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("424585AE") ,com.kingdee.eas.farm.stocking.basedata.IStatementsPolicySubsidyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicySubsidyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicySubsidyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("424585AE"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicySubsidyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicySubsidyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("424585AE"));
    }
}