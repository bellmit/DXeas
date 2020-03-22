package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchBabyBillSaleEntryFactory
{
    private HatchBabyBillSaleEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchBabyBillSaleEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBabyBillSaleEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1298CA1C") ,com.kingdee.eas.farm.hatch.IHatchBabyBillSaleEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchBabyBillSaleEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBabyBillSaleEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1298CA1C") ,com.kingdee.eas.farm.hatch.IHatchBabyBillSaleEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchBabyBillSaleEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBabyBillSaleEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1298CA1C"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchBabyBillSaleEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBabyBillSaleEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1298CA1C"));
    }
}