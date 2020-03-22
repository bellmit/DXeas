package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StatementsBillEntryFactory
{
    private StatementsBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("00DD34A2") ,com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("00DD34A2") ,com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("00DD34A2"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("00DD34A2"));
    }
}