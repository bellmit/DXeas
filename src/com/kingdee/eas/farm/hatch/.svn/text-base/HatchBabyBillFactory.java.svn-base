package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchBabyBillFactory
{
    private HatchBabyBillFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchBabyBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBabyBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("065CC30F") ,com.kingdee.eas.farm.hatch.IHatchBabyBill.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchBabyBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBabyBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("065CC30F") ,com.kingdee.eas.farm.hatch.IHatchBabyBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchBabyBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBabyBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("065CC30F"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchBabyBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBabyBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("065CC30F"));
    }
}