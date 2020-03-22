package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TransportDailyEntryFactory
{
    private TransportDailyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.food.ITransportDailyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.ITransportDailyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("90C054F8") ,com.kingdee.eas.farm.food.ITransportDailyEntry.class);
    }
    
    public static com.kingdee.eas.farm.food.ITransportDailyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ITransportDailyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("90C054F8") ,com.kingdee.eas.farm.food.ITransportDailyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.ITransportDailyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ITransportDailyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("90C054F8"));
    }
    public static com.kingdee.eas.farm.food.ITransportDailyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ITransportDailyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("90C054F8"));
    }
}