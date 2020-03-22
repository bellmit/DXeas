package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BroodDailyFuelEntryFactory
{
    private BroodDailyFuelEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyFuelEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyFuelEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F5E0B203") ,com.kingdee.eas.farm.breed.brood.IBroodDailyFuelEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyFuelEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyFuelEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F5E0B203") ,com.kingdee.eas.farm.breed.brood.IBroodDailyFuelEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyFuelEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyFuelEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F5E0B203"));
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyFuelEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyFuelEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F5E0B203"));
    }
}