package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleAwardPolicyAwardEntryFactory
{
    private SettleAwardPolicyAwardEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyAwardEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyAwardEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6997D5B6") ,com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyAwardEntry.class);
    }
    
    public static com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyAwardEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyAwardEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6997D5B6") ,com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyAwardEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyAwardEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyAwardEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6997D5B6"));
    }
    public static com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyAwardEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleAwardPolicyAwardEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6997D5B6"));
    }
}