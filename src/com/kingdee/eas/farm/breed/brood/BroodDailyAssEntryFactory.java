package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BroodDailyAssEntryFactory
{
    private BroodDailyAssEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyAssEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyAssEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6A7C9BEA") ,com.kingdee.eas.farm.breed.brood.IBroodDailyAssEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyAssEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyAssEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6A7C9BEA") ,com.kingdee.eas.farm.breed.brood.IBroodDailyAssEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyAssEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyAssEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6A7C9BEA"));
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyAssEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyAssEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6A7C9BEA"));
    }
}