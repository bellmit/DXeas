package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CenterControlDeviceFactory
{
    private CenterControlDeviceFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.ICenterControlDevice getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.ICenterControlDevice)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("00E5D024") ,com.kingdee.eas.farm.breed.ICenterControlDevice.class);
    }
    
    public static com.kingdee.eas.farm.breed.ICenterControlDevice getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.ICenterControlDevice)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("00E5D024") ,com.kingdee.eas.farm.breed.ICenterControlDevice.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.ICenterControlDevice getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.ICenterControlDevice)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("00E5D024"));
    }
    public static com.kingdee.eas.farm.breed.ICenterControlDevice getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.ICenterControlDevice)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("00E5D024"));
    }
}