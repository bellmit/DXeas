package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CenterControlDeviceTreeFactory
{
    private CenterControlDeviceTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.ICenterControlDeviceTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.ICenterControlDeviceTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7BA105E2") ,com.kingdee.eas.farm.breed.ICenterControlDeviceTree.class);
    }
    
    public static com.kingdee.eas.farm.breed.ICenterControlDeviceTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.ICenterControlDeviceTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7BA105E2") ,com.kingdee.eas.farm.breed.ICenterControlDeviceTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.ICenterControlDeviceTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.ICenterControlDeviceTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7BA105E2"));
    }
    public static com.kingdee.eas.farm.breed.ICenterControlDeviceTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.ICenterControlDeviceTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7BA105E2"));
    }
}