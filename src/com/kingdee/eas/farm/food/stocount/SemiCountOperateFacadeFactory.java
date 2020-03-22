package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SemiCountOperateFacadeFactory
{
    private SemiCountOperateFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.food.stocount.ISemiCountOperateFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ISemiCountOperateFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4B9DE17A") ,com.kingdee.eas.farm.food.stocount.ISemiCountOperateFacade.class);
    }
    
    public static com.kingdee.eas.farm.food.stocount.ISemiCountOperateFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ISemiCountOperateFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4B9DE17A") ,com.kingdee.eas.farm.food.stocount.ISemiCountOperateFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.stocount.ISemiCountOperateFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ISemiCountOperateFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4B9DE17A"));
    }
    public static com.kingdee.eas.farm.food.stocount.ISemiCountOperateFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ISemiCountOperateFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4B9DE17A"));
    }
}