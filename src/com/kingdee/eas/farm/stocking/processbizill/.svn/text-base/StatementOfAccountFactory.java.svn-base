package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StatementOfAccountFactory
{
    private StatementOfAccountFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccount getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccount)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6E5153CC") ,com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccount.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccount getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccount)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6E5153CC") ,com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccount.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccount getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccount)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6E5153CC"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccount getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccount)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6E5153CC"));
    }
}