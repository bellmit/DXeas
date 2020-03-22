package com.kingdee.eas.custom.taihe.vehicledetection;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class VdChannelSettingFactory
{
    private VdChannelSettingFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.vehicledetection.IVdChannelSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.IVdChannelSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7CF024D0") ,com.kingdee.eas.custom.taihe.vehicledetection.IVdChannelSetting.class);
    }
    
    public static com.kingdee.eas.custom.taihe.vehicledetection.IVdChannelSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.IVdChannelSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7CF024D0") ,com.kingdee.eas.custom.taihe.vehicledetection.IVdChannelSetting.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.vehicledetection.IVdChannelSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.IVdChannelSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7CF024D0"));
    }
    public static com.kingdee.eas.custom.taihe.vehicledetection.IVdChannelSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.IVdChannelSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7CF024D0"));
    }
}