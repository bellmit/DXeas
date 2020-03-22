package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchAssessFactory
{
    private HatchAssessFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.IHatchAssess getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IHatchAssess)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FE2A055A") ,com.kingdee.eas.custom.wages.farm.IHatchAssess.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.IHatchAssess getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IHatchAssess)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FE2A055A") ,com.kingdee.eas.custom.wages.farm.IHatchAssess.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.IHatchAssess getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IHatchAssess)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FE2A055A"));
    }
    public static com.kingdee.eas.custom.wages.farm.IHatchAssess getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IHatchAssess)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FE2A055A"));
    }
}