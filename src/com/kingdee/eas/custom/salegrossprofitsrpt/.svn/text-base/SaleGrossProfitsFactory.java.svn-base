package com.kingdee.eas.custom.salegrossprofitsrpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleGrossProfitsFactory
{
    private SaleGrossProfitsFactory()
    {
    }
    public static com.kingdee.eas.custom.salegrossprofitsrpt.ISaleGrossProfits getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salegrossprofitsrpt.ISaleGrossProfits)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8A092EA1") ,com.kingdee.eas.custom.salegrossprofitsrpt.ISaleGrossProfits.class);
    }
    
    public static com.kingdee.eas.custom.salegrossprofitsrpt.ISaleGrossProfits getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salegrossprofitsrpt.ISaleGrossProfits)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8A092EA1") ,com.kingdee.eas.custom.salegrossprofitsrpt.ISaleGrossProfits.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salegrossprofitsrpt.ISaleGrossProfits getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salegrossprofitsrpt.ISaleGrossProfits)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8A092EA1"));
    }
    public static com.kingdee.eas.custom.salegrossprofitsrpt.ISaleGrossProfits getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salegrossprofitsrpt.ISaleGrossProfits)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8A092EA1"));
    }
}