package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RewardsPolicyTreeFactory
{
    private RewardsPolicyTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7C956B03") ,com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7C956B03") ,com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7C956B03"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IRewardsPolicyTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7C956B03"));
    }
}