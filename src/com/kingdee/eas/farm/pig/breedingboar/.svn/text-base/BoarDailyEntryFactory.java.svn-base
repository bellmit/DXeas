package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BoarDailyEntryFactory
{
    private BoarDailyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("20C93673") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("20C93673") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("20C93673"));
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("20C93673"));
    }
}