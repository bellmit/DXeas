package com.kingdee.eas.custom.farmpolling;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PollingRecordBillInventoryEntryFactory
{
    private PollingRecordBillInventoryEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.farmpolling.IPollingRecordBillInventoryEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.farmpolling.IPollingRecordBillInventoryEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("776347EB") ,com.kingdee.eas.custom.farmpolling.IPollingRecordBillInventoryEntry.class);
    }
    
    public static com.kingdee.eas.custom.farmpolling.IPollingRecordBillInventoryEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.farmpolling.IPollingRecordBillInventoryEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("776347EB") ,com.kingdee.eas.custom.farmpolling.IPollingRecordBillInventoryEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.farmpolling.IPollingRecordBillInventoryEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.farmpolling.IPollingRecordBillInventoryEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("776347EB"));
    }
    public static com.kingdee.eas.custom.farmpolling.IPollingRecordBillInventoryEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.farmpolling.IPollingRecordBillInventoryEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("776347EB"));
    }
}