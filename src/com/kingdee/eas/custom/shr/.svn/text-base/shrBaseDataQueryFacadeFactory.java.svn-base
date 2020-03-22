package com.kingdee.eas.custom.shr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class shrBaseDataQueryFacadeFactory
{
    private shrBaseDataQueryFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.shr.IshrBaseDataQueryFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IshrBaseDataQueryFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("31F946A0") ,com.kingdee.eas.custom.shr.IshrBaseDataQueryFacade.class);
    }
    
    public static com.kingdee.eas.custom.shr.IshrBaseDataQueryFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IshrBaseDataQueryFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("31F946A0") ,com.kingdee.eas.custom.shr.IshrBaseDataQueryFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.shr.IshrBaseDataQueryFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IshrBaseDataQueryFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("31F946A0"));
    }
    public static com.kingdee.eas.custom.shr.IshrBaseDataQueryFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IshrBaseDataQueryFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("31F946A0"));
    }
}