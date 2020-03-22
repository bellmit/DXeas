package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DiscountGridLogFactory
{
    private DiscountGridLogFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountGridLog getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountGridLog)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("886C3F42") ,com.kingdee.eas.custom.salediscount.IDiscountGridLog.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.IDiscountGridLog getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountGridLog)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("886C3F42") ,com.kingdee.eas.custom.salediscount.IDiscountGridLog.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountGridLog getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountGridLog)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("886C3F42"));
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountGridLog getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountGridLog)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("886C3F42"));
    }
}