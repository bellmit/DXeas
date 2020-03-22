package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class IncubatorFactory
{
    private IncubatorFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IIncubator getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IIncubator)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("31F1B473") ,com.kingdee.eas.farm.hatch.IIncubator.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IIncubator getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IIncubator)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("31F1B473") ,com.kingdee.eas.farm.hatch.IIncubator.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IIncubator getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IIncubator)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("31F1B473"));
    }
    public static com.kingdee.eas.farm.hatch.IIncubator getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IIncubator)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("31F1B473"));
    }
}