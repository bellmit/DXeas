package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedModelEntryFactory
{
    private BreedModelEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IBreedModelEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModelEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3C068AC3") ,com.kingdee.eas.farm.breed.IBreedModelEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.IBreedModelEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModelEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3C068AC3") ,com.kingdee.eas.farm.breed.IBreedModelEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IBreedModelEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModelEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3C068AC3"));
    }
    public static com.kingdee.eas.farm.breed.IBreedModelEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModelEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3C068AC3"));
    }
}