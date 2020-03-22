package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DayRateCostDetailFactory
{
    private DayRateCostDetailFactory()
    {
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateCostDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateCostDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("18C12B75") ,com.kingdee.eas.farm.dayratecost.IDayRateCostDetail.class);
    }
    
    public static com.kingdee.eas.farm.dayratecost.IDayRateCostDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateCostDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("18C12B75") ,com.kingdee.eas.farm.dayratecost.IDayRateCostDetail.class, objectCtx);
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateCostDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateCostDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("18C12B75"));
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateCostDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateCostDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("18C12B75"));
    }
}