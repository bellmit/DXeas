package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggSettlePolicySaleEntryFactory
{
    private EggSettlePolicySaleEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicySaleEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicySaleEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("33E93973") ,com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicySaleEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicySaleEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicySaleEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("33E93973") ,com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicySaleEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicySaleEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicySaleEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("33E93973"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicySaleEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicySaleEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("33E93973"));
    }
}