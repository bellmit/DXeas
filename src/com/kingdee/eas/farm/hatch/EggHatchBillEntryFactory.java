package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggHatchBillEntryFactory
{
    private EggHatchBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IEggHatchBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggHatchBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9DF59B62") ,com.kingdee.eas.farm.hatch.IEggHatchBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IEggHatchBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggHatchBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9DF59B62") ,com.kingdee.eas.farm.hatch.IEggHatchBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IEggHatchBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggHatchBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9DF59B62"));
    }
    public static com.kingdee.eas.farm.hatch.IEggHatchBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggHatchBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9DF59B62"));
    }
}