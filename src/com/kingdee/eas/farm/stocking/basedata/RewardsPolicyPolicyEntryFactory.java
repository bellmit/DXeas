package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RewardsPolicyPolicyEntryFactory
{
    private RewardsPolicyPolicyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyPolicyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyPolicyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3BA7BF5B") ,com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyPolicyEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyPolicyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyPolicyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3BA7BF5B") ,com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyPolicyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyPolicyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyPolicyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3BA7BF5B"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyPolicyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyPolicyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3BA7BF5B"));
    }
}