package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SzSemiProductEntryFactory
{
    private SzSemiProductEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.ISzSemiProductEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzSemiProductEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("84568C83") ,com.kingdee.eas.custom.szcount.ISzSemiProductEntry.class);
    }
    
    public static com.kingdee.eas.custom.szcount.ISzSemiProductEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzSemiProductEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("84568C83") ,com.kingdee.eas.custom.szcount.ISzSemiProductEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.ISzSemiProductEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzSemiProductEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("84568C83"));
    }
    public static com.kingdee.eas.custom.szcount.ISzSemiProductEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzSemiProductEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("84568C83"));
    }
}