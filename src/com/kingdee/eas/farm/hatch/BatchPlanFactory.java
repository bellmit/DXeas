package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BatchPlanFactory
{
    private BatchPlanFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBatchPlan getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBatchPlan)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4282CB35") ,com.kingdee.eas.farm.hatch.IBatchPlan.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBatchPlan getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBatchPlan)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4282CB35") ,com.kingdee.eas.farm.hatch.IBatchPlan.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBatchPlan getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBatchPlan)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4282CB35"));
    }
    public static com.kingdee.eas.farm.hatch.IBatchPlan getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBatchPlan)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4282CB35"));
    }
}