package com.kingdee.eas.custom.taihe.sewagedetection;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CheckRecordFactory
{
    private CheckRecordFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecord getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecord)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9AC07B1C") ,com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecord.class);
    }
    
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecord getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecord)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9AC07B1C") ,com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecord.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecord getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecord)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9AC07B1C"));
    }
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecord getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecord)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9AC07B1C"));
    }
}