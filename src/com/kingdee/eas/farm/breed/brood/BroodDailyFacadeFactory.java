package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BroodDailyFacadeFactory
{
    private BroodDailyFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("29FD5053") ,com.kingdee.eas.farm.breed.brood.IBroodDailyFacade.class);
    }
    
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("29FD5053") ,com.kingdee.eas.farm.breed.brood.IBroodDailyFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("29FD5053"));
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("29FD5053"));
    }
}