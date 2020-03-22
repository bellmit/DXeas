package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class traceFacadeFactory
{
    private traceFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.ItraceFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ItraceFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F01DB07A") ,com.kingdee.eas.custom.foodtrac.ItraceFacade.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.ItraceFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ItraceFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F01DB07A") ,com.kingdee.eas.custom.foodtrac.ItraceFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.ItraceFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ItraceFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F01DB07A"));
    }
    public static com.kingdee.eas.custom.foodtrac.ItraceFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ItraceFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F01DB07A"));
    }
}