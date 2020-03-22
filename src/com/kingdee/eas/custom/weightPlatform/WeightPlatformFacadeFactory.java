package com.kingdee.eas.custom.weightPlatform;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WeightPlatformFacadeFactory
{
    private WeightPlatformFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.weightPlatform.IWeightPlatformFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.weightPlatform.IWeightPlatformFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("16C6C7DD") ,com.kingdee.eas.custom.weightPlatform.IWeightPlatformFacade.class);
    }
    
    public static com.kingdee.eas.custom.weightPlatform.IWeightPlatformFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.weightPlatform.IWeightPlatformFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("16C6C7DD") ,com.kingdee.eas.custom.weightPlatform.IWeightPlatformFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.weightPlatform.IWeightPlatformFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.weightPlatform.IWeightPlatformFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("16C6C7DD"));
    }
    public static com.kingdee.eas.custom.weightPlatform.IWeightPlatformFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.weightPlatform.IWeightPlatformFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("16C6C7DD"));
    }
}