package com.kingdee.eas.custom.rye;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RyeReadFilesEntryFactory
{
    private RyeReadFilesEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.rye.IRyeReadFilesEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.rye.IRyeReadFilesEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("36861A7A") ,com.kingdee.eas.custom.rye.IRyeReadFilesEntry.class);
    }
    
    public static com.kingdee.eas.custom.rye.IRyeReadFilesEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.rye.IRyeReadFilesEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("36861A7A") ,com.kingdee.eas.custom.rye.IRyeReadFilesEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.rye.IRyeReadFilesEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.rye.IRyeReadFilesEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("36861A7A"));
    }
    public static com.kingdee.eas.custom.rye.IRyeReadFilesEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.rye.IRyeReadFilesEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("36861A7A"));
    }
}