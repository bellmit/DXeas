package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StatementsBillFactory
{
    private StatementsBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("18D671B0") ,com.kingdee.eas.farm.stocking.processbizill.IStatementsBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("18D671B0") ,com.kingdee.eas.farm.stocking.processbizill.IStatementsBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("18D671B0"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("18D671B0"));
    }
}