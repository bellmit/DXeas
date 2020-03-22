package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerSettlementOfInterestEditUIFactory
{
    private FarmerSettlementOfInterestEditUIFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFarmerSettlementOfInterestEditUI getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFarmerSettlementOfInterestEditUI)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("977B4810") ,com.kingdee.eas.farm.stocking.processbizill.IFarmerSettlementOfInterestEditUI.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IFarmerSettlementOfInterestEditUI getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFarmerSettlementOfInterestEditUI)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("977B4810") ,com.kingdee.eas.farm.stocking.processbizill.IFarmerSettlementOfInterestEditUI.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFarmerSettlementOfInterestEditUI getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFarmerSettlementOfInterestEditUI)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("977B4810"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFarmerSettlementOfInterestEditUI getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFarmerSettlementOfInterestEditUI)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("977B4810"));
    }
}