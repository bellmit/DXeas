package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedFacadeFactory
{
    private BreedFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IBreedFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("70039994") ,com.kingdee.eas.farm.breed.IBreedFacade.class);
    }
    
    public static com.kingdee.eas.farm.breed.IBreedFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("70039994") ,com.kingdee.eas.farm.breed.IBreedFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IBreedFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("70039994"));
    }
    public static com.kingdee.eas.farm.breed.IBreedFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("70039994"));
    }
}