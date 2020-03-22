package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchEggReceivingBillEntryFactory
{
    private HatchEggReceivingBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchEggReceivingBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchEggReceivingBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E31BD2BE") ,com.kingdee.eas.farm.hatch.IHatchEggReceivingBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchEggReceivingBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchEggReceivingBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E31BD2BE") ,com.kingdee.eas.farm.hatch.IHatchEggReceivingBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchEggReceivingBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchEggReceivingBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E31BD2BE"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchEggReceivingBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchEggReceivingBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E31BD2BE"));
    }
}