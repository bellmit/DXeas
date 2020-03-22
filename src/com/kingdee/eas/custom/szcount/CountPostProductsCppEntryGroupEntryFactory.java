package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CountPostProductsCppEntryGroupEntryFactory
{
    private CountPostProductsCppEntryGroupEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.ICountPostProductsCppEntryGroupEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPostProductsCppEntryGroupEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B787D00A") ,com.kingdee.eas.custom.szcount.ICountPostProductsCppEntryGroupEntry.class);
    }
    
    public static com.kingdee.eas.custom.szcount.ICountPostProductsCppEntryGroupEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPostProductsCppEntryGroupEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B787D00A") ,com.kingdee.eas.custom.szcount.ICountPostProductsCppEntryGroupEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.ICountPostProductsCppEntryGroupEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPostProductsCppEntryGroupEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B787D00A"));
    }
    public static com.kingdee.eas.custom.szcount.ICountPostProductsCppEntryGroupEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPostProductsCppEntryGroupEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B787D00A"));
    }
}