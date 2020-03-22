package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchBillEntryFactory
{
    private HatchBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FF4101D9") ,com.kingdee.eas.farm.hatch.IHatchBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FF4101D9") ,com.kingdee.eas.farm.hatch.IHatchBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FF4101D9"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FF4101D9"));
    }
}