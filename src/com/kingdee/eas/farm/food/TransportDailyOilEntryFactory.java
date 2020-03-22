package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TransportDailyOilEntryFactory
{
    private TransportDailyOilEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.food.ITransportDailyOilEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.ITransportDailyOilEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D4085B7A") ,com.kingdee.eas.farm.food.ITransportDailyOilEntry.class);
    }
    
    public static com.kingdee.eas.farm.food.ITransportDailyOilEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ITransportDailyOilEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D4085B7A") ,com.kingdee.eas.farm.food.ITransportDailyOilEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.ITransportDailyOilEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ITransportDailyOilEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D4085B7A"));
    }
    public static com.kingdee.eas.farm.food.ITransportDailyOilEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ITransportDailyOilEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D4085B7A"));
    }
}