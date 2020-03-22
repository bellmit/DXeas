package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StatementsBillEggSettleDetailFactory
{
    private StatementsBillEggSettleDetailFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggSettleDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggSettleDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2F795E51") ,com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggSettleDetail.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggSettleDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggSettleDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2F795E51") ,com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggSettleDetail.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggSettleDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggSettleDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2F795E51"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggSettleDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEggSettleDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2F795E51"));
    }
}