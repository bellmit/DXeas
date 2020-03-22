package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DiscountGridLogEntryFactory
{
    private DiscountGridLogEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountGridLogEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountGridLogEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D1031250") ,com.kingdee.eas.custom.salediscount.IDiscountGridLogEntry.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.IDiscountGridLogEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountGridLogEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D1031250") ,com.kingdee.eas.custom.salediscount.IDiscountGridLogEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountGridLogEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountGridLogEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D1031250"));
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountGridLogEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountGridLogEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D1031250"));
    }
}