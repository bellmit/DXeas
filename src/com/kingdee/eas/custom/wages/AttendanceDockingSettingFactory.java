package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AttendanceDockingSettingFactory
{
    private AttendanceDockingSettingFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IAttendanceDockingSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceDockingSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("241FB1D2") ,com.kingdee.eas.custom.wages.IAttendanceDockingSetting.class);
    }
    
    public static com.kingdee.eas.custom.wages.IAttendanceDockingSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceDockingSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("241FB1D2") ,com.kingdee.eas.custom.wages.IAttendanceDockingSetting.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IAttendanceDockingSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceDockingSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("241FB1D2"));
    }
    public static com.kingdee.eas.custom.wages.IAttendanceDockingSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAttendanceDockingSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("241FB1D2"));
    }
}