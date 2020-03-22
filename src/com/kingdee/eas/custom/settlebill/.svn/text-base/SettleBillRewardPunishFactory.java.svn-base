package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleBillRewardPunishFactory
{
    private SettleBillRewardPunishFactory()
    {
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBillRewardPunish getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillRewardPunish)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("77690F27") ,com.kingdee.eas.custom.settlebill.ISettleBillRewardPunish.class);
    }
    
    public static com.kingdee.eas.custom.settlebill.ISettleBillRewardPunish getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillRewardPunish)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("77690F27") ,com.kingdee.eas.custom.settlebill.ISettleBillRewardPunish.class, objectCtx);
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBillRewardPunish getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillRewardPunish)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("77690F27"));
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBillRewardPunish getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillRewardPunish)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("77690F27"));
    }
}