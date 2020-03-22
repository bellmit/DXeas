package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarcassFactory
{
    private CarcassFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarcass getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarcass)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2B05421C") ,com.kingdee.eas.custom.taihe.weight.ICarcass.class);
    }
    
    public static com.kingdee.eas.custom.taihe.weight.ICarcass getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarcass)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2B05421C") ,com.kingdee.eas.custom.taihe.weight.ICarcass.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarcass getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarcass)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2B05421C"));
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarcass getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarcass)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2B05421C"));
    }
}