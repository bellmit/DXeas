package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedBatchEditBillFactory
{
    private BreedBatchEditBillFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IBreedBatchEditBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatchEditBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("82DD3C51") ,com.kingdee.eas.farm.breed.IBreedBatchEditBill.class);
    }
    
    public static com.kingdee.eas.farm.breed.IBreedBatchEditBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatchEditBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("82DD3C51") ,com.kingdee.eas.farm.breed.IBreedBatchEditBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IBreedBatchEditBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatchEditBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("82DD3C51"));
    }
    public static com.kingdee.eas.farm.breed.IBreedBatchEditBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IBreedBatchEditBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("82DD3C51"));
    }
}