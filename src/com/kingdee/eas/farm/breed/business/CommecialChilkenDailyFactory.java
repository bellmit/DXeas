package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CommecialChilkenDailyFactory
{
    private CommecialChilkenDailyFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.business.ICommecialChilkenDaily getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChilkenDaily)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8506D469") ,com.kingdee.eas.farm.breed.business.ICommecialChilkenDaily.class);
    }
    
    public static com.kingdee.eas.farm.breed.business.ICommecialChilkenDaily getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChilkenDaily)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8506D469") ,com.kingdee.eas.farm.breed.business.ICommecialChilkenDaily.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.business.ICommecialChilkenDaily getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChilkenDaily)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8506D469"));
    }
    public static com.kingdee.eas.farm.breed.business.ICommecialChilkenDaily getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChilkenDaily)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8506D469"));
    }
}