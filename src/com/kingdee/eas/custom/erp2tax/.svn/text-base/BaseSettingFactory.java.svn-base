package com.kingdee.eas.custom.erp2tax;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BaseSettingFactory
{
    private BaseSettingFactory()
    {
    }
    public static com.kingdee.eas.custom.erp2tax.IBaseSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.erp2tax.IBaseSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("78177308") ,com.kingdee.eas.custom.erp2tax.IBaseSetting.class);
    }
    
    public static com.kingdee.eas.custom.erp2tax.IBaseSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.erp2tax.IBaseSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("78177308") ,com.kingdee.eas.custom.erp2tax.IBaseSetting.class, objectCtx);
    }
    public static com.kingdee.eas.custom.erp2tax.IBaseSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.erp2tax.IBaseSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("78177308"));
    }
    public static com.kingdee.eas.custom.erp2tax.IBaseSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.erp2tax.IBaseSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("78177308"));
    }
}