package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SlaughterPlanFacadeFactory
{
    private SlaughterPlanFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.food.ISlaughterPlanFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISlaughterPlanFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CFD4080C") ,com.kingdee.eas.farm.food.ISlaughterPlanFacade.class);
    }
    
    public static com.kingdee.eas.farm.food.ISlaughterPlanFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISlaughterPlanFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CFD4080C") ,com.kingdee.eas.farm.food.ISlaughterPlanFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.ISlaughterPlanFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISlaughterPlanFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CFD4080C"));
    }
    public static com.kingdee.eas.farm.food.ISlaughterPlanFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISlaughterPlanFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CFD4080C"));
    }
}