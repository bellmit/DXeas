package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedSeedReceiveBillEntryFactory
{
    private BreedSeedReceiveBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7B27A749") ,com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7B27A749") ,com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7B27A749"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7B27A749"));
    }
}