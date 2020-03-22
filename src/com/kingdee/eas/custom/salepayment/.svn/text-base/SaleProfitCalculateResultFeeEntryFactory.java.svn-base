package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleProfitCalculateResultFeeEntryFactory
{
    private SaleProfitCalculateResultFeeEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultFeeEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultFeeEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("ACF1EA70") ,com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultFeeEntry.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultFeeEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultFeeEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("ACF1EA70") ,com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultFeeEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultFeeEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultFeeEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("ACF1EA70"));
    }
    public static com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultFeeEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResultFeeEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("ACF1EA70"));
    }
}