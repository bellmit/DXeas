package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedStoorgSetFactory
{
    private BreedStoorgSetFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IBreedStoorgSet getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedStoorgSet)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("03931B52") ,com.kingdee.eas.farm.breed.IBreedStoorgSet.class);
    }
    
    public static com.kingdee.eas.farm.breed.IBreedStoorgSet getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedStoorgSet)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("03931B52") ,com.kingdee.eas.farm.breed.IBreedStoorgSet.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IBreedStoorgSet getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedStoorgSet)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("03931B52"));
    }
    public static com.kingdee.eas.farm.breed.IBreedStoorgSet getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedStoorgSet)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("03931B52"));
    }
}