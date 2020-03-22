package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DiscountRecordBillFactory
{
    private DiscountRecordBillFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountRecordBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountRecordBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BB4F0454") ,com.kingdee.eas.custom.salediscount.IDiscountRecordBill.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.IDiscountRecordBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountRecordBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BB4F0454") ,com.kingdee.eas.custom.salediscount.IDiscountRecordBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountRecordBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountRecordBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BB4F0454"));
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountRecordBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountRecordBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BB4F0454"));
    }
}