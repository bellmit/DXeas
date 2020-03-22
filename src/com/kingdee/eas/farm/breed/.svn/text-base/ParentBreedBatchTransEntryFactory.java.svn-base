package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ParentBreedBatchTransEntryFactory
{
    private ParentBreedBatchTransEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IParentBreedBatchTransEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IParentBreedBatchTransEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3C69AA14") ,com.kingdee.eas.farm.breed.IParentBreedBatchTransEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.IParentBreedBatchTransEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IParentBreedBatchTransEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3C69AA14") ,com.kingdee.eas.farm.breed.IParentBreedBatchTransEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IParentBreedBatchTransEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IParentBreedBatchTransEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3C69AA14"));
    }
    public static com.kingdee.eas.farm.breed.IParentBreedBatchTransEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IParentBreedBatchTransEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3C69AA14"));
    }
}