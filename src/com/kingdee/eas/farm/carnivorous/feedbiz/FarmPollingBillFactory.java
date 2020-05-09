package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmPollingBillFactory
{
    private FarmPollingBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("862C8570") ,com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("862C8570") ,com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("862C8570"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("862C8570"));
    }
}