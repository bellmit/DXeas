package com.kingdee.eas.farm.rpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCProductPlanRptCommonFacadeFactory
{
    private CCProductPlanRptCommonFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.rpt.ICCProductPlanRptCommonFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCProductPlanRptCommonFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("553402DB") ,com.kingdee.eas.farm.rpt.ICCProductPlanRptCommonFacade.class);
    }
    
    public static com.kingdee.eas.farm.rpt.ICCProductPlanRptCommonFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCProductPlanRptCommonFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("553402DB") ,com.kingdee.eas.farm.rpt.ICCProductPlanRptCommonFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.rpt.ICCProductPlanRptCommonFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCProductPlanRptCommonFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("553402DB"));
    }
    public static com.kingdee.eas.farm.rpt.ICCProductPlanRptCommonFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCProductPlanRptCommonFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("553402DB"));
    }
}