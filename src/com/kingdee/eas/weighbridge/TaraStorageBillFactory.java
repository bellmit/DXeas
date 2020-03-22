package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TaraStorageBillFactory
{
    private TaraStorageBillFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.ITaraStorageBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ITaraStorageBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("49252CEB") ,com.kingdee.eas.weighbridge.ITaraStorageBill.class);
    }
    
    public static com.kingdee.eas.weighbridge.ITaraStorageBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ITaraStorageBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("49252CEB") ,com.kingdee.eas.weighbridge.ITaraStorageBill.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.ITaraStorageBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ITaraStorageBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("49252CEB"));
    }
    public static com.kingdee.eas.weighbridge.ITaraStorageBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ITaraStorageBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("49252CEB"));
    }
}