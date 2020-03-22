package com.kingdee.eas.message;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BaseSettingFactory
{
    private BaseSettingFactory()
    {
    }
    public static com.kingdee.eas.message.IBaseSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.message.IBaseSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D355B106") ,com.kingdee.eas.message.IBaseSetting.class);
    }
    
    public static com.kingdee.eas.message.IBaseSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.message.IBaseSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D355B106") ,com.kingdee.eas.message.IBaseSetting.class, objectCtx);
    }
    public static com.kingdee.eas.message.IBaseSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.message.IBaseSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D355B106"));
    }
    public static com.kingdee.eas.message.IBaseSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.message.IBaseSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D355B106"));
    }
}