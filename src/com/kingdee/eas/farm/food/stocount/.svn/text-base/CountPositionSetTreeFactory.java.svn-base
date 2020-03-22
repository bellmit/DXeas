package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CountPositionSetTreeFactory
{
    private CountPositionSetTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.food.stocount.ICountPositionSetTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ICountPositionSetTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DC2CE6E5") ,com.kingdee.eas.farm.food.stocount.ICountPositionSetTree.class);
    }
    
    public static com.kingdee.eas.farm.food.stocount.ICountPositionSetTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ICountPositionSetTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DC2CE6E5") ,com.kingdee.eas.farm.food.stocount.ICountPositionSetTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.stocount.ICountPositionSetTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ICountPositionSetTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DC2CE6E5"));
    }
    public static com.kingdee.eas.farm.food.stocount.ICountPositionSetTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ICountPositionSetTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DC2CE6E5"));
    }
}