package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DiscountFacadeFactory
{
    private DiscountFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("334BCEF6") ,com.kingdee.eas.custom.salediscount.IDiscountFacade.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.IDiscountFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("334BCEF6") ,com.kingdee.eas.custom.salediscount.IDiscountFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("334BCEF6"));
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("334BCEF6"));
    }
}