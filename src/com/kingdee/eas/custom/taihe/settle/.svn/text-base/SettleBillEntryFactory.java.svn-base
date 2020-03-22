package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleBillEntryFactory
{
    private SettleBillEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.settle.ISettleBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F6EE81FD") ,com.kingdee.eas.custom.taihe.settle.ISettleBillEntry.class);
    }
    
    public static com.kingdee.eas.custom.taihe.settle.ISettleBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F6EE81FD") ,com.kingdee.eas.custom.taihe.settle.ISettleBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.settle.ISettleBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F6EE81FD"));
    }
    public static com.kingdee.eas.custom.taihe.settle.ISettleBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F6EE81FD"));
    }
}