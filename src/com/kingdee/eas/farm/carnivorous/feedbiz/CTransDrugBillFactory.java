package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CTransDrugBillFactory
{
    private CTransDrugBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B25E5A50") ,com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B25E5A50") ,com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B25E5A50"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B25E5A50"));
    }
}