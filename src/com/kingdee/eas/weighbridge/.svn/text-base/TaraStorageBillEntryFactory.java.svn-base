package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TaraStorageBillEntryFactory
{
    private TaraStorageBillEntryFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.ITaraStorageBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ITaraStorageBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("50394647") ,com.kingdee.eas.weighbridge.ITaraStorageBillEntry.class);
    }
    
    public static com.kingdee.eas.weighbridge.ITaraStorageBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ITaraStorageBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("50394647") ,com.kingdee.eas.weighbridge.ITaraStorageBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.ITaraStorageBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ITaraStorageBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("50394647"));
    }
    public static com.kingdee.eas.weighbridge.ITaraStorageBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ITaraStorageBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("50394647"));
    }
}