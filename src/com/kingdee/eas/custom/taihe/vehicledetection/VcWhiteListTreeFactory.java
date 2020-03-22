package com.kingdee.eas.custom.taihe.vehicledetection;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class VcWhiteListTreeFactory
{
    private VcWhiteListTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteListTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteListTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("183A05A3") ,com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteListTree.class);
    }
    
    public static com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteListTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteListTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("183A05A3") ,com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteListTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteListTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteListTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("183A05A3"));
    }
    public static com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteListTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.IVcWhiteListTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("183A05A3"));
    }
}