package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeInStorageBillEntryFactory
{
    private FeInStorageBillEntryFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IFeInStorageBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IFeInStorageBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("794C232F") ,com.kingdee.eas.weighbridge.IFeInStorageBillEntry.class);
    }
    
    public static com.kingdee.eas.weighbridge.IFeInStorageBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IFeInStorageBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("794C232F") ,com.kingdee.eas.weighbridge.IFeInStorageBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IFeInStorageBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IFeInStorageBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("794C232F"));
    }
    public static com.kingdee.eas.weighbridge.IFeInStorageBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IFeInStorageBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("794C232F"));
    }
}