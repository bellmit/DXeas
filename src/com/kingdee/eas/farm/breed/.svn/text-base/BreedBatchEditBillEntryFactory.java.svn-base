package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedBatchEditBillEntryFactory
{
    private BreedBatchEditBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IBreedBatchEditBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatchEditBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B040E6A1") ,com.kingdee.eas.farm.breed.IBreedBatchEditBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.IBreedBatchEditBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatchEditBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B040E6A1") ,com.kingdee.eas.farm.breed.IBreedBatchEditBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IBreedBatchEditBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatchEditBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B040E6A1"));
    }
    public static com.kingdee.eas.farm.breed.IBreedBatchEditBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatchEditBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B040E6A1"));
    }
}