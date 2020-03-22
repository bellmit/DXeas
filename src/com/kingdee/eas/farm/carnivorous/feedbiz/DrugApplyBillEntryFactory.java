package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DrugApplyBillEntryFactory
{
    private DrugApplyBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6D53D601") ,com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6D53D601") ,com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6D53D601"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6D53D601"));
    }
}