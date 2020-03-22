package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchBabyBillEntryFactory
{
    private HatchBabyBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchBabyBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBabyBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("71BDE6A3") ,com.kingdee.eas.farm.hatch.IHatchBabyBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchBabyBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBabyBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("71BDE6A3") ,com.kingdee.eas.farm.hatch.IHatchBabyBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchBabyBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBabyBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("71BDE6A3"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchBabyBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBabyBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("71BDE6A3"));
    }
}