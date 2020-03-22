package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LayEggFacadeFactory
{
    private LayEggFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6D392CC8") ,com.kingdee.eas.farm.breed.layegg.ILayEggFacade.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.ILayEggFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6D392CC8") ,com.kingdee.eas.farm.breed.layegg.ILayEggFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6D392CC8"));
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6D392CC8"));
    }
}