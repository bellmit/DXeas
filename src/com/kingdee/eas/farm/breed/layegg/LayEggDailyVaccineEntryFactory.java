package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LayEggDailyVaccineEntryFactory
{
    private LayEggDailyVaccineEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyVaccineEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyVaccineEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5C339D88") ,com.kingdee.eas.farm.breed.layegg.ILayEggDailyVaccineEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyVaccineEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyVaccineEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5C339D88") ,com.kingdee.eas.farm.breed.layegg.ILayEggDailyVaccineEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyVaccineEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyVaccineEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5C339D88"));
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyVaccineEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyVaccineEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5C339D88"));
    }
}