package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CManufactureBillEntryFactory
{
    private CManufactureBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.food.ICManufactureBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICManufactureBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7FE40B83") ,com.kingdee.eas.farm.food.ICManufactureBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.food.ICManufactureBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICManufactureBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7FE40B83") ,com.kingdee.eas.farm.food.ICManufactureBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.ICManufactureBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICManufactureBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7FE40B83"));
    }
    public static com.kingdee.eas.farm.food.ICManufactureBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICManufactureBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7FE40B83"));
    }
}