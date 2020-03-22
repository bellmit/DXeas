package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AttendanceBillEntryFactory
{
    private AttendanceBillEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IAttendanceBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5965AABA") ,com.kingdee.eas.custom.wages.IAttendanceBillEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IAttendanceBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5965AABA") ,com.kingdee.eas.custom.wages.IAttendanceBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IAttendanceBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5965AABA"));
    }
    public static com.kingdee.eas.custom.wages.IAttendanceBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5965AABA"));
    }
}