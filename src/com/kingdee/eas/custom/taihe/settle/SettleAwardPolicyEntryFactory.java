package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleAwardPolicyEntryFactory
{
    private SettleAwardPolicyEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("138D0231") ,com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyEntry.class);
    }
    
    public static com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("138D0231") ,com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("138D0231"));
    }
    public static com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("138D0231"));
    }
}