package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BatchBreedApplyBillEntryFactory
{
    private BatchBreedApplyBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AE64423C") ,com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AE64423C") ,com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AE64423C"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AE64423C"));
    }
}