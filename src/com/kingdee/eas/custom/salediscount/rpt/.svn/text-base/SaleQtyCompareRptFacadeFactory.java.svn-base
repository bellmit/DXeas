package com.kingdee.eas.custom.salediscount.rpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleQtyCompareRptFacadeFactory
{
    private SaleQtyCompareRptFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.rpt.ISaleQtyCompareRptFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.ISaleQtyCompareRptFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0188BD87") ,com.kingdee.eas.custom.salediscount.rpt.ISaleQtyCompareRptFacade.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.rpt.ISaleQtyCompareRptFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.ISaleQtyCompareRptFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0188BD87") ,com.kingdee.eas.custom.salediscount.rpt.ISaleQtyCompareRptFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.rpt.ISaleQtyCompareRptFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.ISaleQtyCompareRptFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0188BD87"));
    }
    public static com.kingdee.eas.custom.salediscount.rpt.ISaleQtyCompareRptFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.ISaleQtyCompareRptFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0188BD87"));
    }
}