package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WorkAgeAwardCalculationFactory
{
    private WorkAgeAwardCalculationFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IWorkAgeAwardCalculation getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWorkAgeAwardCalculation)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5D0E3772") ,com.kingdee.eas.custom.wages.IWorkAgeAwardCalculation.class);
    }
    
    public static com.kingdee.eas.custom.wages.IWorkAgeAwardCalculation getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWorkAgeAwardCalculation)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5D0E3772") ,com.kingdee.eas.custom.wages.IWorkAgeAwardCalculation.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IWorkAgeAwardCalculation getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWorkAgeAwardCalculation)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5D0E3772"));
    }
    public static com.kingdee.eas.custom.wages.IWorkAgeAwardCalculation getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWorkAgeAwardCalculation)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5D0E3772"));
    }
}