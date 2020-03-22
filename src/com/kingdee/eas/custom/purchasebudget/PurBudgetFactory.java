package com.kingdee.eas.custom.purchasebudget;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PurBudgetFactory
{
    private PurBudgetFactory()
    {
    }
    public static com.kingdee.eas.custom.purchasebudget.IPurBudget getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.purchasebudget.IPurBudget)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8E873495") ,com.kingdee.eas.custom.purchasebudget.IPurBudget.class);
    }
    
    public static com.kingdee.eas.custom.purchasebudget.IPurBudget getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.purchasebudget.IPurBudget)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8E873495") ,com.kingdee.eas.custom.purchasebudget.IPurBudget.class, objectCtx);
    }
    public static com.kingdee.eas.custom.purchasebudget.IPurBudget getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.purchasebudget.IPurBudget)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8E873495"));
    }
    public static com.kingdee.eas.custom.purchasebudget.IPurBudget getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.purchasebudget.IPurBudget)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8E873495"));
    }
}