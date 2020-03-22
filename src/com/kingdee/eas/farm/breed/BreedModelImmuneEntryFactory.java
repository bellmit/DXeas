package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedModelImmuneEntryFactory
{
    private BreedModelImmuneEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IBreedModelImmuneEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModelImmuneEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FA590740") ,com.kingdee.eas.farm.breed.IBreedModelImmuneEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.IBreedModelImmuneEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModelImmuneEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FA590740") ,com.kingdee.eas.farm.breed.IBreedModelImmuneEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IBreedModelImmuneEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModelImmuneEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FA590740"));
    }
    public static com.kingdee.eas.farm.breed.IBreedModelImmuneEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModelImmuneEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FA590740"));
    }
}