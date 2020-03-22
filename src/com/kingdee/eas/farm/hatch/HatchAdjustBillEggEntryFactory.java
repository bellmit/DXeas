package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchAdjustBillEggEntryFactory
{
    private HatchAdjustBillEggEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchAdjustBillEggEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchAdjustBillEggEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("94AADC55") ,com.kingdee.eas.farm.hatch.IHatchAdjustBillEggEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchAdjustBillEggEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchAdjustBillEggEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("94AADC55") ,com.kingdee.eas.farm.hatch.IHatchAdjustBillEggEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchAdjustBillEggEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchAdjustBillEggEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("94AADC55"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchAdjustBillEggEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchAdjustBillEggEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("94AADC55"));
    }
}