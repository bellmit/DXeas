package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class IncubatorTreeFactory
{
    private IncubatorTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IIncubatorTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IIncubatorTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C0742AB1") ,com.kingdee.eas.farm.hatch.IIncubatorTree.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IIncubatorTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IIncubatorTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C0742AB1") ,com.kingdee.eas.farm.hatch.IIncubatorTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IIncubatorTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IIncubatorTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C0742AB1"));
    }
    public static com.kingdee.eas.farm.hatch.IIncubatorTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IIncubatorTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C0742AB1"));
    }
}