package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggConveyorFactory
{
    private EggConveyorFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.IEggConveyor getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IEggConveyor)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("453E2B43") ,com.kingdee.eas.farm.breed.layegg.IEggConveyor.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.IEggConveyor getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IEggConveyor)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("453E2B43") ,com.kingdee.eas.farm.breed.layegg.IEggConveyor.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.IEggConveyor getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IEggConveyor)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("453E2B43"));
    }
    public static com.kingdee.eas.farm.breed.layegg.IEggConveyor getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IEggConveyor)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("453E2B43"));
    }
}