package com.kingdee.eas.custom.stockprice;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RealTimeInventoryEntryFactory
{
    private RealTimeInventoryEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.stockprice.IRealTimeInventoryEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IRealTimeInventoryEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6EAC3B51") ,com.kingdee.eas.custom.stockprice.IRealTimeInventoryEntry.class);
    }
    
    public static com.kingdee.eas.custom.stockprice.IRealTimeInventoryEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IRealTimeInventoryEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6EAC3B51") ,com.kingdee.eas.custom.stockprice.IRealTimeInventoryEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.stockprice.IRealTimeInventoryEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IRealTimeInventoryEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6EAC3B51"));
    }
    public static com.kingdee.eas.custom.stockprice.IRealTimeInventoryEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IRealTimeInventoryEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6EAC3B51"));
    }
}