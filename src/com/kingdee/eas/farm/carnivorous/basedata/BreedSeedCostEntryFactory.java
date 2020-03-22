package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedSeedCostEntryFactory
{
    private BreedSeedCostEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCostEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCostEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0142C142") ,com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCostEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCostEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCostEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0142C142") ,com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCostEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCostEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCostEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0142C142"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCostEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCostEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0142C142"));
    }
}