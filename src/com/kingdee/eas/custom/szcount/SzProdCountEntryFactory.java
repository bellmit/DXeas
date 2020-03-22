package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SzProdCountEntryFactory
{
    private SzProdCountEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.ISzProdCountEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzProdCountEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DD72510C") ,com.kingdee.eas.custom.szcount.ISzProdCountEntry.class);
    }
    
    public static com.kingdee.eas.custom.szcount.ISzProdCountEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzProdCountEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DD72510C") ,com.kingdee.eas.custom.szcount.ISzProdCountEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.ISzProdCountEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzProdCountEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DD72510C"));
    }
    public static com.kingdee.eas.custom.szcount.ISzProdCountEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzProdCountEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DD72510C"));
    }
}