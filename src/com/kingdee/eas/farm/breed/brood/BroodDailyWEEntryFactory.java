package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BroodDailyWEEntryFactory
{
    private BroodDailyWEEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyWEEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyWEEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("678E5DCB") ,com.kingdee.eas.farm.breed.brood.IBroodDailyWEEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyWEEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyWEEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("678E5DCB") ,com.kingdee.eas.farm.breed.brood.IBroodDailyWEEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyWEEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyWEEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("678E5DCB"));
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyWEEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyWEEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("678E5DCB"));
    }
}