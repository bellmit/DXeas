package com.kingdee.eas.custom.independence;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PermissionSettingFactory
{
    private PermissionSettingFactory()
    {
    }
    public static com.kingdee.eas.custom.independence.IPermissionSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.independence.IPermissionSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("69804A7A") ,com.kingdee.eas.custom.independence.IPermissionSetting.class);
    }
    
    public static com.kingdee.eas.custom.independence.IPermissionSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.independence.IPermissionSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("69804A7A") ,com.kingdee.eas.custom.independence.IPermissionSetting.class, objectCtx);
    }
    public static com.kingdee.eas.custom.independence.IPermissionSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.independence.IPermissionSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("69804A7A"));
    }
    public static com.kingdee.eas.custom.independence.IPermissionSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.independence.IPermissionSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("69804A7A"));
    }
}