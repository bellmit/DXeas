package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ParentBreedBatchEntryFieldDetailEntryFactory
{
    private ParentBreedBatchEntryFieldDetailEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IParentBreedBatchEntryFieldDetailEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IParentBreedBatchEntryFieldDetailEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1B7FB82F") ,com.kingdee.eas.farm.breed.IParentBreedBatchEntryFieldDetailEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.IParentBreedBatchEntryFieldDetailEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IParentBreedBatchEntryFieldDetailEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1B7FB82F") ,com.kingdee.eas.farm.breed.IParentBreedBatchEntryFieldDetailEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IParentBreedBatchEntryFieldDetailEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IParentBreedBatchEntryFieldDetailEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1B7FB82F"));
    }
    public static com.kingdee.eas.farm.breed.IParentBreedBatchEntryFieldDetailEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IParentBreedBatchEntryFieldDetailEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1B7FB82F"));
    }
}