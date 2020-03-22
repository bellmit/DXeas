package com.kingdee.eas.custom.runkanban;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class runKanbanFacadeFactory
{
    private runKanbanFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.runkanban.IrunKanbanFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.runkanban.IrunKanbanFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3CF833AB") ,com.kingdee.eas.custom.runkanban.IrunKanbanFacade.class);
    }
    
    public static com.kingdee.eas.custom.runkanban.IrunKanbanFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.runkanban.IrunKanbanFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3CF833AB") ,com.kingdee.eas.custom.runkanban.IrunKanbanFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.runkanban.IrunKanbanFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.runkanban.IrunKanbanFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3CF833AB"));
    }
    public static com.kingdee.eas.custom.runkanban.IrunKanbanFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.runkanban.IrunKanbanFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3CF833AB"));
    }
}