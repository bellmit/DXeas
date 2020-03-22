package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AttendanceBillFactory
{
    private AttendanceBillFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IAttendanceBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("13B28C98") ,com.kingdee.eas.custom.wages.IAttendanceBill.class);
    }
    
    public static com.kingdee.eas.custom.wages.IAttendanceBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("13B28C98") ,com.kingdee.eas.custom.wages.IAttendanceBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IAttendanceBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("13B28C98"));
    }
    public static com.kingdee.eas.custom.wages.IAttendanceBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("13B28C98"));
    }
}