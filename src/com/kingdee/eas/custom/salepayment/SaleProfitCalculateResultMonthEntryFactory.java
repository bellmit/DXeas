package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleProfitCalculateResultMonthEntryFactory
{
    private SaleProfitCalculateResultMonthEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultMonthEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultMonthEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0129B6B6") ,com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultMonthEntry.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultMonthEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultMonthEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0129B6B6") ,com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultMonthEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultMonthEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultMonthEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0129B6B6"));
    }
    public static com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultMonthEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultMonthEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0129B6B6"));
    }
}