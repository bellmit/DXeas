package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LayEggDailyTransHenhouseEntryFactory
{
    private LayEggDailyTransHenhouseEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyTransHenhouseEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyTransHenhouseEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B16790C6") ,com.kingdee.eas.farm.breed.layegg.ILayEggDailyTransHenhouseEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyTransHenhouseEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyTransHenhouseEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B16790C6") ,com.kingdee.eas.farm.breed.layegg.ILayEggDailyTransHenhouseEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyTransHenhouseEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyTransHenhouseEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B16790C6"));
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyTransHenhouseEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyTransHenhouseEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B16790C6"));
    }
}