package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BEggHatchBillFactory
{
    private BEggHatchBillFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBEggHatchBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D2F77416") ,com.kingdee.eas.farm.hatch.IBEggHatchBill.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBEggHatchBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D2F77416") ,com.kingdee.eas.farm.hatch.IBEggHatchBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBEggHatchBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D2F77416"));
    }
    public static com.kingdee.eas.farm.hatch.IBEggHatchBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D2F77416"));
    }
}