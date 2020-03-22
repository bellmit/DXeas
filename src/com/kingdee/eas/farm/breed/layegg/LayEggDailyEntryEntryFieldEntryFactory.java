package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LayEggDailyEntryEntryFieldEntryFactory
{
    private LayEggDailyEntryEntryFieldEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntryEntryFieldEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntryEntryFieldEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3EF593A3") ,com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntryEntryFieldEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntryEntryFieldEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntryEntryFieldEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3EF593A3") ,com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntryEntryFieldEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntryEntryFieldEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntryEntryFieldEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3EF593A3"));
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntryEntryFieldEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyEntryEntryFieldEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3EF593A3"));
    }
}