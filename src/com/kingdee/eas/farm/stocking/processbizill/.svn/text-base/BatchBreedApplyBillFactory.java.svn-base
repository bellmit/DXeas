package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BatchBreedApplyBillFactory
{
    private BatchBreedApplyBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C7EFCBD6") ,com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C7EFCBD6") ,com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C7EFCBD6"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C7EFCBD6"));
    }
}