package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DayRateInitBillEntryFactory
{
    private DayRateInitBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateInitBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateInitBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("56685124") ,com.kingdee.eas.farm.dayratecost.IDayRateInitBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.dayratecost.IDayRateInitBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateInitBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("56685124") ,com.kingdee.eas.farm.dayratecost.IDayRateInitBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateInitBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateInitBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("56685124"));
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateInitBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateInitBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("56685124"));
    }
}