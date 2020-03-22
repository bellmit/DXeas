package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OtherStorageBillEntryFactory
{
    private OtherStorageBillEntryFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IOtherStorageBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOtherStorageBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("299EDAA5") ,com.kingdee.eas.weighbridge.IOtherStorageBillEntry.class);
    }
    
    public static com.kingdee.eas.weighbridge.IOtherStorageBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOtherStorageBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("299EDAA5") ,com.kingdee.eas.weighbridge.IOtherStorageBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IOtherStorageBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOtherStorageBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("299EDAA5"));
    }
    public static com.kingdee.eas.weighbridge.IOtherStorageBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOtherStorageBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("299EDAA5"));
    }
}