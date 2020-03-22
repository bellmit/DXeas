package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DailyImmunePlanFactory
{
    private DailyImmunePlanFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IDailyImmunePlan getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IDailyImmunePlan)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DBAADF05") ,com.kingdee.eas.farm.pig.IDailyImmunePlan.class);
    }
    
    public static com.kingdee.eas.farm.pig.IDailyImmunePlan getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IDailyImmunePlan)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DBAADF05") ,com.kingdee.eas.farm.pig.IDailyImmunePlan.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IDailyImmunePlan getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IDailyImmunePlan)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DBAADF05"));
    }
    public static com.kingdee.eas.farm.pig.IDailyImmunePlan getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IDailyImmunePlan)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DBAADF05"));
    }
}