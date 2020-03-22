package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InStorageBillFactory
{
    private InStorageBillFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IInStorageBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IInStorageBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("52D6BAC2") ,com.kingdee.eas.weighbridge.IInStorageBill.class);
    }
    
    public static com.kingdee.eas.weighbridge.IInStorageBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IInStorageBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("52D6BAC2") ,com.kingdee.eas.weighbridge.IInStorageBill.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IInStorageBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IInStorageBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("52D6BAC2"));
    }
    public static com.kingdee.eas.weighbridge.IInStorageBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IInStorageBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("52D6BAC2"));
    }
}