package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchBaseDataTreeFactory
{
    private HatchBaseDataTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchBaseDataTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBaseDataTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0E62A46B") ,com.kingdee.eas.farm.hatch.IHatchBaseDataTree.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchBaseDataTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBaseDataTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0E62A46B") ,com.kingdee.eas.farm.hatch.IHatchBaseDataTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchBaseDataTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBaseDataTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0E62A46B"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchBaseDataTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBaseDataTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0E62A46B"));
    }
}