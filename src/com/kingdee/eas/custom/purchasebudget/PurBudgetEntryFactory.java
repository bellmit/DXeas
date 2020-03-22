package com.kingdee.eas.custom.purchasebudget;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PurBudgetEntryFactory
{
    private PurBudgetEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.purchasebudget.IPurBudgetEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.purchasebudget.IPurBudgetEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2C1B78DD") ,com.kingdee.eas.custom.purchasebudget.IPurBudgetEntry.class);
    }
    
    public static com.kingdee.eas.custom.purchasebudget.IPurBudgetEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.purchasebudget.IPurBudgetEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2C1B78DD") ,com.kingdee.eas.custom.purchasebudget.IPurBudgetEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.purchasebudget.IPurBudgetEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.purchasebudget.IPurBudgetEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2C1B78DD"));
    }
    public static com.kingdee.eas.custom.purchasebudget.IPurBudgetEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.purchasebudget.IPurBudgetEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2C1B78DD"));
    }
}