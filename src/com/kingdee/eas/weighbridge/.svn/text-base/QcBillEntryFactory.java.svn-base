package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class QcBillEntryFactory
{
    private QcBillEntryFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IQcBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IQcBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5E1397FE") ,com.kingdee.eas.weighbridge.IQcBillEntry.class);
    }
    
    public static com.kingdee.eas.weighbridge.IQcBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IQcBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5E1397FE") ,com.kingdee.eas.weighbridge.IQcBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IQcBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IQcBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5E1397FE"));
    }
    public static com.kingdee.eas.weighbridge.IQcBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IQcBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5E1397FE"));
    }
}