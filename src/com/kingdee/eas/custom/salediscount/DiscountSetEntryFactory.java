package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DiscountSetEntryFactory
{
    private DiscountSetEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountSetEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountSetEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C518C08C") ,com.kingdee.eas.custom.salediscount.IDiscountSetEntry.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.IDiscountSetEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountSetEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C518C08C") ,com.kingdee.eas.custom.salediscount.IDiscountSetEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountSetEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountSetEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C518C08C"));
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountSetEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountSetEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C518C08C"));
    }
}