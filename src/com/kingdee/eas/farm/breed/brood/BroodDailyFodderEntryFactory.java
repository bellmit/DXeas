package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BroodDailyFodderEntryFactory
{
    private BroodDailyFodderEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyFodderEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyFodderEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("14786483") ,com.kingdee.eas.farm.breed.brood.IBroodDailyFodderEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyFodderEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyFodderEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("14786483") ,com.kingdee.eas.farm.breed.brood.IBroodDailyFodderEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyFodderEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyFodderEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("14786483"));
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyFodderEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyFodderEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("14786483"));
    }
}