package com.kingdee.eas.farm.rpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCProductPlanRptFacadeFactory
{
    private CCProductPlanRptFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.rpt.ICCProductPlanRptFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCProductPlanRptFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6E1B5990") ,com.kingdee.eas.farm.rpt.ICCProductPlanRptFacade.class);
    }
    
    public static com.kingdee.eas.farm.rpt.ICCProductPlanRptFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCProductPlanRptFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6E1B5990") ,com.kingdee.eas.farm.rpt.ICCProductPlanRptFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.rpt.ICCProductPlanRptFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCProductPlanRptFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6E1B5990"));
    }
    public static com.kingdee.eas.farm.rpt.ICCProductPlanRptFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCProductPlanRptFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6E1B5990"));
    }
}