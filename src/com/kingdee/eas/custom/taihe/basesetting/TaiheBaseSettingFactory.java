package com.kingdee.eas.custom.taihe.basesetting;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TaiheBaseSettingFactory
{
    private TaiheBaseSettingFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.basesetting.ITaiheBaseSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.basesetting.ITaiheBaseSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FA9DEB0F") ,com.kingdee.eas.custom.taihe.basesetting.ITaiheBaseSetting.class);
    }
    
    public static com.kingdee.eas.custom.taihe.basesetting.ITaiheBaseSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.basesetting.ITaiheBaseSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FA9DEB0F") ,com.kingdee.eas.custom.taihe.basesetting.ITaiheBaseSetting.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.basesetting.ITaiheBaseSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.basesetting.ITaiheBaseSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FA9DEB0F"));
    }
    public static com.kingdee.eas.custom.taihe.basesetting.ITaiheBaseSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.basesetting.ITaiheBaseSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FA9DEB0F"));
    }
}