package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CostAllocationFactory
{
    private CostAllocationFactory()
    {
    }
    public static com.kingdee.eas.farm.dayratecost.ICostAllocation getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.ICostAllocation)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8337DD32") ,com.kingdee.eas.farm.dayratecost.ICostAllocation.class);
    }
    
    public static com.kingdee.eas.farm.dayratecost.ICostAllocation getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.ICostAllocation)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8337DD32") ,com.kingdee.eas.farm.dayratecost.ICostAllocation.class, objectCtx);
    }
    public static com.kingdee.eas.farm.dayratecost.ICostAllocation getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.ICostAllocation)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8337DD32"));
    }
    public static com.kingdee.eas.farm.dayratecost.ICostAllocation getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.ICostAllocation)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8337DD32"));
    }
}