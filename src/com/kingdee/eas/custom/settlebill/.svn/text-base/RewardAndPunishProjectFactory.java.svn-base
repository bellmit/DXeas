package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RewardAndPunishProjectFactory
{
    private RewardAndPunishProjectFactory()
    {
    }
    public static com.kingdee.eas.custom.settlebill.IRewardAndPunishProject getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.IRewardAndPunishProject)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CC5EAE6D") ,com.kingdee.eas.custom.settlebill.IRewardAndPunishProject.class);
    }
    
    public static com.kingdee.eas.custom.settlebill.IRewardAndPunishProject getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.IRewardAndPunishProject)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CC5EAE6D") ,com.kingdee.eas.custom.settlebill.IRewardAndPunishProject.class, objectCtx);
    }
    public static com.kingdee.eas.custom.settlebill.IRewardAndPunishProject getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.IRewardAndPunishProject)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CC5EAE6D"));
    }
    public static com.kingdee.eas.custom.settlebill.IRewardAndPunishProject getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.IRewardAndPunishProject)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CC5EAE6D"));
    }
}