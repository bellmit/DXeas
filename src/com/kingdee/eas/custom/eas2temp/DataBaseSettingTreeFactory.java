package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DataBaseSettingTreeFactory
{
    private DataBaseSettingTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.eas2temp.IDataBaseSettingTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IDataBaseSettingTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5F5A871F") ,com.kingdee.eas.custom.eas2temp.IDataBaseSettingTree.class);
    }
    
    public static com.kingdee.eas.custom.eas2temp.IDataBaseSettingTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IDataBaseSettingTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5F5A871F") ,com.kingdee.eas.custom.eas2temp.IDataBaseSettingTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.eas2temp.IDataBaseSettingTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IDataBaseSettingTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5F5A871F"));
    }
    public static com.kingdee.eas.custom.eas2temp.IDataBaseSettingTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IDataBaseSettingTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5F5A871F"));
    }
}