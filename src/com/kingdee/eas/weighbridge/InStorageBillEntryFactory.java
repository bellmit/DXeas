package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InStorageBillEntryFactory
{
    private InStorageBillEntryFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IInStorageBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IInStorageBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B759C6D0") ,com.kingdee.eas.weighbridge.IInStorageBillEntry.class);
    }
    
    public static com.kingdee.eas.weighbridge.IInStorageBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IInStorageBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B759C6D0") ,com.kingdee.eas.weighbridge.IInStorageBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IInStorageBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IInStorageBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B759C6D0"));
    }
    public static com.kingdee.eas.weighbridge.IInStorageBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IInStorageBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B759C6D0"));
    }
}