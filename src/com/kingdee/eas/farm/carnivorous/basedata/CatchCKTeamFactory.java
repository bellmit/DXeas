package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CatchCKTeamFactory
{
    private CatchCKTeamFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ICatchCKTeam getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICatchCKTeam)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0477F67E") ,com.kingdee.eas.farm.carnivorous.basedata.ICatchCKTeam.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ICatchCKTeam getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICatchCKTeam)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0477F67E") ,com.kingdee.eas.farm.carnivorous.basedata.ICatchCKTeam.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ICatchCKTeam getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICatchCKTeam)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0477F67E"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ICatchCKTeam getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICatchCKTeam)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0477F67E"));
    }
}