package com.kingdee.eas.custom.test;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SdlFactory
{
    private SdlFactory()
    {
    }
    public static com.kingdee.eas.custom.test.ISdl getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.test.ISdl)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8151256A") ,com.kingdee.eas.custom.test.ISdl.class);
    }
    
    public static com.kingdee.eas.custom.test.ISdl getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.test.ISdl)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8151256A") ,com.kingdee.eas.custom.test.ISdl.class, objectCtx);
    }
    public static com.kingdee.eas.custom.test.ISdl getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.test.ISdl)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8151256A"));
    }
    public static com.kingdee.eas.custom.test.ISdl getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.test.ISdl)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8151256A"));
    }
}