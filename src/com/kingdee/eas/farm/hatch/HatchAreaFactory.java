package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchAreaFactory
{
    private HatchAreaFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchArea getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchArea)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BC16AA9F") ,com.kingdee.eas.farm.hatch.IHatchArea.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchArea getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchArea)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BC16AA9F") ,com.kingdee.eas.farm.hatch.IHatchArea.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchArea getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchArea)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BC16AA9F"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchArea getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchArea)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BC16AA9F"));
    }
}