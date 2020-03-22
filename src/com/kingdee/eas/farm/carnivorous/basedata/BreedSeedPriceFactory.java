package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedSeedPriceFactory
{
    private BreedSeedPriceFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPrice getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPrice)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("30150866") ,com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPrice.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPrice getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPrice)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("30150866") ,com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPrice.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPrice getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPrice)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("30150866"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPrice getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBreedSeedPrice)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("30150866"));
    }
}