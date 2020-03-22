package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LayEggDailyConveyorFactory
{
    private LayEggDailyConveyorFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyConveyor getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyConveyor)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FBB2E016") ,com.kingdee.eas.farm.breed.layegg.ILayEggDailyConveyor.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyConveyor getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyConveyor)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FBB2E016") ,com.kingdee.eas.farm.breed.layegg.ILayEggDailyConveyor.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyConveyor getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyConveyor)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FBB2E016"));
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggDailyConveyor getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggDailyConveyor)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FBB2E016"));
    }
}