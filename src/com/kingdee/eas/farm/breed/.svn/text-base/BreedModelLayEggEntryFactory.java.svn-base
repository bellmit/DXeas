package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedModelLayEggEntryFactory
{
    private BreedModelLayEggEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IBreedModelLayEggEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModelLayEggEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4FB0AEC2") ,com.kingdee.eas.farm.breed.IBreedModelLayEggEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.IBreedModelLayEggEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModelLayEggEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4FB0AEC2") ,com.kingdee.eas.farm.breed.IBreedModelLayEggEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IBreedModelLayEggEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModelLayEggEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4FB0AEC2"));
    }
    public static com.kingdee.eas.farm.breed.IBreedModelLayEggEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedModelLayEggEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4FB0AEC2"));
    }
}