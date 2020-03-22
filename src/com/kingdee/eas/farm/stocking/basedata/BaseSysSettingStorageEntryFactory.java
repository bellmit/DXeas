package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BaseSysSettingStorageEntryFactory
{
    private BaseSysSettingStorageEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBaseSysSettingStorageEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBaseSysSettingStorageEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F0B2615C") ,com.kingdee.eas.farm.stocking.basedata.IBaseSysSettingStorageEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IBaseSysSettingStorageEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBaseSysSettingStorageEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F0B2615C") ,com.kingdee.eas.farm.stocking.basedata.IBaseSysSettingStorageEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBaseSysSettingStorageEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBaseSysSettingStorageEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F0B2615C"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBaseSysSettingStorageEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBaseSysSettingStorageEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F0B2615C"));
    }
}