package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggSettlePolicyPolicyEntryFactory
{
    private EggSettlePolicyPolicyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyPolicyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyPolicyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5E838D68") ,com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyPolicyEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyPolicyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyPolicyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5E838D68") ,com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyPolicyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyPolicyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyPolicyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5E838D68"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyPolicyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyPolicyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5E838D68"));
    }
}