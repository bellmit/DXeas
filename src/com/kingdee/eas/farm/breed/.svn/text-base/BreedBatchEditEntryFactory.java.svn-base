package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedBatchEditEntryFactory
{
    private BreedBatchEditEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IBreedBatchEditEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatchEditEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D8F6F968") ,com.kingdee.eas.farm.breed.IBreedBatchEditEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.IBreedBatchEditEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatchEditEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D8F6F968") ,com.kingdee.eas.farm.breed.IBreedBatchEditEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IBreedBatchEditEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatchEditEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D8F6F968"));
    }
    public static com.kingdee.eas.farm.breed.IBreedBatchEditEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatchEditEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D8F6F968"));
    }
}