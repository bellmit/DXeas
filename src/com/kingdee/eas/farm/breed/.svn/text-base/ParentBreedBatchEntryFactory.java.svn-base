package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ParentBreedBatchEntryFactory
{
    private ParentBreedBatchEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IParentBreedBatchEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IParentBreedBatchEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A719F2C8") ,com.kingdee.eas.farm.breed.IParentBreedBatchEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.IParentBreedBatchEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IParentBreedBatchEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A719F2C8") ,com.kingdee.eas.farm.breed.IParentBreedBatchEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IParentBreedBatchEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IParentBreedBatchEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A719F2C8"));
    }
    public static com.kingdee.eas.farm.breed.IParentBreedBatchEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IParentBreedBatchEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A719F2C8"));
    }
}