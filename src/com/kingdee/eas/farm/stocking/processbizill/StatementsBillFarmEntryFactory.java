package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StatementsBillFarmEntryFactory
{
    private StatementsBillFarmEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillFarmEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillFarmEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("08E5860C") ,com.kingdee.eas.farm.stocking.processbizill.IStatementsBillFarmEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillFarmEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillFarmEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("08E5860C") ,com.kingdee.eas.farm.stocking.processbizill.IStatementsBillFarmEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillFarmEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillFarmEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("08E5860C"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillFarmEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillFarmEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("08E5860C"));
    }
}