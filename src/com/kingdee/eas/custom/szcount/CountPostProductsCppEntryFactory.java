package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CountPostProductsCppEntryFactory
{
    private CountPostProductsCppEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.ICountPostProductsCppEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPostProductsCppEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("721E4377") ,com.kingdee.eas.custom.szcount.ICountPostProductsCppEntry.class);
    }
    
    public static com.kingdee.eas.custom.szcount.ICountPostProductsCppEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPostProductsCppEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("721E4377") ,com.kingdee.eas.custom.szcount.ICountPostProductsCppEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.ICountPostProductsCppEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPostProductsCppEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("721E4377"));
    }
    public static com.kingdee.eas.custom.szcount.ICountPostProductsCppEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPostProductsCppEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("721E4377"));
    }
}