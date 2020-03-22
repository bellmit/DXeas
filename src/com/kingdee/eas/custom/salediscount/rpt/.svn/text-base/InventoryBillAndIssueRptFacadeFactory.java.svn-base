package com.kingdee.eas.custom.salediscount.rpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InventoryBillAndIssueRptFacadeFactory
{
    private InventoryBillAndIssueRptFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.rpt.IInventoryBillAndIssueRptFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IInventoryBillAndIssueRptFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A8ED717E") ,com.kingdee.eas.custom.salediscount.rpt.IInventoryBillAndIssueRptFacade.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.rpt.IInventoryBillAndIssueRptFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IInventoryBillAndIssueRptFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A8ED717E") ,com.kingdee.eas.custom.salediscount.rpt.IInventoryBillAndIssueRptFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.rpt.IInventoryBillAndIssueRptFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IInventoryBillAndIssueRptFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A8ED717E"));
    }
    public static com.kingdee.eas.custom.salediscount.rpt.IInventoryBillAndIssueRptFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IInventoryBillAndIssueRptFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A8ED717E"));
    }
}