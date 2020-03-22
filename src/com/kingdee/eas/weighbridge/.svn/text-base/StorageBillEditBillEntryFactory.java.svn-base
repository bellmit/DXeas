package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StorageBillEditBillEntryFactory
{
    private StorageBillEditBillEntryFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IStorageBillEditBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IStorageBillEditBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A944B69A") ,com.kingdee.eas.weighbridge.IStorageBillEditBillEntry.class);
    }
    
    public static com.kingdee.eas.weighbridge.IStorageBillEditBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IStorageBillEditBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A944B69A") ,com.kingdee.eas.weighbridge.IStorageBillEditBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IStorageBillEditBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IStorageBillEditBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A944B69A"));
    }
    public static com.kingdee.eas.weighbridge.IStorageBillEditBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IStorageBillEditBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A944B69A"));
    }
}