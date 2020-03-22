package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SeniorityBonusEntryFactory
{
    private SeniorityBonusEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.ISeniorityBonusEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ISeniorityBonusEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A8735DA9") ,com.kingdee.eas.custom.wages.ISeniorityBonusEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.ISeniorityBonusEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ISeniorityBonusEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A8735DA9") ,com.kingdee.eas.custom.wages.ISeniorityBonusEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.ISeniorityBonusEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ISeniorityBonusEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A8735DA9"));
    }
    public static com.kingdee.eas.custom.wages.ISeniorityBonusEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ISeniorityBonusEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A8735DA9"));
    }
}