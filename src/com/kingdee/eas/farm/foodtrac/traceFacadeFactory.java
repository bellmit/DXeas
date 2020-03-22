package com.kingdee.eas.farm.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class traceFacadeFactory
{
    private traceFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.foodtrac.ItraceFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.foodtrac.ItraceFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("10772615") ,com.kingdee.eas.farm.foodtrac.ItraceFacade.class);
    }
    
    public static com.kingdee.eas.farm.foodtrac.ItraceFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.foodtrac.ItraceFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("10772615") ,com.kingdee.eas.farm.foodtrac.ItraceFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.foodtrac.ItraceFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.foodtrac.ItraceFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("10772615"));
    }
    public static com.kingdee.eas.farm.foodtrac.ItraceFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.foodtrac.ItraceFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("10772615"));
    }
}