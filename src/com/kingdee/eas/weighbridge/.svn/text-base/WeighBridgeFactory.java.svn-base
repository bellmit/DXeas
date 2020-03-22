package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WeighBridgeFactory
{
    private WeighBridgeFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IWeighBridge getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IWeighBridge)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("71E0616A") ,com.kingdee.eas.weighbridge.IWeighBridge.class);
    }
    
    public static com.kingdee.eas.weighbridge.IWeighBridge getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IWeighBridge)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("71E0616A") ,com.kingdee.eas.weighbridge.IWeighBridge.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IWeighBridge getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IWeighBridge)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("71E0616A"));
    }
    public static com.kingdee.eas.weighbridge.IWeighBridge getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IWeighBridge)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("71E0616A"));
    }
}