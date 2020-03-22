package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedModelFactory
{
    private BreedModelFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IBreedModel getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModel)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("04060AEF") ,com.kingdee.eas.farm.breed.IBreedModel.class);
    }
    
    public static com.kingdee.eas.farm.breed.IBreedModel getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModel)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("04060AEF") ,com.kingdee.eas.farm.breed.IBreedModel.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IBreedModel getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModel)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("04060AEF"));
    }
    public static com.kingdee.eas.farm.breed.IBreedModel getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModel)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("04060AEF"));
    }
}