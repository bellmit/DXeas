package com.kingdee.eas.custom.bsxbudget;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BSXBudgetGroupFactory
{
    private BSXBudgetGroupFactory()
    {
    }
    public static com.kingdee.eas.custom.bsxbudget.IBSXBudgetGroup getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.bsxbudget.IBSXBudgetGroup)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("255B25DA") ,com.kingdee.eas.custom.bsxbudget.IBSXBudgetGroup.class);
    }
    
    public static com.kingdee.eas.custom.bsxbudget.IBSXBudgetGroup getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.bsxbudget.IBSXBudgetGroup)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("255B25DA") ,com.kingdee.eas.custom.bsxbudget.IBSXBudgetGroup.class, objectCtx);
    }
    public static com.kingdee.eas.custom.bsxbudget.IBSXBudgetGroup getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.bsxbudget.IBSXBudgetGroup)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("255B25DA"));
    }
    public static com.kingdee.eas.custom.bsxbudget.IBSXBudgetGroup getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.bsxbudget.IBSXBudgetGroup)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("255B25DA"));
    }
}