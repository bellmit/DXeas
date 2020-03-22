package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MonthFeeFactory
{
    private MonthFeeFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.IMonthFee getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMonthFee)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AFB5FBDA") ,com.kingdee.eas.custom.salepayment.IMonthFee.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.IMonthFee getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMonthFee)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AFB5FBDA") ,com.kingdee.eas.custom.salepayment.IMonthFee.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.IMonthFee getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMonthFee)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AFB5FBDA"));
    }
    public static com.kingdee.eas.custom.salepayment.IMonthFee getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMonthFee)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AFB5FBDA"));
    }
}