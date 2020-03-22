package com.kingdee.eas.custom.independence;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PermissionSettingTreeFactory
{
    private PermissionSettingTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.independence.IPermissionSettingTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.independence.IPermissionSettingTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C32A6538") ,com.kingdee.eas.custom.independence.IPermissionSettingTree.class);
    }
    
    public static com.kingdee.eas.custom.independence.IPermissionSettingTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.independence.IPermissionSettingTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C32A6538") ,com.kingdee.eas.custom.independence.IPermissionSettingTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.independence.IPermissionSettingTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.independence.IPermissionSettingTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C32A6538"));
    }
    public static com.kingdee.eas.custom.independence.IPermissionSettingTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.independence.IPermissionSettingTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C32A6538"));
    }
}