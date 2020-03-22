package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BatchPlanLayEggEntryFactory
{
    private BatchPlanLayEggEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBatchPlanLayEggEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBatchPlanLayEggEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C24F26BC") ,com.kingdee.eas.farm.hatch.IBatchPlanLayEggEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBatchPlanLayEggEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBatchPlanLayEggEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C24F26BC") ,com.kingdee.eas.farm.hatch.IBatchPlanLayEggEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBatchPlanLayEggEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBatchPlanLayEggEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C24F26BC"));
    }
    public static com.kingdee.eas.farm.hatch.IBatchPlanLayEggEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBatchPlanLayEggEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C24F26BC"));
    }
}