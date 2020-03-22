package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LayEggDailyWEEntryFactory
{
    private LayEggDailyWEEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyWEEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyWEEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E86C83B9") ,com.kingdee.eas.farm.breed.layegg.ILayEggDailyWEEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyWEEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyWEEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E86C83B9") ,com.kingdee.eas.farm.breed.layegg.ILayEggDailyWEEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyWEEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyWEEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E86C83B9"));
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyWEEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyWEEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E86C83B9"));
    }
}