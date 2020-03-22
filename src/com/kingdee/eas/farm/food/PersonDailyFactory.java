package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PersonDailyFactory
{
    private PersonDailyFactory()
    {
    }
    public static com.kingdee.eas.farm.food.IPersonDaily getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.IPersonDaily)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("24FF14DA") ,com.kingdee.eas.farm.food.IPersonDaily.class);
    }
    
    public static com.kingdee.eas.farm.food.IPersonDaily getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IPersonDaily)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("24FF14DA") ,com.kingdee.eas.farm.food.IPersonDaily.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.IPersonDaily getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IPersonDaily)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("24FF14DA"));
    }
    public static com.kingdee.eas.farm.food.IPersonDaily getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IPersonDaily)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("24FF14DA"));
    }
}