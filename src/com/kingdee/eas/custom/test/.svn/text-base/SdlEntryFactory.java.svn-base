package com.kingdee.eas.custom.test;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SdlEntryFactory
{
    private SdlEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.test.ISdlEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.test.ISdlEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("857FC528") ,com.kingdee.eas.custom.test.ISdlEntry.class);
    }
    
    public static com.kingdee.eas.custom.test.ISdlEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.test.ISdlEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("857FC528") ,com.kingdee.eas.custom.test.ISdlEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.test.ISdlEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.test.ISdlEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("857FC528"));
    }
    public static com.kingdee.eas.custom.test.ISdlEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.test.ISdlEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("857FC528"));
    }
}