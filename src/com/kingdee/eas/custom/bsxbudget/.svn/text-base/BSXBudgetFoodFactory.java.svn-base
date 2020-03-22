package com.kingdee.eas.custom.bsxbudget;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BSXBudgetFoodFactory
{
    private BSXBudgetFoodFactory()
    {
    }
    public static com.kingdee.eas.custom.bsxbudget.IBSXBudgetFood getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.bsxbudget.IBSXBudgetFood)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("855505A3") ,com.kingdee.eas.custom.bsxbudget.IBSXBudgetFood.class);
    }
    
    public static com.kingdee.eas.custom.bsxbudget.IBSXBudgetFood getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.bsxbudget.IBSXBudgetFood)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("855505A3") ,com.kingdee.eas.custom.bsxbudget.IBSXBudgetFood.class, objectCtx);
    }
    public static com.kingdee.eas.custom.bsxbudget.IBSXBudgetFood getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.bsxbudget.IBSXBudgetFood)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("855505A3"));
    }
    public static com.kingdee.eas.custom.bsxbudget.IBSXBudgetFood getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.bsxbudget.IBSXBudgetFood)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("855505A3"));
    }
}