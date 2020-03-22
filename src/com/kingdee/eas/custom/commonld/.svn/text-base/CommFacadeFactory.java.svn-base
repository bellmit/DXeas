package com.kingdee.eas.custom.commonld;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CommFacadeFactory
{
    private CommFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.commonld.ICommFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.commonld.ICommFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FE85DA86") ,com.kingdee.eas.custom.commonld.ICommFacade.class);
    }
    
    public static com.kingdee.eas.custom.commonld.ICommFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.commonld.ICommFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FE85DA86") ,com.kingdee.eas.custom.commonld.ICommFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.commonld.ICommFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.commonld.ICommFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FE85DA86"));
    }
    public static com.kingdee.eas.custom.commonld.ICommFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.commonld.ICommFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FE85DA86"));
    }
}