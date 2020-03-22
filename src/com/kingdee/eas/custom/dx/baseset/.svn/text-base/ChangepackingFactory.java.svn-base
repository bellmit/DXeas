package com.kingdee.eas.custom.dx.baseset;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ChangepackingFactory
{
    private ChangepackingFactory()
    {
    }
    public static com.kingdee.eas.custom.dx.baseset.IChangepacking getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IChangepacking)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("35D43EAD") ,com.kingdee.eas.custom.dx.baseset.IChangepacking.class);
    }
    
    public static com.kingdee.eas.custom.dx.baseset.IChangepacking getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IChangepacking)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("35D43EAD") ,com.kingdee.eas.custom.dx.baseset.IChangepacking.class, objectCtx);
    }
    public static com.kingdee.eas.custom.dx.baseset.IChangepacking getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IChangepacking)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("35D43EAD"));
    }
    public static com.kingdee.eas.custom.dx.baseset.IChangepacking getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IChangepacking)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("35D43EAD"));
    }
}