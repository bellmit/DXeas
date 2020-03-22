package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DayRateCostDetailEntryFactory
{
    private DayRateCostDetailEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("63E8CDFD") ,com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntry.class);
    }
    
    public static com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("63E8CDFD") ,com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("63E8CDFD"));
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("63E8CDFD"));
    }
}