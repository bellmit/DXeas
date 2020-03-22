package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchBillFactory
{
    private HatchBillFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BC16FE19") ,com.kingdee.eas.farm.hatch.IHatchBill.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BC16FE19") ,com.kingdee.eas.farm.hatch.IHatchBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BC16FE19"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BC16FE19"));
    }
}