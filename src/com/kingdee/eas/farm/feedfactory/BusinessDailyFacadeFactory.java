package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BusinessDailyFacadeFactory
{
    private BusinessDailyFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.IBusinessDailyFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IBusinessDailyFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("72E04711") ,com.kingdee.eas.farm.feedfactory.IBusinessDailyFacade.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.IBusinessDailyFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IBusinessDailyFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("72E04711") ,com.kingdee.eas.farm.feedfactory.IBusinessDailyFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.IBusinessDailyFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IBusinessDailyFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("72E04711"));
    }
    public static com.kingdee.eas.farm.feedfactory.IBusinessDailyFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IBusinessDailyFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("72E04711"));
    }
}