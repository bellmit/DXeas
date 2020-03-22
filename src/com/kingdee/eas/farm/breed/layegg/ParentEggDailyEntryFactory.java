package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ParentEggDailyEntryFactory
{
    private ParentEggDailyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.IParentEggDailyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IParentEggDailyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DB066D87") ,com.kingdee.eas.farm.breed.layegg.IParentEggDailyEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.IParentEggDailyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IParentEggDailyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DB066D87") ,com.kingdee.eas.farm.breed.layegg.IParentEggDailyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.IParentEggDailyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IParentEggDailyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DB066D87"));
    }
    public static com.kingdee.eas.farm.breed.layegg.IParentEggDailyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IParentEggDailyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DB066D87"));
    }
}