package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggConveyorTreeFactory
{
    private EggConveyorTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.IEggConveyorTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IEggConveyorTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D808B981") ,com.kingdee.eas.farm.breed.layegg.IEggConveyorTree.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.IEggConveyorTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IEggConveyorTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D808B981") ,com.kingdee.eas.farm.breed.layegg.IEggConveyorTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.IEggConveyorTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IEggConveyorTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D808B981"));
    }
    public static com.kingdee.eas.farm.breed.layegg.IEggConveyorTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IEggConveyorTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D808B981"));
    }
}