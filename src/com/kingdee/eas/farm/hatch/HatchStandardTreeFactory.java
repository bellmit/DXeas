package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchStandardTreeFactory
{
    private HatchStandardTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchStandardTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchStandardTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A04C080D") ,com.kingdee.eas.farm.hatch.IHatchStandardTree.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchStandardTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchStandardTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A04C080D") ,com.kingdee.eas.farm.hatch.IHatchStandardTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchStandardTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchStandardTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A04C080D"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchStandardTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchStandardTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A04C080D"));
    }
}