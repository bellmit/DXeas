package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BoarDailyDCEntryFactory
{
    private BoarDailyDCEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9276A114") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9276A114") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9276A114"));
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyDCEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9276A114"));
    }
}