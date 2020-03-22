package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StorageBillEditBillFactory
{
    private StorageBillEditBillFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IStorageBillEditBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IStorageBillEditBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CDD394B8") ,com.kingdee.eas.weighbridge.IStorageBillEditBill.class);
    }
    
    public static com.kingdee.eas.weighbridge.IStorageBillEditBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IStorageBillEditBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CDD394B8") ,com.kingdee.eas.weighbridge.IStorageBillEditBill.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IStorageBillEditBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IStorageBillEditBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CDD394B8"));
    }
    public static com.kingdee.eas.weighbridge.IStorageBillEditBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IStorageBillEditBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CDD394B8"));
    }
}