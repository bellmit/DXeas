package com.kingdee.eas.custom.runkanban;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class KanbanUserAuthorityEntryFactory
{
    private KanbanUserAuthorityEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.runkanban.IKanbanUserAuthorityEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.runkanban.IKanbanUserAuthorityEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("351F8D62") ,com.kingdee.eas.custom.runkanban.IKanbanUserAuthorityEntry.class);
    }
    
    public static com.kingdee.eas.custom.runkanban.IKanbanUserAuthorityEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.runkanban.IKanbanUserAuthorityEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("351F8D62") ,com.kingdee.eas.custom.runkanban.IKanbanUserAuthorityEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.runkanban.IKanbanUserAuthorityEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.runkanban.IKanbanUserAuthorityEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("351F8D62"));
    }
    public static com.kingdee.eas.custom.runkanban.IKanbanUserAuthorityEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.runkanban.IKanbanUserAuthorityEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("351F8D62"));
    }
}