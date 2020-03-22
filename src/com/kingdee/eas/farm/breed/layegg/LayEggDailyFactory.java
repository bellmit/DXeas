package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LayEggDailyFactory
{
    private LayEggDailyFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDaily getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDaily)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2472242B") ,com.kingdee.eas.farm.breed.layegg.ILayEggDaily.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDaily getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDaily)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2472242B") ,com.kingdee.eas.farm.breed.layegg.ILayEggDaily.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDaily getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDaily)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2472242B"));
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDaily getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDaily)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2472242B"));
    }
}