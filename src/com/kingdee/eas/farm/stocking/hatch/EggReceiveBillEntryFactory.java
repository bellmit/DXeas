package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggReceiveBillEntryFactory
{
    private EggReceiveBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E9378F03") ,com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E9378F03") ,com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E9378F03"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E9378F03"));
    }
}