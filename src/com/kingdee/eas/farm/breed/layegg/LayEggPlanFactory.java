package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LayEggPlanFactory
{
    private LayEggPlanFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggPlan getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggPlan)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("53C73AD7") ,com.kingdee.eas.farm.breed.layegg.ILayEggPlan.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.ILayEggPlan getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggPlan)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("53C73AD7") ,com.kingdee.eas.farm.breed.layegg.ILayEggPlan.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggPlan getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggPlan)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("53C73AD7"));
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggPlan getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggPlan)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("53C73AD7"));
    }
}