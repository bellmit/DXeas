package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggSettlePolicyTreeFactory
{
    private EggSettlePolicyTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8A7DA196") ,com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8A7DA196") ,com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8A7DA196"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8A7DA196"));
    }
}