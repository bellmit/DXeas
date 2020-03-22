package com.kingdee.eas.custom.bsxbudget;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BSXBudgetFacadeFactory
{
    private BSXBudgetFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.bsxbudget.IBSXBudgetFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.bsxbudget.IBSXBudgetFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("835F6C9F") ,com.kingdee.eas.custom.bsxbudget.IBSXBudgetFacade.class);
    }
    
    public static com.kingdee.eas.custom.bsxbudget.IBSXBudgetFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.bsxbudget.IBSXBudgetFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("835F6C9F") ,com.kingdee.eas.custom.bsxbudget.IBSXBudgetFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.bsxbudget.IBSXBudgetFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.bsxbudget.IBSXBudgetFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("835F6C9F"));
    }
    public static com.kingdee.eas.custom.bsxbudget.IBSXBudgetFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.bsxbudget.IBSXBudgetFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("835F6C9F"));
    }
}