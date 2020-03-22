package com.kingdee.eas.custom.dx.baseset;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PackbasicFactory
{
    private PackbasicFactory()
    {
    }
    public static com.kingdee.eas.custom.dx.baseset.IPackbasic getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IPackbasic)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EAD218E9") ,com.kingdee.eas.custom.dx.baseset.IPackbasic.class);
    }
    
    public static com.kingdee.eas.custom.dx.baseset.IPackbasic getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IPackbasic)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EAD218E9") ,com.kingdee.eas.custom.dx.baseset.IPackbasic.class, objectCtx);
    }
    public static com.kingdee.eas.custom.dx.baseset.IPackbasic getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IPackbasic)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EAD218E9"));
    }
    public static com.kingdee.eas.custom.dx.baseset.IPackbasic getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IPackbasic)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EAD218E9"));
    }
}