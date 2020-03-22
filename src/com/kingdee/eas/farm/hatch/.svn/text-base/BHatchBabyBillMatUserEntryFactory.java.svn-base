package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BHatchBabyBillMatUserEntryFactory
{
    private BHatchBabyBillMatUserEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillMatUserEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillMatUserEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DB643F30") ,com.kingdee.eas.farm.hatch.IBHatchBabyBillMatUserEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillMatUserEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillMatUserEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DB643F30") ,com.kingdee.eas.farm.hatch.IBHatchBabyBillMatUserEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillMatUserEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillMatUserEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DB643F30"));
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillMatUserEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillMatUserEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DB643F30"));
    }
}