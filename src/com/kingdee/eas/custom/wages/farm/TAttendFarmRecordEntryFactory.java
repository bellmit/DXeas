package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TAttendFarmRecordEntryFactory
{
    private TAttendFarmRecordEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.ITAttendFarmRecordEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.ITAttendFarmRecordEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DD1F8F27") ,com.kingdee.eas.custom.wages.farm.ITAttendFarmRecordEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.ITAttendFarmRecordEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.ITAttendFarmRecordEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DD1F8F27") ,com.kingdee.eas.custom.wages.farm.ITAttendFarmRecordEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.ITAttendFarmRecordEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.ITAttendFarmRecordEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DD1F8F27"));
    }
    public static com.kingdee.eas.custom.wages.farm.ITAttendFarmRecordEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.ITAttendFarmRecordEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DD1F8F27"));
    }
}