package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class QualityCheckFacadeFactory
{
    private QualityCheckFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.IQualityCheckFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IQualityCheckFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("051276A5") ,com.kingdee.eas.farm.feedfactory.IQualityCheckFacade.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.IQualityCheckFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IQualityCheckFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("051276A5") ,com.kingdee.eas.farm.feedfactory.IQualityCheckFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.IQualityCheckFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IQualityCheckFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("051276A5"));
    }
    public static com.kingdee.eas.farm.feedfactory.IQualityCheckFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IQualityCheckFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("051276A5"));
    }
}