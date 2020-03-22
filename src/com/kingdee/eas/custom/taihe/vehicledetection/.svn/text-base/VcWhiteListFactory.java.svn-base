package com.kingdee.eas.custom.taihe.vehicledetection;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class VcWhiteListFactory
{
    private VcWhiteListFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteList getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteList)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B5AED865") ,com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteList.class);
    }
    
    public static com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteList getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteList)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B5AED865") ,com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteList.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteList getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteList)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B5AED865"));
    }
    public static com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteList getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteList)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B5AED865"));
    }
}