package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TAttendFarmRecordFactory
{
    private TAttendFarmRecordFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.ITAttendFarmRecord getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.ITAttendFarmRecord)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("63ECD80B") ,com.kingdee.eas.custom.wages.farm.ITAttendFarmRecord.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.ITAttendFarmRecord getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.ITAttendFarmRecord)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("63ECD80B") ,com.kingdee.eas.custom.wages.farm.ITAttendFarmRecord.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.ITAttendFarmRecord getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.ITAttendFarmRecord)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("63ECD80B"));
    }
    public static com.kingdee.eas.custom.wages.farm.ITAttendFarmRecord getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.ITAttendFarmRecord)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("63ECD80B"));
    }
}