package com.kingdee.eas.custom.stockprice;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BasePriceOfOtherCompanyEntryFactory
{
    private BasePriceOfOtherCompanyEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompanyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompanyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3A630866") ,com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompanyEntry.class);
    }
    
    public static com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompanyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompanyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3A630866") ,com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompanyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompanyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompanyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3A630866"));
    }
    public static com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompanyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompanyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3A630866"));
    }
}