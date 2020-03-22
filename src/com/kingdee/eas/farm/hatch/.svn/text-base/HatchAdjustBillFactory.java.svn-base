package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchAdjustBillFactory
{
    private HatchAdjustBillFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchAdjustBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchAdjustBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6A51F4C8") ,com.kingdee.eas.farm.hatch.IHatchAdjustBill.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchAdjustBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchAdjustBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6A51F4C8") ,com.kingdee.eas.farm.hatch.IHatchAdjustBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchAdjustBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchAdjustBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6A51F4C8"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchAdjustBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchAdjustBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6A51F4C8"));
    }
}