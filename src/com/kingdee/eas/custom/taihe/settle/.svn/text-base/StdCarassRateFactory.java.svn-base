package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StdCarassRateFactory
{
    private StdCarassRateFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.settle.IStdCarassRate getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.IStdCarassRate)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BC1A28CD") ,com.kingdee.eas.custom.taihe.settle.IStdCarassRate.class);
    }
    
    public static com.kingdee.eas.custom.taihe.settle.IStdCarassRate getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.IStdCarassRate)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BC1A28CD") ,com.kingdee.eas.custom.taihe.settle.IStdCarassRate.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.settle.IStdCarassRate getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.IStdCarassRate)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BC1A28CD"));
    }
    public static com.kingdee.eas.custom.taihe.settle.IStdCarassRate getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.IStdCarassRate)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BC1A28CD"));
    }
}