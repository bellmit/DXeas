package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CostAllocationEntryFactory
{
    private CostAllocationEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.dayratecost.ICostAllocationEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.ICostAllocationEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5F7CAA60") ,com.kingdee.eas.farm.dayratecost.ICostAllocationEntry.class);
    }
    
    public static com.kingdee.eas.farm.dayratecost.ICostAllocationEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.ICostAllocationEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5F7CAA60") ,com.kingdee.eas.farm.dayratecost.ICostAllocationEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.dayratecost.ICostAllocationEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.ICostAllocationEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5F7CAA60"));
    }
    public static com.kingdee.eas.farm.dayratecost.ICostAllocationEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.ICostAllocationEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5F7CAA60"));
    }
}