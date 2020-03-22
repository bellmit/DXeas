package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedModelTreeFactory
{
    private BreedModelTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IBreedModelTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModelTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2B40E32D") ,com.kingdee.eas.farm.breed.IBreedModelTree.class);
    }
    
    public static com.kingdee.eas.farm.breed.IBreedModelTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModelTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2B40E32D") ,com.kingdee.eas.farm.breed.IBreedModelTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IBreedModelTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModelTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2B40E32D"));
    }
    public static com.kingdee.eas.farm.breed.IBreedModelTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModelTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2B40E32D"));
    }
}