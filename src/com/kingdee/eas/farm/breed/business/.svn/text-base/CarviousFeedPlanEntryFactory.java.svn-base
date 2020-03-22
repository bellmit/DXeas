package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarviousFeedPlanEntryFactory
{
    private CarviousFeedPlanEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.business.ICarviousFeedPlanEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICarviousFeedPlanEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2BE8F577") ,com.kingdee.eas.farm.breed.business.ICarviousFeedPlanEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.business.ICarviousFeedPlanEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICarviousFeedPlanEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2BE8F577") ,com.kingdee.eas.farm.breed.business.ICarviousFeedPlanEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.business.ICarviousFeedPlanEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICarviousFeedPlanEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2BE8F577"));
    }
    public static com.kingdee.eas.farm.breed.business.ICarviousFeedPlanEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICarviousFeedPlanEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2BE8F577"));
    }
}