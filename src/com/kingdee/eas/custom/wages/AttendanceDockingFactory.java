package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AttendanceDockingFactory
{
    private AttendanceDockingFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IAttendanceDocking getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceDocking)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AA82E69E") ,com.kingdee.eas.custom.wages.IAttendanceDocking.class);
    }
    
    public static com.kingdee.eas.custom.wages.IAttendanceDocking getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceDocking)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AA82E69E") ,com.kingdee.eas.custom.wages.IAttendanceDocking.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IAttendanceDocking getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceDocking)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AA82E69E"));
    }
    public static com.kingdee.eas.custom.wages.IAttendanceDocking getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceDocking)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AA82E69E"));
    }
}