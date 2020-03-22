package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StatementsPolicyPriceEntryFactory
{
    private StatementsPolicyPriceEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyPriceEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyPriceEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4EC88090") ,com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyPriceEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyPriceEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyPriceEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4EC88090") ,com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyPriceEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyPriceEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyPriceEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4EC88090"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyPriceEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyPriceEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4EC88090"));
    }
}