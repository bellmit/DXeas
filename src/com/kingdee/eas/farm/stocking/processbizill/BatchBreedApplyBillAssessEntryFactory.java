package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BatchBreedApplyBillAssessEntryFactory
{
    private BatchBreedApplyBillAssessEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillAssessEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillAssessEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("36A15DB8") ,com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillAssessEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillAssessEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillAssessEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("36A15DB8") ,com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillAssessEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillAssessEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillAssessEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("36A15DB8"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillAssessEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchBreedApplyBillAssessEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("36A15DB8"));
    }
}