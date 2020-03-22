package com.kingdee.eas.spray;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DeviceDataTreeFactory
{
    private DeviceDataTreeFactory()
    {
    }
    public static com.kingdee.eas.spray.IDeviceDataTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.spray.IDeviceDataTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6CCB1591") ,com.kingdee.eas.spray.IDeviceDataTree.class);
    }
    
    public static com.kingdee.eas.spray.IDeviceDataTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.spray.IDeviceDataTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6CCB1591") ,com.kingdee.eas.spray.IDeviceDataTree.class, objectCtx);
    }
    public static com.kingdee.eas.spray.IDeviceDataTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.spray.IDeviceDataTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6CCB1591"));
    }
    public static com.kingdee.eas.spray.IDeviceDataTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.spray.IDeviceDataTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6CCB1591"));
    }
}