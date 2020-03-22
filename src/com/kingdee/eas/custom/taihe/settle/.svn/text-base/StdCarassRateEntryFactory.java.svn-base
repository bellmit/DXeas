package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StdCarassRateEntryFactory
{
    private StdCarassRateEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.settle.IStdCarassRateEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.IStdCarassRateEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("67D067A5") ,com.kingdee.eas.custom.taihe.settle.IStdCarassRateEntry.class);
    }
    
    public static com.kingdee.eas.custom.taihe.settle.IStdCarassRateEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.IStdCarassRateEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("67D067A5") ,com.kingdee.eas.custom.taihe.settle.IStdCarassRateEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.settle.IStdCarassRateEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.IStdCarassRateEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("67D067A5"));
    }
    public static com.kingdee.eas.custom.taihe.settle.IStdCarassRateEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.IStdCarassRateEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("67D067A5"));
    }
}