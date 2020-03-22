package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EarlyEggStockFactory
{
    private EarlyEggStockFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IEarlyEggStock getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEarlyEggStock)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FBBB1B46") ,com.kingdee.eas.farm.hatch.IEarlyEggStock.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IEarlyEggStock getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEarlyEggStock)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FBBB1B46") ,com.kingdee.eas.farm.hatch.IEarlyEggStock.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IEarlyEggStock getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEarlyEggStock)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FBBB1B46"));
    }
    public static com.kingdee.eas.farm.hatch.IEarlyEggStock getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEarlyEggStock)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FBBB1B46"));
    }
}