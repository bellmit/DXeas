package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggSettlePolicyFactory
{
    private EggSettlePolicyFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("652C65D8") ,com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicy.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("652C65D8") ,com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicy.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("652C65D8"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("652C65D8"));
    }
}