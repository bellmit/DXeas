package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TruckPlanFacadeFactory
{
    private TruckPlanFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.ITruckPlanFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.ITruckPlanFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2795E4C0") ,com.kingdee.eas.farm.feedfactory.ITruckPlanFacade.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.ITruckPlanFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.ITruckPlanFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2795E4C0") ,com.kingdee.eas.farm.feedfactory.ITruckPlanFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.ITruckPlanFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.ITruckPlanFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2795E4C0"));
    }
    public static com.kingdee.eas.farm.feedfactory.ITruckPlanFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.ITruckPlanFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2795E4C0"));
    }
}