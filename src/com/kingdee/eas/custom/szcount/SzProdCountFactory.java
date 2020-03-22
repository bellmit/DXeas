package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SzProdCountFactory
{
    private SzProdCountFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.ISzProdCount getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzProdCount)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5367BB06") ,com.kingdee.eas.custom.szcount.ISzProdCount.class);
    }
    
    public static com.kingdee.eas.custom.szcount.ISzProdCount getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzProdCount)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5367BB06") ,com.kingdee.eas.custom.szcount.ISzProdCount.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.ISzProdCount getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzProdCount)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5367BB06"));
    }
    public static com.kingdee.eas.custom.szcount.ISzProdCount getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzProdCount)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5367BB06"));
    }
}