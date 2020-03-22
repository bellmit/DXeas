package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FreshDailyFrozenEntryFactory
{
    private FreshDailyFrozenEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.IFreshDailyFrozenEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IFreshDailyFrozenEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("061B069C") ,com.kingdee.eas.custom.szcount.IFreshDailyFrozenEntry.class);
    }
    
    public static com.kingdee.eas.custom.szcount.IFreshDailyFrozenEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IFreshDailyFrozenEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("061B069C") ,com.kingdee.eas.custom.szcount.IFreshDailyFrozenEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.IFreshDailyFrozenEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IFreshDailyFrozenEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("061B069C"));
    }
    public static com.kingdee.eas.custom.szcount.IFreshDailyFrozenEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IFreshDailyFrozenEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("061B069C"));
    }
}