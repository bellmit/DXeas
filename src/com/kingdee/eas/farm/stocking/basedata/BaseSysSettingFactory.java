package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BaseSysSettingFactory
{
    private BaseSysSettingFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBaseSysSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBaseSysSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("22DDC205") ,com.kingdee.eas.farm.stocking.basedata.IBaseSysSetting.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IBaseSysSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBaseSysSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("22DDC205") ,com.kingdee.eas.farm.stocking.basedata.IBaseSysSetting.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBaseSysSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBaseSysSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("22DDC205"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBaseSysSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBaseSysSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("22DDC205"));
    }
}