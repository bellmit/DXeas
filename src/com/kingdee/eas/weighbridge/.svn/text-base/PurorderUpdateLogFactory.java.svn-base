package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PurorderUpdateLogFactory
{
    private PurorderUpdateLogFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IPurorderUpdateLog getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IPurorderUpdateLog)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("958DC3DF") ,com.kingdee.eas.weighbridge.IPurorderUpdateLog.class);
    }
    
    public static com.kingdee.eas.weighbridge.IPurorderUpdateLog getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IPurorderUpdateLog)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("958DC3DF") ,com.kingdee.eas.weighbridge.IPurorderUpdateLog.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IPurorderUpdateLog getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IPurorderUpdateLog)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("958DC3DF"));
    }
    public static com.kingdee.eas.weighbridge.IPurorderUpdateLog getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IPurorderUpdateLog)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("958DC3DF"));
    }
}