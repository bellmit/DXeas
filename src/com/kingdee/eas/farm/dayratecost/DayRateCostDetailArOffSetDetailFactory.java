package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DayRateCostDetailArOffSetDetailFactory
{
    private DayRateCostDetailArOffSetDetailFactory()
    {
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateCostDetailArOffSetDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateCostDetailArOffSetDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3727744A") ,com.kingdee.eas.farm.dayratecost.IDayRateCostDetailArOffSetDetail.class);
    }
    
    public static com.kingdee.eas.farm.dayratecost.IDayRateCostDetailArOffSetDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateCostDetailArOffSetDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3727744A") ,com.kingdee.eas.farm.dayratecost.IDayRateCostDetailArOffSetDetail.class, objectCtx);
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateCostDetailArOffSetDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateCostDetailArOffSetDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3727744A"));
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateCostDetailArOffSetDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateCostDetailArOffSetDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3727744A"));
    }
}