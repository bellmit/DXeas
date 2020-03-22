package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaintenTeamFactory
{
    private MaintenTeamFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.IMaintenTeam getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMaintenTeam)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B64259D7") ,com.kingdee.eas.custom.wages.farm.IMaintenTeam.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.IMaintenTeam getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMaintenTeam)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B64259D7") ,com.kingdee.eas.custom.wages.farm.IMaintenTeam.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.IMaintenTeam getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMaintenTeam)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B64259D7"));
    }
    public static com.kingdee.eas.custom.wages.farm.IMaintenTeam getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMaintenTeam)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B64259D7"));
    }
}