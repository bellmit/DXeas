package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HenhouseEntryFactory
{
    private HenhouseEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IHenhouseEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IHenhouseEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F4D2FFE9") ,com.kingdee.eas.farm.breed.IHenhouseEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.IHenhouseEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IHenhouseEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F4D2FFE9") ,com.kingdee.eas.farm.breed.IHenhouseEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IHenhouseEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IHenhouseEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F4D2FFE9"));
    }
    public static com.kingdee.eas.farm.breed.IHenhouseEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IHenhouseEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F4D2FFE9"));
    }
}