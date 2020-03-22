package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DrugReceptionBillEntryFactory
{
    private DrugReceptionBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F9735001") ,com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F9735001") ,com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F9735001"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F9735001"));
    }
}