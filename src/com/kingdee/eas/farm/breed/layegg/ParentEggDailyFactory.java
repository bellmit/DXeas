package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ParentEggDailyFactory
{
    private ParentEggDailyFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.IParentEggDaily getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IParentEggDaily)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("020C7DAB") ,com.kingdee.eas.farm.breed.layegg.IParentEggDaily.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.IParentEggDaily getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IParentEggDaily)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("020C7DAB") ,com.kingdee.eas.farm.breed.layegg.IParentEggDaily.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.IParentEggDaily getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IParentEggDaily)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("020C7DAB"));
    }
    public static com.kingdee.eas.farm.breed.layegg.IParentEggDaily getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IParentEggDaily)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("020C7DAB"));
    }
}