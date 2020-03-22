package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedSeedReceiveBillFactory
{
    private BreedSeedReceiveBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("681AB2A9") ,com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("681AB2A9") ,com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("681AB2A9"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("681AB2A9"));
    }
}