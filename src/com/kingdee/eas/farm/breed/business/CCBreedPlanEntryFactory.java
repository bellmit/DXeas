package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCBreedPlanEntryFactory
{
    private CCBreedPlanEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.business.ICCBreedPlanEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCBreedPlanEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("630F6763") ,com.kingdee.eas.farm.breed.business.ICCBreedPlanEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.business.ICCBreedPlanEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCBreedPlanEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("630F6763") ,com.kingdee.eas.farm.breed.business.ICCBreedPlanEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.business.ICCBreedPlanEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCBreedPlanEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("630F6763"));
    }
    public static com.kingdee.eas.farm.breed.business.ICCBreedPlanEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCBreedPlanEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("630F6763"));
    }
}