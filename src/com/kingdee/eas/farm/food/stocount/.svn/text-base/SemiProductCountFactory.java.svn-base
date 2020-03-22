package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SemiProductCountFactory
{
    private SemiProductCountFactory()
    {
    }
    public static com.kingdee.eas.farm.food.stocount.ISemiProductCount getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ISemiProductCount)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1F4754AB") ,com.kingdee.eas.farm.food.stocount.ISemiProductCount.class);
    }
    
    public static com.kingdee.eas.farm.food.stocount.ISemiProductCount getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ISemiProductCount)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1F4754AB") ,com.kingdee.eas.farm.food.stocount.ISemiProductCount.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.stocount.ISemiProductCount getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ISemiProductCount)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1F4754AB"));
    }
    public static com.kingdee.eas.farm.food.stocount.ISemiProductCount getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ISemiProductCount)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1F4754AB"));
    }
}