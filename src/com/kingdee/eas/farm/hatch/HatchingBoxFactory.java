package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchingBoxFactory
{
    private HatchingBoxFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchingBox getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchingBox)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("55207BFB") ,com.kingdee.eas.farm.hatch.IHatchingBox.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchingBox getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchingBox)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("55207BFB") ,com.kingdee.eas.farm.hatch.IHatchingBox.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchingBox getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchingBox)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("55207BFB"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchingBox getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchingBox)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("55207BFB"));
    }
}