package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BroodDailyImmuneEntryFactory
{
    private BroodDailyImmuneEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyImmuneEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyImmuneEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CCD89196") ,com.kingdee.eas.farm.breed.brood.IBroodDailyImmuneEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyImmuneEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyImmuneEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CCD89196") ,com.kingdee.eas.farm.breed.brood.IBroodDailyImmuneEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyImmuneEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyImmuneEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CCD89196"));
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDailyImmuneEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDailyImmuneEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CCD89196"));
    }
}