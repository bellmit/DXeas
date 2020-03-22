package com.kingdee.eas.custom.salediscount.rpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CustomerProfitRptFacadeFactory
{
    private CustomerProfitRptFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.rpt.ICustomerProfitRptFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.ICustomerProfitRptFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("76044C3B") ,com.kingdee.eas.custom.salediscount.rpt.ICustomerProfitRptFacade.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.rpt.ICustomerProfitRptFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.ICustomerProfitRptFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("76044C3B") ,com.kingdee.eas.custom.salediscount.rpt.ICustomerProfitRptFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.rpt.ICustomerProfitRptFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.ICustomerProfitRptFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("76044C3B"));
    }
    public static com.kingdee.eas.custom.salediscount.rpt.ICustomerProfitRptFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.ICustomerProfitRptFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("76044C3B"));
    }
}