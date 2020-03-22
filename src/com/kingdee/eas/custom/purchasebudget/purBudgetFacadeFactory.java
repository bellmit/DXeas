package com.kingdee.eas.custom.purchasebudget;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class purBudgetFacadeFactory
{
    private purBudgetFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.purchasebudget.IpurBudgetFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.purchasebudget.IpurBudgetFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("93B695AF") ,com.kingdee.eas.custom.purchasebudget.IpurBudgetFacade.class);
    }
    
    public static com.kingdee.eas.custom.purchasebudget.IpurBudgetFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.purchasebudget.IpurBudgetFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("93B695AF") ,com.kingdee.eas.custom.purchasebudget.IpurBudgetFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.purchasebudget.IpurBudgetFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.purchasebudget.IpurBudgetFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("93B695AF"));
    }
    public static com.kingdee.eas.custom.purchasebudget.IpurBudgetFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.purchasebudget.IpurBudgetFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("93B695AF"));
    }
}