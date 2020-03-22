package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BatchContractBillReceiveBillEntryFactory
{
    private BatchContractBillReceiveBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBillReceiveBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBillReceiveBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2B4021D7") ,com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBillReceiveBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBillReceiveBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBillReceiveBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2B4021D7") ,com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBillReceiveBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBillReceiveBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBillReceiveBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2B4021D7"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBillReceiveBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBillReceiveBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2B4021D7"));
    }
}