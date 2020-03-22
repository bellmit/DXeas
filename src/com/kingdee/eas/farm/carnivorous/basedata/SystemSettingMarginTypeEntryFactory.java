package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SystemSettingMarginTypeEntryFactory
{
    private SystemSettingMarginTypeEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingMarginTypeEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingMarginTypeEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B3AE468B") ,com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingMarginTypeEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingMarginTypeEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingMarginTypeEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B3AE468B") ,com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingMarginTypeEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingMarginTypeEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingMarginTypeEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B3AE468B"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingMarginTypeEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISystemSettingMarginTypeEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B3AE468B"));
    }
}