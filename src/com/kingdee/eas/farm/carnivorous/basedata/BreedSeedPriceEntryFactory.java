package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedSeedPriceEntryFactory
{
    private BreedSeedPriceEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPriceEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPriceEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EDDE5FAC") ,com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPriceEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPriceEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPriceEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EDDE5FAC") ,com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPriceEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPriceEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPriceEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EDDE5FAC"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPriceEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPriceEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EDDE5FAC"));
    }
}