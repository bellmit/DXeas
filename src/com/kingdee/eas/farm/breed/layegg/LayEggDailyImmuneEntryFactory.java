package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LayEggDailyImmuneEntryFactory
{
    private LayEggDailyImmuneEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyImmuneEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyImmuneEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C5361084") ,com.kingdee.eas.farm.breed.layegg.ILayEggDailyImmuneEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyImmuneEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyImmuneEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C5361084") ,com.kingdee.eas.farm.breed.layegg.ILayEggDailyImmuneEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyImmuneEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyImmuneEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C5361084"));
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyImmuneEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyImmuneEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C5361084"));
    }
}