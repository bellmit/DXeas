package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BHatchBabyBillImmuneEntryFactory
{
    private BHatchBabyBillImmuneEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillImmuneEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillImmuneEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F18C1346") ,com.kingdee.eas.farm.hatch.IBHatchBabyBillImmuneEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillImmuneEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillImmuneEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F18C1346") ,com.kingdee.eas.farm.hatch.IBHatchBabyBillImmuneEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillImmuneEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillImmuneEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F18C1346"));
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillImmuneEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillImmuneEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F18C1346"));
    }
}