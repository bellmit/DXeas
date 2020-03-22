package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BEggHatchBillEggEntryFactory
{
    private BEggHatchBillEggEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A83B2DA3") ,com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A83B2DA3") ,com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A83B2DA3"));
    }
    public static com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggHatchBillEggEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A83B2DA3"));
    }
}