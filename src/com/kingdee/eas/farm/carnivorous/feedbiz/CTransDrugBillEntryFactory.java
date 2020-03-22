package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CTransDrugBillEntryFactory
{
    private CTransDrugBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("390DB002") ,com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("390DB002") ,com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("390DB002"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ICTransDrugBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("390DB002"));
    }
}