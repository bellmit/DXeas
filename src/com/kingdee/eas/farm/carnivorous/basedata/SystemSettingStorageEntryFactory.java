package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SystemSettingStorageEntryFactory
{
    private SystemSettingStorageEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingStorageEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingStorageEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AA25AF16") ,com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingStorageEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingStorageEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingStorageEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AA25AF16") ,com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingStorageEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingStorageEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingStorageEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AA25AF16"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingStorageEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingStorageEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AA25AF16"));
    }
}