package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StatementsBillEggEntryFactory
{
    private StatementsBillEggEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("02F7F13D") ,com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("02F7F13D") ,com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("02F7F13D"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("02F7F13D"));
    }
}