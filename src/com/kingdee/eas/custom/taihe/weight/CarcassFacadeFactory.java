package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarcassFacadeFactory
{
    private CarcassFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarcassFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarcassFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B4B2D9D6") ,com.kingdee.eas.custom.taihe.weight.ICarcassFacade.class);
    }
    
    public static com.kingdee.eas.custom.taihe.weight.ICarcassFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarcassFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B4B2D9D6") ,com.kingdee.eas.custom.taihe.weight.ICarcassFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarcassFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarcassFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B4B2D9D6"));
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarcassFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarcassFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B4B2D9D6"));
    }
}