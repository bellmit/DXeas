package com.kingdee.eas.custom.taihe.sewagedetection;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CheckRecordFacadeFactory
{
    private CheckRecordFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6F5F52D6") ,com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordFacade.class);
    }
    
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6F5F52D6") ,com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6F5F52D6"));
    }
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6F5F52D6"));
    }
}