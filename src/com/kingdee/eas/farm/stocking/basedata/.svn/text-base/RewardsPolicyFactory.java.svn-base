package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RewardsPolicyFactory
{
    private RewardsPolicyFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IRewardsPolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IRewardsPolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4753EDC5") ,com.kingdee.eas.farm.stocking.basedata.IRewardsPolicy.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IRewardsPolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IRewardsPolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4753EDC5") ,com.kingdee.eas.farm.stocking.basedata.IRewardsPolicy.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IRewardsPolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IRewardsPolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4753EDC5"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IRewardsPolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IRewardsPolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4753EDC5"));
    }
}