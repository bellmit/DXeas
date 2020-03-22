package com.kingdee.eas.custom.dx.baseset;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OtherGroupSetCppEntryFactory
{
    private OtherGroupSetCppEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4EFE7376") ,com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntry.class);
    }
    
    public static com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4EFE7376") ,com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4EFE7376"));
    }
    public static com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4EFE7376"));
    }
}