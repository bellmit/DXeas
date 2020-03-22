package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TAttendanceRecordsEntryFactory
{
    private TAttendanceRecordsEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.food.ITAttendanceRecordsEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.ITAttendanceRecordsEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6C627B2B") ,com.kingdee.eas.custom.wages.food.ITAttendanceRecordsEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.food.ITAttendanceRecordsEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.ITAttendanceRecordsEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6C627B2B") ,com.kingdee.eas.custom.wages.food.ITAttendanceRecordsEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.food.ITAttendanceRecordsEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.ITAttendanceRecordsEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6C627B2B"));
    }
    public static com.kingdee.eas.custom.wages.food.ITAttendanceRecordsEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.ITAttendanceRecordsEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6C627B2B"));
    }
}