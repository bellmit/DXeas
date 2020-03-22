package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TaiHeSettlePolicyFactory
{
    private TaiHeSettlePolicyFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.settle.ITaiHeSettlePolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ITaiHeSettlePolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E6F5C1D3") ,com.kingdee.eas.custom.taihe.settle.ITaiHeSettlePolicy.class);
    }
    
    public static com.kingdee.eas.custom.taihe.settle.ITaiHeSettlePolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ITaiHeSettlePolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E6F5C1D3") ,com.kingdee.eas.custom.taihe.settle.ITaiHeSettlePolicy.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.settle.ITaiHeSettlePolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ITaiHeSettlePolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E6F5C1D3"));
    }
    public static com.kingdee.eas.custom.taihe.settle.ITaiHeSettlePolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ITaiHeSettlePolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E6F5C1D3"));
    }
}