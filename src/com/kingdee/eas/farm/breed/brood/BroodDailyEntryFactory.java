package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BroodDailyEntryFactory
{
    private BroodDailyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9E3A0D99") ,com.kingdee.eas.farm.breed.brood.IBroodDailyEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9E3A0D99") ,com.kingdee.eas.farm.breed.brood.IBroodDailyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9E3A0D99"));
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9E3A0D99"));
    }
}