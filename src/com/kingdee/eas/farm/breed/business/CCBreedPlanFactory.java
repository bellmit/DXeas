package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCBreedPlanFactory
{
    private CCBreedPlanFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.business.ICCBreedPlan getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCBreedPlan)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("92CDCA4F") ,com.kingdee.eas.farm.breed.business.ICCBreedPlan.class);
    }
    
    public static com.kingdee.eas.farm.breed.business.ICCBreedPlan getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCBreedPlan)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("92CDCA4F") ,com.kingdee.eas.farm.breed.business.ICCBreedPlan.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.business.ICCBreedPlan getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCBreedPlan)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("92CDCA4F"));
    }
    public static com.kingdee.eas.farm.breed.business.ICCBreedPlan getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCBreedPlan)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("92CDCA4F"));
    }
}