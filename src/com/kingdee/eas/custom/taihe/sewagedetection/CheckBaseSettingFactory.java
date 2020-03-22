package com.kingdee.eas.custom.taihe.sewagedetection;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CheckBaseSettingFactory
{
    private CheckBaseSettingFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckBaseSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckBaseSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E792FA54") ,com.kingdee.eas.custom.taihe.sewagedetection.ICheckBaseSetting.class);
    }
    
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckBaseSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckBaseSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E792FA54") ,com.kingdee.eas.custom.taihe.sewagedetection.ICheckBaseSetting.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckBaseSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckBaseSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E792FA54"));
    }
    public static com.kingdee.eas.custom.taihe.sewagedetection.ICheckBaseSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.ICheckBaseSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E792FA54"));
    }
}