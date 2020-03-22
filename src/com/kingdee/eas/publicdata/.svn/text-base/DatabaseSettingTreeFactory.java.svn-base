package com.kingdee.eas.publicdata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DatabaseSettingTreeFactory
{
    private DatabaseSettingTreeFactory()
    {
    }
    public static com.kingdee.eas.publicdata.IDatabaseSettingTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.publicdata.IDatabaseSettingTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("850BD0D0") ,com.kingdee.eas.publicdata.IDatabaseSettingTree.class);
    }
    
    public static com.kingdee.eas.publicdata.IDatabaseSettingTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.IDatabaseSettingTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("850BD0D0") ,com.kingdee.eas.publicdata.IDatabaseSettingTree.class, objectCtx);
    }
    public static com.kingdee.eas.publicdata.IDatabaseSettingTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.IDatabaseSettingTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("850BD0D0"));
    }
    public static com.kingdee.eas.publicdata.IDatabaseSettingTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.publicdata.IDatabaseSettingTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("850BD0D0"));
    }
}