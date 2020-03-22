package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CostAllocationEntryDetailFactory
{
    private CostAllocationEntryDetailFactory()
    {
    }
    public static com.kingdee.eas.farm.dayratecost.ICostAllocationEntryDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.ICostAllocationEntryDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("05FA66D1") ,com.kingdee.eas.farm.dayratecost.ICostAllocationEntryDetail.class);
    }
    
    public static com.kingdee.eas.farm.dayratecost.ICostAllocationEntryDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.ICostAllocationEntryDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("05FA66D1") ,com.kingdee.eas.farm.dayratecost.ICostAllocationEntryDetail.class, objectCtx);
    }
    public static com.kingdee.eas.farm.dayratecost.ICostAllocationEntryDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.ICostAllocationEntryDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("05FA66D1"));
    }
    public static com.kingdee.eas.farm.dayratecost.ICostAllocationEntryDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.ICostAllocationEntryDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("05FA66D1"));
    }
}