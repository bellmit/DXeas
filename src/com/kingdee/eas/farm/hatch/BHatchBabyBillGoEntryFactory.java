package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BHatchBabyBillGoEntryFactory
{
    private BHatchBabyBillGoEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillGoEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillGoEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AD6E0D81") ,com.kingdee.eas.farm.hatch.IBHatchBabyBillGoEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillGoEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillGoEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AD6E0D81") ,com.kingdee.eas.farm.hatch.IBHatchBabyBillGoEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillGoEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillGoEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AD6E0D81"));
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillGoEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillGoEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AD6E0D81"));
    }
}