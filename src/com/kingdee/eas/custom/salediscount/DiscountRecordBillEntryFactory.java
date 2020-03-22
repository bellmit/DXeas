package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DiscountRecordBillEntryFactory
{
    private DiscountRecordBillEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountRecordBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountRecordBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("64CAA87E") ,com.kingdee.eas.custom.salediscount.IDiscountRecordBillEntry.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.IDiscountRecordBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountRecordBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("64CAA87E") ,com.kingdee.eas.custom.salediscount.IDiscountRecordBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountRecordBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountRecordBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("64CAA87E"));
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountRecordBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountRecordBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("64CAA87E"));
    }
}