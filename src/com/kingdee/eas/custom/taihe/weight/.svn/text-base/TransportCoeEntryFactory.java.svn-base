package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TransportCoeEntryFactory
{
    private TransportCoeEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.weight.ITransportCoeEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ITransportCoeEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5D2CC94C") ,com.kingdee.eas.custom.taihe.weight.ITransportCoeEntry.class);
    }
    
    public static com.kingdee.eas.custom.taihe.weight.ITransportCoeEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ITransportCoeEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5D2CC94C") ,com.kingdee.eas.custom.taihe.weight.ITransportCoeEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.weight.ITransportCoeEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ITransportCoeEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5D2CC94C"));
    }
    public static com.kingdee.eas.custom.taihe.weight.ITransportCoeEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ITransportCoeEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5D2CC94C"));
    }
}