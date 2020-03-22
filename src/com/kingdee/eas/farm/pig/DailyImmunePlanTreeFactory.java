package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DailyImmunePlanTreeFactory
{
    private DailyImmunePlanTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IDailyImmunePlanTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IDailyImmunePlanTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3D91BC43") ,com.kingdee.eas.farm.pig.IDailyImmunePlanTree.class);
    }
    
    public static com.kingdee.eas.farm.pig.IDailyImmunePlanTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IDailyImmunePlanTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3D91BC43") ,com.kingdee.eas.farm.pig.IDailyImmunePlanTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IDailyImmunePlanTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IDailyImmunePlanTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3D91BC43"));
    }
    public static com.kingdee.eas.farm.pig.IDailyImmunePlanTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IDailyImmunePlanTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3D91BC43"));
    }
}