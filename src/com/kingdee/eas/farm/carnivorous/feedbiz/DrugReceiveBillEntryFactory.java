package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DrugReceiveBillEntryFactory
{
    private DrugReceiveBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F887C12C") ,com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F887C12C") ,com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F887C12C"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F887C12C"));
    }
}