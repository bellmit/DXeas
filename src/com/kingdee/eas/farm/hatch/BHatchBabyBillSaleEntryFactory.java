package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BHatchBabyBillSaleEntryFactory
{
    private BHatchBabyBillSaleEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillSaleEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillSaleEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4C24B3C2") ,com.kingdee.eas.farm.hatch.IBHatchBabyBillSaleEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillSaleEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillSaleEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4C24B3C2") ,com.kingdee.eas.farm.hatch.IBHatchBabyBillSaleEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillSaleEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillSaleEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4C24B3C2"));
    }
    public static com.kingdee.eas.farm.hatch.IBHatchBabyBillSaleEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBHatchBabyBillSaleEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4C24B3C2"));
    }
}