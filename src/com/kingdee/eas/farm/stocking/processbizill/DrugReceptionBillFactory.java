package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DrugReceptionBillFactory
{
    private DrugReceptionBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F16676F1") ,com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F16676F1") ,com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F16676F1"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F16676F1"));
    }
}