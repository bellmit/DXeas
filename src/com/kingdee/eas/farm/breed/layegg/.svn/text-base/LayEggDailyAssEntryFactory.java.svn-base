package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LayEggDailyAssEntryFactory
{
    private LayEggDailyAssEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyAssEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyAssEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("056333BC") ,com.kingdee.eas.farm.breed.layegg.ILayEggDailyAssEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyAssEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyAssEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("056333BC") ,com.kingdee.eas.farm.breed.layegg.ILayEggDailyAssEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyAssEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyAssEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("056333BC"));
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyAssEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyAssEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("056333BC"));
    }
}