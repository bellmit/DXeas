package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettingFactory
{
    private SettingFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.ISetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ISetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("64B9EA15") ,com.kingdee.eas.weighbridge.ISetting.class);
    }
    
    public static com.kingdee.eas.weighbridge.ISetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ISetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("64B9EA15") ,com.kingdee.eas.weighbridge.ISetting.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.ISetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ISetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("64B9EA15"));
    }
    public static com.kingdee.eas.weighbridge.ISetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ISetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("64B9EA15"));
    }
}