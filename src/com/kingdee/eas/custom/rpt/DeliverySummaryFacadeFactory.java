package com.kingdee.eas.custom.rpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DeliverySummaryFacadeFactory
{
    private DeliverySummaryFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.rpt.IDeliverySummaryFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.rpt.IDeliverySummaryFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6E37412F") ,com.kingdee.eas.custom.rpt.IDeliverySummaryFacade.class);
    }
    
    public static com.kingdee.eas.custom.rpt.IDeliverySummaryFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.rpt.IDeliverySummaryFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6E37412F") ,com.kingdee.eas.custom.rpt.IDeliverySummaryFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.rpt.IDeliverySummaryFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.rpt.IDeliverySummaryFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6E37412F"));
    }
    public static com.kingdee.eas.custom.rpt.IDeliverySummaryFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.rpt.IDeliverySummaryFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6E37412F"));
    }
}