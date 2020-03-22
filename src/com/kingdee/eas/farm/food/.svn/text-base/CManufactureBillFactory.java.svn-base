package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CManufactureBillFactory
{
    private CManufactureBillFactory()
    {
    }
    public static com.kingdee.eas.farm.food.ICManufactureBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICManufactureBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D66B122F") ,com.kingdee.eas.farm.food.ICManufactureBill.class);
    }
    
    public static com.kingdee.eas.farm.food.ICManufactureBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICManufactureBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D66B122F") ,com.kingdee.eas.farm.food.ICManufactureBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.ICManufactureBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICManufactureBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D66B122F"));
    }
    public static com.kingdee.eas.farm.food.ICManufactureBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICManufactureBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D66B122F"));
    }
}