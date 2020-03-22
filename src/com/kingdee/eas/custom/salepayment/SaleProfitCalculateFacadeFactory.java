package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleProfitCalculateFacadeFactory
{
    private SaleProfitCalculateFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ISaleProfitCalculateFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleProfitCalculateFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7CDAA241") ,com.kingdee.eas.custom.salepayment.ISaleProfitCalculateFacade.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ISaleProfitCalculateFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleProfitCalculateFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7CDAA241") ,com.kingdee.eas.custom.salepayment.ISaleProfitCalculateFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ISaleProfitCalculateFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleProfitCalculateFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7CDAA241"));
    }
    public static com.kingdee.eas.custom.salepayment.ISaleProfitCalculateFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleProfitCalculateFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7CDAA241"));
    }
}