package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmRatingFactory
{
    private FarmRatingFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.IFarmRating getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IFarmRating)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EA7FF91D") ,com.kingdee.eas.custom.wages.farm.IFarmRating.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.IFarmRating getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IFarmRating)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EA7FF91D") ,com.kingdee.eas.custom.wages.farm.IFarmRating.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.IFarmRating getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IFarmRating)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EA7FF91D"));
    }
    public static com.kingdee.eas.custom.wages.farm.IFarmRating getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IFarmRating)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EA7FF91D"));
    }
}