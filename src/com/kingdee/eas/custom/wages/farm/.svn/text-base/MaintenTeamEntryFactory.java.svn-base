package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaintenTeamEntryFactory
{
    private MaintenTeamEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.IMaintenTeamEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMaintenTeamEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("352F4CDB") ,com.kingdee.eas.custom.wages.farm.IMaintenTeamEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.IMaintenTeamEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMaintenTeamEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("352F4CDB") ,com.kingdee.eas.custom.wages.farm.IMaintenTeamEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.IMaintenTeamEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMaintenTeamEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("352F4CDB"));
    }
    public static com.kingdee.eas.custom.wages.farm.IMaintenTeamEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMaintenTeamEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("352F4CDB"));
    }
}