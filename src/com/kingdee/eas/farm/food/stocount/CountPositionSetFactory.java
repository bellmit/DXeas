package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CountPositionSetFactory
{
    private CountPositionSetFactory()
    {
    }
    public static com.kingdee.eas.farm.food.stocount.ICountPositionSet getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ICountPositionSet)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D338AAA7") ,com.kingdee.eas.farm.food.stocount.ICountPositionSet.class);
    }
    
    public static com.kingdee.eas.farm.food.stocount.ICountPositionSet getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ICountPositionSet)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D338AAA7") ,com.kingdee.eas.farm.food.stocount.ICountPositionSet.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.stocount.ICountPositionSet getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ICountPositionSet)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D338AAA7"));
    }
    public static com.kingdee.eas.farm.food.stocount.ICountPositionSet getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ICountPositionSet)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D338AAA7"));
    }
}