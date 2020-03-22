package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchEggReceivingBillFactory
{
    private HatchEggReceivingBillFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchEggReceivingBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchEggReceivingBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("08FC7214") ,com.kingdee.eas.farm.hatch.IHatchEggReceivingBill.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchEggReceivingBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchEggReceivingBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("08FC7214") ,com.kingdee.eas.farm.hatch.IHatchEggReceivingBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchEggReceivingBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchEggReceivingBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("08FC7214"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchEggReceivingBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchEggReceivingBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("08FC7214"));
    }
}