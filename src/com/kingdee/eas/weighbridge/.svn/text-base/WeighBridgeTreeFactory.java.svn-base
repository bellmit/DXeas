package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WeighBridgeTreeFactory
{
    private WeighBridgeTreeFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IWeighBridgeTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IWeighBridgeTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DEC58428") ,com.kingdee.eas.weighbridge.IWeighBridgeTree.class);
    }
    
    public static com.kingdee.eas.weighbridge.IWeighBridgeTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IWeighBridgeTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DEC58428") ,com.kingdee.eas.weighbridge.IWeighBridgeTree.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IWeighBridgeTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IWeighBridgeTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DEC58428"));
    }
    public static com.kingdee.eas.weighbridge.IWeighBridgeTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IWeighBridgeTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DEC58428"));
    }
}