package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BHatchBabyBillFactory
{
    private BHatchBabyBillFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CF8246A9") ,com.kingdee.eas.farm.hatch.IBHatchBabyBill.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CF8246A9") ,com.kingdee.eas.farm.hatch.IBHatchBabyBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CF8246A9"));
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CF8246A9"));
    }
}