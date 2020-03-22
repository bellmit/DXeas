package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggSettleBillEntryFactory
{
    private EggSettleBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("220F1645") ,com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("220F1645") ,com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("220F1645"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("220F1645"));
    }
}