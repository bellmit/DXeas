package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TransportCoeFactory
{
    private TransportCoeFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.weight.ITransportCoe getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ITransportCoe)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FA931AC6") ,com.kingdee.eas.custom.taihe.weight.ITransportCoe.class);
    }
    
    public static com.kingdee.eas.custom.taihe.weight.ITransportCoe getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ITransportCoe)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FA931AC6") ,com.kingdee.eas.custom.taihe.weight.ITransportCoe.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.weight.ITransportCoe getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ITransportCoe)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FA931AC6"));
    }
    public static com.kingdee.eas.custom.taihe.weight.ITransportCoe getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ITransportCoe)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FA931AC6"));
    }
}