package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SeedBillEntryFactory
{
    private SeedBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ISeedBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ISeedBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C0B191F5") ,com.kingdee.eas.farm.stocking.processbizill.ISeedBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ISeedBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ISeedBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C0B191F5") ,com.kingdee.eas.farm.stocking.processbizill.ISeedBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ISeedBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ISeedBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C0B191F5"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ISeedBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ISeedBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C0B191F5"));
    }
}