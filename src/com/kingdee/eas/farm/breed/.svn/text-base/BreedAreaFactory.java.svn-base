package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedAreaFactory
{
    private BreedAreaFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IBreedArea getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedArea)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EF97B007") ,com.kingdee.eas.farm.breed.IBreedArea.class);
    }
    
    public static com.kingdee.eas.farm.breed.IBreedArea getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedArea)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EF97B007") ,com.kingdee.eas.farm.breed.IBreedArea.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IBreedArea getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedArea)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EF97B007"));
    }
    public static com.kingdee.eas.farm.breed.IBreedArea getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedArea)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EF97B007"));
    }
}