package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BoarDailyImmuneEntryFactory
{
    private BoarDailyImmuneEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("ED782EF0") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("ED782EF0") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("ED782EF0"));
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("ED782EF0"));
    }
}