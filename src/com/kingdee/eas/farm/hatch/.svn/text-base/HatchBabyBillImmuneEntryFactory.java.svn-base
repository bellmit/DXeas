package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchBabyBillImmuneEntryFactory
{
    private HatchBabyBillImmuneEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchBabyBillImmuneEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBabyBillImmuneEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EB53FB20") ,com.kingdee.eas.farm.hatch.IHatchBabyBillImmuneEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchBabyBillImmuneEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBabyBillImmuneEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EB53FB20") ,com.kingdee.eas.farm.hatch.IHatchBabyBillImmuneEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchBabyBillImmuneEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBabyBillImmuneEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EB53FB20"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchBabyBillImmuneEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBabyBillImmuneEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EB53FB20"));
    }
}