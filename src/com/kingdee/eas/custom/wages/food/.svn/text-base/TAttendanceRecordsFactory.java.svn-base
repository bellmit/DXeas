package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TAttendanceRecordsFactory
{
    private TAttendanceRecordsFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.food.ITAttendanceRecords getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.ITAttendanceRecords)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F7BF7987") ,com.kingdee.eas.custom.wages.food.ITAttendanceRecords.class);
    }
    
    public static com.kingdee.eas.custom.wages.food.ITAttendanceRecords getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.ITAttendanceRecords)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F7BF7987") ,com.kingdee.eas.custom.wages.food.ITAttendanceRecords.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.food.ITAttendanceRecords getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.ITAttendanceRecords)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F7BF7987"));
    }
    public static com.kingdee.eas.custom.wages.food.ITAttendanceRecords getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.food.ITAttendanceRecords)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F7BF7987"));
    }
}