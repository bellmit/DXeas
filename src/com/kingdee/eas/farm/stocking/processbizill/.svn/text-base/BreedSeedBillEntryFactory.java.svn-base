package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedSeedBillEntryFactory
{
    private BreedSeedBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0676404B") ,com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0676404B") ,com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0676404B"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0676404B"));
    }
}