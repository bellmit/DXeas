package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StatementsBillHandEntryFactory
{
    private StatementsBillHandEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillHandEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillHandEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4E79D973") ,com.kingdee.eas.farm.stocking.processbizill.IStatementsBillHandEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillHandEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillHandEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4E79D973") ,com.kingdee.eas.farm.stocking.processbizill.IStatementsBillHandEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillHandEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillHandEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4E79D973"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillHandEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillHandEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4E79D973"));
    }
}