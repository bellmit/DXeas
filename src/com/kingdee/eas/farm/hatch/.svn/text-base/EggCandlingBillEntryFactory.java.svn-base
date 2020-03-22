package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggCandlingBillEntryFactory
{
    private EggCandlingBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IEggCandlingBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggCandlingBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F39918CA") ,com.kingdee.eas.farm.hatch.IEggCandlingBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IEggCandlingBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggCandlingBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F39918CA") ,com.kingdee.eas.farm.hatch.IEggCandlingBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IEggCandlingBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggCandlingBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F39918CA"));
    }
    public static com.kingdee.eas.farm.hatch.IEggCandlingBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggCandlingBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F39918CA"));
    }
}