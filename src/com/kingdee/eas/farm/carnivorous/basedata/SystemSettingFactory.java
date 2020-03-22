package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SystemSettingFactory
{
    private SystemSettingFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISystemSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISystemSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1E5C56BF") ,com.kingdee.eas.farm.carnivorous.basedata.ISystemSetting.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ISystemSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISystemSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1E5C56BF") ,com.kingdee.eas.farm.carnivorous.basedata.ISystemSetting.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISystemSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISystemSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1E5C56BF"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISystemSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISystemSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1E5C56BF"));
    }
}