package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BEggCandlingBillEggEntryFactory
{
    private BEggCandlingBillEggEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBEggCandlingBillEggEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggCandlingBillEggEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3205072F") ,com.kingdee.eas.farm.hatch.IBEggCandlingBillEggEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBEggCandlingBillEggEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggCandlingBillEggEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3205072F") ,com.kingdee.eas.farm.hatch.IBEggCandlingBillEggEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBEggCandlingBillEggEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggCandlingBillEggEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3205072F"));
    }
    public static com.kingdee.eas.farm.hatch.IBEggCandlingBillEggEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggCandlingBillEggEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3205072F"));
    }
}