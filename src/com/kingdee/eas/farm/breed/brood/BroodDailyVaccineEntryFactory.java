package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BroodDailyVaccineEntryFactory
{
    private BroodDailyVaccineEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyVaccineEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyVaccineEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("48E13EB6") ,com.kingdee.eas.farm.breed.brood.IBroodDailyVaccineEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyVaccineEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyVaccineEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("48E13EB6") ,com.kingdee.eas.farm.breed.brood.IBroodDailyVaccineEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyVaccineEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyVaccineEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("48E13EB6"));
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyVaccineEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyVaccineEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("48E13EB6"));
    }
}