package com.kingdee.eas.custom.salediscount.rpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProductSaleDayRptFacadeFactory
{
    private ProductSaleDayRptFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.rpt.IProductSaleDayRptFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IProductSaleDayRptFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FBFEFE97") ,com.kingdee.eas.custom.salediscount.rpt.IProductSaleDayRptFacade.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.rpt.IProductSaleDayRptFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IProductSaleDayRptFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FBFEFE97") ,com.kingdee.eas.custom.salediscount.rpt.IProductSaleDayRptFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.rpt.IProductSaleDayRptFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IProductSaleDayRptFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FBFEFE97"));
    }
    public static com.kingdee.eas.custom.salediscount.rpt.IProductSaleDayRptFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IProductSaleDayRptFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FBFEFE97"));
    }
}