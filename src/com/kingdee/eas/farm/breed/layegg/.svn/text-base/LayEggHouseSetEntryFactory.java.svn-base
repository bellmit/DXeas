package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LayEggHouseSetEntryFactory
{
    private LayEggHouseSetEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggHouseSetEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggHouseSetEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A97AE882") ,com.kingdee.eas.farm.breed.layegg.ILayEggHouseSetEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.ILayEggHouseSetEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggHouseSetEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A97AE882") ,com.kingdee.eas.farm.breed.layegg.ILayEggHouseSetEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggHouseSetEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggHouseSetEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A97AE882"));
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggHouseSetEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggHouseSetEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A97AE882"));
    }
}