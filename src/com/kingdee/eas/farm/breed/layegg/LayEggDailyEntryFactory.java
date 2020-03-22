package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LayEggDailyEntryFactory
{
    private LayEggDailyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8EA4D707") ,com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8EA4D707") ,com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8EA4D707"));
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8EA4D707"));
    }
}