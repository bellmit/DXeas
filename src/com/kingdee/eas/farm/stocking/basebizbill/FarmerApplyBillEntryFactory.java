package com.kingdee.eas.farm.stocking.basebizbill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerApplyBillEntryFactory
{
    private FarmerApplyBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9564B781") ,com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9564B781") ,com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9564B781"));
    }
    public static com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9564B781"));
    }
}