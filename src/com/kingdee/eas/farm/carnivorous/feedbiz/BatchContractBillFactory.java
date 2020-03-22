package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BatchContractBillFactory
{
    private BatchContractBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F66F7EAF") ,com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F66F7EAF") ,com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F66F7EAF"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F66F7EAF"));
    }
}