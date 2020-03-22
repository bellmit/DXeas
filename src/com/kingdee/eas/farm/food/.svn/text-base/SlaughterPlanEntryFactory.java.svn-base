package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SlaughterPlanEntryFactory
{
    private SlaughterPlanEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.food.ISlaughterPlanEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISlaughterPlanEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5940FAC0") ,com.kingdee.eas.farm.food.ISlaughterPlanEntry.class);
    }
    
    public static com.kingdee.eas.farm.food.ISlaughterPlanEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISlaughterPlanEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5940FAC0") ,com.kingdee.eas.farm.food.ISlaughterPlanEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.ISlaughterPlanEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISlaughterPlanEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5940FAC0"));
    }
    public static com.kingdee.eas.farm.food.ISlaughterPlanEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ISlaughterPlanEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5940FAC0"));
    }
}