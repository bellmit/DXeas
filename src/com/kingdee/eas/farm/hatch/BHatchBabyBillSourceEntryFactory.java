package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BHatchBabyBillSourceEntryFactory
{
    private BHatchBabyBillSourceEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillSourceEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillSourceEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CFA956AE") ,com.kingdee.eas.farm.hatch.IBHatchBabyBillSourceEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillSourceEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillSourceEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CFA956AE") ,com.kingdee.eas.farm.hatch.IBHatchBabyBillSourceEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillSourceEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillSourceEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CFA956AE"));
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillSourceEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillSourceEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CFA956AE"));
    }
}