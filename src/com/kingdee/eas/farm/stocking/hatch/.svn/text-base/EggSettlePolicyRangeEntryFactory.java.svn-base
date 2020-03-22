package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggSettlePolicyRangeEntryFactory
{
    private EggSettlePolicyRangeEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyRangeEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyRangeEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C2D9F12D") ,com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyRangeEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyRangeEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyRangeEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C2D9F12D") ,com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyRangeEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyRangeEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyRangeEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C2D9F12D"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyRangeEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettlePolicyRangeEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C2D9F12D"));
    }
}