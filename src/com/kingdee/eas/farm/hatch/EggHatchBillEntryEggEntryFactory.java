package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggHatchBillEntryEggEntryFactory
{
    private EggHatchBillEntryEggEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IEggHatchBillEntryEggEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggHatchBillEntryEggEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("067348EF") ,com.kingdee.eas.farm.hatch.IEggHatchBillEntryEggEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IEggHatchBillEntryEggEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggHatchBillEntryEggEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("067348EF") ,com.kingdee.eas.farm.hatch.IEggHatchBillEntryEggEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IEggHatchBillEntryEggEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggHatchBillEntryEggEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("067348EF"));
    }
    public static com.kingdee.eas.farm.hatch.IEggHatchBillEntryEggEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggHatchBillEntryEggEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("067348EF"));
    }
}