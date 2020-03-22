package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeInStorageBillFactory
{
    private FeInStorageBillFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IFeInStorageBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IFeInStorageBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("17A5DF03") ,com.kingdee.eas.weighbridge.IFeInStorageBill.class);
    }
    
    public static com.kingdee.eas.weighbridge.IFeInStorageBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IFeInStorageBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("17A5DF03") ,com.kingdee.eas.weighbridge.IFeInStorageBill.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IFeInStorageBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IFeInStorageBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("17A5DF03"));
    }
    public static com.kingdee.eas.weighbridge.IFeInStorageBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IFeInStorageBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("17A5DF03"));
    }
}