package com.kingdee.eas.custom.stockprice;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class saveRealTimeInventoryFacadeFactory
{
    private saveRealTimeInventoryFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.stockprice.IsaveRealTimeInventoryFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IsaveRealTimeInventoryFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D0D4637E") ,com.kingdee.eas.custom.stockprice.IsaveRealTimeInventoryFacade.class);
    }
    
    public static com.kingdee.eas.custom.stockprice.IsaveRealTimeInventoryFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IsaveRealTimeInventoryFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D0D4637E") ,com.kingdee.eas.custom.stockprice.IsaveRealTimeInventoryFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.stockprice.IsaveRealTimeInventoryFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IsaveRealTimeInventoryFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D0D4637E"));
    }
    public static com.kingdee.eas.custom.stockprice.IsaveRealTimeInventoryFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IsaveRealTimeInventoryFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D0D4637E"));
    }
}