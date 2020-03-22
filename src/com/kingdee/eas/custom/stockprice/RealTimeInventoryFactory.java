package com.kingdee.eas.custom.stockprice;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RealTimeInventoryFactory
{
    private RealTimeInventoryFactory()
    {
    }
    public static com.kingdee.eas.custom.stockprice.IRealTimeInventory getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IRealTimeInventory)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8D7BB9A1") ,com.kingdee.eas.custom.stockprice.IRealTimeInventory.class);
    }
    
    public static com.kingdee.eas.custom.stockprice.IRealTimeInventory getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IRealTimeInventory)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8D7BB9A1") ,com.kingdee.eas.custom.stockprice.IRealTimeInventory.class, objectCtx);
    }
    public static com.kingdee.eas.custom.stockprice.IRealTimeInventory getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IRealTimeInventory)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8D7BB9A1"));
    }
    public static com.kingdee.eas.custom.stockprice.IRealTimeInventory getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IRealTimeInventory)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8D7BB9A1"));
    }
}