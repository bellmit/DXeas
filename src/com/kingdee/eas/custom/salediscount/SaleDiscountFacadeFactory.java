package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleDiscountFacadeFactory
{
    private SaleDiscountFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.ISaleDiscountFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ISaleDiscountFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8CBD7D9D") ,com.kingdee.eas.custom.salediscount.ISaleDiscountFacade.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.ISaleDiscountFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ISaleDiscountFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8CBD7D9D") ,com.kingdee.eas.custom.salediscount.ISaleDiscountFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.ISaleDiscountFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ISaleDiscountFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8CBD7D9D"));
    }
    public static com.kingdee.eas.custom.salediscount.ISaleDiscountFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ISaleDiscountFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8CBD7D9D"));
    }
}