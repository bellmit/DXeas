package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BEggHatchBillEggEntryComputeEntryFactory
{
    private BEggHatchBillEggEntryComputeEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntryComputeEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntryComputeEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A3C03FBE") ,com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntryComputeEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntryComputeEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntryComputeEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A3C03FBE") ,com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntryComputeEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntryComputeEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntryComputeEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A3C03FBE"));
    }
    public static com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntryComputeEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntryComputeEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A3C03FBE"));
    }
}