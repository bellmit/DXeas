package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RewardAndPunishItemFactory
{
    private RewardAndPunishItemFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IRewardAndPunishItem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRewardAndPunishItem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B2AB0AEE") ,com.kingdee.eas.farm.carnivorous.basedata.IRewardAndPunishItem.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IRewardAndPunishItem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRewardAndPunishItem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B2AB0AEE") ,com.kingdee.eas.farm.carnivorous.basedata.IRewardAndPunishItem.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IRewardAndPunishItem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRewardAndPunishItem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B2AB0AEE"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IRewardAndPunishItem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRewardAndPunishItem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B2AB0AEE"));
    }
}