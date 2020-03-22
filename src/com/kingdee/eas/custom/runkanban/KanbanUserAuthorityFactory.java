package com.kingdee.eas.custom.runkanban;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class KanbanUserAuthorityFactory
{
    private KanbanUserAuthorityFactory()
    {
    }
    public static com.kingdee.eas.custom.runkanban.IKanbanUserAuthority getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.runkanban.IKanbanUserAuthority)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("552FA0F0") ,com.kingdee.eas.custom.runkanban.IKanbanUserAuthority.class);
    }
    
    public static com.kingdee.eas.custom.runkanban.IKanbanUserAuthority getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.runkanban.IKanbanUserAuthority)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("552FA0F0") ,com.kingdee.eas.custom.runkanban.IKanbanUserAuthority.class, objectCtx);
    }
    public static com.kingdee.eas.custom.runkanban.IKanbanUserAuthority getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.runkanban.IKanbanUserAuthority)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("552FA0F0"));
    }
    public static com.kingdee.eas.custom.runkanban.IKanbanUserAuthority getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.runkanban.IKanbanUserAuthority)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("552FA0F0"));
    }
}