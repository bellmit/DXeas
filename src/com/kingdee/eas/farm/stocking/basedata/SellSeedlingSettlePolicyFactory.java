package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SellSeedlingSettlePolicyFactory
{
    private SellSeedlingSettlePolicyFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISellSeedlingSettlePolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISellSeedlingSettlePolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("91B14CA7") ,com.kingdee.eas.farm.stocking.basedata.ISellSeedlingSettlePolicy.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.ISellSeedlingSettlePolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISellSeedlingSettlePolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("91B14CA7") ,com.kingdee.eas.farm.stocking.basedata.ISellSeedlingSettlePolicy.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISellSeedlingSettlePolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISellSeedlingSettlePolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("91B14CA7"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISellSeedlingSettlePolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISellSeedlingSettlePolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("91B14CA7"));
    }
}