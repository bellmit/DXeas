package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchHouseTreeFactory
{
    private HatchHouseTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchHouseTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchHouseTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D1E3C00C") ,com.kingdee.eas.farm.hatch.IHatchHouseTree.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchHouseTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchHouseTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D1E3C00C") ,com.kingdee.eas.farm.hatch.IHatchHouseTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchHouseTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchHouseTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D1E3C00C"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchHouseTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchHouseTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D1E3C00C"));
    }
}