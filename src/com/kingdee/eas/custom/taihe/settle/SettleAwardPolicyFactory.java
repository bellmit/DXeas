package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleAwardPolicyFactory
{
    private SettleAwardPolicyFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("013226C1") ,com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicy.class);
    }
    
    public static com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("013226C1") ,com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicy.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("013226C1"));
    }
    public static com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("013226C1"));
    }
}