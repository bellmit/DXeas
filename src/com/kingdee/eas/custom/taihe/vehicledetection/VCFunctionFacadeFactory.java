package com.kingdee.eas.custom.taihe.vehicledetection;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class VCFunctionFacadeFactory
{
    private VCFunctionFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.vehicledetection.IVCFunctionFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.IVCFunctionFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("48D63134") ,com.kingdee.eas.custom.taihe.vehicledetection.IVCFunctionFacade.class);
    }
    
    public static com.kingdee.eas.custom.taihe.vehicledetection.IVCFunctionFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.IVCFunctionFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("48D63134") ,com.kingdee.eas.custom.taihe.vehicledetection.IVCFunctionFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.vehicledetection.IVCFunctionFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.IVCFunctionFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("48D63134"));
    }
    public static com.kingdee.eas.custom.taihe.vehicledetection.IVCFunctionFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.IVCFunctionFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("48D63134"));
    }
}