package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BirdsRecycleBillEntryFactory
{
    private BirdsRecycleBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("05E04C0D") ,com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("05E04C0D") ,com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("05E04C0D"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBirdsRecycleBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("05E04C0D"));
    }
}