package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CountPostProductsFactory
{
    private CountPostProductsFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.ICountPostProducts getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPostProducts)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1E0202C8") ,com.kingdee.eas.custom.szcount.ICountPostProducts.class);
    }
    
    public static com.kingdee.eas.custom.szcount.ICountPostProducts getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPostProducts)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1E0202C8") ,com.kingdee.eas.custom.szcount.ICountPostProducts.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.ICountPostProducts getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPostProducts)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1E0202C8"));
    }
    public static com.kingdee.eas.custom.szcount.ICountPostProducts getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ICountPostProducts)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1E0202C8"));
    }
}