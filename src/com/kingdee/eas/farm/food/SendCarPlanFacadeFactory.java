package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SendCarPlanFacadeFactory
{
    private SendCarPlanFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.food.ISendCarPlanFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISendCarPlanFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("23E13205") ,com.kingdee.eas.farm.food.ISendCarPlanFacade.class);
    }
    
    public static com.kingdee.eas.farm.food.ISendCarPlanFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISendCarPlanFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("23E13205") ,com.kingdee.eas.farm.food.ISendCarPlanFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.ISendCarPlanFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISendCarPlanFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("23E13205"));
    }
    public static com.kingdee.eas.farm.food.ISendCarPlanFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISendCarPlanFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("23E13205"));
    }
}