package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CoefficientFactory
{
    private CoefficientFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.ICoefficient getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ICoefficient)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D1EAF82D") ,com.kingdee.eas.custom.wages.ICoefficient.class);
    }
    
    public static com.kingdee.eas.custom.wages.ICoefficient getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ICoefficient)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D1EAF82D") ,com.kingdee.eas.custom.wages.ICoefficient.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.ICoefficient getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ICoefficient)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D1EAF82D"));
    }
    public static com.kingdee.eas.custom.wages.ICoefficient getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ICoefficient)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D1EAF82D"));
    }
}