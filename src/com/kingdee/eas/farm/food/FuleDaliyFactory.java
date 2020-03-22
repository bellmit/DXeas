package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FuleDaliyFactory
{
    private FuleDaliyFactory()
    {
    }
    public static com.kingdee.eas.farm.food.IFuleDaliy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFuleDaliy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("677C6DED") ,com.kingdee.eas.farm.food.IFuleDaliy.class);
    }
    
    public static com.kingdee.eas.farm.food.IFuleDaliy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFuleDaliy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("677C6DED") ,com.kingdee.eas.farm.food.IFuleDaliy.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.IFuleDaliy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFuleDaliy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("677C6DED"));
    }
    public static com.kingdee.eas.farm.food.IFuleDaliy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IFuleDaliy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("677C6DED"));
    }
}