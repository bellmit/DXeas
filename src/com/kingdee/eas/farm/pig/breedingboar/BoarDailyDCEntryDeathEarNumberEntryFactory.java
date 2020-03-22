package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BoarDailyDCEntryDeathEarNumberEntryFactory
{
    private BoarDailyDCEntryDeathEarNumberEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntryDeathEarNumberEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntryDeathEarNumberEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("90257B53") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntryDeathEarNumberEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntryDeathEarNumberEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntryDeathEarNumberEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("90257B53") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntryDeathEarNumberEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntryDeathEarNumberEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntryDeathEarNumberEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("90257B53"));
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntryDeathEarNumberEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntryDeathEarNumberEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("90257B53"));
    }
}