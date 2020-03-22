package com.kingdee.eas.farm.rpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCProductAgeDetailRptFacadeFactory
{
    private CCProductAgeDetailRptFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.rpt.ICCProductAgeDetailRptFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCProductAgeDetailRptFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D2A0C6F7") ,com.kingdee.eas.farm.rpt.ICCProductAgeDetailRptFacade.class);
    }
    
    public static com.kingdee.eas.farm.rpt.ICCProductAgeDetailRptFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCProductAgeDetailRptFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D2A0C6F7") ,com.kingdee.eas.farm.rpt.ICCProductAgeDetailRptFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.rpt.ICCProductAgeDetailRptFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCProductAgeDetailRptFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D2A0C6F7"));
    }
    public static com.kingdee.eas.farm.rpt.ICCProductAgeDetailRptFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICCProductAgeDetailRptFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D2A0C6F7"));
    }
}