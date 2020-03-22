package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BusinessBreedFacadeFactory
{
    private BusinessBreedFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.business.IBusinessBreedFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.IBusinessBreedFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3717FD40") ,com.kingdee.eas.farm.breed.business.IBusinessBreedFacade.class);
    }
    
    public static com.kingdee.eas.farm.breed.business.IBusinessBreedFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.IBusinessBreedFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3717FD40") ,com.kingdee.eas.farm.breed.business.IBusinessBreedFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.business.IBusinessBreedFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.IBusinessBreedFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3717FD40"));
    }
    public static com.kingdee.eas.farm.breed.business.IBusinessBreedFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.IBusinessBreedFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3717FD40"));
    }
}