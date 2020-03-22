package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DiscountSetFactory
{
    private DiscountSetFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountSet getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountSet)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("32599B86") ,com.kingdee.eas.custom.salediscount.IDiscountSet.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.IDiscountSet getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountSet)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("32599B86") ,com.kingdee.eas.custom.salediscount.IDiscountSet.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountSet getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountSet)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("32599B86"));
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountSet getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountSet)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("32599B86"));
    }
}