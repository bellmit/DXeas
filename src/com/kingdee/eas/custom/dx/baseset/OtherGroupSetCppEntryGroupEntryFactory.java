package com.kingdee.eas.custom.dx.baseset;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OtherGroupSetCppEntryGroupEntryFactory
{
    private OtherGroupSetCppEntryGroupEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntryGroupEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntryGroupEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("49074D49") ,com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntryGroupEntry.class);
    }
    
    public static com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntryGroupEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntryGroupEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("49074D49") ,com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntryGroupEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntryGroupEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntryGroupEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("49074D49"));
    }
    public static com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntryGroupEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IOtherGroupSetCppEntryGroupEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("49074D49"));
    }
}