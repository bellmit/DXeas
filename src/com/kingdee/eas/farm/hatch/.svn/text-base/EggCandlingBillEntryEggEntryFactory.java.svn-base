package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggCandlingBillEntryEggEntryFactory
{
    private EggCandlingBillEntryEggEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IEggCandlingBillEntryEggEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggCandlingBillEntryEggEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AF16DE57") ,com.kingdee.eas.farm.hatch.IEggCandlingBillEntryEggEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IEggCandlingBillEntryEggEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggCandlingBillEntryEggEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AF16DE57") ,com.kingdee.eas.farm.hatch.IEggCandlingBillEntryEggEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IEggCandlingBillEntryEggEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggCandlingBillEntryEggEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AF16DE57"));
    }
    public static com.kingdee.eas.farm.hatch.IEggCandlingBillEntryEggEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggCandlingBillEntryEggEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AF16DE57"));
    }
}