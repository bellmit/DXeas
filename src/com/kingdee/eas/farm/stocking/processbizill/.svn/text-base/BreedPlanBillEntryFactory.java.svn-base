package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedPlanBillEntryFactory
{
    private BreedPlanBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A8145293") ,com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A8145293") ,com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A8145293"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A8145293"));
    }
}