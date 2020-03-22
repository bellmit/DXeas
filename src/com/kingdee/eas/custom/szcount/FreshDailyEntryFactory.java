package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FreshDailyEntryFactory
{
    private FreshDailyEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.IFreshDailyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IFreshDailyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("165EDCDC") ,com.kingdee.eas.custom.szcount.IFreshDailyEntry.class);
    }
    
    public static com.kingdee.eas.custom.szcount.IFreshDailyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IFreshDailyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("165EDCDC") ,com.kingdee.eas.custom.szcount.IFreshDailyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.IFreshDailyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IFreshDailyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("165EDCDC"));
    }
    public static com.kingdee.eas.custom.szcount.IFreshDailyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IFreshDailyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("165EDCDC"));
    }
}