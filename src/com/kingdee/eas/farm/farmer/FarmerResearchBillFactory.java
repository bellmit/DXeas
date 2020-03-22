package com.kingdee.eas.farm.farmer;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerResearchBillFactory
{
    private FarmerResearchBillFactory()
    {
    }
    public static com.kingdee.eas.farm.farmer.IFarmerResearchBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.farmer.IFarmerResearchBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E826F98A") ,com.kingdee.eas.farm.farmer.IFarmerResearchBill.class);
    }
    
    public static com.kingdee.eas.farm.farmer.IFarmerResearchBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.farmer.IFarmerResearchBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E826F98A") ,com.kingdee.eas.farm.farmer.IFarmerResearchBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.farmer.IFarmerResearchBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.farmer.IFarmerResearchBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E826F98A"));
    }
    public static com.kingdee.eas.farm.farmer.IFarmerResearchBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.farmer.IFarmerResearchBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E826F98A"));
    }
}