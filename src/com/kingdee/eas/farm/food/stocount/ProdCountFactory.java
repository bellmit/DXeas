package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProdCountFactory
{
    private ProdCountFactory()
    {
    }
    public static com.kingdee.eas.farm.food.stocount.IProdCount getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.IProdCount)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F470D1DB") ,com.kingdee.eas.farm.food.stocount.IProdCount.class);
    }
    
    public static com.kingdee.eas.farm.food.stocount.IProdCount getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.IProdCount)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F470D1DB") ,com.kingdee.eas.farm.food.stocount.IProdCount.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.stocount.IProdCount getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.IProdCount)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F470D1DB"));
    }
    public static com.kingdee.eas.farm.food.stocount.IProdCount getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.IProdCount)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F470D1DB"));
    }
}