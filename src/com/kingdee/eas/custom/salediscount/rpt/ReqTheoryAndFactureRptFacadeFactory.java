package com.kingdee.eas.custom.salediscount.rpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ReqTheoryAndFactureRptFacadeFactory
{
    private ReqTheoryAndFactureRptFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.rpt.IReqTheoryAndFactureRptFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IReqTheoryAndFactureRptFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("24515A5B") ,com.kingdee.eas.custom.salediscount.rpt.IReqTheoryAndFactureRptFacade.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.rpt.IReqTheoryAndFactureRptFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IReqTheoryAndFactureRptFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("24515A5B") ,com.kingdee.eas.custom.salediscount.rpt.IReqTheoryAndFactureRptFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.rpt.IReqTheoryAndFactureRptFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IReqTheoryAndFactureRptFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("24515A5B"));
    }
    public static com.kingdee.eas.custom.salediscount.rpt.IReqTheoryAndFactureRptFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IReqTheoryAndFactureRptFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("24515A5B"));
    }
}