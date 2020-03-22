package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CommecialChilkenDailyImmuneEntryFactory
{
    private CommecialChilkenDailyImmuneEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.business.ICommecialChilkenDailyImmuneEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChilkenDailyImmuneEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FED96D86") ,com.kingdee.eas.farm.breed.business.ICommecialChilkenDailyImmuneEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.business.ICommecialChilkenDailyImmuneEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChilkenDailyImmuneEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FED96D86") ,com.kingdee.eas.farm.breed.business.ICommecialChilkenDailyImmuneEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.business.ICommecialChilkenDailyImmuneEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChilkenDailyImmuneEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FED96D86"));
    }
    public static com.kingdee.eas.farm.breed.business.ICommecialChilkenDailyImmuneEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChilkenDailyImmuneEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FED96D86"));
    }
}