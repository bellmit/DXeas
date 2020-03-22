package com.kingdee.eas.custom.shr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RecordBusChangeEntryFactory
{
    private RecordBusChangeEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.shr.IRecordBusChangeEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IRecordBusChangeEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("08A4C489") ,com.kingdee.eas.custom.shr.IRecordBusChangeEntry.class);
    }
    
    public static com.kingdee.eas.custom.shr.IRecordBusChangeEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IRecordBusChangeEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("08A4C489") ,com.kingdee.eas.custom.shr.IRecordBusChangeEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.shr.IRecordBusChangeEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IRecordBusChangeEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("08A4C489"));
    }
    public static com.kingdee.eas.custom.shr.IRecordBusChangeEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IRecordBusChangeEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("08A4C489"));
    }
}