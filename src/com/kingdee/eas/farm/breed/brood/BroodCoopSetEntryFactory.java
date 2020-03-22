package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BroodCoopSetEntryFactory
{
    private BroodCoopSetEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodCoopSetEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodCoopSetEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("58873B5D") ,com.kingdee.eas.farm.breed.brood.IBroodCoopSetEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.brood.IBroodCoopSetEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodCoopSetEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("58873B5D") ,com.kingdee.eas.farm.breed.brood.IBroodCoopSetEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodCoopSetEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodCoopSetEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("58873B5D"));
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodCoopSetEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodCoopSetEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("58873B5D"));
    }
}