package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarExcuteCircsEntryFactory
{
    private CarExcuteCircsEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.food.ICarExcuteCircsEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICarExcuteCircsEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BA2F48D6") ,com.kingdee.eas.farm.food.ICarExcuteCircsEntry.class);
    }
    
    public static com.kingdee.eas.farm.food.ICarExcuteCircsEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICarExcuteCircsEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BA2F48D6") ,com.kingdee.eas.farm.food.ICarExcuteCircsEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.ICarExcuteCircsEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICarExcuteCircsEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BA2F48D6"));
    }
    public static com.kingdee.eas.farm.food.ICarExcuteCircsEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICarExcuteCircsEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BA2F48D6"));
    }
}