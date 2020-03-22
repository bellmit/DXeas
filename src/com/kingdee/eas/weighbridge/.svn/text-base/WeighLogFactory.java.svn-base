package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WeighLogFactory
{
    private WeighLogFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IWeighLog getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IWeighLog)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BE8A9903") ,com.kingdee.eas.weighbridge.IWeighLog.class);
    }
    
    public static com.kingdee.eas.weighbridge.IWeighLog getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IWeighLog)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BE8A9903") ,com.kingdee.eas.weighbridge.IWeighLog.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IWeighLog getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IWeighLog)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BE8A9903"));
    }
    public static com.kingdee.eas.weighbridge.IWeighLog getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IWeighLog)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BE8A9903"));
    }
}