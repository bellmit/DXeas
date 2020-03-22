package com.kingdee.eas.custom.stockprice;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SalesPriceFactory
{
    private SalesPriceFactory()
    {
    }
    public static com.kingdee.eas.custom.stockprice.ISalesPrice getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.ISalesPrice)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AFF94C0D") ,com.kingdee.eas.custom.stockprice.ISalesPrice.class);
    }
    
    public static com.kingdee.eas.custom.stockprice.ISalesPrice getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.ISalesPrice)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AFF94C0D") ,com.kingdee.eas.custom.stockprice.ISalesPrice.class, objectCtx);
    }
    public static com.kingdee.eas.custom.stockprice.ISalesPrice getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.ISalesPrice)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AFF94C0D"));
    }
    public static com.kingdee.eas.custom.stockprice.ISalesPrice getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.ISalesPrice)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AFF94C0D"));
    }
}