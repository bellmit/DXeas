package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LayEggPlanEntryFactory
{
    private LayEggPlanEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggPlanEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggPlanEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5C8F0BDB") ,com.kingdee.eas.farm.breed.layegg.ILayEggPlanEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.ILayEggPlanEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggPlanEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5C8F0BDB") ,com.kingdee.eas.farm.breed.layegg.ILayEggPlanEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggPlanEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggPlanEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5C8F0BDB"));
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggPlanEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggPlanEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5C8F0BDB"));
    }
}