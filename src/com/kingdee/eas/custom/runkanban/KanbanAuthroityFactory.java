package com.kingdee.eas.custom.runkanban;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class KanbanAuthroityFactory
{
    private KanbanAuthroityFactory()
    {
    }
    public static com.kingdee.eas.custom.runkanban.IKanbanAuthroity getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.runkanban.IKanbanAuthroity)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("11519DE1") ,com.kingdee.eas.custom.runkanban.IKanbanAuthroity.class);
    }
    
    public static com.kingdee.eas.custom.runkanban.IKanbanAuthroity getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.runkanban.IKanbanAuthroity)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("11519DE1") ,com.kingdee.eas.custom.runkanban.IKanbanAuthroity.class, objectCtx);
    }
    public static com.kingdee.eas.custom.runkanban.IKanbanAuthroity getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.runkanban.IKanbanAuthroity)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("11519DE1"));
    }
    public static com.kingdee.eas.custom.runkanban.IKanbanAuthroity getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.runkanban.IKanbanAuthroity)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("11519DE1"));
    }
}