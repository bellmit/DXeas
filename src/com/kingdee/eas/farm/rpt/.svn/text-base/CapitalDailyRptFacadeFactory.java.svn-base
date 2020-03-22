package com.kingdee.eas.farm.rpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CapitalDailyRptFacadeFactory
{
    private CapitalDailyRptFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.rpt.ICapitalDailyRptFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICapitalDailyRptFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D7FC0FC7") ,com.kingdee.eas.farm.rpt.ICapitalDailyRptFacade.class);
    }
    
    public static com.kingdee.eas.farm.rpt.ICapitalDailyRptFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICapitalDailyRptFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D7FC0FC7") ,com.kingdee.eas.farm.rpt.ICapitalDailyRptFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.rpt.ICapitalDailyRptFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICapitalDailyRptFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D7FC0FC7"));
    }
    public static com.kingdee.eas.farm.rpt.ICapitalDailyRptFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.rpt.ICapitalDailyRptFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D7FC0FC7"));
    }
}