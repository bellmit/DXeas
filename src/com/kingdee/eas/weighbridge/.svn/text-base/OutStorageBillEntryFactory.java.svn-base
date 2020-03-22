package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OutStorageBillEntryFactory
{
    private OutStorageBillEntryFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IOutStorageBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOutStorageBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7E37CC23") ,com.kingdee.eas.weighbridge.IOutStorageBillEntry.class);
    }
    
    public static com.kingdee.eas.weighbridge.IOutStorageBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOutStorageBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7E37CC23") ,com.kingdee.eas.weighbridge.IOutStorageBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IOutStorageBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOutStorageBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7E37CC23"));
    }
    public static com.kingdee.eas.weighbridge.IOutStorageBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOutStorageBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7E37CC23"));
    }
}