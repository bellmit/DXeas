package com.kingdee.eas.farm.stocking.basebizbill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerApplyBillFactory
{
    private FarmerApplyBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E7125F71") ,com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E7125F71") ,com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E7125F71"));
    }
    public static com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IFarmerApplyBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E7125F71"));
    }
}