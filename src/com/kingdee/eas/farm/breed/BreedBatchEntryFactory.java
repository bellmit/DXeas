package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedBatchEntryFactory
{
    private BreedBatchEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IBreedBatchEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatchEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AE939152") ,com.kingdee.eas.farm.breed.IBreedBatchEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.IBreedBatchEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatchEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AE939152") ,com.kingdee.eas.farm.breed.IBreedBatchEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IBreedBatchEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatchEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AE939152"));
    }
    public static com.kingdee.eas.farm.breed.IBreedBatchEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatchEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AE939152"));
    }
}