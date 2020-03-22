package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BotpSettingFactory
{
    private BotpSettingFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBotpSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBotpSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5A138696") ,com.kingdee.eas.farm.stocking.basedata.IBotpSetting.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IBotpSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBotpSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5A138696") ,com.kingdee.eas.farm.stocking.basedata.IBotpSetting.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBotpSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBotpSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5A138696"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBotpSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBotpSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5A138696"));
    }
}