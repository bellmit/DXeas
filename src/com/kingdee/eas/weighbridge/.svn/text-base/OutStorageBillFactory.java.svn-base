package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OutStorageBillFactory
{
    private OutStorageBillFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IOutStorageBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOutStorageBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5BA96D8F") ,com.kingdee.eas.weighbridge.IOutStorageBill.class);
    }
    
    public static com.kingdee.eas.weighbridge.IOutStorageBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOutStorageBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5BA96D8F") ,com.kingdee.eas.weighbridge.IOutStorageBill.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IOutStorageBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOutStorageBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5BA96D8F"));
    }
    public static com.kingdee.eas.weighbridge.IOutStorageBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOutStorageBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5BA96D8F"));
    }
}