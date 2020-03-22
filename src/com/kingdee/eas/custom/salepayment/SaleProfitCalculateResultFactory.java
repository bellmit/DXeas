package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleProfitCalculateResultFactory
{
    private SaleProfitCalculateResultFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResult getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResult)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9194B9C4") ,com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResult.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResult getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResult)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9194B9C4") ,com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResult.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResult getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResult)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9194B9C4"));
    }
    public static com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResult getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleProfitCalculateResult)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9194B9C4"));
    }
}