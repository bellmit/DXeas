package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CmChangeEntryFactory
{
    private CmChangeEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.ICmChangeEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ICmChangeEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B1B7ED0E") ,com.kingdee.eas.custom.signwasthetable.ICmChangeEntry.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.ICmChangeEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ICmChangeEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B1B7ED0E") ,com.kingdee.eas.custom.signwasthetable.ICmChangeEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.ICmChangeEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ICmChangeEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B1B7ED0E"));
    }
    public static com.kingdee.eas.custom.signwasthetable.ICmChangeEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ICmChangeEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B1B7ED0E"));
    }
}