package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BoarDailyEntryFeedDetailEntryFactory
{
    private BoarDailyEntryFeedDetailEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntryFeedDetailEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntryFeedDetailEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DEC7AB30") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntryFeedDetailEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntryFeedDetailEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntryFeedDetailEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DEC7AB30") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntryFeedDetailEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntryFeedDetailEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntryFeedDetailEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DEC7AB30"));
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntryFeedDetailEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEntryFeedDetailEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DEC7AB30"));
    }
}