package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedSeedCostFactory
{
    private BreedSeedCostFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCost getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCost)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("33138110") ,com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCost.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCost getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCost)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("33138110") ,com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCost.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCost getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCost)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("33138110"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCost getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedCost)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("33138110"));
    }
}