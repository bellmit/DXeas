package com.kingdee.eas.custom.rpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaterialApplyFacadeFactory
{
    private MaterialApplyFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.rpt.IMaterialApplyFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.rpt.IMaterialApplyFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E7EA37A4") ,com.kingdee.eas.custom.rpt.IMaterialApplyFacade.class);
    }
    
    public static com.kingdee.eas.custom.rpt.IMaterialApplyFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.rpt.IMaterialApplyFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E7EA37A4") ,com.kingdee.eas.custom.rpt.IMaterialApplyFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.rpt.IMaterialApplyFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.rpt.IMaterialApplyFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E7EA37A4"));
    }
    public static com.kingdee.eas.custom.rpt.IMaterialApplyFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.rpt.IMaterialApplyFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E7EA37A4"));
    }
}