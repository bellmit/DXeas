package com.kingdee.eas.custom.taihe.sewagedetection;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CheckItemFactory
{
    private CheckItemFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckItem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckItem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AAE6C09E") ,com.kingdee.eas.custom.taihe.sewagedetection.ICheckItem.class);
    }
    
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckItem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckItem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AAE6C09E") ,com.kingdee.eas.custom.taihe.sewagedetection.ICheckItem.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckItem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckItem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AAE6C09E"));
    }
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckItem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckItem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AAE6C09E"));
    }
}