package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggHatchBillFactory
{
    private EggHatchBillFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IEggHatchBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggHatchBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0648D2F0") ,com.kingdee.eas.farm.hatch.IEggHatchBill.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IEggHatchBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggHatchBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0648D2F0") ,com.kingdee.eas.farm.hatch.IEggHatchBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IEggHatchBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggHatchBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0648D2F0"));
    }
    public static com.kingdee.eas.farm.hatch.IEggHatchBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggHatchBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0648D2F0"));
    }
}