package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ForecastOrderFacadeFactory
{
    private ForecastOrderFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.lhsm.IForecastOrderFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IForecastOrderFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C1925C00") ,com.kingdee.eas.custom.lhsm.IForecastOrderFacade.class);
    }
    
    public static com.kingdee.eas.custom.lhsm.IForecastOrderFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IForecastOrderFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C1925C00") ,com.kingdee.eas.custom.lhsm.IForecastOrderFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.lhsm.IForecastOrderFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IForecastOrderFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C1925C00"));
    }
    public static com.kingdee.eas.custom.lhsm.IForecastOrderFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IForecastOrderFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C1925C00"));
    }
}