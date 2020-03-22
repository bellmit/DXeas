package com.kingdee.eas.farm.rpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCTowerFodderDetailPlanRptFacadeFactory
{
    private CCTowerFodderDetailPlanRptFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.rpt.ICCTowerFodderDetailPlanRptFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCTowerFodderDetailPlanRptFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1855BB0F") ,com.kingdee.eas.farm.rpt.ICCTowerFodderDetailPlanRptFacade.class);
    }
    
    public static com.kingdee.eas.farm.rpt.ICCTowerFodderDetailPlanRptFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCTowerFodderDetailPlanRptFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1855BB0F") ,com.kingdee.eas.farm.rpt.ICCTowerFodderDetailPlanRptFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.rpt.ICCTowerFodderDetailPlanRptFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCTowerFodderDetailPlanRptFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1855BB0F"));
    }
    public static com.kingdee.eas.farm.rpt.ICCTowerFodderDetailPlanRptFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCTowerFodderDetailPlanRptFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1855BB0F"));
    }
}