package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AttendanceDockingEntryFactory
{
    private AttendanceDockingEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IAttendanceDockingEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceDockingEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("22FAA474") ,com.kingdee.eas.custom.wages.IAttendanceDockingEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IAttendanceDockingEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceDockingEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("22FAA474") ,com.kingdee.eas.custom.wages.IAttendanceDockingEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IAttendanceDockingEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceDockingEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("22FAA474"));
    }
    public static com.kingdee.eas.custom.wages.IAttendanceDockingEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceDockingEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("22FAA474"));
    }
}