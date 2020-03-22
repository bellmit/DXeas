package com.kingdee.eas.custom.stockprice;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BasePriceOfOtherCompanyFactory
{
    private BasePriceOfOtherCompanyFactory()
    {
    }
    public static com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompany getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompany)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2AA4536C") ,com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompany.class);
    }
    
    public static com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompany getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompany)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2AA4536C") ,com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompany.class, objectCtx);
    }
    public static com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompany getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompany)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2AA4536C"));
    }
    public static com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompany getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompany)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2AA4536C"));
    }
}