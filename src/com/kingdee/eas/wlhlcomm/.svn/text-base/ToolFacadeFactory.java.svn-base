package com.kingdee.eas.wlhlcomm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ToolFacadeFactory
{
    private ToolFacadeFactory()
    {
    }
    public static com.kingdee.eas.wlhlcomm.IToolFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.IToolFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D0C1A963") ,com.kingdee.eas.wlhlcomm.IToolFacade.class);
    }
    
    public static com.kingdee.eas.wlhlcomm.IToolFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.IToolFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D0C1A963") ,com.kingdee.eas.wlhlcomm.IToolFacade.class, objectCtx);
    }
    public static com.kingdee.eas.wlhlcomm.IToolFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.IToolFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D0C1A963"));
    }
    public static com.kingdee.eas.wlhlcomm.IToolFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.IToolFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D0C1A963"));
    }
}