package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class hatchFacadeFactory
{
    private hatchFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IhatchFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IhatchFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B544A64C") ,com.kingdee.eas.farm.hatch.IhatchFacade.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IhatchFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IhatchFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B544A64C") ,com.kingdee.eas.farm.hatch.IhatchFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IhatchFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IhatchFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B544A64C"));
    }
    public static com.kingdee.eas.farm.hatch.IhatchFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IhatchFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B544A64C"));
    }
}