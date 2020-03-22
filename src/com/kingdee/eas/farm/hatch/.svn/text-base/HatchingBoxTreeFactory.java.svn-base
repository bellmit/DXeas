package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchingBoxTreeFactory
{
    private HatchingBoxTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchingBoxTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchingBoxTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9863EE39") ,com.kingdee.eas.farm.hatch.IHatchingBoxTree.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchingBoxTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchingBoxTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9863EE39") ,com.kingdee.eas.farm.hatch.IHatchingBoxTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchingBoxTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchingBoxTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9863EE39"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchingBoxTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchingBoxTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9863EE39"));
    }
}