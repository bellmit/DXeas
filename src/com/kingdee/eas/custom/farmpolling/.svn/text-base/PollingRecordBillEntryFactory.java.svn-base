package com.kingdee.eas.custom.farmpolling;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PollingRecordBillEntryFactory
{
    private PollingRecordBillEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.farmpolling.IPollingRecordBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.farmpolling.IPollingRecordBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F8A9115D") ,com.kingdee.eas.custom.farmpolling.IPollingRecordBillEntry.class);
    }
    
    public static com.kingdee.eas.custom.farmpolling.IPollingRecordBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.farmpolling.IPollingRecordBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F8A9115D") ,com.kingdee.eas.custom.farmpolling.IPollingRecordBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.farmpolling.IPollingRecordBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.farmpolling.IPollingRecordBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F8A9115D"));
    }
    public static com.kingdee.eas.custom.farmpolling.IPollingRecordBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.farmpolling.IPollingRecordBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F8A9115D"));
    }
}