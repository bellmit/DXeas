package com.kingdee.eas.spray;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DeviceDataFactory
{
    private DeviceDataFactory()
    {
    }
    public static com.kingdee.eas.spray.IDeviceData getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.spray.IDeviceData)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("95310F53") ,com.kingdee.eas.spray.IDeviceData.class);
    }
    
    public static com.kingdee.eas.spray.IDeviceData getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.spray.IDeviceData)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("95310F53") ,com.kingdee.eas.spray.IDeviceData.class, objectCtx);
    }
    public static com.kingdee.eas.spray.IDeviceData getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.spray.IDeviceData)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("95310F53"));
    }
    public static com.kingdee.eas.spray.IDeviceData getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.spray.IDeviceData)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("95310F53"));
    }
}