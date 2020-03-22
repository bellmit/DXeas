package com.kingdee.eas.custom.taihe.server;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ReturnBillEntryFactory
{
    private ReturnBillEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.server.IReturnBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.server.IReturnBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4B3259B0") ,com.kingdee.eas.custom.taihe.server.IReturnBillEntry.class);
    }
    
    public static com.kingdee.eas.custom.taihe.server.IReturnBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.server.IReturnBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4B3259B0") ,com.kingdee.eas.custom.taihe.server.IReturnBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.server.IReturnBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.server.IReturnBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4B3259B0"));
    }
    public static com.kingdee.eas.custom.taihe.server.IReturnBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.server.IReturnBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4B3259B0"));
    }
}