package com.kingdee.eas.custom.taihe.sewagedetection;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CheckRecordEntryFactory
{
    private CheckRecordEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("351C2EB6") ,com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordEntry.class);
    }
    
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("351C2EB6") ,com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("351C2EB6"));
    }
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckRecordEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("351C2EB6"));
    }
}