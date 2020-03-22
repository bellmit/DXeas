package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BroodDailyFactory
{
    private BroodDailyFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDaily getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDaily)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AD159A59") ,com.kingdee.eas.farm.breed.brood.IBroodDaily.class);
    }
    
    public static com.kingdee.eas.farm.breed.brood.IBroodDaily getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDaily)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AD159A59") ,com.kingdee.eas.farm.breed.brood.IBroodDaily.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDaily getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDaily)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AD159A59"));
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodDaily getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodDaily)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AD159A59"));
    }
}