package com.kingdee.eas.message;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BaseSettingTreeFactory
{
    private BaseSettingTreeFactory()
    {
    }
    public static com.kingdee.eas.message.IBaseSettingTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.message.IBaseSettingTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DF91A5C4") ,com.kingdee.eas.message.IBaseSettingTree.class);
    }
    
    public static com.kingdee.eas.message.IBaseSettingTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.message.IBaseSettingTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DF91A5C4") ,com.kingdee.eas.message.IBaseSettingTree.class, objectCtx);
    }
    public static com.kingdee.eas.message.IBaseSettingTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.message.IBaseSettingTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DF91A5C4"));
    }
    public static com.kingdee.eas.message.IBaseSettingTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.message.IBaseSettingTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DF91A5C4"));
    }
}