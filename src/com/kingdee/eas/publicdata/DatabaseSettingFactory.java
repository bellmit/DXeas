package com.kingdee.eas.publicdata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DatabaseSettingFactory
{
    private DatabaseSettingFactory()
    {
    }
    public static com.kingdee.eas.publicdata.IDatabaseSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.publicdata.IDatabaseSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("65574212") ,com.kingdee.eas.publicdata.IDatabaseSetting.class);
    }
    
    public static com.kingdee.eas.publicdata.IDatabaseSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.IDatabaseSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("65574212") ,com.kingdee.eas.publicdata.IDatabaseSetting.class, objectCtx);
    }
    public static com.kingdee.eas.publicdata.IDatabaseSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.IDatabaseSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("65574212"));
    }
    public static com.kingdee.eas.publicdata.IDatabaseSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.publicdata.IDatabaseSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("65574212"));
    }
}