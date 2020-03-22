package com.kingdee.eas.farm.rpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCProductPlanDetailRptFacadeFactory
{
    private CCProductPlanDetailRptFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.rpt.ICCProductPlanDetailRptFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCProductPlanDetailRptFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2DE7243F") ,com.kingdee.eas.farm.rpt.ICCProductPlanDetailRptFacade.class);
    }
    
    public static com.kingdee.eas.farm.rpt.ICCProductPlanDetailRptFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCProductPlanDetailRptFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2DE7243F") ,com.kingdee.eas.farm.rpt.ICCProductPlanDetailRptFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.rpt.ICCProductPlanDetailRptFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCProductPlanDetailRptFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2DE7243F"));
    }
    public static com.kingdee.eas.farm.rpt.ICCProductPlanDetailRptFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCProductPlanDetailRptFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2DE7243F"));
    }
}