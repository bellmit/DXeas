package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchBaseDataFactory
{
    private HatchBaseDataFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchBaseData getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBaseData)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("22461B2D") ,com.kingdee.eas.farm.hatch.IHatchBaseData.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchBaseData getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBaseData)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("22461B2D") ,com.kingdee.eas.farm.hatch.IHatchBaseData.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchBaseData getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBaseData)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("22461B2D"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchBaseData getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBaseData)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("22461B2D"));
    }
}