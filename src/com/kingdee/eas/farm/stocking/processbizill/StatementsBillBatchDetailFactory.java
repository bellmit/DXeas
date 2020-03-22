package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StatementsBillBatchDetailFactory
{
    private StatementsBillBatchDetailFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillBatchDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillBatchDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1EC2505B") ,com.kingdee.eas.farm.stocking.processbizill.IStatementsBillBatchDetail.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillBatchDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillBatchDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1EC2505B") ,com.kingdee.eas.farm.stocking.processbizill.IStatementsBillBatchDetail.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillBatchDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillBatchDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1EC2505B"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStatementsBillBatchDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStatementsBillBatchDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1EC2505B"));
    }
}