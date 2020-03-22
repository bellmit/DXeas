package com.kingdee.eas.custom.stockprice;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SalesPriceEntryFactory
{
    private SalesPriceEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.stockprice.ISalesPriceEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.ISalesPriceEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2E254C65") ,com.kingdee.eas.custom.stockprice.ISalesPriceEntry.class);
    }
    
    public static com.kingdee.eas.custom.stockprice.ISalesPriceEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.ISalesPriceEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2E254C65") ,com.kingdee.eas.custom.stockprice.ISalesPriceEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.stockprice.ISalesPriceEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.ISalesPriceEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2E254C65"));
    }
    public static com.kingdee.eas.custom.stockprice.ISalesPriceEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.ISalesPriceEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2E254C65"));
    }
}