package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DayRateInitBillFactory
{
    private DayRateInitBillFactory()
    {
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateInitBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateInitBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8E080BEE") ,com.kingdee.eas.farm.dayratecost.IDayRateInitBill.class);
    }
    
    public static com.kingdee.eas.farm.dayratecost.IDayRateInitBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateInitBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8E080BEE") ,com.kingdee.eas.farm.dayratecost.IDayRateInitBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateInitBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateInitBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8E080BEE"));
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateInitBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateInitBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8E080BEE"));
    }
}