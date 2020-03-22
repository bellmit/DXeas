package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BHatchBabyBillEntryFactory
{
    private BHatchBabyBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("295C9349") ,com.kingdee.eas.farm.hatch.IBHatchBabyBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("295C9349") ,com.kingdee.eas.farm.hatch.IBHatchBabyBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("295C9349"));
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("295C9349"));
    }
}