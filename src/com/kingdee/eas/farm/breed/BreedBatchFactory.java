package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedBatchFactory
{
    private BreedBatchFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IBreedBatch getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatch)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0364E700") ,com.kingdee.eas.farm.breed.IBreedBatch.class);
    }
    
    public static com.kingdee.eas.farm.breed.IBreedBatch getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatch)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0364E700") ,com.kingdee.eas.farm.breed.IBreedBatch.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IBreedBatch getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatch)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0364E700"));
    }
    public static com.kingdee.eas.farm.breed.IBreedBatch getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatch)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0364E700"));
    }
}