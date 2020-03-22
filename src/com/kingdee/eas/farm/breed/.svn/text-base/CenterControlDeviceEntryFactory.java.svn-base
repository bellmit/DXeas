package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CenterControlDeviceEntryFactory
{
    private CenterControlDeviceEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.ICenterControlDeviceEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.ICenterControlDeviceEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F7AABEAE") ,com.kingdee.eas.farm.breed.ICenterControlDeviceEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.ICenterControlDeviceEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.ICenterControlDeviceEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F7AABEAE") ,com.kingdee.eas.farm.breed.ICenterControlDeviceEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.ICenterControlDeviceEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.ICenterControlDeviceEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F7AABEAE"));
    }
    public static com.kingdee.eas.farm.breed.ICenterControlDeviceEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.ICenterControlDeviceEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F7AABEAE"));
    }
}