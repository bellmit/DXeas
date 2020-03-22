package com.kingdee.eas.farm.stocking.basebizbill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerApplyBillFarmEntryFactory
{
    private FarmerApplyBillFarmEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillFarmEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillFarmEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3622816B") ,com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillFarmEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillFarmEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillFarmEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3622816B") ,com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillFarmEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillFarmEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillFarmEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3622816B"));
    }
    public static com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillFarmEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBillFarmEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3622816B"));
    }
}