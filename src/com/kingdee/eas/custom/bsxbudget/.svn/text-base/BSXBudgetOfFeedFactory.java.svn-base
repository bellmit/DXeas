package com.kingdee.eas.custom.bsxbudget;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BSXBudgetOfFeedFactory
{
    private BSXBudgetOfFeedFactory()
    {
    }
    public static com.kingdee.eas.custom.bsxbudget.IBSXBudgetOfFeed getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.bsxbudget.IBSXBudgetOfFeed)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("92F4601A") ,com.kingdee.eas.custom.bsxbudget.IBSXBudgetOfFeed.class);
    }
    
    public static com.kingdee.eas.custom.bsxbudget.IBSXBudgetOfFeed getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.bsxbudget.IBSXBudgetOfFeed)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("92F4601A") ,com.kingdee.eas.custom.bsxbudget.IBSXBudgetOfFeed.class, objectCtx);
    }
    public static com.kingdee.eas.custom.bsxbudget.IBSXBudgetOfFeed getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.bsxbudget.IBSXBudgetOfFeed)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("92F4601A"));
    }
    public static com.kingdee.eas.custom.bsxbudget.IBSXBudgetOfFeed getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.bsxbudget.IBSXBudgetOfFeed)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("92F4601A"));
    }
}