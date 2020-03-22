package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DayRateCostDetailEntryDetailFactory
{
    private DayRateCostDetailEntryDetailFactory()
    {
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntryDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntryDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F4B2A0AE") ,com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntryDetail.class);
    }
    
    public static com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntryDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntryDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F4B2A0AE") ,com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntryDetail.class, objectCtx);
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntryDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntryDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F4B2A0AE"));
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntryDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateCostDetailEntryDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F4B2A0AE"));
    }
}