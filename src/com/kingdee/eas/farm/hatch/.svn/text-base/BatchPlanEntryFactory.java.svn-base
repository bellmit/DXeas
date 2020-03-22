package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BatchPlanEntryFactory
{
    private BatchPlanEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBatchPlanEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBatchPlanEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C4F5063D") ,com.kingdee.eas.farm.hatch.IBatchPlanEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBatchPlanEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBatchPlanEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C4F5063D") ,com.kingdee.eas.farm.hatch.IBatchPlanEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBatchPlanEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBatchPlanEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C4F5063D"));
    }
    public static com.kingdee.eas.farm.hatch.IBatchPlanEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBatchPlanEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C4F5063D"));
    }
}