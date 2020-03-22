package com.kingdee.eas.custom.salediscount.rpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleDiscountAnalyzeRptFacadeFactory
{
    private SaleDiscountAnalyzeRptFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.rpt.ISaleDiscountAnalyzeRptFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.ISaleDiscountAnalyzeRptFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7ECE417F") ,com.kingdee.eas.custom.salediscount.rpt.ISaleDiscountAnalyzeRptFacade.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.rpt.ISaleDiscountAnalyzeRptFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.ISaleDiscountAnalyzeRptFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7ECE417F") ,com.kingdee.eas.custom.salediscount.rpt.ISaleDiscountAnalyzeRptFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.rpt.ISaleDiscountAnalyzeRptFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.ISaleDiscountAnalyzeRptFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7ECE417F"));
    }
    public static com.kingdee.eas.custom.salediscount.rpt.ISaleDiscountAnalyzeRptFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.ISaleDiscountAnalyzeRptFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7ECE417F"));
    }
}