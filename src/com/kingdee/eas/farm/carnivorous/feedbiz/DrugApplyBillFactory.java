package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DrugApplyBillFactory
{
    private DrugApplyBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("08CA30F1") ,com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("08CA30F1") ,com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("08CA30F1"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("08CA30F1"));
    }
}