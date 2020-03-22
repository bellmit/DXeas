package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CountPositionSetOperatorEntryFactory
{
    private CountPositionSetOperatorEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.food.stocount.ICountPositionSetOperatorEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ICountPositionSetOperatorEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3CC302C7") ,com.kingdee.eas.farm.food.stocount.ICountPositionSetOperatorEntry.class);
    }
    
    public static com.kingdee.eas.farm.food.stocount.ICountPositionSetOperatorEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ICountPositionSetOperatorEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3CC302C7") ,com.kingdee.eas.farm.food.stocount.ICountPositionSetOperatorEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.stocount.ICountPositionSetOperatorEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ICountPositionSetOperatorEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3CC302C7"));
    }
    public static com.kingdee.eas.farm.food.stocount.ICountPositionSetOperatorEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ICountPositionSetOperatorEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3CC302C7"));
    }
}