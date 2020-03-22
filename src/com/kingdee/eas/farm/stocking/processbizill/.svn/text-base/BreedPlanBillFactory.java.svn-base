package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedPlanBillFactory
{
    private BreedPlanBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BDCEA11F") ,com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BDCEA11F") ,com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BDCEA11F"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedPlanBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BDCEA11F"));
    }
}