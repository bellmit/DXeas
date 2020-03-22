package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ParentBreedBatchFactory
{
    private ParentBreedBatchFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IParentBreedBatch getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IParentBreedBatch)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0238F3CA") ,com.kingdee.eas.farm.breed.IParentBreedBatch.class);
    }
    
    public static com.kingdee.eas.farm.breed.IParentBreedBatch getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IParentBreedBatch)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0238F3CA") ,com.kingdee.eas.farm.breed.IParentBreedBatch.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IParentBreedBatch getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IParentBreedBatch)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0238F3CA"));
    }
    public static com.kingdee.eas.farm.breed.IParentBreedBatch getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IParentBreedBatch)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0238F3CA"));
    }
}