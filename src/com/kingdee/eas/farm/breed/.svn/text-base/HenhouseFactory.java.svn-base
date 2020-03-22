package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HenhouseFactory
{
    private HenhouseFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IHenhouse getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IHenhouse)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EFA27609") ,com.kingdee.eas.farm.breed.IHenhouse.class);
    }
    
    public static com.kingdee.eas.farm.breed.IHenhouse getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IHenhouse)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EFA27609") ,com.kingdee.eas.farm.breed.IHenhouse.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IHenhouse getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IHenhouse)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EFA27609"));
    }
    public static com.kingdee.eas.farm.breed.IHenhouse getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IHenhouse)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EFA27609"));
    }
}