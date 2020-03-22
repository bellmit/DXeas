package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OtherStorageBillFactory
{
    private OtherStorageBillFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IOtherStorageBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOtherStorageBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("79CFD5CD") ,com.kingdee.eas.weighbridge.IOtherStorageBill.class);
    }
    
    public static com.kingdee.eas.weighbridge.IOtherStorageBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOtherStorageBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("79CFD5CD") ,com.kingdee.eas.weighbridge.IOtherStorageBill.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IOtherStorageBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOtherStorageBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("79CFD5CD"));
    }
    public static com.kingdee.eas.weighbridge.IOtherStorageBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOtherStorageBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("79CFD5CD"));
    }
}